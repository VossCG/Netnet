package com.example.netnet.views.balancesheet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.BalanceSheetRow
import com.example.netnet.model.ResponseResult
import com.example.netnet.repo.BalanceRepository
import kotlinx.coroutines.launch

class BalanceSheetViewModel : ViewModel() {
    private val balanceRepository = BalanceRepository()

    private val _balanceSheet = MutableLiveData<ResponseResult<List<BalanceSheetRow>>>()
    val balanceSheet: LiveData<ResponseResult<List<BalanceSheetRow>>> = _balanceSheet

    fun queryByCode(code: String) {
        viewModelScope.launch {
            Log.d("BalanceSheet","query $code")
            _balanceSheet.value = balanceRepository.queryByCode(code)
        }
    }
}