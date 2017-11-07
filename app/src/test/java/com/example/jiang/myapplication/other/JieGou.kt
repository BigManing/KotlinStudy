package com.example.jiang.myapplication.other

/**
 * Created by BigManing on 17-11-7.
 * 解构 这个很常见
 */
fun aaa() {
//     把entry 解构成 kv
    mapOf<Int, String>().forEach { k, v -> println("k = ${k}") }
//    不需要的 可以省略
    mapOf<Int, String>().forEach { k, _ -> println("k = ${k}") }
//    默认 一个参数  可以省略成 it
    mapOf<Int, String>().forEach { println("it.key = ${it.key}") }
}

