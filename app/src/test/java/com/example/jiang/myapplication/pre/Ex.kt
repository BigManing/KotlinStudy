package com.example.jiang.myapplication.pre

import org.junit.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by jiang on 17-10-31.
 * 扩展的东西
 */
class Ex {
    @Test
    fun print() {
        arrayss()
        stream1()


    }
/**
 *  动态解析成 T 对象
 *
 * */
//   inline fun  <reified T:Any> Gson.fromJson(json:jsonElement):T=this.fromJson(json,T::class.java)

    /**
 * array的使用
 * */
    private fun arrayss() {
        val files = File("ok").listFiles()


        //    if not null 缩写
        println(files?.size)

        //    if not null  else 缩写 todo 这里 ？ 是什么意思
        println(files?.size ?: "empty")

        //        //    if not null 缩写
        //        var s= files?.size ? : throw  IllegalStateException("Email is missing!")
        //
        //        println(s)


        // 类似builder  链式调用
        val intArray = IntArray(3)
        intArray.forEach { println(it) }
        intArray
                .apply { fill(-1) }
                .apply { sort() }
    }

    //  todo    创建单例   和 class说明区别
    object Resource {
        val name = "name"
    }
/**
 * java 新io  读取文件
 * 文件读取   非常的简单
 * */
    fun stream1() {

//        val inputStream = File("ss").inputStream()
    val path = Paths.get("/work/project/ep/MyApplication2/app/src/test/java/com/example/jiang/myapplication/" ,
            "ForWhenWhileRange.kt")
    println("path = ${path}")

//    println(File("").absolutePath)
//     获取当前文件所在的文件夹路径
    println(this.javaClass.getResource("").path)

    val inputStream = Files.newInputStream(path)
//      简单的几句话 就能连续打印
        inputStream.buffered().reader().use { println(it.readLines()) }
    }

}