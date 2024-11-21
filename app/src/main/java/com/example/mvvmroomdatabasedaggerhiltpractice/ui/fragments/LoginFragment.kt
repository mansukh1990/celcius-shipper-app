package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentLoginBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.Resource
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity.OrdersActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.Util.showToast
import com.example.mvvmroomdatabasedaggerhiltpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
    }

    override fun bindViewData() {
    }

    override fun setObserver() {
        super.setObserver()
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    showProgressDialog()
                }

                is Resource.Success -> {
                    dismissProgressDialog()
                    requireContext().showToast("Login Success:${it.data!!.response}")
                    startActivity(Intent(requireActivity(), OrdersActivity::class.java))
                    requireActivity().finish()
                }

                is Resource.Failure -> {
                    dismissProgressDialog()
                    requireContext().showToast("Login Failed : ${it.message}")

                }
            }

        }

    }

    override fun setOnClickListener() {
        binding.relContinue.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty()) {
                requireContext().showToast(getString(R.string.enter_email_id))
            }
            if (password.isEmpty()) {
                requireContext().showToast(getString(R.string.enter_password))
            } else {
                viewModel.loginUser(email, password)
            }
        }
    }

}