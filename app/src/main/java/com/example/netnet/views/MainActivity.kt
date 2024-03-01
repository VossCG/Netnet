package com.example.netnet.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.netnet.databinding.ActivityMainBinding
import com.example.netnet.views.balancesheet.BalanceSheetFragment
import com.example.netnet.views.incomestatement.IncomeStateFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragments: List<Fragment> by lazy { listOf(BalanceSheetFragment(), IncomeStateFragment()) }
    private val titles = listOf("資產負債表", "綜合損益表")

    private val tabsAdapter: FragmentStateAdapter = object : FragmentStateAdapter(this) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashScreen()
        setTabs()
    }

    private fun splashScreen() {
        runBlocking {
            delay(1000)
        }
    }
    private fun setTabs() {
        binding.tabViewPager2.apply {
            adapter = tabsAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        TabLayoutMediator(
            binding.fixedTab, binding.tabViewPager2
        ) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

}