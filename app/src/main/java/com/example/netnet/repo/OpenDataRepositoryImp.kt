package com.example.netnet.repo

import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ClientManager
import com.example.netnet.remote.ResponseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenDataRepositoryImp : OpenDataRepository {

    private val api = ClientManager.API

    override suspend fun getAllCompaniesBalanceSheet(): List<BalanceSheet> {
        return try {
            val res = api.getAllCompaniesBalanceSheet()
            if (res.isSuccessful) {
                res.body() ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

}