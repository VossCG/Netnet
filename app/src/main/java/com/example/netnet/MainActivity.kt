package com.example.netnet

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.netnet.databinding.ActivityMainBinding
import com.example.netnet.extension.showToast
import com.example.netnet.model.listed.ListedBalanceSheet
import com.example.netnet.model.ResponseResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashScreen()
        setObserver()
        setListener()
    }

    private fun splashScreen() {
        runBlocking {
            delay(1000)
        }
    }

    private fun setListener() {
        binding.searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                val inputText = editable.toString()
                if (inputText.length > 3) {
                    viewModel.findBalanceSheetByCode(editable.toString())
                }
            }
        })

    }

    @SuppressLint("SetTextI18n")
    private fun setObserver() {
        viewModel.listedBalanceSheets.observe(this) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    this.showToast("init BalanceSheet failure")
                }

                is ResponseResult.Loading -> {}
                is ResponseResult.Success -> {
                    viewModel.refreshBalanceSheets(result.data)
                }
            }
        }

        viewModel.listedStock.observe(this) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    this.showToast("init StockInfo failure")
                }

                is ResponseResult.Loading -> {}
                is ResponseResult.Success -> {
                    viewModel.refreshStockInfo(result.data)
                }
            }
        }

        lifecycleScope.launch {
            viewModel.selectedListedBalanceSheet.collect { balanceSheet ->
                balanceSheet?.let {
                    setBalanceSheetText(it)
                }
            }
        }

    }

    private fun setBalanceSheetText(listedBalanceSheet: ListedBalanceSheet) {
        binding.dateTv.text = listedBalanceSheet.getDateText()
        binding.outputTv.text = listedBalanceSheet.getNetNetText()
        binding.capitalTv.text = listedBalanceSheet.getCapitalText()
        binding.bookValueTv.text = listedBalanceSheet.getBookValueText()
        binding.liabilitiesTv.text = listedBalanceSheet.getLiabilitiesText()
        binding.companyNameTv.text = listedBalanceSheet.getCompanyNameText()
        binding.currentAssetTv.text = listedBalanceSheet.getCurrentAssetText()
        binding.closingPriceTv.text =
            "昨日收盤價 : " + viewModel.getStockInfoByCode(listedBalanceSheet.code).closingPrice
    }

}