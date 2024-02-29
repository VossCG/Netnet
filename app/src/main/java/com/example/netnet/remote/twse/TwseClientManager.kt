package com.example.netnet.remote.twse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class TwseClientManager {

    companion object {
        const val BASEURL = "https://mops.twse.com.tw/"

        private val manager = TwseClientManager()
        val API: TwseService = manager.retrofit.create(TwseService::class.java)
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
}