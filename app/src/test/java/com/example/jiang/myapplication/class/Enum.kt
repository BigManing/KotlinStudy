package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by BigManing on 17-11-2.
 * 枚举
 */
enum class ColorMy(val num: Int) {
    RED(0X222), GREEN(0x5234)
}

//自己封装的打印所有值
inline  fun <reified T :Enum<T>> printAllValues(){
    println(enumValues<T>().joinToString { it.name })
}
class dd {
    @Test
    fun d() {
//        1.1 之后  可以使用的方法
        val enumValues = enumValues<ColorMy>()
        println(enumValues.joinToString { it.name })
//        1.1  之前 常用的写法
        val values = ColorMy.values()
//        values.forEach { println(it.name) }
        println(values.joinToString { it.name })


        printAllValues<ColorMy>()
    }
}
///////////////////////////////////////////////////////////////////////////
//
// EnumClass.valueOf(value: String): EnumClass
//EnumClass.values(): Array<EnumClass>
//
//
// 自 Kotlin 1.1 起，可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量
// ：
///////////////////////////////////////////////////////////////////////////