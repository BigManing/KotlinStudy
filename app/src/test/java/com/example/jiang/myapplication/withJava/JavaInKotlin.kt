package com.example.jiang.myapplication.withJava

import org.junit.Test
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
///////////////////////////////////////////////////////////////////////////
// java某个参数是可变参数   在kotlin中用*args 来表示这个参数
///////////////////////////////////////////////////////////////////////////
fun kebiancanshu(): Unit {
    val myClass = MyClass()
    val args = intArrayOf(1, 2, 3)
    myClass.remove(*args)
}

///////////////////////////////////////////////////////////////////////////
// kotlin中使用jni  需要使用 external 来修饰
// 在java中  使用  native  来修饰
///////////////////////////////////////////////////////////////////////////
//external fun foo(): Unit {
//
//}