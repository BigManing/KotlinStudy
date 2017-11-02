package com.example.jiang.myapplication.`class`

/**
 * Created by BigManing on 17-11-2.
 * 泛型
 */
class Generic {
}

///////////////////////////////////////////////////////////////////////////
// 声明处型变  下面样式确保它仅从source《T》成员中返回（生产），并从不被消费，为此我们提供out修饰符
///////////////////////////////////////////////////////////////////////////
//生产者
abstract class Source<out T> {
    abstract fun nextT(): T
}


fun demo(strs: Source<String>) {
    val strs1: Source<Any> = strs
    val nextT = strs1.nextT()
}

//消费者
abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int
}

fun d(x: Comparable<Number>) {
    x.compareTo(1.0)
    val y: Comparable<Double> = x
}
///////////////////////////////////////////////////////////////////////////
// 个人理解
// out-- super  生产者  下限
// in---extend   消费者  上限
///////////////////////////////////////////////////////////////////////////