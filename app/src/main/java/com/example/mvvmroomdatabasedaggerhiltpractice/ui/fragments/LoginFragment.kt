package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.fragment.app.activityViewModels
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentLoginBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.Resource
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity.OrdersActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.Util.showDialog
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
                    showDialog(
                        context = requireContext(),
                        type = SweetAlertDialog.SUCCESS_TYPE,
                        title = "Success!",
                        content = it.data!!.response!!,
                        confirmText = "OK",
                        cancelText = "Cancel",
                        onConfirm = {}
                    )
                    startActivity(Intent(requireActivity(), OrdersActivity::class.java))
                    requireActivity().finish()
                }

                is Resource.Failure -> {
                    dismissProgressDialog()
                    requireContext().showToast(it.message.toString())
                }
            }

        }

    }

    override fun setOnClickListener() {
        binding.relContinue.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (TextUtils.isEmpty(email)) {
                showDialog(
                    context = requireContext(),
                    type = SweetAlertDialog.ERROR_TYPE,
                    title = "Opps...",
                    content = "Please Enter Valid email id",
                    confirmText = "OK",
                    cancelText = "Cancel"
                )
            } else if (TextUtils.isEmpty(password)) {
                showDialog(
                    context = requireContext(),
                    type = SweetAlertDialog.ERROR_TYPE,
                    title = "Opps...",
                    content = "Please Enter Valid Password",
                    confirmText = "OK",
                    cancelText = "Cancel"
                )
            } else {
                viewModel.loginUser(email, password, "37")
            }
        }
    }

}