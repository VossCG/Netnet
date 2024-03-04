package com.example.netnet.remote.twse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TwseClientManager {

    companion object {
        const val BASEURL = "https://openapi.twse.com.tw/v1/"
        private val manager = TwseClientManager()

        val ListedBalanceSheet: TwseListedBalanceSheetService =
            manager.retrofit.create(TwseListedBalanceSheetService::class.java)
        val ListedIncomeStatement: TwseListedIncomeStatementService =
            manager.retrofit.create(TwseListedIncomeStatementService::class.java)
        val PublicBalanceSheet: TwsePublicBalanceSheetService =
            manager.retrofit.create(TwsePublicBalanceSheetService::class.java)
        val PublicIncomeStatement: TwsePublicIncomeStatementService =
            manager.retrofit.create(TwsePublicIncomeStatementService::class.java)
        val ListedStock: TwseListedStockService =
            manager.retrofit.create(TwseListedStockService::class.java)
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}