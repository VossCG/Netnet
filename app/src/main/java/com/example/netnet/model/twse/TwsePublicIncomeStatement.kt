package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

class TwsePublicIncomeStatement(
    @SerializedName("出表日期") val date: String,
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val quarter: String,
    @SerializedName("公司代號") val code: String,
    @SerializedName("公司名稱") val name: String,
    @SerializedName("利息淨收益") val netInterestIncome: String,
    @SerializedName("利息以外淨損益") val netNonInterestIncome: String,
    @SerializedName("呆帳費用、承諾及保證責任準備提存") val provisionForBadDebts: String,
    @SerializedName("營業費用") val operatingExpenses: String,
    @SerializedName("繼續營業單位稅前淨利（淨損）") val profitBeforeTax: String,
    @SerializedName("所得稅費用（利益）") val incomeTaxExpense: String,
    @SerializedName("繼續營業單位本期稅後淨利（淨損）") val netProfitAfterTax: String,
    @SerializedName("停業單位損益") val discontinuedOperationsProfitLoss: String,
    @SerializedName("合併前非屬共同控制股權損益") val profitLossFromDiscontinuedOperationsBeforeJointControl: String,
    @SerializedName("本期稅後淨利（淨損）") val netProfitLossForThePeriod: String,
    @SerializedName("其他綜合損益（稅後）") val otherComprehensiveIncomeAfterTax: String,
    @SerializedName("合併前非屬共同控制股權綜合損益淨額") val profitLossFromDiscontinuedOperationsBeforeJointControlComprehensiveIncomeNetAmount: String,
    @SerializedName("本期綜合損益總額（稅後）") val totalComprehensiveIncomeForThePeriodAfterTax: String,
    @SerializedName("淨利（損）歸屬於母公司業主") val profitLossAttributableToOwnersOfParent: String,
    @SerializedName("淨利（損）歸屬於共同控制下前手權益") val profitLossAttributableToControllingInterests: String,
    @SerializedName("淨利（損）歸屬於非控制權益") val profitLossAttributableToNonControllingInterests: String,
    @SerializedName("綜合損益總額歸屬於母公司業主") val totalComprehensiveIncomeAttributableToOwnersOfParent: String,
    @SerializedName("綜合損益總額歸屬於共同控制下前手權益") val totalComprehensiveIncomeAttributableToControllingInterests: String,
    @SerializedName("綜合損益總額歸屬於非控制權益") val totalComprehensiveIncomeAttributableToNonControllingInterests: String,
    @SerializedName("基本每股盈餘（元）") val basicEarningsPerShare: String,
) {
}