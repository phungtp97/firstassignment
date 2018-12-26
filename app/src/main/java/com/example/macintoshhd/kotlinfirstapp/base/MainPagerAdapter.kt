package com.example.macintoshhd.kotlinfirstapp.base

import android.app.Activity
import android.graphics.PorterDuff
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

/**
 * Create on 11/13/18
 *
 * @author duonghd
 */

class MainPagerAdapter(
    private val activity: Activity,
    private val fm: FragmentManager,
    private val arrayFragment: ArrayList<Fragment>
) : FragmentStatePagerAdapter(fm) {

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getItem(position: Int): Fragment {
        return arrayFragment[position]
    }

    override fun getCount(): Int {
        return arrayFragment.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}