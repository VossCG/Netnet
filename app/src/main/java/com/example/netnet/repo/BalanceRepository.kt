package com.example.netnet.repo

import com.example.netnet.model.BalanceSheetRow
import com.example.netnet.model.ResponseResult
import com.example.netnet.remote.twse.TwseClientManager
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class BalanceRepository {

    suspend fun queryByCode(code: String): ResponseResult<List<BalanceSheetRow>> {
        return try {
            val response = TwseClientManager.API.getBalanceSheetByCode(coId = code)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val document = Jsoup.parse(body)
                    val balanceSheetRows = parseHtml(document)
                    ResponseResult.Success(balanceSheetRows)
                } else {
                    ResponseResult.Error(Exception("Response body is null"))
                }
            } else {
                ResponseResult.Error(Exception("Response is not successful: ${response.code()}"))
            }
        } catch (e: Exception) {
            ResponseResult.Error(e)
        }
    }


    private fun parseHtml(document: Document): List<BalanceSheetRow> {
        val balanceSheetRows = mutableListOf<BalanceSheetRow>()
        val trElements = document.select("tr")
        // 遍歷所有的 <tr> 元素，檢查是否包含 <td> 元素
        for (tr in trElements) {
            val tds = tr.select("td")
            if (tds.size == 5) {
                val balanceSheetRow = BalanceSheetRow(
                    tds[0].text().trim(),
                    tds[1].text().trim(),
                    tds[2].text().trim(),
                    tds[3].text().trim(),
                    tds[4].text().trim(),
                )
                balanceSheetRows.add(balanceSheetRow)
            }
        }
        return balanceSheetRows
    }
}