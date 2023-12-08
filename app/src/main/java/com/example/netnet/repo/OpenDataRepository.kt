package com.example.netnet.repo

import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ResponseResult

interface OpenDataRepository {

    suspend fun fetchData(): ResponseResult<List<BalanceSheet>>

}