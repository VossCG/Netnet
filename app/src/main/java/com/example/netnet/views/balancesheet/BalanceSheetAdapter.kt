package com.example.netnet.views.balancesheet

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.netnet.databinding.ListItemSheetBinding
import com.example.netnet.model.BalanceSheetRow

class BalanceSheetAdapter :
    ListAdapter<BalanceSheetRow, BalanceSheetAdapter.BalanceViewHolder>(BalanceDiffUtil()) {

    inner class BalanceViewHolder(private val binding: ListItemSheetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(balanceSheetRows: BalanceSheetRow) {
            balanceSheetRows.apply {
                val text = "$item:$currentYearAmount"

                val spannableString = SpannableString(text)

                // 設置 item 部分的文字顏色為黃色
                spannableString.setSpan(
                    ForegroundColorSpan(Color.YELLOW),
                    0,
                    item.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                binding.itemTv.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceViewHolder {
        return BalanceViewHolder(
            ListItemSheetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class BalanceDiffUtil : DiffUtil.ItemCallback<BalanceSheetRow>() {
        override fun areItemsTheSame(oldItem: BalanceSheetRow, newItem: BalanceSheetRow): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: BalanceSheetRow,
            newItem: BalanceSheetRow,
        ): Boolean {
            return oldItem.item == newItem.item
        }
    }
}