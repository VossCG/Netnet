package com.example.netnet.model.otc

import com.google.gson.annotations.SerializedName

data class OTCBalanceSheet(
    @SerializedName("Date") val date: String,
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val quarter: String,
    @SerializedName("SecuritiesCompanyCode") val securitiesCompanyCode: String,
    @SerializedName("CompanyName") val companyName: String,
    @SerializedName("流動資產") val currentAssets: String,
    @SerializedName("非流動資產") val nonCurrentAssets: String,
    @SerializedName("資產總計") val totalAssets: String,
    @SerializedName("流動負債") val currentLiabilities: String,
    @SerializedName("非流動負債") val nonCurrentLiabilities: String,
    @SerializedName("負債總計") val totalLiabilities: String,
    @SerializedName("股本") val capital: String,
    @SerializedName("資本公積") val capitalReserve: String,
    @SerializedName("保留盈餘") val retainedEarnings: String,
    @SerializedName("其他權益") val otherEquity: String,
    @SerializedName("庫藏股票") val treasuryStock: String,
    @SerializedName("權益總計") val totalEquity: String,
    @SerializedName("每股參考淨值") val netAssetValuePerShare: String,
) {

}