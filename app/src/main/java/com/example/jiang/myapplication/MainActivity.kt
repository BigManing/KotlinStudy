package com.example.jiang.myapplication

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout

import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.example.jiang.myapplication.commen.preference
import com.example.jiang.myapplication.module.gif.GifFragment
import com.example.jiang.myapplication.module.pic.PicFragment
import com.example.jiang.myapplication.module.text.TextFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    /** 懒加载  线程不用安全 */
    val mFragments: Array<Fragment> by lazy(LazyThreadSafetyMode.NONE) { arrayOf(TextFragment(), PicFragment(), GifFragment()) }
    /**当前默认为自己*/
    var mDefaultIndex: Int by preference(this, "sp_key_default_fragment", 0)
    /** 当前主分类的index*/
    private var mCurrentIndex: Int  by Delegates.observable(0) { _, _, newValue ->
        //         todo 这一步看看需要不
//        navigationView.setCheckedItem(
//                when (newValue) {
//                    0 -> R.id.nav_text
//                    1 -> R.id.nav_pic
//                    2 -> R.id.nav_gif
//                    else -> R.id.nav_text
//                }
//        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        竖向
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        init()
    }

    /** 初始化操作*/
    private fun init() {
        setSupportActionBar(toolbar)

        val listener = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(listener)
        listener.syncState()
//       打开关闭监听
        drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerClosed(drawerView: View?) {
                navigationView.menu.findItem(R.id.nav_clear).title = "清理缓存"
            }

            override fun onDrawerOpened(drawerView: View?) {
                navigationView.menu.findItem(R.id.nav_clear).title = "清理缓存${10}M"
            }
        })
//        navigation  item  点击监听
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_text -> {
                    switchFragment(0, item)
                }
                R.id.nav_pic -> {
                    switchFragment(1, item)
                }
                R.id.nav_gif -> {
                    switchFragment(2, item)
                }
                R.id.nav_clear -> {
                    toast("清理缓存")
                    true
                }
                R.id.nav_about -> {
                    toast("关于界面")
                    true
                }
                else -> false
            }
        }
        // 设置默认页
        mCurrentIndex = mDefaultIndex
        supportFragmentManager.beginTransaction().replace(R.id.content, mFragments[mCurrentIndex]).commitAllowingStateLoss()
//         左侧头像
        Glide.with(this).load(R.mipmap.yhaolpz).into(navigationView.getHeaderView(0).find(R.id.avatar))
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun switchFragment(index: Int, item: MenuItem): Boolean {
        //  非当前fragment
        if (index != mCurrentIndex) {
            val tx = supportFragmentManager.beginTransaction()
            tx.hide(mFragments[mCurrentIndex])
            val indexFragment: Fragment = mFragments[index]
            //
            if (indexFragment.isAdded.not()) {
                tx.add(R.id.content, indexFragment)
            }
            // 显示最新的
            tx.show(indexFragment).commitAllowingStateLoss()
            // 首页的文字也要重新显示
            toolbar.title = item.title.toString()
            mCurrentIndex = index
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }
}

