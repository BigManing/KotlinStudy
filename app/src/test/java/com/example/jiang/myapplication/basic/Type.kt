package com.example.jiang.myapplication.basic

import org.junit.Test

/**
 * Created by jiang on 17-11-1.
 * 基本类型
 * Int  32
 * long  64
 * short  16
 * byte  8
 * double  64
 * float 32
 *
 */
class Type {
    @Test
    fun print() {
        equals()
        cast()

    }
/**
 * 装换*/
    private fun cast() {
      val a:Int?=1
       val l=1L+2


    }

    fun equals() {
        val i: Int = 1000
        val x :Int?= i
        val y:Int? = i
        println(x == y)  // true
        println(x === y)  // false  因为在定义x y的时候 声明了可null  int？
    }
}
