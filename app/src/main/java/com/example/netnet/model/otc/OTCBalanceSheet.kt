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
    @SerializedName("權益─具證券性質之虛擬通貨") val virtualCurrencyEquity: String,
    @SerializedName("資本公積") val capitalReserve: String,
    @SerializedName("保留盈餘") val retainedEarnings: String,
    @SerializedName("其他權益") val otherEquity: String,
    @SerializedName("庫藏股票") val treasuryStock: String,
    @SerializedName("歸屬於母公司業主之權益合計") val totalEquityToOwners: String,
    @SerializedName("共同控制下前手權益") val equityUnderJointControl: String,
    @SerializedName("合併前非屬共同控制股權") val nonControllingInterests: String,
    @SerializedName("非控制權益") val nonControllingEquity: String,
    @SerializedName("權益總計") val totalEquity: String,
    @SerializedName("待註銷股本股數（單位：股）") val unissuedCapitalStock: String,
    @SerializedName("預收股款（權益項下）之約當發行股數（單位：股）") val prepaymentsForEquity: String,
    @SerializedName("母公司暨子公司所持有之母公司庫藏股股數（單位：股）") val treasuryStockHeldBySubsidiaries: String,
    @SerializedName("每股參考淨值") val netAssetValuePerShare: String,
) {

    fun getCompanyNameText(): String {
        return "公司代號 : $securitiesCompanyCode \t 名稱 : $companyName"
    }

    fun getDateText(): String {
        return "年份 : $year \t 季度 : $quarter"
    }

    fun getCurrentAssetText(): String {
        return "流動資產 : $currentAssets"
    }

    fun getLiabilitiesText(): String {
        return "總負債 : $totalLiabilities"
    }

    fun getCapitalText(): String {
        return "股本 : $capital"
    }

    fun getBookValueText(): String {
        return "每股淨值 : $netAssetValuePerShare"
    }

    private fun getNetNet(): Float {
        val shares = capital.toFloat() / 10f
        return (currentAssets.toFloat() - totalLiabilities.toFloat()) / shares
    }

    fun getNetNetText(): String {
        return "$ ${getNetNet()}"
    }
}