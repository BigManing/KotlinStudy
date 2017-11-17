package com.example.jiang.myapplication.module.text.joke

import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.module.ListBaseAdapter
import kotlinx.android.synthetic.main.item_joke.view.*

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 * joke  adapter
 */
class JokeAdapter(override var mData: List<Joke>) : ListBaseAdapter<Joke>(mData) {
    override fun setItemData(holder: MyViewHolder, itemData: Joke, position: Int) {
        holder.item.title.text = itemData.title
        holder.item.content.text = itemData.text
    }
}

