package com.example.netnet.remote.otc

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OTCClientManager {

    companion object {
        const val BASEURL = "https://www.tpex.org.tw/openapi/v1/"

        private val manager = OTCClientManager()
        val API: OTCService = manager.retrofit.create(OTCService::class.java)
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}