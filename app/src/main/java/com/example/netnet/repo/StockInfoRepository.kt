package com.example.netnet.repo

import android.util.Log
import com.example.netnet.DEBUG_TAG
import com.example.netnet.model.response.StockInfo
import com.example.netnet.remote.ClientManager
import com.example.netnet.model.response.ResponseResult

class StockInfoRepository {

    suspend fun fetchData(): ResponseResult<List<StockInfo>> {
        return try {
            val res = ClientManager.API.getAllDailyStockInfo()
            if (res.isSuccessful) {
                Log.d(DEBUG_TAG, res.body().toString())
                ResponseResult.Success(res.body() ?: emptyList())
            } else {
                ResponseResult.Success(emptyList())
            }
        } catch (e: Exception) {
            ResponseResult.Error(e)
        }
    }
}