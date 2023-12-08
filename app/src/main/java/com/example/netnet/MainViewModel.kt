package com.example.netnet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.response.StockInfo
import com.example.netnet.model.response.BalanceSheet
import com.example.netnet.model.response.ResponseResult
import com.example.netnet.repo.BalanceSheetRepository
import com.example.netnet.repo.StockInfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val stockInfoRepo = StockInfoRepository()
    private val balanceSheetRepo = BalanceSheetRepository()

    private val _balanceSheets = MutableLiveData<ResponseResult<List<BalanceSheet>>>()
    val balanceSheets: LiveData<ResponseResult<List<BalanceSheet>>> = _balanceSheets

    private val _stockInfo = MutableLiveData<ResponseResult<List<StockInfo>>>()
    val stockInfo: LiveData<ResponseResult<List<StockInfo>>> = _stockInfo

    private var allBalanceSheets: List<BalanceSheet> = emptyList()
    private var allStockInfo: List<StockInfo> = emptyList()

    private val _selectedBalanceSheet = MutableStateFlow<BalanceSheet?>(null)
    val selectedBalanceSheet: StateFlow<BalanceSheet?> = _selectedBalanceSheet

    init {
        viewModelScope.launch {
            _balanceSheets.value = balanceSheetRepo.fetchData()
            _stockInfo.value = stockInfoRepo.fetchData()
        }
    }

    fun refreshBalanceSheets(balanceSheets: List<BalanceSheet>) {
        allBalanceSheets = balanceSheets
    }

    fun refreshStockInfo(stockInfo: List<StockInfo>) {
        allStockInfo = stockInfo
    }

    fun getStockInfoByCode(code: String): StockInfo {
        return allStockInfo.find { it.code == code } ?: StockInfo()
    }

    fun findBalanceSheetByCode(code: String) {
        allBalanceSheets.find { it.code == code }?.let {
            _selectedBalanceSheet.value = it
        }
    }

}