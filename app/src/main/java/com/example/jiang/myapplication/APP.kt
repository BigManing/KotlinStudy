package com.example.jiang.myapplication

import android.app.Application
import com.example.jiang.myapplication.commen.notNullSingleValue
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.orhanobut.logger.FormatStrategy
import kotlin.properties.ReadWriteProperty


/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  application 文件
 */
class APP : Application() {
    companion object {
        var instance: APP by notNullSingleValue()


    }
    override fun onCreate() {
        super.onCreate()
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
//                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
//                .tag("My custom tag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}
