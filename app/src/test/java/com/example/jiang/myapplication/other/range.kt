package com.example.jiang.myapplication.other

import org.junit.Test

/**
 * Created by BigManing on 17-11-7.
 * 区间
 */
class range {
    @Test
    fun a() {

        var c = 200
        c.rangeTo(2222)  // 区间对象
        c.downTo(1).step(2).forEach { println(it) }


        //  ... 区间声明
        for (i in 1..3) {
            println("i = ${i}")
        }

        for (a in 10 downTo 1) {
            println("i = ${a}")
        }

//         IntRange  区间类
        for (x in IntRange(2, 100)) {
            println("x = ${x}")
        }

        //  step 步长
        for (i in 1..3 step 2) {
            println("i = ${i}")
        }

    }
}