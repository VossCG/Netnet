package com.example.netnet.repo

import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ClientManager
import com.example.netnet.remote.ResponseResult

class OpenDataRepositoryImp : OpenDataRepository {

    private val api = ClientManager.API

    override suspend fun fetchData(): ResponseResult<List<BalanceSheet>> {
        return try {
            val res = api.getAllCompaniesBalanceSheet()
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