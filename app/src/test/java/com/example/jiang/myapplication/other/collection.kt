package com.example.jiang.myapplication.other

import org.junit.Test

/**
 * Created by BigManing on 17-11-7.
 * 集合
 * l
 */
class ccc {
    @Test
    fun a() {
        myCollection()
        newFur()
    }
}

/*
listOf  setOf  mapOf   只读
multableListOf    multableSetOf  multableMapOf  可以添加元素
kotlin的集合 增加了很多的新特新
*/
fun myCollection() {
    val mutableList = mutableListOf(1, 2, 3)
    val readOnlyList: List<Int> = mutableList

    println("mutableList = ${mutableList}")
    println("readOnlyList = ${readOnlyList}")
    mutableList.add(4)
    println("mutableList = ${mutableList}")
    println("readOnlyList = ${readOnlyList}")



    mutableList.toList()  // 返回只读的list  不能add
}

///////////////////////////////////////////////////////////////////////////
// collection新特性
///////////////////////////////////////////////////////////////////////////
fun newFur() {
    val items = listOf(1, 2, 3, 4)
    items.first() == 1
    items.last() == 1
    items.none()  // 没有元素
    val zip = items.zip(listOf("a", "b", "c"))
    println("zip = ${zip}")  // [(1, a), (2, b), (3, c)]

    val fold = items.fold("a") { acc, i ->
        acc + i   // acc的初始赋值为"a"
    }
    println("fold = ${fold}")  //fold = a1234


    val reduce = items.reduce { acc, i ->
        acc + i  // 定义连个数之间的关系
    }
    println("reduce = ${reduce}")  //reduce = 10

    items.take(2)  // 获取前连个元素
    items.filterNotNull()  // 得到没有null的list
}