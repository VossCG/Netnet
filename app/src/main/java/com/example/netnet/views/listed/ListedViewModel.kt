package com.example.netnet.views.listed

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

class ListedViewModel : ViewModel() {

    private val stockRepo = StockRepository()
    private val balanceSheetRepo = BalanceSheetRepository()

    private val _listedBalanceSheets = MutableLiveData<ResponseResult<List<ListedBalanceSheet>>>()
    val listedBalanceSheets: LiveData<ResponseResult<List<ListedBalanceSheet>>> =
        _listedBalanceSheets

    private val _listedStock = MutableLiveData<ResponseResult<List<ListedStock>>>()
    val listedStock: LiveData<ResponseResult<List<ListedStock>>> = _listedStock

    private var allBalanceSheets: List<ListedBalanceSheet> = emptyList()
    private var allStock: List<ListedStock> = emptyList()

    private val _selectedListedBalanceSheet = MutableStateFlow<ListedBalanceSheet?>(null)
    val selectedListedBalanceSheet: StateFlow<ListedBalanceSheet?> = _selectedListedBalanceSheet

    init {
        viewModelScope.launch {
            _listedBalanceSheets.value = balanceSheetRepo.fetchListedData()
            _listedStock.value = stockRepo.fetchListedData()
        }
    }

    fun refreshBalanceSheets(listedBalanceSheets: List<ListedBalanceSheet>) {
        allBalanceSheets = listedBalanceSheets
    }

    fun refreshStock(listedStock: List<ListedStock>) {
        allStock = listedStock
    }

    fun getStock(code: String): ListedStock? {
        return allStock.find { it.code == code }
    }

    fun findBalanceSheet(code: String): Boolean {
        val balanceSheet = allBalanceSheets.find { it.code == code }

        return if (balanceSheet != null) {
            _selectedListedBalanceSheet.value = balanceSheet
            true
        } else {
            false
        }
    }

}