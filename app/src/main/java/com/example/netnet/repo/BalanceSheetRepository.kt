package com.example.netnet.repo

import android.util.Log
import com.example.netnet.DEBUG_TAG
import com.example.netnet.model.listed.ListedBalanceSheet
import com.example.netnet.remote.listed.ListedClientManager
import com.example.netnet.model.ResponseResult
import com.example.netnet.model.otc.OTCBalanceSheet
import com.example.netnet.remote.otc.OTCClientManager

class BalanceSheetRepository {

    suspend fun fetchListedData(): ResponseResult<List<ListedBalanceSheet>> {
        return try {
            val res = ListedClientManager.API.getAllCompaniesBalanceSheet()
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

    suspend fun fetchOTCData(): ResponseResult<List<OTCBalanceSheet>> {
        return try {
            val res = OTCClientManager.API.getAllCompaniesBalanceSheet()
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