package com.example.netnet.repo

import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ResponseResult
import kotlinx.coroutines.flow.Flow

interface OpenDataRepository {

    suspend fun getAllCompaniesBalanceSheet(): List<BalanceSheet>

}