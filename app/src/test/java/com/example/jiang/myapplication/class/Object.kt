package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by BigManing on 17-11-2.
 * 对象表达式   需要立即执行
 * 对象声明   先声明 在别处引用
 *
 */

class A {
    @Test
    fun t() {
        MyClass.Companion.print()
    }
}

///////////////////////////////////////////////////////////////////////////
// 对象表达式
///////////////////////////////////////////////////////////////////////////
class CC {

    // 返回的就是匿名对象
    private fun foo() = object {
        val x: String = "x"
    }

    //  返回的是Any类型  不能访问其中的x
    public fun foo1() = object {
        val x: String = "x"
    }

    fun ct() {
        foo().x
//        foo1().x
    }
}
///////////////////////////////////////////////////////////////////////////
// 对象声明
// 对象声明不能在局部作用域（即直接嵌套在函数内部），但是它们可以嵌套到其他对象声明或非内部类中。
//todo 和类的声明有声明区别
///////////////////////////////////////////////////////////////////////////


object L : IndexOutOfBoundsException("我的角标越界")
object MyListener


///////////////////////////////////////////////////////////////////////////
// 伴生对象 关键字  companion
///////////////////////////////////////////////////////////////////////////
/*
*
* 不省略---
* */
class MyClass {
    companion object Factory {
        fun create(): MyClass {
            return MyClass()
        }
    }
}

class MyClass1 {
    companion object {  //  伴生对象的名字可以省略
        fun print() {
            println("伴生对象")
        }
    }
}

fun t() {
//    伴生对象  有明确的名字时 可以直接调用其内部的方法
    val myClass = MyClass.create()
    myClass.toString()
//    伴生对象的名字可以省略   然后这样调用  MyClass.Companion()
    MyClass1.Companion.print()
}
