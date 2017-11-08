package com.example.jiang.myapplication.other

/**
 * Created by BigManing on 17-11-8.
 * 异常
 */
//fun fail(): Nothing {
//    return  IllegalArgumentException("不可能到达的代码")
//}
///////////////////////////////////////////////////////////////////////////
// throw 是一个表达式
///////////////////////////////////////////////////////////////////////////
/*
throw 表达式的类型是特殊类型 Nothing。 该类型没有值，而是用于标记永远不能达到的代码位置。
在你自己的代码中，你可以使用 Nothing 来标记一个永远不会返回的函数：
 */
val s = "".length ?: throw IllegalArgumentException("")

val ss = null   //  Nothing? 类型
val list = listOf(null) // List<Nothing?> 类型