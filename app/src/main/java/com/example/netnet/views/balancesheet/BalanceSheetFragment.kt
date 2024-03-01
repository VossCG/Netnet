package com.example.netnet.views.balancesheet

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netnet.databinding.LayoutSheetBinding
import com.example.netnet.extension.toast
import com.example.netnet.model.ResponseResult
import com.example.netnet.views.BaseFragment

class BalanceSheetFragment : BaseFragment<LayoutSheetBinding>(LayoutSheetBinding::inflate) {

    private val balanceSheetAdapter: BalanceSheetAdapter by lazy { BalanceSheetAdapter() }
    private val viewModel: BalanceSheetViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycler()
        setObserver()
        setListener()
    }

    private fun setListener() {
        binding.searchBtn.setOnClickListener {
            val code = binding.searchInput.text.toString()
            viewModel.queryByCode(code)
        }
    }

    private fun setObserver() {

        viewModel.balanceSheet.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Success -> {
                    Log.d("BalanceSheet", result.data.toString())
                    if (result.data.isEmpty()) {
                        toast("not found")
                    } else {
                        balanceSheetAdapter.submitList(result.data)
                    }
                }

                is ResponseResult.Error -> {
                    toast(result.exception.message.toString())
                }

                is ResponseResult.Loading -> {}
            }
        }
    }


    private fun setRecycler() {
        binding.sheetRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = balanceSheetAdapter
        }
    }
}