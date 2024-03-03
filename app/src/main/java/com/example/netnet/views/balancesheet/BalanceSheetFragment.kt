package com.example.netnet.views.balancesheet

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.example.netnet.databinding.LayoutNetnetBinding
import com.example.netnet.extension.toast
import com.example.netnet.model.twse.TwseListedBalanceSheet
import com.example.netnet.views.BaseFragment

class BalanceSheetFragment : BaseFragment<LayoutNetnetBinding>(LayoutNetnetBinding::inflate) {

    private val viewModel: BalanceSheetViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        setObserver()
    }

    private fun setListener() {
        binding.searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                val inputString = editable.toString()
                if (inputString.length > 3) {
                    if (!viewModel.findBalanceSheet(inputString)) {
                        toast("$inputString not found")
                    }
                }
            }

        })
    }

    private fun setObserver() {
        viewModel.selectedBalanceSheet.observe(viewLifecycleOwner) { balanceSheet ->
            balanceSheet?.let {
                setBalanceSheetUI(balanceSheet)
            }
        }
    }

    private fun setBalanceSheetUI(balanceSheet: TwseListedBalanceSheet) {
        binding.apply {
            bookValueTv.text = balanceSheet.getBookValueText()
            dateTv.text = balanceSheet.getDateText()
            capitalTv.text = balanceSheet.getCapitalText()
            companyNameTv.text = balanceSheet.getCompanyNameText()
            currentAssetTv.text = balanceSheet.getCurrentAssetText()
            liabilitiesTv.text = balanceSheet.getLiabilitiesText()
            netnetTv.text = balanceSheet.getNetNetText()
        }
    }

}