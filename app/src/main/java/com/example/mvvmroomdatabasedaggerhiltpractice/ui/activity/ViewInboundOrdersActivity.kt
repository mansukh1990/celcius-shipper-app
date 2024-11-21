@file:Suppress("DEPRECATION")

package com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.ViewPagerAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ActivityViewInboundOrdersBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.ViewPager2ViewHeightAnimator
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewInboundOrdersActivity : BaseActivity<ActivityViewInboundOrdersBinding>() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setToolbar(getString(R.string.str_view_inbound_orders))
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val viewPager2ViewHeightAnimator = ViewPager2ViewHeightAnimator()
        viewPager2ViewHeightAnimator.viewPager2 = viewPager2

        setViewPager()
        setupTabLayout()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.str_grn)
                }

                1 -> {
                    tab.text = getString(R.string.str_grn_document)
                }

                2 -> {
                    tab.text = getString(R.string.str_quality_check)
                }

                3 -> {
                    tab.text = getString(R.string.str_docum)
                }

                4 -> {
                    tab.text = getString(R.string.str_putaway)
                }

                5 -> {
                    tab.text = getString(R.string.str_status_log)
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager.currentItem = tab.position

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }

    private fun setViewPager() {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))

            }
        })
    }

    override fun inflateBinding() = ActivityViewInboundOrdersBinding.inflate(layoutInflater)


    override fun bindViewData() {
    }

    override fun setOnclickListeners() {
        binding.toolbar.ivBack.setOnClickListener {
            startActivity(Intent(this, OrdersActivity::class.java))
            finish()
        }
    }

    override fun observeData() {

    }

    override fun onBackPressed() {
        val viewPager = binding.viewPager
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem -= 1
        }

    }
}