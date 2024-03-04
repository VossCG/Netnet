package com.example.netnet.remote.twse

import com.example.netnet.model.twse.TwsePublicIncomeStatement
import retrofit2.Response
import retrofit2.http.GET

interface TwsePublicIncomeStatementService {

    // 上市公司
    @GET("opendata/t187ap06_X_bd")
    suspend fun getBD(): Response<List<TwsePublicIncomeStatement>>

    @GET("opendata/t187ap06_X_ci")
    suspend fun getCI(): Response<List<TwsePublicIncomeStatement>>

    @GET("opendata/t187ap06_X_fh")
    suspend fun getFH(): Response<List<TwsePublicIncomeStatement>>

    @GET("opendata/t187ap06_X_ins")
    suspend fun getINS(): Response<List<TwsePublicIncomeStatement>>

    @GET("opendata/t187ap06_X_mim")
    suspend fun getMIM(): Response<List<TwsePublicIncomeStatement>>

    @GET("opendata/t187ap06_X_basi")
    suspend fun getBASI(): Response<List<TwsePublicIncomeStatement>>

}