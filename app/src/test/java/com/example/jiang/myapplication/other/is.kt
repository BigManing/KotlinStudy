package com.example.jiang.myapplication.other

import org.junit.Test

/**
 * Created by BigManing on 17-11-8.
 * 类型装换
 */

class Is {
    @Test
    fun aaa() {
        myCast(null)
    }
}

fun myIs(a: Any) {
    ///////////////////////////////////////////////////////////////////////////
    // is  ！is    类型检查/智能转换
    ///////////////////////////////////////////////////////////////////////////
    if (a is String && a.length > 0) {
        println(a)  // 这里已经智能转换了
    }

    when (a) {
        is String -> {
            println(a.length)
        }
        is Int -> {
            println(a)
        }
        else -> {
            println("不是我想要的数据")
        }
    }

    when {
        a is String && a.length == 2 -> {
        }
        a is Int && a == 3 -> {
        }
        else -> {
        }
    }
}

///////////////////////////////////////////////////////////////////////////
// 类型转换  as 转换符
///////////////////////////////////////////////////////////////////////////
fun myCast(y: String?) {

//1 不安全的类型转换 下面这句话会报异常   kotlin.TypeCastException: null cannot be cast to non-null type kotlin.String
    val s: String = y as String
    println(s)

//2 安全的类型转换
// 为了避免抛出异常，可以使用安全转换操作符 as?，它可以在失败时返回 null：
    val ss: String? = null as? String
    println(ss)


}