package com.example.netnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.netnet.databinding.ActivityMainBinding
import com.example.netnet.remote.ResponseResult

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.requestBtn.setOnClickListener {
            viewModel.getAllCompaniesBalanceSheet()
        }

        setObserver()
    }

    private fun setObserver() {
        viewModel.balanceSheet.observe(this) { result ->
            when (result) {
                is ResponseResult.Error -> {
                    binding.loadingProgress.hide()
                    Toast.makeText(this, result.exception.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

                is ResponseResult.Loading -> {
                    binding.loadingProgress.show()
                }

                is ResponseResult.Success -> {
                    binding.loadingProgress.hide()
                    Log.d("Main", result.data.toString())
                }
            }
        }
    }

}