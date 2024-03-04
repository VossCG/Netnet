package com.example.netnet.remote.twse

import com.example.netnet.model.twse.TwseListedBalanceSheet
import retrofit2.Response
import retrofit2.http.GET

interface TwseListedBalanceSheetService {

    // 上市公司
    @GET("opendata/t187ap07_L_bd")
    suspend fun getBD(): Response<List<TwseListedBalanceSheet>>

    @GET("opendata/t187ap07_L_ci")
    suspend fun getCI(): Response<List<TwseListedBalanceSheet>>

    @GET("opendata/t187ap07_L_fh")
    suspend fun getFH(): Response<List<TwseListedBalanceSheet>>

    @GET("opendata/t187ap07_L_ins")
    suspend fun getINS(): Response<List<TwseListedBalanceSheet>>

    @GET("opendata/t187ap07_L_mim")
    suspend fun getMIM(): Response<List<TwseListedBalanceSheet>>

    @GET("opendata/t187ap07_L_basi")
    suspend fun getBASI(): Response<List<TwseListedBalanceSheet>>

}