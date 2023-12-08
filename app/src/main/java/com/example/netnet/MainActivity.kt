package com.example.netnet

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.example.netnet.databinding.ActivityMainBinding
import com.example.netnet.extension.showToast
import com.example.netnet.remote.BalanceSheet
import com.example.netnet.remote.ResponseResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObserver()
        setListener()
    }

    private fun initData() {
        runBlocking {
            viewModel.getAllCompaniesBalanceSheet()
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
                viewModel.findBalanceSheetByCode(editable.toString())
            }

        })

    }

    @SuppressLint("SetTextI18n")
    private fun setObserver() {
        viewModel.selectedBalanceSheet.observe(this) { balanceSheet ->
            binding.dateTv.text = "年份 : ${balanceSheet.year} | 季度 : ${balanceSheet.season}"
            binding.companyNameTv.text =
                "公司代號 : ${balanceSheet.code} | 名稱 : ${balanceSheet.name}"
            binding.currentAssetTv.text = "流動資產 : ${balanceSheet.currentAsset}"
            binding.liabilitiesTv.text = "總負債 : ${balanceSheet.liabilities}"
            binding.capitalTv.text = "股本 : ${balanceSheet.capital}"
            binding.bookValueTv.text = "每股淨值 : ${balanceSheet.bookValue}"
            binding.outputTv.text =
                "清算價值 : ${
                    viewModel.calculateNetMet(
                        balanceSheet.currentAsset.toFloat(),
                        balanceSheet.liabilities.toFloat(),
                        balanceSheet.capital.toFloat()
                    )
                }"

        }
    }


}