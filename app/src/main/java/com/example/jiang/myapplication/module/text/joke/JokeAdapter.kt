package com.example.jiang.myapplication.module.text.joke

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.model.bean.Joke
import kotlinx.android.synthetic.main.item_joke.view.*
import org.jetbrains.anko.find
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *
 */
class JokeAdapter(var mData: List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {
    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JokeViewHolder {
        return JokeViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_joke, parent, false))
//        return JokeViewHolder(View.inflate(parent?.context, R.layout.item_joke, null))
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.item.title.text = mData.get(position).title
        //原数据有html标签，过滤掉
        val p_html = compile("<[^>]+>", Pattern.CASE_INSENSITIVE)
        val m_html = p_html.matcher(mData.get(position).text)

        holder.item.content.text = m_html.replaceAll("")
    }

    class JokeViewHolder(val item: View) : RecyclerView.ViewHolder(item)
}

