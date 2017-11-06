package com.example.jiang.myapplication.`fun`

import android.support.v4.R
import com.example.jiang.myapplication.`class`.T
import com.example.jiang.myapplication.`class`.i
import org.junit.Test
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Created
by BigManing on 17-11-3.
 *lambda 表达式
 */
class AAA {
    @Test
    fun p() {
        myOperation()
        myTransactionOperation()
        myXiaHuaXian()
        myMax()
        myClose()
        myTrue()
    }
}

///////////////////////////////////////////////////////////////////////////
// 高阶函数---把函数作为参数 或者 返回类型
///////////////////////////////////////////////////////////////////////////
/*
*  1 如果函数的最后一个参数是函数，那么可以把他写在方法{} 中
*  2  函数作为参数  在调用的时候   要(xx,xx,{...}) lambda 表达式总是被大括号括着
*
*
* */
// 定义高级函数--  线程锁
fun <T> lock(lock: Lock, operation: () -> T): T {
    lock.lock()
    try {
        return operation()
    } finally {
        lock.unlock()
    }
}

// 调用高级函数
fun myOperation() {

    println("lock：" + lock(ReentrantLock(), { "调用lock ，普通写法-lambda" }))
    println("lock：" + lock(ReentrantLock()) {
        "调用lock ， 如果最后一个参数是 函数，那么 最后一个参数的的具体实现写在了最外面的{} 里面"
    }
    )
}


///////////////////////////////////////////////////////////////////////////
// map 例子 分析
///////////////////////////////////////////////////////////////////////////

//  list的 map 效果  这里用到了 泛型
fun <T, R> List<T>.myTransaction(ff: (T) -> R): List<R> {
    val list = arrayListOf<R>()
    forEach { list.add(ff(it)) }
    return list
}

// 调用高级函数
fun myTransactionOperation() {
    println()
    val orignal = listOf<Int>(1, 22, 3)
    println(orignal.myTransaction { it.times(2) }.sortedByDescending {
        it
    })
//    todo  sortedBy    升序排序   指定按照哪个字段来来升序  如user.name  user.age
//    降序排序  用sortedByDescending 来实现
}

///////////////////////////////////////////////////////////////////////////
// 下划线代表未使用的变量   结合  解构
///////////////////////////////////////////////////////////////////////////
fun myXiaHuaXian() {
    println()
    mapOf("a".to(1), "b".to(2)).forEach { _, value -> println(value) }
    mapOf("a".to(1), "b".to(2)).forEach { println("$it") }
}

///////////////////////////////////////////////////////////////////////////
// 参数的类型
///////////////////////////////////////////////////////////////////////////
/*这里定义一个高阶函数*/
fun <T> max(c: Collection<T>, less: (T, T) -> Boolean): T? {
    var v: T? = null
    for (it in c) {
        if (v == null || less(v, it)) {
            v = it
        }
    }
    return v
}

fun myMax() {
    println()
    println("最大值：" + max(listOf(1, 2, 3), { a, b -> a < b }))
}
///////////////////////////////////////////////////////////////////////////
// Lambda表达式与匿名函数之间的另一个区别是非局部返回的行为。
// 一个不带标签的 return 语句总是在用 fun 关键字声明的函数中返回。
// 这意味着 lambda 表达式中的 return 将从包含它的函数返回，
// 而匿名函数中的 return 将从匿名函数自身返回。
///////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////
// 闭包
///////////////////////////////////////////////////////////////////////////
/*Lambda 表达式或者匿名函数（以及局部函数和对象表达式） 可以访问其 闭包 ，即在外部作用域中声明的变量。
 与 Java 不同的是可以修改闭包中捕获的变量：

*/
fun myClose() {
    println()
    var count = 0
    listOf<Int>(1, 2).forEach { count += it }
    println("闭包值：" + count)

}
///////////////////////////////////////////////////////////////////////////
// 带接受者的函数字面值
///////////////////////////////////////////////////////////////////////////

//var  mySum:  Int.(other :Int) ->Int
//
//1.mysum(2)

//val mySun : fun Int.(other:Int):Int=this+other

val represent: String.(Int) -> Boolean = { other -> toIntOrNull() == other }

fun testOperation(op: (String, Int) -> Boolean, a: String, b: Int, c: Boolean) {
    assert(op(a, b) == c)
}

fun myTrue() {
    testOperation(represent, "1", 1, true)
}

/*例子
* 当接受者类型可以从上下文中推断时，lamda表达式可以用作带接受者的函数字面值
* */

class HTML {
    fun body() {

    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()  //todo  为什么html能调用init方法
    return html

}
//html{
//    body()
//}