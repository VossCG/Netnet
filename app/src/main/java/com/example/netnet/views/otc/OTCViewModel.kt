package com.example.netnet.views.otc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.ResponseResult
import com.example.netnet.model.otc.OTCBalanceSheet
import com.example.netnet.model.otc.OTCStock
import com.example.netnet.repo.BalanceSheetRepository
import com.example.netnet.repo.StockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OTCViewModel : ViewModel() {

    private val stockRepo: StockRepository = StockRepository()
    private val balanceSheetRepo: BalanceSheetRepository = BalanceSheetRepository()

    private val _stock = MutableLiveData<ResponseResult<List<OTCStock>>>()
    val stock: LiveData<ResponseResult<List<OTCStock>>> = _stock

    private val _balanceSheet = MutableLiveData<ResponseResult<List<OTCBalanceSheet>>>()
    val balanceSheet: LiveData<ResponseResult<List<OTCBalanceSheet>>> = _balanceSheet

    private var allStock: List<OTCStock> = emptyList()
    private var allBalanceSheets: List<OTCBalanceSheet> = emptyList()

    private val _selectedOTCBalanceSheet = MutableStateFlow<OTCBalanceSheet?>(null)
    val selectedOTCBalanceSheet: StateFlow<OTCBalanceSheet?> = _selectedOTCBalanceSheet


    init {
        viewModelScope.launch {
            _stock.value = stockRepo.fetchOTCData()
            _balanceSheet.value = balanceSheetRepo.fetchOTCData()
        }
    }

    fun refreshBalanceSheets(otcBalanceSheets: List<OTCBalanceSheet>) {
        allBalanceSheets = otcBalanceSheets
    }

    fun refreshStock(otcStock: List<OTCStock>) {
        allStock = otcStock
    }

    fun getStock(code: String): OTCStock? {
        return allStock.find { it.securitiesCompanyCode == code }
    }

    fun findBalanceSheet(code: String) {
        _selectedOTCBalanceSheet.value = allBalanceSheets.find { it.securitiesCompanyCode == code }
    }

}