package com.example.netnet.views.balancesheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.twse.TwseListedBalanceSheet
import com.example.netnet.repo.TwseRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BalanceSheetViewModel : ViewModel() {
    private val twseRepository = TwseRepository()

    private val _twseListedBalanceSheets = MutableLiveData<List<TwseListedBalanceSheet>>()
    private val _selectedBalanceSheet = MutableLiveData<TwseListedBalanceSheet?>()
    val selectedBalanceSheet: LiveData<TwseListedBalanceSheet?> = _selectedBalanceSheet

    private val _allCompaniesCode = MutableLiveData<List<String>>()
    val allCompaniesCode: LiveData<List<String>> = _allCompaniesCode

    init {
        viewModelScope.launch {
            val allBalanceSheets = twseRepository.getBalanceSheet()
            _twseListedBalanceSheets.value = allBalanceSheets
            _allCompaniesCode.value = allBalanceSheets.map { it.code }
        }
    }

    fun findBalanceSheet(code: String): Boolean {
        val balanceSheet = _twseListedBalanceSheets.value?.find { it.code == code }

        return if (balanceSheet != null) {
            _selectedBalanceSheet.value = balanceSheet
            true
        } else {
            false
        }
    }

}