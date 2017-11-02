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

///////////////////////////////////////////////////////////////////////////
// 扩展函数是静态分发的
///////////////////////////////////////////////////////////////////////////
/*
* 通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
* */
open  class C
class D: C()

fun C.foo() {
    println("c")
}

fun D.foo() {
    println("d")
}

fun p(c: C) {
    c.foo()
}
//p(D())     结果为  "c "----     .foo 只是扩展了原有类 并没有改变原有类的结构   它并

