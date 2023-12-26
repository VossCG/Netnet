package com.example.netnet.model.otc

import com.google.gson.annotations.SerializedName

data class OTCStock(
    @SerializedName("Date") val date: String,
    @SerializedName("SecuritiesCompanyCode") val securitiesCompanyCode: String,
    @SerializedName("CompanyName") val companyName: String,
    @SerializedName("Close") val close: String,
    @SerializedName("Change") val change: String,
    @SerializedName("Open") val open: String,
    @SerializedName("High") val high: String,
    @SerializedName("Low") val low: String,
    @SerializedName("TradingShares") val tradingShares: String,
    @SerializedName("TransactionAmount") val transactionAmount: String,
    @SerializedName("TransactionNumber") val transactionNumber: String,
    @SerializedName("LatestBidPrice") val latestBidPrice: String,
    @SerializedName("LatesAskPrice") val latestAskPrice: String,
    @SerializedName("Capitals") val capitals: String,
    @SerializedName("NextLimitUp") val nextLimitUp: String,
    @SerializedName("NextLimitDown") val nextLimitDown: String,
)