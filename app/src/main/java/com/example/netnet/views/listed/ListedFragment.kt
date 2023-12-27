package com.example.netnet.views.listed

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.netnet.databinding.FragListedBinding
import com.example.netnet.extension.showToast
import com.example.netnet.model.ResponseResult
import com.example.netnet.model.listed.ListedBalanceSheet
import com.example.netnet.views.BaseFragment
import kotlinx.coroutines.launch

class ListedFragment : BaseFragment<FragListedBinding>(FragListedBinding::inflate) {

    private val viewModel: ListedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        setObserver()
    }


    private fun setListener() {
        binding.netNetLayout.searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                val inputText = editable.toString()
                if (inputText.length > 3) {
                    viewModel.findBalanceSheet(editable.toString())
                }
            }
        })

    }

    @SuppressLint("SetTextI18n")
    private fun setObserver() {
        viewModel.listedBalanceSheets.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    requireContext().showToast("init Listed BalanceSheet failure")
                }

                is ResponseResult.Loading -> {}
                is ResponseResult.Success -> {
                    viewModel.refreshBalanceSheets(result.data)
                }
            }
        }

        viewModel.listedStock.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    requireContext().showToast("init Listed Stock failure")
                }

                is ResponseResult.Loading -> {}
                is ResponseResult.Success -> {
                    viewModel.refreshStock(result.data)
                }
            }
        }

        lifecycleScope.launch {
            viewModel.selectedListedBalanceSheet.collect { balanceSheet ->
                balanceSheet?.let {
                    setBalanceSheetUI(it)
                }
            }
        }

    }

    private fun setBalanceSheetUI(listedBalanceSheet: ListedBalanceSheet) {
        binding.netNetLayout.dateTv.text = listedBalanceSheet.getDateText()
        binding.netNetLayout.outputTv.text = listedBalanceSheet.getNetNetText()
        binding.netNetLayout.capitalTv.text = listedBalanceSheet.getCapitalText()
        binding.netNetLayout.bookValueTv.text = listedBalanceSheet.getBookValueText()
        binding.netNetLayout.liabilitiesTv.text = listedBalanceSheet.getLiabilitiesText()
        binding.netNetLayout.companyNameTv.text = listedBalanceSheet.getCompanyNameText()
        binding.netNetLayout.currentAssetTv.text = listedBalanceSheet.getCurrentAssetText()
        binding.netNetLayout.closingPriceTv.text =
            viewModel.getStock(listedBalanceSheet.code)?.getClosingPriceText() ?: "not found"
    }

}