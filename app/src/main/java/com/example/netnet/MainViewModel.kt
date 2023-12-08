package com.example.netnet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.response.BalanceSheet
import com.example.netnet.remote.ResponseResult
import com.example.netnet.repo.BalanceSheetRepository
import com.example.netnet.repo.StockInfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val balanceSheetRepo = BalanceSheetRepository()

    private val _balanceSheets = MutableLiveData<ResponseResult<List<BalanceSheet>>>()
    val balanceSheets: LiveData<ResponseResult<List<BalanceSheet>>> = _balanceSheets

    private var allBalanceSheets: List<BalanceSheet> = emptyList()

    private val _selectedBalanceSheet = MutableStateFlow<BalanceSheet?>(null)
    val selectedBalanceSheet: StateFlow<BalanceSheet?> = _selectedBalanceSheet

    init {
        viewModelScope.launch {
            _balanceSheets.value = balanceSheetRepo.fetchData()
        }
    }

    fun refreshBalanceSheets(balanceSheets: List<BalanceSheet>) {
        allBalanceSheets = balanceSheets
    }

    fun findBalanceSheetByCode(code: String) {
        _selectedBalanceSheet.value = allBalanceSheets.find { it.code == code }
    }
}