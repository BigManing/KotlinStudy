package com.example.jiang.myapplication.pre

import java.util.function.ToDoubleFunction

/**
 * Created by jiang on 17-10-31.
 * 定义变量
 */
class Var {
    //    一次赋值  只读  类似java的final 修饰符
    val a: Int = 1
    val b = 1
    val c: Int = 0
//    c=1


    //字符串模板
    var str = "看看这个数值是多少：${t()}"
    //    可变变量
    var x = 1

    fun t(): Int {
        return (x++)
    }

    //    条件表达式
    fun maxOf(x: Int, y: Int): Int {
        if (x > y) {
            return x
        } else {
            return y
        }
    }
// 类似Java的三元运算符
    fun maxOf2(x: Int, y: Int) = if (x > y) x else y

}