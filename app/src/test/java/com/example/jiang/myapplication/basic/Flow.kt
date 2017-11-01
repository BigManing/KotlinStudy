package com.example.jiang.myapplication.basic

import org.junit.Test

/**
 * Created by jiang on 17-11-1.
 * 控制流
 */

class Flow {

    @Test
    fun print() {
        myFor()
        myBreak()
    }

    /**
     * break
     * continue
     * */
    private fun myBreak() {
        loop@ for (x in 1..100) {
            for (y in 1..100) {

                if (x == 2 && y == 100) {
                    break@loop   // 跳出三界外  不再执行任何操作了
                } else if(y%2==0) {
                    continue@loop  // 跳出内部循环， 进行外部循环
                }
                println("x:${x},y:${y}")
            }
        }
    }
}

val strs = arrayOf("a", "b")
fun myFor(): Unit {
    for ((index, value) in strs.withIndex()) {
        println("the element at $index is $value")
    }
}