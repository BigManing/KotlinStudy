package com.example.jiang.myapplication.other

import com.example.jiang.myapplication.`class`.AAA
import org.junit.Test

/**
 * Created by BigManing on 17-11-8.
 * 空类型
 */
class Null {
    @Test
    fun myNull() {
        ///////////////////////////////////////////////////////////////////////////
        // null 安全的调用
        ///////////////////////////////////////////////////////////////////////////
        val list: List<String?> = listOf("ok", null)
        for (s in list) {
//            s?.apply { println(this) }
            s?.let { println(it) }  // 打印不为null的对象
        }
        ///////////////////////////////////////////////////////////////////////////
        // elvis   仅当 ？： 左边的值为null时  才赋予右侧的值
        ///////////////////////////////////////////////////////////////////////////
//        在
        fun foo(a: AAA): String? {
            val s = a.toString() ?: return null
            val e = a.hashCode() ?: throw  IllegalArgumentException("no hashcode ")
            return null
        }
        ///////////////////////////////////////////////////////////////////////////
        //!!操作符
        ///////////////////////////////////////////////////////////////////////////
//        val length = foo(AAA())!!.length  // 断言 不为空    否则会出现空指针异常
        val l = foo(AAA())?.length   // 平时应该这样写    结果为 null 但不会报错
        val lastCount = l ?: 0
        println(l)
        println(lastCount)
        ///////////////////////////////////////////////////////////////////////////
        // 安全的类型转换
        ///////////////////////////////////////////////////////////////////////////
//        val castInt = l as Int  // kotlin.TypeCastException: null cannot be cast to non-null type kotlin.Int
//        println(castInt)
        val castInt = l as? Int
        println("castInt = ${castInt}")  // null  不会报错
///////////////////////////////////////////////////////////////////////////
// 可空类型的集合
///////////////////////////////////////////////////////////////////////////
        val nullList: List<Int?> = listOf(1, 2, null, 9)
        val filterNotNull = nullList.filterNotNull()
        println("filterNotNull = ${filterNotNull}")  //filterNotNull = [1, 2, 9]  去掉了null元素

    }
}
