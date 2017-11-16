package com.example.jiang.myapplication.module.text.encouragement


import com.example.jiang.myapplication.model.bean.Rhesis
import com.example.jiang.myapplication.model.service.EncouragementService
import com.example.jiang.myapplication.model.service.JokerService
import com.example.jiang.myapplication.module.ListBaseAdapter
import com.example.jiang.myapplication.module.ListBaseFragment


/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 * 励志界面
 */

class EncouragementFragment : ListBaseFragment<Rhesis>() {
    override fun getData(mPage: Int): List<Rhesis>? {
        return EncouragementService.getData(mPage)
    }

    override fun getAdapter(mData: List<Rhesis>): ListBaseAdapter<Rhesis> {
        return EncouragementAdapter(mData)

    }
}