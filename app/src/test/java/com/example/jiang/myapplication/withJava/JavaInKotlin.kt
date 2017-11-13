package com.example.jiang.myapplication.withJava

import org.junit.Test
import java.util.*
import kotlin.Comparator

/**
 * Created by BigManing on 17-11-10.
 * 调用java数据
 */
class JavaInKotlin {
    @Test
    fun aa() {
        val calendar = Calendar.getInstance()
        if (calendar.firstDayOfWeek == Calendar.DAY_OF_WEEK) {
            calendar.firstDayOfWeek = Calendar.MONDAY  // 隐式调用了 get set 方法
        }
    }
}

///////////////////////////////////////////////////////////////////////////
// ``  反引符 来转义java中 is  object as 等关键字
// 因为这些是空调林中的关键字
///////////////////////////////////////////////////////////////////////////
//foo.`is`(bar)
///////////////////////////////////////////////////////////////////////////
// java某个参数是可变参数   在kotlin中用*args 来表示这个参数
///////////////////////////////////////////////////////////////////////////
fun kebiancanshu(): Unit {
    val myClass = MyClass()
    val args = intArrayOf(1, 2, 3)
    myClass.remove(*args)
}

///////////////////////////////////////////////////////////////////////////
// kotlin中使用jni  需要使用 external 来修饰
// 在java中  使用  native  来修饰
///////////////////////////////////////////////////////////////////////////
//external fun foo(): Unit {
//
//}

class C(id: String) {
    @JvmField
    val ID = id
    val a = id
}

// kotlin中静态字段  不过属性为私有

/*
在命名对象或伴生对象中声明的 Kotlin 属性会在该命名对象或包含伴生对象的类中具有静态幕后字段。

通常这些字段是私有的，但可以通过以下方式之一暴露出来：

@JvmField 注解；
lateinit 修饰符；
const 修饰符。
*/
class Key(val c: Int) {
    companion object {
        @JvmField
        val comparator: Comparator<Key> = compareBy<Key>({ it.c })
    }
}

// 命名对象 / 伴生对象 延迟初始化的属性 具有属性setter相同的可见性的静态幕后字段
object Singleton {
    lateinit var provider: Key
}


///////////////////////////////////////////////////////////////////////////
// const 标注的属性 在java中 会成为静态字段
///////////////////////////////////////////////////////////////////////////
object Obj {
    const val CONST = 1
}

class C1 {
    companion object {
        const val VERSION = 2
    }
}

const val MAX = 24

///////////////////////////////////////////////////////////////////////////
// 静态方法
///////////////////////////////////////////////////////////////////////////
class C2 {
    companion object {
        // 在伴生对象里 定义静态方法
        @JvmStatic
        fun foo() {
        }

        fun bar() {}
    }
}

object Obj1 {
    // 在命名对象里 定义静态方法
    @JvmStatic
    fun foo() {
    }

    fun bar() {}
}

///////////////////////////////////////////////////////////////////////////
//重载   JvmOverloads   适用于构造函数  普通函数
///////////////////////////////////////////////////////////////////////////
class MyOver @JvmOverloads constructor(x: Int, y: Int = 2) {
    @JvmOverloads
    fun f(a: String, b: String = "b", c: String = "c") {

    }
}