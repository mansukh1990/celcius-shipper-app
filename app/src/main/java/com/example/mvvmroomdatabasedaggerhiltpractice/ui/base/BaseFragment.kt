package com.example.mvvmroomdatabasedaggerhiltpractice.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

@Suppress("DEPRECATION")
abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: (LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    private lateinit var mProgressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mProgressDialog = ProgressDialog(requireContext())
        bindViewData()
        setOnClickListener()
    }

    abstract fun bindViewData()
    abstract fun setOnClickListener()

    open fun setObserver(){}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showProgressDialog() {
        if (!mProgressDialog.isShowing) {
            mProgressDialog.show()
            mProgressDialog.setCancelable(false)
            mProgressDialog.setCanceledOnTouchOutside(false)
        }
    }

    fun dismissProgressDialog() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }

}