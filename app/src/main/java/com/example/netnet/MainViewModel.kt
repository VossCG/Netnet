package com.example.netnet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.listed.ListedBalanceSheet
import com.example.netnet.model.listed.ListedStock
import com.example.netnet.model.ResponseResult
import com.example.netnet.repo.BalanceSheetRepository
import com.example.netnet.repo.StockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val stockRepo = StockRepository()
    private val balanceSheetRepo = BalanceSheetRepository()

    private val _listedBalanceSheets = MutableLiveData<ResponseResult<List<ListedBalanceSheet>>>()
    val listedBalanceSheets: LiveData<ResponseResult<List<ListedBalanceSheet>>> =
        _listedBalanceSheets

    private val _listedStock = MutableLiveData<ResponseResult<List<ListedStock>>>()
    val listedStock: LiveData<ResponseResult<List<ListedStock>>> = _listedStock

    private var allListedBalanceSheets: List<ListedBalanceSheet> = emptyList()
    private var allListedStock: List<ListedStock> = emptyList()

    private val _selectedListedBalanceSheet = MutableStateFlow<ListedBalanceSheet?>(null)
    val selectedListedBalanceSheet: StateFlow<ListedBalanceSheet?> = _selectedListedBalanceSheet

    init {
        viewModelScope.launch {
            _listedBalanceSheets.value = balanceSheetRepo.fetchListedData()
            _listedStock.value = stockRepo.fetchListedData()

            stockRepo.fetchOTCData()
            balanceSheetRepo.fetchOTCData()
        }
    }

    fun refreshBalanceSheets(listedBalanceSheets: List<ListedBalanceSheet>) {
        allListedBalanceSheets = listedBalanceSheets
    }

    fun refreshStockInfo(listedStock: List<ListedStock>) {
        allListedStock = listedStock
    }

    fun getStockInfoByCode(code: String): ListedStock {
        return allListedStock.find { it.code == code } ?: ListedStock()
    }

    fun findBalanceSheetByCode(code: String) {
        _selectedListedBalanceSheet.value = allListedBalanceSheets.find { it.code == code }
    }

}