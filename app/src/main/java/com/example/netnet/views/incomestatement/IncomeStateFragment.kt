package com.example.netnet.views.incomestatement

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.netnet.R
import com.example.netnet.databinding.LayoutIncomeStatementBinding
import com.example.netnet.extension.setAccountText
import com.example.netnet.model.twse.TwseListedIncomeStatement
import com.example.netnet.views.BaseFragment

class IncomeStateFragment :
    BaseFragment<LayoutIncomeStatementBinding>(LayoutIncomeStatementBinding::inflate) {

    private val viewModel: IncomeStatementViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setListener()
        setObserver()
    }

    private fun setListener() {
        binding.codeDropdownMenu.setOnItemClickListener { parent, view, position, id ->
            val code = parent.getItemAtPosition(position).toString()
            viewModel.findIncomeStatement(code)
        }
    }

    private fun setObserver() {
        viewModel.selectedListedIncomeStatement.observe(viewLifecycleOwner) { incomeStatement ->
            incomeStatement?.let {
                setIncomeStatementUI(incomeStatement)
            }
        }
        viewModel.allCompaniesCode.observe(viewLifecycleOwner) { allCompaniesCode ->
            binding.codeDropdownMenu.setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.item_dropmenu,
                    allCompaniesCode
                )
            )
        }
    }

    private fun setIncomeStatementUI(incomeStatement: TwseListedIncomeStatement) {
        binding.apply {
            yearTv.text = "年度：" + incomeStatement.year
            seasonTv.text = "季度：" + incomeStatement.season
            codeDropdownInputLayout.suffixText = incomeStatement.name
            operatingCostTv.setAccountText(incomeStatement.operatingCost)
            operatingIncomeTv.setAccountText(incomeStatement.operatingIncome)
            operatingProfitTv.setAccountText(incomeStatement.operatingProfit)
            operatingRevenueTv.setAccountText(incomeStatement.operatingRevenue)
            operatingExpensesTv.setAccountText(incomeStatement.operatingExpenses)
            nonOperatingIncomeTv.setAccountText(incomeStatement.nonOperatingIncome)
            profitBeforeTaxTv.setAccountText(incomeStatement.profitBeforeTax)
            incomeTaxExpenseTv.setAccountText(incomeStatement.incomeTaxExpense)
            profitFromContinuingOperationsTv.setAccountText(incomeStatement.profitFromContinuingOperations)
            profitFromDiscontinuedOperationsTv.setAccountText(incomeStatement.profitFromDiscontinuedOperations)
            comprehensiveIncomeTv.setAccountText(incomeStatement.comprehensiveIncome)
            otherComprehensiveIncomeTv.setAccountText(incomeStatement.otherComprehensiveIncome)
            netProfitTv.setAccountText(incomeStatement.netProfit)
            earningsPerShareTv.setAccountText(incomeStatement.earningsPerShare)
        }
    }
}