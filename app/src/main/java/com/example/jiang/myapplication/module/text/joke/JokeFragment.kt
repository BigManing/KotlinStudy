package com.example.jiang.myapplication.module.text.joke


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.commen.log
import kotlinx.android.synthetic.main.fragment_joke.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import kotlin.properties.Delegates


/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  段子 笑话界面
 */

class JokeFragment : Fragment() {
    var c = 1

    //     标示变更后  相应的
    var mLoading by Delegates.observable(true) { _, _, newValue ->
        mSwipeRefreshLayout.isRefreshing = newValue
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
        loadData()
    }

    private fun initEvent() {
//         刷新加载数据
        mSwipeRefreshLayout.setOnRefreshListener {
            log("setOnRefreshListener")
            loadData()
        }
        mRecyclerView.setOnTouchListener { _, _ ->
            if (mLoading.not() && mRecyclerView.canScrollVertically(1).not()) {
                loadData()
            }
            false
        }

    }

    private fun loadData() {
        log("loadData:" + (c++))
        log("改变加载标示")
        mLoading = true
        timerTask { }
        Handler().postDelayed({
            log("过了两秒  就不用加载了")
            mLoading = false
        }, 2000)

    }

    private fun initView() {
        // 加载颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
//        固定位置
        mRecyclerView.setHasFixedSize(true)
//        线性布局
        mRecyclerView.layoutManager = LinearLayoutManager(context)

    }
}