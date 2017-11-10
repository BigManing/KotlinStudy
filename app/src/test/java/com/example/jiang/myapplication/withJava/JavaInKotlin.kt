package com.example.jiang.myapplication.withJava

import org.junit.Test
import java.time.DayOfWeek
import java.util.*

/**
 * Created by BigManing on 17-11-10.
 * 调用java数据
 */
class JavaInKotlin {
    @Test
    fun aa() {
        val calendar = Calendar.getInstance()
        if (calendar.firstDayOfWeek == Calendar.DAY_OF_WEEK) {
            calendar.firstDayOfWeek = Calendar.MONDAY  // 隐式调用了 get set 方法
        }
    }
}
///////////////////////////////////////////////////////////////////////////
// ``  反引符 来转义java中 is  object as 等关键字
// 因为这些是空调林中的关键字
///////////////////////////////////////////////////////////////////////////
//foo.`is`(bar)