package com.example.netnet.remote.twse

import com.example.netnet.model.twse.TwseDailyStock
import com.example.netnet.model.twse.TwseMonthlyStock
import retrofit2.Response
import retrofit2.http.GET

interface TwseListedStockService {

    @GET("exchangeReport/STOCK_DAY_ALL")
    suspend fun getDaily(): Response<List<TwseDailyStock>>

    @GET("exchangeReport/FMSRFK_ALL")
    suspend fun getMonthly(): Response<List<TwseMonthlyStock>>


}