package com.example.netnet.views.balancesheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.twse.TwseListedBalanceSheet
import com.example.netnet.repo.TwseRepository
import kotlinx.coroutines.launch

class BalanceSheetViewModel : ViewModel() {
    private val twseRepository = TwseRepository()

    private val _twseListedBalanceSheets = MutableLiveData<List<TwseListedBalanceSheet>>()
    val twseListedBalanceSheets: LiveData<List<TwseListedBalanceSheet>> = _twseListedBalanceSheets

    private val _selectedBalanceSheet = MutableLiveData<TwseListedBalanceSheet?>()
    val selectedBalanceSheet: LiveData<TwseListedBalanceSheet?> = _selectedBalanceSheet

    init {
        viewModelScope.launch {
            _twseListedBalanceSheets.value = twseRepository.getBalanceSheet()
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