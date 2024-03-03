package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

data class TwseListedBalanceSheet(
    @SerializedName("年度") val year: String = "",
    @SerializedName("季別") val season: String = "",
    @SerializedName("股本") val capital: String = "",
    @SerializedName("公司代號") val code: String = "",
    @SerializedName("公司名稱") val name: String = "",
    @SerializedName("流動資產") val currentAsset: String = "",
    @SerializedName("資產總額") val asset: String = "",
    @SerializedName("負債總額") val liabilities: String = "",
    @SerializedName("流動負債") val currentLiabilities: String = "",
    @SerializedName("非流動負債") val non_currentLiabilities: String = "",
    @SerializedName("每股參考淨值") val bookValue: String = "",
){
    fun getCompanyNameText(): String {
        return "公司代號 : $code \t 名稱 : $name"
    }

    fun getDateText(): String {
        return "年份 : $year \t 季度 : $season"
    }

    fun getCurrentAssetText(): String {
        return "流動資產 : $currentAsset"
    }

    fun getLiabilitiesText(): String {
        return "總負債 : $liabilities"
    }

    fun getCapitalText(): String {
        return "股本 : $capital"
    }

    fun getBookValueText(): String {
        return "每股淨值 : $bookValue"
    }

    private fun getNetNet(): Float {
        val shares = capital.toFloat() / 10f
        return (currentAsset.toFloat() - liabilities.toFloat()) / shares
    }

    fun getNetNetText(): String {
        return "$ ${getNetNet()}"
    }
}