package com.example.netnet.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("t187ap07_L_ci")
    suspend fun getAllCompaniesBalanceSheet(): Response<List<BalanceSheet>>
}