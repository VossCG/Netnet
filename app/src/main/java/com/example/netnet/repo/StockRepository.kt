package com.example.netnet.repo

import android.util.Log
import com.example.netnet.DEBUG_TAG
import com.example.netnet.model.ResponseResult
import com.example.netnet.model.otc.OTCStock
import com.example.netnet.remote.otc.OTCClientManager

class StockRepository {

    suspend fun fetchOTCData(): ResponseResult<List<OTCStock>> {
        return try {
            val res = OTCClientManager.API.getAllDailyStock()
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