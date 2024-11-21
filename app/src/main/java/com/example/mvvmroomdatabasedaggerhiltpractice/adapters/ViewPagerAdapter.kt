package com.example.mvvmroomdatabasedaggerhiltpractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.DocumentsFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.GRNDocumentsFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.GRNFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.PutAwayFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.QualityCheckFragment
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.StatusLogFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GRNFragment()
            1 -> GRNDocumentsFragment()
            2 -> QualityCheckFragment()
            3 -> DocumentsFragment()
            4 -> PutAwayFragment()
            5 -> StatusLogFragment()
            else -> Fragment()
        }
    }

}