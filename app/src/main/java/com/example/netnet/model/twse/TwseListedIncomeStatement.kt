package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

class TwseListedIncomeStatement(
    @SerializedName("出表日期") val date: String,
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val season: String,
    @SerializedName("公司代號") val code: String,
    @SerializedName("公司名稱") val name: String,
    @SerializedName("營業收入") val operatingRevenue: String,
    @SerializedName("營業成本") val operatingCost: String,
    @SerializedName("營業毛利（毛損）") val operatingProfit: String,
    @SerializedName("營業費用") val operatingExpenses: String,
    @SerializedName("營業利益（損失）") val operatingIncome: String,
    @SerializedName("營業外收入及支出") val nonOperatingIncome: String,
    @SerializedName("稅前淨利（淨損）") val profitBeforeTax: String,
    @SerializedName("所得稅費用（利益）") val incomeTaxExpense: String,
    @SerializedName("繼續營業單位本期淨利（淨損）") val profitFromContinuingOperations: String,
    @SerializedName("停業單位損益") val profitFromDiscontinuedOperations: String,
    @SerializedName("本期綜合損益總額") val comprehensiveIncome: String,
    @SerializedName("本期其他綜合損益（稅後淨額）") val otherComprehensiveIncome: String,
    @SerializedName("本期淨利（淨損）") val netProfit: String,
    @SerializedName("基本每股盈餘（元）") val earningsPerShare: String,
) {
}