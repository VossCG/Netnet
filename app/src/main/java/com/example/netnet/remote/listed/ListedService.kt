package com.example.netnet.remote.listed

import com.example.netnet.model.listed.ListedBalanceSheet
import com.example.netnet.model.listed.ListedStock
import retrofit2.Response
import retrofit2.http.GET

interface ListedService {

    @GET("opendata/t187ap07_L_ci")
    suspend fun getAllCompaniesBalanceSheet(): Response<List<ListedBalanceSheet>>

    @GET("exchangeReport/STOCK_DAY_ALL")
    suspend fun getAllDailyStock(): Response<List<ListedStock>>
}