package com.example.jiang.myapplication.pre

import org.junit.Test

/**
 * Created by jiang on 17-10-31.
 */
class ForWhenWhileRange {
val  count:Int by lazy {
    return@lazy 1
}

    fun String.ok(): String {
        return  "ok"
    }


    val strs = listOf<String>("你",
            "好",
            "啊",
            "adoke",
            "ok",
            "kotlin")
    @Test
    fun print() {
        for1()
        while1()
        strs.forEach { s: String -> when1(s) }
        filter1()
//        range1()
        print("--------".ok())
    }

    private fun range1() {
        println(" ")
        println("frange的用法：")

//        1-10
        for (i in 1..10){
            println(i)
        }

//        10-1
        for (i in 10 downTo 1){
            println(i)
        }

        val map = mapOf("a".to(1), "b".to(2))

    }

    private fun filter1() {
        println(" ")
        println("filter的用法：")
        strs.filter {  it.contains("k")}
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    /**
     * for循环
     *
     * */

    fun for1() {


        println("按照每个对象:")
        for (str in strs) {
            println(str)
        }

        val filter = strs.filter { s -> s.length == 6 }
        println("过滤后的数组集合：" + filter)

//         按照索引 遍历集合
        println("按照索引 遍历集合")
        for (index in strs.indices) {
            println("index:${index},value:${strs[index]}")
        }
//        map 的作用
        val map = strs.map { s -> s + "1" }
        println("map后的数组集合：" + map)

//        这个也是遍历
        map.forEach { s: String -> println(s) }






    }


    /**
     * while
     *
     * */

    fun while1() {
        println()


        var index = 0
        println("while:")
        while (index < strs.size) {
            print(strs[index])
            index++
        }
    }

     /**
     * when
      *   函数这个可以有返回值  也可以没有返回值
     *
     * */

    fun when1(s: String) {
         when (s) {
             "你" -> {
                 println("这是个  你  字 ")
             }
             else -> {
                 println("原封不动的返回去：${s}")
             }
         }
    }




}