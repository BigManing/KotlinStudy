package com.example.jiang.myapplication.module

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.commen.toast
import kotlinx.android.synthetic.main.fragment_joke.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.properties.Delegates

/**
 * Created by BigManing on 17-11-16.
 * 邮箱：lingshui2008@qq.com
 *  列表fragment基类
 */
abstract class ListBaseFragment<T> : Fragment() {
    var mData: MutableList<T> = arrayListOf()
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

    open fun initEvent() {
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
            val data: List<T>? = getData(mPage)
            uiThread {
                mLoading = false
                when {
                    data == null -> {
                        toast("笑话加载失败")
                        return@uiThread
                    }
                    mRecyclerView?.adapter == null -> {
                        mData.addAll(data)
                        mRecyclerView.adapter = getAdapter(mData)

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

    /**获取数据*/
    abstract fun getData(mPage: Int): List<T>?

    /**获取适配器*/
    abstract fun getAdapter(mData: List<T>): ListBaseAdapter<T>

    private fun initView() {
        // 加载颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
//        固定位置
        mRecyclerView.setHasFixedSize(true)
//        线性布局
        mRecyclerView.layoutManager = LinearLayoutManager(context)
    }
}
