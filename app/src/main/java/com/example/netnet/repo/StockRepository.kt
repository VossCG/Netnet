package com.example.netnet.repo

import com.example.netnet.model.twse.TwseDailyStock
import com.example.netnet.model.twse.TwseMonthlyStock
import com.example.netnet.remote.twse.TwseClientManager

class StockRepository {

    suspend fun getDailyStock(): List<TwseDailyStock> {
        return TwseClientManager.ListedStock.getDaily().body() ?: emptyList()
    }

    suspend fun getMonthlyStock(): List<TwseMonthlyStock> {
        return TwseClientManager.ListedStock.getMonthly().body() ?: emptyList()
    }
}