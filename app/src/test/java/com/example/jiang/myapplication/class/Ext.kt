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
        list.swap(0, 2)
    }
}

///////////////////////////////////////////////////////////////////////////
// 给MutableList扩展一个方法
///////////////////////////////////////////////////////////////////////////
/*
* this  ： 被扩展对象
* */
fun <T> MutableList<T>.swap(x: Int, y: Int) {
    var i1 = this[x]
    this[x] = this[y]
    this[y] = i1
}

///////////////////////////////////////////////////////////////////////////
// 扩展函数是静态分发的 * 通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。

///////////////////////////////////////////////////////////////////////////
open class C

class D : C()

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

///////////////////////////////////////////////////////////////////////////
// 同名的类中函数 优先级高于 同名的 扩展函数
///////////////////////////////////////////////////////////////////////////
class E : C() {
    fun foo() {
        println("e")
    }
}

fun E.foo() {
    println("扩展函数")
}

//E().foo()    打印的是e
///////////////////////////////////////////////////////////////////////////
// 类 可以为null  我们在扩展函数里来判断它
///////////////////////////////////////////////////////////////////////////
fun Any?.toString(): String {
    if (this == null) {
        return "null"
    }
    return toString();
}

///////////////////////////////////////////////////////////////////////////
// 扩展属性
// 由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
// 这就是为什么扩展属性不能有初始化器。他们的行为只能由显式提供的 getters/setters 定义。
///////////////////////////////////////////////////////////////////////////
val <T> List<T>.lastIndexMy: Int
    get() = size - 1

//val<T> List<T>.lastIndexMy1: Int=2   这个就是错误的


fun f() {
    println(listOf(1, 2).lastIndexMy)
}

///////////////////////////////////////////////////////////////////////////
// 可以在A类中定义其他类的扩展（扩展声明为成员）
///////////////////////////////////////////////////////////////////////////

class F {
    fun D.to() {
//       d类的方法
        toString()
//       f类的方法
        this@F.toString()
    }
}

//
//open class D {
//}
//
//class D1 : D() {
//}
//
//open class C {
//    open fun D.foo() {
//        println("D.foo in C")
//    }
//
//    open fun D1.foo() {
//        println("D1.foo in C")
//    }
//
//    fun caller(d: D) {
//        d.foo()   // 调用扩展函数
//    }
//}
//
//class C1 : C() {
//    override fun D.foo() {
//        println("D.foo in C1")
//    }
//
//    override fun D1.foo() {
//        println("D1.foo in C1")
//    }
//}
//


//C().caller(D())   // 输出 "D.foo in C"
//C1().caller(D())  // 输出 "D.foo in C1" —— 分发接收者虚拟解析
//C().caller(D1())  // 输出 "D.foo in C" —— 扩展接收者静态解析