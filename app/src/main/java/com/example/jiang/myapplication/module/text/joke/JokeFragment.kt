package com.example.jiang.myapplication.module.text.joke


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.commen.log
import com.example.jiang.myapplication.commen.toast
import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.model.service.JokerService
import kotlinx.android.synthetic.main.fragment_joke.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.properties.Delegates


/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  段子 笑话界面
 */

class JokeFragment : Fragment() {
    val mData: MutableList<Joke> = arrayListOf()
    var mPage = 1
    //     标示变更后  相应的
    var mLoading by Delegates.observable(true) { _, _, newValue ->
        mSwipeRefreshLayout?.isRefreshing = newValue
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
            mPage = 1  // 这是手动刷新 来获取最新的数据
            loadData()
        }
        mRecyclerView.setOnTouchListener { _, _ ->
            if (mLoading.not() && mRecyclerView.canScrollVertically(1).not()) {
                mPage++
                loadData()
            }
            false
        }

    }

    private fun loadData() {
        mLoading = true
        doAsync {
            val data = JokerService.getData(mPage)
            uiThread {
                mLoading = false
                when {
                    data == null -> {
                        toast("笑话加载失败")
                        return@uiThread
                    }
                    mRecyclerView.adapter == null -> {
                        mData.addAll(data)
                        initAdapter()
                    }
                    mPage > 1 -> {
                        val index = mData.size
                        mData.addAll(data)
                        mRecyclerView.adapter.notifyItemRangeInserted(index, data.size)
                    }
//                     如果是第一页的数据就开始 清除以前的
                    else -> {
                        mData.clear()
                        mData.addAll(data)
                        mRecyclerView.adapter.notifyDataSetChanged()
                    }
                }

            }
        }

    }

    private fun initAdapter() {
        mRecyclerView.adapter = JokeAdapter(mData)

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