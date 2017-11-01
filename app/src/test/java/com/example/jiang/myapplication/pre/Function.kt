package com.example.jiang.myapplication.pre

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Function {
    @Test
    fun myTest() {
        println("普通函数 add:" + add(1, 2))
        println("将表达式作为函数体， 返回值会自动类型推导 add2:" + add2(1, 2))
        println("普通函数 add3:" +add3(1, 2))
    }

    /**
     * 定义函数  变量
     * */
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    /** 将表达式作为函数体， 返回值会自动类型推导*/
    fun add2(x: Int, y: Int) = x + y

    /** 返回无意义的值*/
    fun add3(x: Int, y: Int): Unit {
       println("返回无意义的值")
    }


}
