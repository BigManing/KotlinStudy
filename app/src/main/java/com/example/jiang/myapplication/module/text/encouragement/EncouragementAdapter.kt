package com.example.jiang.myapplication.module.text.encouragement

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.model.bean.Rhesis
import kotlinx.android.synthetic.main.item_joke.view.*
import org.jetbrains.anko.find
import java.util.regex.Pattern

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *
 */
class EncouragementAdapter(var mData: List<Rhesis>) : RecyclerView.Adapter<EncouragementAdapter.MyViewHolder>() {
    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_joke, parent, false)
        view.title.visibility = View.GONE
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.item.content.text = mData[position].english + "\n\n" + mData[position].chinese
    }

    class MyViewHolder(val item: View) : RecyclerView.ViewHolder(item)
}