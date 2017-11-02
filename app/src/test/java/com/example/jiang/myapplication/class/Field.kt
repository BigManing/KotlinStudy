package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by jiang on 17-11-1.
 *  属性和字段
 *  val 只读
 *  var 可变
 */
class AAA {
    @Test
    fun print() {
        backing()
    }

    /**幕后字段 属性*/
    private fun backing() {
        println("count = ${count}")
    }
}

///////////////////////////////////////////////////////////////////////////
// 幕后字段 属性
///////////////////////////////////////////////////////////////////////////
var allByDefault: Int? = 1
var i = 3


// 从1.1 开始  如果可以从getter 中推导出其类型  则可以省略
val b get() = 9 == 0
var count = 0
    get() = 4
    set(value) {
        /*幕后字段

Kotlin 中类不能有字段。然而，当使用自定义访问器时，有时有一个幕后字段（backing field）有时是必要的。
为此 Kotlin 提供一个自动幕后字段，它可通过使用 field 标识符访问。

*/
        field = value
    }

///////////////////////////////////////////////////////////////////////////
// 编译期常量（这个和java 的常量类似）
///////////////////////////////////////////////////////////////////////////
const val  URLAddress="www.baidu.com"
const val  COUNT=3
@Deprecated(URLAddress)  // 可以用在注解上
fun foo() {
    /*
 使用情况
 1 没有自定义的getter方法
 2 位于顶层变量或 object的成员
 3 用string或者原生类型来初始化值

 */
}
