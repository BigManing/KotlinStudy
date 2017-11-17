package com.example.jiang.myapplication.module.gif

import android.support.v7.widget.RecyclerView
import com.example.jiang.myapplication.commen.toast
import com.example.jiang.myapplication.model.bean.Gif
import com.example.jiang.myapplication.model.service.GifService
import com.example.jiang.myapplication.module.ListBaseAdapter
import com.example.jiang.myapplication.module.ListBaseFragment
import kotlinx.android.synthetic.main.fragment_joke.*


/**
 * Created by BigManing on 17-11-14.
 * 邮箱：lingshui2008@qq.com
 * gif 图片
 */

class GifFragment : ListBaseFragment<Gif>() {
    override fun getData(mPage: Int) = GifService.getData(mPage)

    override fun getAdapter(mData: List<Gif>): ListBaseAdapter<Gif> {
        return GifAdapter(mData)
    }


    override fun initEvent() {
        super.initEvent()
        mRecyclerView.addOnScrollListener(MyListener)
    }


    override fun onDestroy() {
        super.onDestroy()
        // 摧毁的时候  去掉监听器
        mRecyclerView?.removeOnScrollListener(MyListener)
    }

    override fun onPause() {
        super.onPause()
        (mRecyclerView?.adapter  as? GifAdapter)?.pause()
    }

    object MyListener : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            (recyclerView?.adapter  as? GifAdapter)?.pause()
        }
    }
}
