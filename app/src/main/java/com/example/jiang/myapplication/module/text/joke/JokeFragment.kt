package com.example.jiang.myapplication.module.text.joke


import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.model.service.JokerService
import com.example.jiang.myapplication.module.ListBaseAdapter
import com.example.jiang.myapplication.module.ListBaseFragment
import kotlinx.android.synthetic.main.item_joke.view.*


/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  段子 笑话界面
 */

class JokeFragment : ListBaseFragment<Joke>() {
    override fun getData(mPage: Int): List<Joke>? {
        return JokerService.getData(mPage)
    }

    override fun getAdapter(mData: List<Joke>): ListBaseAdapter<Joke> {
//        return JokeAdapter(mData)
        return object : ListBaseAdapter<Joke>(mData) {
            override fun setItemData(holder: MyViewHolder, itemData: Joke, position: Int) {
                holder.item.title.text = itemData.title
                holder.item.content.text = itemData.text
            }
        }
    }

}