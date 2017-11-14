package com.example.jiang.myapplication

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /** 懒加载  线程不用安全 */
//    val mFragments:Array<Fragment> by lazy(LazyThreadSafetyMode.NONE) { arrayOf(TextFragment(),PicFragment(),GifFragment()) }

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

        val listener = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(listener)

        listener.syncState()


    }
}
