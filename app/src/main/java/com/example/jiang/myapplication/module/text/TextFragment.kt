package com.example.jiang.myapplication.module.text

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView

import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.module.text.joke.HardFragment
import com.example.jiang.myapplication.module.text.joke.JokeFragment
import kotlinx.android.synthetic.main.fragment_text.*

/**
 * Created by BigManing on 17-11-14.
 * 邮箱：lingshui2008@qq.com
 *  鸡汤段子
 */

class TextFragment : Fragment() {

    val tabs: Array<String> = arrayOf("墨客段子", "励志深度")
    val fragments: Array<Fragment> by lazy { arrayOf(JokeFragment(), HardFragment()) }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_text, container, false)
    }

    // onCreateView 后  紧接着调用这个方法
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.offscreenPageLimit = tabs.size
        viewPager.adapter = TextAdapter(childFragmentManager)
        tabLayout.tabMode = TabLayout.MODE_FIXED
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class TextAdapter(pm: FragmentManager) : FragmentPagerAdapter(pm) {
        override fun getItem(position: Int): Fragment {
            return fragments[position % tabs.size]
        }

        override fun getCount(): Int {
            return tabs.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return tabs[position]
        }

    }


}