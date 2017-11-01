package com.example.jiang.myapplication.pre

import org.junit.Test

/**
 * Created by jiang on 17-10-31.
 */
class Null {
    //     声明 可为null  使用  ？
    fun parseInt(x:Int): Int? {
        return null
    }

    @Test
    fun test() {
        val p1 = parseInt(1)

        var p2 = parseInt(2)
//        println(p1?.times(p2!!))
        println(p1!! * p2!!)
    }

}

