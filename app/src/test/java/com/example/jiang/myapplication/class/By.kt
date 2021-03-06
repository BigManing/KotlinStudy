package com.example.jiang.myapplication.`class`

import android.support.v4.content.res.FontResourcesParserCompat
import org.junit.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by BigManing on 17-11-3.
 * 委托属性
 */
class By {
    var count: Int by DD()
    @Test
    fun t() {
        count = 10  //  赋值   会调用dd 的 set。。
        println(count)   // 取值  会调用dd的 get..
        println()

        println(lazyValue1)
        println(lazyValue1)
        println()


        var lazyUser = LazyUser()
        lazyUser.name = "ok"
        lazyUser.name = "no"
        println()


        var lazyUser1 = LazyUser1()
        lazyUser1.name = "o000"
        lazyUser1.name = "ok"
        println(lazyUser1.name)


        mapTest()
    }
}

///////////////////////////////////////////////////////////////////////////
// 委托    基本语法：var/val  <xx> : <类型> by  <xx表达式>
///////////////////////////////////////////////////////////////////////////
/*
* by 后面的就是委托接受方 其  get  set  都会委托给xx
* */
class DD {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("取值:")
        return 10
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        println("赋值")

    }
}

///////////////////////////////////////////////////////////////////////////
// -- lazy  延迟属性
///////////////////////////////////////////////////////////////////////////


val lazyValue1: String by lazy {
    println("---只会在第一次加载的时候 打印---")
    "普通的延迟加载-- 默认就是 多线程同步的  "
}
val lazyValue2: String by lazy(LazyThreadSafetyMode.PUBLICATION, { "LazyThreadSafetyMode.PUBLICATION" })
val lazyValue3: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED, { "多线程同步  延迟 属性" })


///////////////////////////////////////////////////////////////////////////
// -- observable  可观察属性
///////////////////////////////////////////////////////////////////////////
/*构造参数里面是默认值，
*
* 每当name 变动时就会出发 onchange 函数
* */
class LazyUser {
    var name: String by Delegates.observable("张三") { property, oldValue, newValue ->
        println("property = [${property}], oldValue = [${oldValue}], newValue = [${newValue}]")
    }
}

/*
* 这个方法是否决特定的操作  如果名字变为ok  就拒接
* */
class LazyUser1 {
    var name: String by Delegates.vetoable("李四") { property, oldValue, newValue ->

        var equals = newValue.equals("ok")
        if (equals) {
            println("新该的名字为ok  拒绝它")
        }
        !equals
    }
}
///////////////////////////////////////////////////////////////////////////
// map 属性委托    map中以属性为key  存储着所有的数据
///////////////////////////////////////////////////////////////////////////

/* 要想获取name  去map 里面找*/
class  LazyUser3(val map1: Map<String, Any?>){
    val name:String by map1
    val age:Int by map1
}

fun mapTest() {
    val lazyUser3 = LazyUser3(mapOf(
            "name".to("张三"),
            "age".to(10)
    ))
    println()
    println(lazyUser3.name+"" +
            ":" +
            lazyUser3.age)
}
///////////////////////////////////////////////////////////////////////////
// 局部委托 从1.1开始
/////////////////// ////////////////////////////////////////////////////////
// 伪代码
fun myBy(x: Int) {

    val  count :Int by lazy { x }
    if (3==2) {   // 只有这个表达式成立时  才会初始化count
        println(count)
    }
}

///////////////////////////////////////////////////////////////////////////
// 委托属性的要求
///////////////////////////////////////////////////////////////////////////
/*
* val  实现getValue 方法
* var  实现getValue  setValue 方法
* 通过   operator 关键字来标示
*
* 委托类可以实现 operator 方法的  ReadOnlyProperty /  ReadWriteProperty    这两个都是kotlin的标准库
*
*
* 这里我们总结了委托对象的要求。

对于一个只读属性（即 val 声明的），委托必须提供一个名为 getValue 的函数，该函数接受以下参数：

thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型；
property —— 必须是类型 KProperty<*> 或其超类型。
这个函数必须返回与属性相同的类型（或其子类型）。

对于一个可变属性（即 var 声明的），委托必须额外提供一个名为 setValue 的函数，该函数接受以下参数：

thisRef —— 同 getValue()；
property —— 同 getValue()；
new value —— 必须和属性同类型或者是它的超类型。

* */

///////////////////////////////////////////////////////////////////////////
// 提供委托（自 1.1 起） todo  不甚了解
///////////////////////////////////////////////////////////////////////////
