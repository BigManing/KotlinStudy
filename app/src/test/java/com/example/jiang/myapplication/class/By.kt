package com.example.jiang.myapplication.`class`

import org.junit.Test
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
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

        println(lazyValue1)
        println(lazyValue1)

        var lazyUser = LazyUser()
        lazyUser.name="ok"
        lazyUser.name="no"

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


val  lazyValue1: String by lazy{
    println("---只会在第一次加载的时候 打印---")
    "普通的延迟加载-- 默认就是 多线程同步的  "
}
val  lazyValue2: String by lazy(LazyThreadSafetyMode.PUBLICATION,{"LazyThreadSafetyMode.PUBLICATION"})
val  lazyValue3: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED,{"多线程同步  延迟 属性"})


///////////////////////////////////////////////////////////////////////////
// -- observable  可观察属性
///////////////////////////////////////////////////////////////////////////
/*构造参数里面是默认值，
*
* 每当name 变动时就会出发 onchange 函数
* */
class  LazyUser{
    var  name :String by Delegates.observable("张三"){
        property, oldValue, newValue ->
        println("property = [${property}], oldValue = [${oldValue}], newValue = [${newValue}]")
    }
}
