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
    var x = 0
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
        // 你可以通过将方法引用存储在具有显式指定类型的变量中来提供必要的上下文：
        var p: (Int) -> Boolean = ::isNotTwo

//        val numbers = listOf(1, 2, 3)
//        fun isOdd(x: Int) = x % 2 != 0
//        println(numbers.filter(::isOdd)) // 输出 [1, 3];

        ///////////////////////////////////////////////////////////////////////////
        // 4 属性引用
        ///////////////////////////////////////////////////////////////////////////
        /*

       val a=    ::x   作为一等对象   KProperty<T>
        ::x.name
        ar a=::x   KMutableProperty<T>
       */
        // 属性引用可以用在不需要参数的函数处
        val strs = listOf("a", "bc", "def")
        strs.map(String::length)  // 1,2,3



    }

    // 扩展属性
    val String.lastChar: Char
        get() = this[length - 1]

}
