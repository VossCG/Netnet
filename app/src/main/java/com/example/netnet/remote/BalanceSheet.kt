package com.example.netnet.remote

import com.google.gson.annotations.SerializedName

data class BalanceSheet(
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val season: String,
    @SerializedName("公司代號") val code: String,
    @SerializedName("公司名稱") val name: String,
    @SerializedName("流動資產") val currentAsset: String,
    @SerializedName("資產總額") val asset: String,
    @SerializedName("流動負債") val currentLiabilities: String,
    @SerializedName("非流動負債") val non_currentLiabilities: String,
    @SerializedName("負債總額") val liabilities: String,
    @SerializedName("股本") val capital: String,
    @SerializedName("每股參考淨值") val bookValue: String,
)