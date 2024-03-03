package com.example.netnet.remote.twse

import com.example.netnet.model.twse.TwseListedIncomeStatement
import retrofit2.Response
import retrofit2.http.GET

interface TwseListedIncomeStatementService {

    // 上市公司
    @GET("v1/opendata/t187ap06_L_bd")
    suspend fun getBD(): Response<List<TwseListedIncomeStatement>>

    @GET("v1/opendata/t187ap06_L_ci")
    suspend fun getCI(): Response<List<TwseListedIncomeStatement>>

    @GET("v1/opendata/t187ap06_L_fh")
    suspend fun getFH(): Response<List<TwseListedIncomeStatement>>

    @GET("v1/opendata/t187ap06_L_ins")
    suspend fun getINS(): Response<List<TwseListedIncomeStatement>>

    @GET("v1/opendata/t187ap06_L_mim")
    suspend fun getMIM(): Response<List<TwseListedIncomeStatement>>

    @GET("v1/opendata/t187ap06_L_basi")
    suspend fun getBASI(): Response<List<TwseListedIncomeStatement>>


}