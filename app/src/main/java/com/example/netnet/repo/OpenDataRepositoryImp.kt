package com.example.netnet.repo

import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ClientManager
import com.example.netnet.remote.ResponseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenDataRepositoryImp : OpenDataRepository {

    private val api = ClientManager.API

    override suspend fun getAllCompaniesBalanceSheet(): Flow<ResponseResult<List<BalanceSheet>>> =
        flow {
            emit(ResponseResult.Loading)
            try {
                val res = api.getAllCompaniesBalanceSheet()
                if (res.isSuccessful) {
                    emit(ResponseResult.Success(res.body() ?: emptyList()))
                } else {
                    emit(ResponseResult.Success(emptyList()))
                }
            } catch (e: Exception) {
                emit(ResponseResult.Error(e))
            }
        }
}