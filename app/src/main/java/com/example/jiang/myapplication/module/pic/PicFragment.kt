package com.example.jiang.myapplication.module.pic


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jiang.myapplication.R
import kotlinx.android.synthetic.main.fragment_pic.*
/**
 * Created by BigManing on 17-11-14.
 * 邮箱：lingshui2008@qq.com
 * 图片详情
 */

class PicFragment : Fragment() {

    val tabs: Array<String> = arrayOf("大胸妹", "小清新", "文艺范", "性感妹", "大长腿", "黑丝袜", "小翘臀")
    val types: Array<Int> = arrayOf(34, 35, 36, 37, 38, 39, 40)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_pic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewPager.offscreenPageLimit = tabs.size
        mViewPager.adapter = PicPageAdapter(childFragmentManager)
        mTabLayout.setupWithViewPager(mViewPager)
    }

    private inner class PicPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return ClassifyPicFragment.newInstance(types[position])
        }

        override fun getPageTitle(position: Int): CharSequence {
            return tabs[position]
        }

        override fun getCount(): Int {
            return tabs.size
        }
    }

}
