package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

class TwseListedIncomeStatement(
    @SerializedName("出表日期") val date: String,
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val season: String,
    @SerializedName("公司代號") val code: String,
    @SerializedName("公司名稱") val name: String,
    @SerializedName("收益") val revenue: String,
    @SerializedName("支出及費用") val expenses: String,
    @SerializedName("營業利益") val operatingIncome: String,
    @SerializedName("營業外損益") val nonOperatingIncome: String,
    @SerializedName("稅前淨利（淨損）") val profitBeforeTax: String,
    @SerializedName("所得稅費用（利益）") val incomeTaxExpense: String,
    @SerializedName("繼續營業單位本期淨利（淨損）") val netProfitFromContinuingOperations: String,
    @SerializedName("停業單位損益") val profitLossFromDiscontinuedOperations: String,
    @SerializedName("合併前非屬共同控制股權損益") val profitLossFromJointlyControlledEntitiesBeforeMerger: String,
    @SerializedName("本期淨利（淨損）") val netProfitLossForThePeriod: String,
    @SerializedName("本期其他綜合損益（稅後淨額）") val otherComprehensiveIncomeForThePeriod: String,
    @SerializedName("合併前非屬共同控制股權綜合損益淨額") val netComprehensiveIncomeFromJointlyControlledEntitiesBeforeMerger: String,
    @SerializedName("本期綜合損益總額") val totalComprehensiveIncomeForThePeriod: String,
    @SerializedName("淨利（損）歸屬於母公司業主") val netProfitLossAttributableToOwnersOfTheCompany: String,
    @SerializedName("淨利（淨損）歸屬於共同控制下前手權益") val netProfitLossAttributableToOwnersOfControlledJointlyBeforehand: String,
    @SerializedName("淨利（損）歸屬於非控制權益") val netProfitLossAttributableToNonControlEquity: String,
    @SerializedName("綜合損益總額歸屬於母公司業主") val totalComprehensiveIncomeAttributableToOwnersOfTheCompany: String,
    @SerializedName("綜合損益總額歸屬於共同控制下前手權益") val totalComprehensiveIncomeAttributableToControlledJointlyBeforehand: String,
    @SerializedName("綜合損益總額歸屬於非控制權益") val totalComprehensiveIncomeAttributableToNonControlEquity: String,
    @SerializedName("基本每股盈餘（元）") val basicEarningsPerShare: String,
) {
}