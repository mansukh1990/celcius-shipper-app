package com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity

import android.os.Bundle
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ActivityLoginBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(LoginFragment(), getString(R.string.login_fragment_tag))


    }

    override fun inflateBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun bindViewData() {
    }

    override fun setOnclickListeners() {
    }

    override fun observeData() {

    }
}