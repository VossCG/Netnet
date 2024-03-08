package com.example.netnet.views.incomestatement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netnet.model.twse.TwseListedIncomeStatement
import com.example.netnet.repo.TwseRepository
import kotlinx.coroutines.launch

class IncomeStatementViewModel : ViewModel() {
    private val twseRepository = TwseRepository()
    private val _twseListedIncomeStatement = MutableLiveData<List<TwseListedIncomeStatement>>()
    private val _selectedListedIncomeStatement = MutableLiveData<TwseListedIncomeStatement?>()
    val selectedListedIncomeStatement: LiveData<TwseListedIncomeStatement?> =
        _selectedListedIncomeStatement

    private val _allCompaniesCode = MutableLiveData<List<String>>()
    val allCompaniesCode: LiveData<List<String>> = _allCompaniesCode

    init {
        viewModelScope.launch {
            val allIncomeStatements = twseRepository.getIncomeStatement()
            _twseListedIncomeStatement.value = allIncomeStatements
            _allCompaniesCode.value = allIncomeStatements
                .map { it.code }
                .sortedBy { it.toIntOrNull() }
                .filterNot { it.isBlank() }
        }
    }


    fun findIncomeStatement(code: String): Boolean {
        val incomeStatement = _twseListedIncomeStatement.value?.find { it.code == code }

        return if (incomeStatement != null) {
            _selectedListedIncomeStatement.value = incomeStatement
            true
        } else {
            false
        }
    }
}