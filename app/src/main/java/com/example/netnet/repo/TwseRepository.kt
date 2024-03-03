package com.example.netnet.repo

import com.example.netnet.model.twse.TwseListedBalanceSheet
import com.example.netnet.remote.twse.TwseClientManager


class TwseRepository {

    suspend fun getBalanceSheet(): List<TwseListedBalanceSheet> {
        val balanceSheet = mutableListOf<TwseListedBalanceSheet>()
        // Listed
        balanceSheet.addAll(TwseClientManager.ListedBalanceSheet.getBD().body() ?: emptyList())
        balanceSheet.addAll(TwseClientManager.ListedBalanceSheet.getCI().body() ?: emptyList())
        balanceSheet.addAll(TwseClientManager.ListedBalanceSheet.getFH().body() ?: emptyList())
        balanceSheet.addAll(TwseClientManager.ListedBalanceSheet.getINS().body() ?: emptyList())
        balanceSheet.addAll(TwseClientManager.ListedBalanceSheet.getMIM().body() ?: emptyList())
        balanceSheet.addAll(TwseClientManager.ListedBalanceSheet.getBASI().body() ?: emptyList())
        return balanceSheet
    }
}