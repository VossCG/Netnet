package com.example.netnet.remote

import com.example.netnet.model.response.BalanceSheet
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("opendata/t187ap07_L_ci")
    suspend fun getAllCompaniesBalanceSheet(): Response<List<BalanceSheet>>
}