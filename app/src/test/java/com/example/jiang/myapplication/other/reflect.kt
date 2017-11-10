package com.example.jiang.myapplication.other

import com.example.jiang.myapplication.`class`.AAA
import org.junit.Test

/**
 * Created by BigManing on 17-11-8.
 *反射
 *
 */

class Reflect {
    ///////////////////////////////////////////////////////////////////////////
//1  类引用
///////////////////////////////////////////////////////////////////////////
    /*
    我们可以很容易地直接调用它（isOdd(5)），但是我们也可以把它作为一个值传递。例如传给另一个函数。 为此，我们使用 :: 操作符
    当上下文中已知函数期望的类型时，:: 可以用于重载函数。
    */
    val c = this::class  // Kclass
    val jc = this.javaClass  // java class
    @Test
    fun print() {
        println(jc.simpleName)
        ///////////////////////////////////////////////////////////////////////////
        //2 绑定的类引用   在类型判断的时候可以更加的具体
        ///////////////////////////////////////////////////////////////////////////
        var a = AAA()
        assert(a is AAA) { "返回成功：${a::class.simpleName}" }
///////////////////////////////////////////////////////////////////////////
// 3   ::xx 可以作为一个值 来传递
///////////////////////////////////////////////////////////////////////////
        val list = listOf(1, 2, 3)
        fun isNotTwo(i: Int) = i != 2

//        下面这两个是同效的
//        println(list.filter(::isNotTwo))
        println(list.filter { isNotTwo(it) })
//

//        val numbers = listOf(1, 2, 3)
//        fun isOdd(x: Int) = x % 2 != 0
//        println(numbers.filter(::isOdd)) // 输出 [1, 3]
    }
}
