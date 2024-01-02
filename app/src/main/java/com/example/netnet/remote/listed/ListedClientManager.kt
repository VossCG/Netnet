package com.example.netnet.remote.listed

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListedClientManager {

    companion object {
        const val BASEURL = "https://openapi.twse.com.tw/v1/"

        private val manager = ListedClientManager()
        val API: ListedService = manager.retrofit.create(ListedService::class.java)
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}