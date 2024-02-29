package com.example.netnet.remote.twse

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TwseService {
    @POST("mops/web/ajax_t164sb03")
    @FormUrlEncoded
    suspend fun getBalanceSheetByCode(
        @Field("encodeURIComponent") encodeURIComponent: Int = 1,
        @Field("step") step: Int = 1,
        @Field("firstin") firstin: Int = 1,
        @Field("off") off: Int = 1,
        @Field("queryName") queryName: String = "co_id",
        @Field("inpuType") inpuType: String = "co_id",
        @Field("TYPEK") typek: String = "all",
        @Field("isnew") isNew: Boolean = true,
        @Field("co_id") coId: String,
    ): Response<String>
}