package com.example.netnet.repo

import com.example.netnet.model.twse.TwseListedBalanceSheet
import com.example.netnet.model.twse.TwseListedIncomeStatement
import com.example.netnet.model.twse.TwsePublicIncomeStatement
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

    suspend fun getIncomeStatement(): List<TwseListedIncomeStatement> {
        val incomeStatement = mutableListOf<TwseListedIncomeStatement>()
        // Listed
        incomeStatement.addAll(
            TwseClientManager.ListedIncomeStatement.getBD().body() ?: emptyList()
        )
        incomeStatement.addAll(
            TwseClientManager.ListedIncomeStatement.getCI().body() ?: emptyList()
        )
        incomeStatement.addAll(
            TwseClientManager.ListedIncomeStatement.getFH().body() ?: emptyList()
        )
        incomeStatement.addAll(
            TwseClientManager.ListedIncomeStatement.getINS().body() ?: emptyList()
        )
        incomeStatement.addAll(
            TwseClientManager.ListedIncomeStatement.getMIM().body() ?: emptyList()
        )
        incomeStatement.addAll(
            TwseClientManager.ListedIncomeStatement.getBASI().body() ?: emptyList()
        )
        return incomeStatement
    }
}