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
import com.example.netnet.model.response.BalanceSheet
import com.example.netnet.remote.ResponseResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        viewModel.balanceSheets.observe(this) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    this.showToast("init Data failure")
                }

                is ResponseResult.Loading -> {}
                is ResponseResult.Success -> {
                    viewModel.refreshBalanceSheets(result.data)
                }
            }
        }

        lifecycleScope.launch {
            launch {
                viewModel.selectedBalanceSheet.collect { balanceSheet ->
                    balanceSheet?.let {
                        setBalanceSheetText(it)
                    }
                }
            }
        }
    }

    private fun setBalanceSheetText(balanceSheet: BalanceSheet) {
        binding.dateTv.text = balanceSheet.getDateText()
        binding.outputTv.text = balanceSheet.getNetNetText()
        binding.capitalTv.text = balanceSheet.getCapitalText()
        binding.bookValueTv.text = balanceSheet.getBookValueText()
        binding.liabilitiesTv.text = balanceSheet.getLiabilitiesText()
        binding.companyNameTv.text = balanceSheet.getCompanyNameText()
        binding.currentAssetTv.text = balanceSheet.getCurrentAssetText()
    }

}