package com.example.netnet.repo

import android.util.Log
import com.example.netnet.remote.twse.TwseClientManager
import org.jsoup.Jsoup

class TwseRepo {
    suspend fun fetchTwseData() {
        val tag = "Twse"
        try {
            val res = TwseClientManager.API.getBalanceSheetByCode(coId = "2330")
            if (res.isSuccessful) {
                val document = Jsoup.parse(res.body().toString())

            } else {
                Log.d(tag, "failure")
            }
        } catch (e: Exception) {
            Log.d(tag, e.message.toString())
        }
    }

    private fun parseHtml() {

    }
}