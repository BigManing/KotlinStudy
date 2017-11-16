package com.example.jiang.myapplication.module.text.joke

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.module.ListBaseAdapter
import kotlinx.android.synthetic.main.item_joke.view.*
import org.jetbrains.anko.find
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

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

