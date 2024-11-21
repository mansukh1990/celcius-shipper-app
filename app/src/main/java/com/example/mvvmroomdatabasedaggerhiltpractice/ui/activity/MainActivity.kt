package com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ActivityMainBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.isLoggedIn()) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, OrdersActivity::class.java))
                finish()
            }, 2000)
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }

    }

    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun bindViewData() {
    }

    override fun setOnclickListeners() {
    }

    override fun observeData() {

    }


}