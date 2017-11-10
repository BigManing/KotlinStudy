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

        getKotlin()
    }

    // 扩展属性
    val String.lastChar: Char
        get() = this[length - 1]

}

///////////////////////////////////////////////////////////////////////////
// 和java反射的互操作性
///////////////////////////////////////////////////////////////////////////
class AA(val p: String)

/*
在Java平台上，标准库包含反射类的扩展，它提供了与 Java 反射对象之间映射（参见 kotlin.reflect.jvm 包）。
 例如，要查找一个用作 Kotlin 属性 getter 的 幕后字段或 Java方法，可以这样写：
*/
fun getJavaClass() {
//    println(AA::p.javaGetter)  // AA.getP()
//    println(AA::p.javaField)  // AA.p
}

fun getKotlin() {
    val java = AA::class.java
    val kClass = AA::class
    println(kClass)
    println(java)
}

///////////////////////////////////////////////////////////////////////////
// 构造函数引用
///////////////////////////////////////////////////////////////////////////
/*
构造函数可以像方法和属性那样引用。他们可以用于期待这样的函数类型对象的任何地方：它与该构造函数接受相同参数并且返回相应类型的对象。
 通过使用 :: 操作符并添加类名来引用构造函数。考虑下面的函数，
 它期待一个无参并返回 Foo 类型的函数参数：
*/
fun cc(factory: () -> AA) {
    val a: AA = factory()
}
//等价于 fun cc(::AA)

///////////////////////////////////////////////////////////////////////////
// 绑定的函数和属性引用
///////////////////////////////////////////////////////////////////////////
/*
取代直接调用方法 matches 的是我们存储其引用。 这样的引用会绑定到其接收者上。
它可以直接调用（如上例所示）或者用于任何期待一个函数类型表达式的时候
*/
fun myProperty() {

    var xxx = "".toRegex()

    val numberRegex = "\\d+".toRegex()
    println(numberRegex.matches("29")) // 输出“true”

    val isNumber = numberRegex::matches
    println(isNumber("29")) // 输出“true”
}
