package com.example.jiang.myapplication.commen

import android.support.v4.app.Fragment
import com.orhanobut.logger.Logger
import org.jetbrains.anko.toast
import com.orhanobut.logger.AndroidLogAdapter


/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 * fragment的扩展
 *
 */
/** fragment的吐司*/
fun Fragment.toast(str: CharSequence) {
    context.toast(str)
}

/**logger 打印*/

fun Fragment.log(str: Any) {
    Logger.d(str)
}