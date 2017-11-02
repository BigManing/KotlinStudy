package com.example.jiang.myapplication.`class`

import org.junit.Test
import java.util.*

/**
 * Created by BigManing on 17-11-2.
 * 扩展函数
 * 无需继承   就能扩展原有类的功能
 *
 */

class Ext {
    @Test
    fun print() {
        val list = mutableListOf(1, 2, 3)
        list.swap(0,2)
    }
}

///////////////////////////////////////////////////////////////////////////
// 给MutableList扩展一个方法
///////////////////////////////////////////////////////////////////////////
/*
* this  ： 被扩展对象
* */
fun <T> MutableList<T>.swap(x:Int,y:Int) {
    var i1 = this[x]
    this[x]=this[y]
    this[y]=i1
}