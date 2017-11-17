package com.example.jiang.myapplication.module

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.model.bean.Joke
import java.util.regex.Pattern

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  RecyclerView  adapter  基类
 */
abstract class ListBaseAdapter<T>(open var mData: List<T>) : RecyclerView.Adapter<ListBaseAdapter.MyViewHolder>() {
    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent?.context).inflate(getResourceId(), parent, false))
    }

    open fun getResourceId() = R.layout.item_joke

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        setItemData(holder, mData[position], position)
    }

    abstract fun setItemData(holder: MyViewHolder, itemData: T, position: Int)

    class MyViewHolder(val item: View) : RecyclerView.ViewHolder(item)
}