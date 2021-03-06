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
///////////////////////////////////////////////////////////////////////////
// 对象表达式和对象声明之间的语义差异
///////////////////////////////////////////////////////////////////////////
/*
*
*对象表达式和对象声明之间有一个重要的语义差别：

对象表达式是在使用他们的地方立即执行（及初始化）的；
对象声明是在第一次被访问到时延迟初始化的；
伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配。
* */