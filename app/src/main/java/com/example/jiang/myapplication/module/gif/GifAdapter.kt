package com.example.jiang.myapplication.module.gif

import android.graphics.Bitmap
import android.support.annotation.UiThread
import android.text.style.LineHeightSpan
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.jiang.myapplication.R
import com.example.jiang.myapplication.commen.download.ProgressDownload
import com.example.jiang.myapplication.commen.download.ProgressListener
import com.example.jiang.myapplication.commen.util.ScreenUtil
import com.example.jiang.myapplication.model.bean.Gif
import com.example.jiang.myapplication.module.ListBaseAdapter
import kotlinx.android.synthetic.main.item_gif.view.*
import org.jetbrains.anko.ScreenSize
import org.jetbrains.anko.displayMetrics
import pl.droidsonroids.gif.GifDrawable

/**
 * Created by BigManing on 17-11-16.
 * 邮箱：lingshui2008@qq.com
 *  gif  adapter
 */

class GifAdapter(mData: List<Gif>) : ListBaseAdapter<Gif>(mData) {
    var d: GifDrawable? = null
    var mHeights = hashMapOf<Int, Int>()
    fun pause(): Unit {
        d?.pause()

    }
    override fun getResourceId() = R.layout.item_gif
    override fun setItemData(holder: MyViewHolder, itemData: Gif, position: Int) {
        /*主要预加图片 设置view 站位大小*/

        Glide.with(holder.itemView).asBitmap().load(itemData.img)
                .transition(BitmapTransitionOptions.withCrossFade(800))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .listener(object : RequestListener<Bitmap> {
                    override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        if (resource == null) return false

                        // 第一次  网络加载的时候会进入这一步 第二次就直接加载缓存

                        val w = ScreenUtil.w(holder.itemView.context)
                        val h = ((w.toDouble() / resource.width) * resource.height).toInt()
//                        设置布局参数
                        holder.item.gifImageView.layoutParams.height = h
                        holder.item.gifImageView.layoutParams.width = w
                        mHeights.put(position, h)
//                        显示文字
                        holder.item.textView.text = itemData.title
                        holder.item.textView.visibility = View.VISIBLE
                        return false

                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                .into(holder.item.gifImageView)


//
        if (mHeights.containsKey(position)) {
            holder.item.gifImageView.layoutParams.height = mHeights[position]!!
//                        显示文字
            holder.item.textView.text = itemData.title
            holder.item.textView.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            pause()
            ProgressDownload.downloadPhoto(itemData.img, object : ProgressListener {
                override fun onProgress(readByte: Long, totalByte: Long, done: Boolean) {
                    val persent = (readByte.toFloat() / totalByte) * 100
                    println("readByte = [${readByte}], totalByte = [${totalByte}], url = [${itemData.img}], persent = [${persent}]")
                    holder.itemView.post {
                        holder.item.progressBar.visibility = View.VISIBLE
                        holder.item.progressBar.progress = persent
                    }

                }

                override fun onSave(filePath: String) {
                    holder.item.gifImageView?.post {
                        holder.item.progressBar.visibility = View.INVISIBLE
                        d = pl.droidsonroids.gif.GifDrawable(filePath)
                        holder.item.gifImageView.setImageDrawable(d)
                    }

                }

            })
        }
    }
}
