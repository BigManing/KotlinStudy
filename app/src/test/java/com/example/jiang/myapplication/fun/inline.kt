package com.example.jiang.myapplication.`fun`

import org.junit.Test

/**
 * Created by BigManing on 17-11-7.
 * 内联函数
 *
 * 可以内联的 lambda 表达式只能在内联函数内部调用或者作为可内联的参数传递，
 *
 * 高阶函数 中 参数 或者 返回值的 类型为函数的话 会增加运行时的开销 ， 他们都会形成一个闭包
 * 1 使用 inline 修饰高阶函数   此属性会自动传递给 内部的 函数参数，  使其运行在调用处  尤其是在循环中
 * 2 如果不使用内联   使用notInline来修饰
 */

class Inline {
    @Test
    fun myReturn() {
        ///////////////////////////////////////////////////////////////////////////
        // 这种返回（位于 lambda 表达式中，但退出包含它的函数）称为非局部返回。
        // 我们习惯了在循环中用这种结构，其内联函数通常包含：
        ///////////////////////////////////////////////////////////////////////////
        fun isOK(): Boolean {
//            return listOf(1, 2).filter { it == 0 }.size > 0
            listOf(1, 2).forEach { if (it == 0) return true }
            return false
        }
        println("集合中是否有为0的元素：" + isOK())

    }
}