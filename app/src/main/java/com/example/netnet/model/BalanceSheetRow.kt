package com.example.netnet.model

data class BalanceSheetRow(
    val item: String,
    val currentYearAmount: String,
    val currentYearPercent: String,
    val lastYearAmount: String,
    val lastYearPercent: String,
)