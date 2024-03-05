package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

data class TwseListedBalanceSheet(
    @SerializedName("出表日期") val date: String,
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val season: String,
    @SerializedName("公司代號") val code: String,
    @SerializedName("公司名稱") val name: String,
    @SerializedName("流動資產") val currentAssets: String,
    @SerializedName("非流動資產") val nonCurrentAssets: String,
    @SerializedName("資產總額") val totalAssets: String,
    @SerializedName("流動負債") val currentLiabilities: String,
    @SerializedName("非流動負債") val nonCurrentLiabilities: String,
    @SerializedName("負債總額") val totalLiabilities: String,
    @SerializedName("股本") val capital: String,
    @SerializedName("資本公積") val capitalSurplus: String,
    @SerializedName("保留盈餘") val retainedEarnings: String,
    @SerializedName("其他權益") val otherEquity: String,
    @SerializedName("庫藏股票") val treasuryStock: String,
    @SerializedName("非控制權益") val nonControllingInterests: String,
    @SerializedName("權益總額") val totalEquityAmount: String,
    @SerializedName("待註銷股本股數") val unissuedCapitalStock: String,
    @SerializedName("每股參考淨值") val netValuePerShare: String
){
    private fun getNetNet(): Float {
        val shares = capital.toFloat() / 10f
        return (currentAssets.toFloat() - totalLiabilities.toFloat()) / shares
    }

}