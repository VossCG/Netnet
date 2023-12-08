package com.example.netnet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ResponseResult
import com.example.netnet.repo.OpenDataRepository
import com.example.netnet.repo.OpenDataRepositoryImp
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: OpenDataRepository = OpenDataRepositoryImp()

    private val _balanceSheets = MutableLiveData<List<BalanceSheet>>()

    private val _selectedBalanceSheet = MutableLiveData<BalanceSheet>()
    val selectedBalanceSheet: LiveData<BalanceSheet> = _selectedBalanceSheet


    suspend fun getAllCompaniesBalanceSheet() {
        _balanceSheets.value = repository.getAllCompaniesBalanceSheet()
    }

    fun calculateNetMet(currentAsset: Float, liabilities: Float, capital: Float): Float {
        val shares = capital / 10f
        return (currentAsset - liabilities) / shares
    }

    fun findBalanceSheetByCode(code: String): Boolean {
        val result = _balanceSheets.value?.find { it.code == code }

        return if (result != null) {
            _selectedBalanceSheet.value = result!!
            true
        } else {
            false
        }
    }
}