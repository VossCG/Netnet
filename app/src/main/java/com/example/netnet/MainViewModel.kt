package com.example.netnet

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

    private val _balanceSheets = MutableLiveData<ResponseResult<List<BalanceSheet>>>()
    val balanceSheet: LiveData<ResponseResult<List<BalanceSheet>>> = _balanceSheets

    fun getAllCompaniesBalanceSheet() {
        viewModelScope.launch {
            repository.getAllCompaniesBalanceSheet()
                .catch { error ->
                    _balanceSheets.value = ResponseResult.Error(error)
                }
                .collect { result ->
                    _balanceSheets.value = result
                }
        }
    }
}