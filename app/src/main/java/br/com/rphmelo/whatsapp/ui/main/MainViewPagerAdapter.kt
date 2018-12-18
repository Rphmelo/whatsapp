package br.com.rphmelo.whatsapp.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.rphmelo.whatsapp.ui.base.BaseFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    private val myFragments = ArrayList<BaseFragment>()

    override fun getItem(position: Int): Fragment {
        return myFragments[position]
    }

    override fun getCount(): Int {
        return myFragments.size
    }

    fun addFragment(fragment: BaseFragment) {
        myFragments.add(fragment)
    }
}