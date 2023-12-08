package com.example.netnet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ResponseResult
import com.example.netnet.repo.OpenDataRepository
import com.example.netnet.repo.OpenDataRepositoryImp
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: OpenDataRepository = OpenDataRepositoryImp()

    private val _balanceSheets = MutableLiveData<ResponseResult<List<BalanceSheet>>>()
    val balanceSheets: LiveData<ResponseResult<List<BalanceSheet>>> = _balanceSheets

    private var allBalanceSheets: List<BalanceSheet> = emptyList()

    private val _selectedBalanceSheet = MutableLiveData<BalanceSheet>()
    val selectedBalanceSheet: LiveData<BalanceSheet> = _selectedBalanceSheet

    init {
        viewModelScope.launch {
            _balanceSheets.value = repository.fetchData()
        }
    }

    fun refreshBalanceSheets(balanceSheets: List<BalanceSheet>) {
        allBalanceSheets = balanceSheets
    }

    fun findBalanceSheetByCode(code: String) {
        allBalanceSheets.find { it.code == code }?.let {
            _selectedBalanceSheet.value = it
        }
    }
}