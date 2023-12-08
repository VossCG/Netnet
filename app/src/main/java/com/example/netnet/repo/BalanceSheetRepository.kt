package com.example.netnet.repo

import com.example.netnet.model.response.BalanceSheet
import com.example.netnet.remote.ClientManager
import com.example.netnet.model.response.ResponseResult

class BalanceSheetRepository {

    suspend fun fetchData(): ResponseResult<List<BalanceSheet>> {
        return try {
            val res = ClientManager.API.getAllCompaniesBalanceSheet()
            if (res.isSuccessful) {
                ResponseResult.Success(res.body() ?: emptyList())
            } else {
                ResponseResult.Success(emptyList())
            }
        } catch (e: Exception) {
            ResponseResult.Error(e)
        }
    }

}