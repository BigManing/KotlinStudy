package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by BigManing on 17-11-2.
 * 嵌套类
 */
class Outer1 {
    @Test
    fun t() {
// 嵌套类
        println(Outer2.Nested().foo())  // 2
// 内部类
        println(Outer2().InnerC().fooC())  // 1
    }

}

class Outer2 {

    private val bar = 1

    ///////////////////////////////////////////////////////////////////////////
    // 嵌套类
    ///////////////////////////////////////////////////////////////////////////
    class Nested {
        fun foo() = 2
    }

    ///////////////////////////////////////////////////////////////////////////
    // 内部类（inner修饰符） 可以访问外部类的成员变量
    ///////////////////////////////////////////////////////////////////////////
    inner class InnerC {
        fun fooC() = bar

    }
}


