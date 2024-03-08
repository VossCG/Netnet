package com.example.netnet.views.balancesheet

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.netnet.R
import com.example.netnet.databinding.LayoutBalanceSheetBinding
import com.example.netnet.model.twse.TwseListedBalanceSheet
import com.example.netnet.views.BaseFragment

class BalanceSheetFragment :
    BaseFragment<LayoutBalanceSheetBinding>(LayoutBalanceSheetBinding::inflate) {

    private val viewModel: BalanceSheetViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        setObserver()

    }

    private fun setListener() {
        binding.codeDropdownMenu.setOnItemClickListener { parent, view, position, id ->
            val code = parent.getItemAtPosition(position).toString()
            viewModel.findBalanceSheet(code)
        }
    }

    private fun setObserver() {
        viewModel.selectedBalanceSheet.observe(viewLifecycleOwner) { balanceSheet ->
            balanceSheet?.let {
                setBalanceSheetUI(balanceSheet)
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

    private fun setBalanceSheetUI(balanceSheet: TwseListedBalanceSheet) {
        binding.apply {
            yearTv.text = "年度：" + balanceSheet.year
            seasonTv.text = "季度：" + balanceSheet.season
            codeDropdownInputLayout.suffixText = balanceSheet.name
            currentAssetTv.setText(balanceSheet.currentAssets)
            nonCurrentAssetTv.setText(balanceSheet.nonCurrentAssets)
            totalAssetsTv.setText(balanceSheet.totalAssets)
            currentLiabilitiesTv.setText(balanceSheet.currentLiabilities)
            nonCurrentLiabilitiesTv.setText(balanceSheet.nonCurrentLiabilities)
            totalLiabilitiesTv.setText(balanceSheet.totalLiabilities)
            capitalTv.setText(balanceSheet.capital)
            capitalSurplusTv.setText(balanceSheet.capitalSurplus)
            retainedEarningsTv.setText(balanceSheet.retainedEarnings)
            treasuryStockTv.setText(balanceSheet.treasuryStock)
            nonControllingInterestsTv.setText(balanceSheet.nonControllingInterests)
            otherEquityTv.setText(balanceSheet.otherEquity)
            totalEquityAmountTv.setText(balanceSheet.totalEquityAmount)
            netValuePerShareTv.setText(balanceSheet.netValuePerShare)
        }
    }

}