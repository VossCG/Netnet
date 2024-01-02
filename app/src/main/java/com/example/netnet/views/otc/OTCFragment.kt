package com.example.netnet.views.otc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.netnet.databinding.FragOtcBinding
import com.example.netnet.extension.showToast
import com.example.netnet.model.ResponseResult
import com.example.netnet.model.otc.OTCBalanceSheet
import com.example.netnet.views.BaseFragment
import kotlinx.coroutines.launch

class OTCFragment : BaseFragment<FragOtcBinding>(FragOtcBinding::inflate) {

    private val viewModel: OTCViewModel by viewModels()
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


    private fun setObserver() {
        viewModel.balanceSheet.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    requireContext().showToast("init OTC BalanceSheet failure")
                }

                is ResponseResult.Loading -> {

                }

                is ResponseResult.Success -> {
                    viewModel.refreshBalanceSheets(result.data)
                }
            }
        }

        viewModel.stock.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    requireContext().showToast("init OTC Stock failure")
                }

                is ResponseResult.Loading -> {}
                is ResponseResult.Success -> {
                    viewModel.refreshStock(result.data)
                }
            }
        }

        lifecycleScope.launch {
            viewModel.selectedOTCBalanceSheet.collect { balanceSheet ->
                balanceSheet?.let {
                    setBalanceSheetUI(balanceSheet)
                }
            }
        }
    }

    private fun setBalanceSheetUI(otcBalanceSheet: OTCBalanceSheet) {
        binding.netNetLayout.dateTv.text = otcBalanceSheet.getDateText()
        binding.netNetLayout.outputTv.text = otcBalanceSheet.getNetNetText()
        binding.netNetLayout.capitalTv.text = otcBalanceSheet.getCapitalText()
        binding.netNetLayout.bookValueTv.text = otcBalanceSheet.getBookValueText()
        binding.netNetLayout.liabilitiesTv.text = otcBalanceSheet.getLiabilitiesText()
        binding.netNetLayout.companyNameTv.text = otcBalanceSheet.getCompanyNameText()
        binding.netNetLayout.currentAssetTv.text = otcBalanceSheet.getCurrentAssetText()
        binding.netNetLayout.closingPriceTv.text =
            viewModel.getStock(otcBalanceSheet.securitiesCompanyCode)?.getClosingPriceText()
    }
}