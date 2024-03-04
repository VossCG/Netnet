package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

data class TwseMonthlyStock(
    @SerializedName("Code") val code: String,
    @SerializedName("Name") val name: String,
    @SerializedName("HighestPrice") val highestPrice: String,
    @SerializedName("LowestPrice") val lowestPrice: String,
    @SerializedName("WeightedAvgPriceAB") val weightedAvgPriceAB: String,
    @SerializedName("Transaction") val transaction: String,
    @SerializedName("TradeValueA") val tradeValueA: String,
    @SerializedName("TradeVolumeB") val tradeVolumeB: String,
    @SerializedName("TurnoverRatio") val turnoverRatio: String,
)