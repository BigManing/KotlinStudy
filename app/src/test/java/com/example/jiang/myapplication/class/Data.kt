package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by BigManing on 17-11-2.
 * 数据类 == java中的 javabean
 *
 */
///////////////////////////////////////////////////////////////////////////
// 1 数据类的构造函数至少有一个参数
// 2 参数修饰： val 或者 var
// 3 不能抽象 开放 封闭
// 4 实现接口 或者 密封类
///////////////////////////////////////////////////////////////////////////
data class User(val name: String, var age: Int, val s: String)

// 此时会生成无参的构造函数
data class User1(val name: String = "", val age: Int = 1, val s: String = "")  //


class Data {
    @Test
    fun t() {
        val user = User("张三", 10, "ok")
///////////////////////////////////////////////////////////////////////////
// 复制  把需要变更的写在参数里
///////////////////////////////////////////////////////////////////////////
        val copy = user.copy(name = "李四")
        println(copy.toString())

        ///////////////////////////////////////////////////////////////////////////
        // 结构声明  为数据生成的component 函数可以使他们在结构声明中使用
        ///////////////////////////////////////////////////////////////////////////
        val (name,age,s)=copy
        println("name = ${name}")
//         这个(key,value)就是对map.Entry的解构    好理解吧
        emptyMap<String,String>().map { (key,value)-> println(value) }

    }
}

