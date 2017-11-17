package com.example.jiang.myapplication.commen.util

import android.content.Context
import org.jetbrains.anko.displayMetrics

/**
 * Created by BigManing on 17-11-17.
 * 邮箱：lingshui2008@qq.com
 * 屏幕类
 * 单例
 */
object ScreenUtil {
    var h = 0
    var w = 0
    fun h(context: Context): Int {
        return if (h > 0) h else context.displayMetrics.heightPixels

    }

    fun w(context: Context): Int {
        return if (w > 0) w else context.displayMetrics.widthPixels
    }
}
