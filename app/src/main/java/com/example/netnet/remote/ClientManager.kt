package com.example.netnet.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientManager {

    companion object {
        const val BASEURL = "https://openapi.twse.com.tw/v1/opendata/"
        private val manager = ClientManager()
        val API: ApiService = manager.retrofit.create(ApiService::class.java)
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}