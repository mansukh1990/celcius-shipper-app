package com.example.mvvmroomdatabasedaggerhiltpractice.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.R

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var toolbarTitle: TextView? = null
    private var toolbarBackButton: ImageView? = null

    private lateinit var mProgressDialog: ProgressDialog

    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding()
        setContentView(binding.root)
        mProgressDialog = ProgressDialog(this)
        bindViewData()
        observeData()
        setOnclickListeners()
    }

    abstract fun inflateBinding(): VB
    abstract fun bindViewData()
    abstract fun setOnclickListeners()
    abstract fun observeData()

    fun setToolbar(
        title: String
    ) {
        toolbar = findViewById(R.id.tool_bar)
        toolbarTitle = findViewById(R.id.txt_name)
        toolbarBackButton = findViewById(R.id.ivBack)

        toolbarTitle?.text = title

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


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun addFragment(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment, fragmentTag)
            .commit()
    }

    fun replaceFragment(fragment: Fragment, fragmentTag: String, backStackStateName: String?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, fragmentTag)
            .addToBackStack(backStackStateName)
            .commit()
    }
}
