package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by BigManing on 17-11-2.
 * 数据类 == java中的 javabean
 *
 */
class Data {
    @Test
    fun t() {
        val user = User("张三", 10,"ok")
        user.age=10
        user.copy()
        println(user.component1())
    }
}

///////////////////////////////////////////////////////////////////////////
// 1 数据类的构造函数至少有一个参数
// 2 参数修饰： val 或者 var
// 3 不能抽象 开放 封闭
// 4 实现接口 或者 密封类
///////////////////////////////////////////////////////////////////////////
data class  User(val name: String, var age: Int,val s: String)
// 此时会生成无参的构造函数
data class  User1(val name: String="", var age: Int=1,val s: String="")  //