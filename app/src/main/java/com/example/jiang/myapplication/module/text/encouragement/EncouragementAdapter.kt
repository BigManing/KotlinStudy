package com.example.jiang.myapplication.module.text.encouragement

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.model.bean.Rhesis
import com.example.jiang.myapplication.module.ListBaseAdapter
import kotlinx.android.synthetic.main.item_joke.view.*
import org.jetbrains.anko.find
import java.util.regex.Pattern

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  励志adapter
 */
class EncouragementAdapter(override var mData: List<Rhesis>) : ListBaseAdapter<Rhesis>(mData) {
    override fun setItemData(holder: ListBaseAdapter.MyViewHolder, itemData: Rhesis, position: Int) {
        holder.item.title.text = mData[position].english
        holder.item.content.text = mData[position].chinese
    }
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListBaseAdapter.MyViewHolder {
//        val onCreateViewHolder = super.onCreateViewHolder(parent, viewType)
//        onCreateViewHolder.item.title.visibility = View.GONE
//        return onCreateViewHolder
//    }
}