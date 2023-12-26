package com.example.netnet.remote.otc

import com.example.netnet.model.otc.OTCBalanceSheet
import com.example.netnet.model.otc.OTCStock
import retrofit2.Response
import retrofit2.http.GET

interface OTCService {

    @GET("mopsfin_t187ap07_O_ci")
    suspend fun getAllCompaniesBalanceSheet(): Response<List<OTCBalanceSheet>>

    @GET("tpex_mainboard_quotes")
    suspend fun getAllDailyStock(): Response<List<OTCStock>>
}