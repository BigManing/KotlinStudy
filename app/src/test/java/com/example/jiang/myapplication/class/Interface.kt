package com.example.jiang.myapplication.`class`

import org.junit.Test

/**
 * Created by BigManing on 17-11-2.
 *接口
 */
class Interface {
    @Test
    fun print() {
    }
}
///////////////////////////////////////////////////////////////////////////
// 接口 普通的书写  和java8类似  可以抽象声明+具体实现
///////////////////////////////////////////////////////////////////////////

/*Kotlin 的接口与 Java 8 类似，既包含抽象方法的声明，也包含实现。与抽象类不同的是，接口无法保存状态。
它可以有属性但必须声明为抽象或提供访问器实现。*/

interface MyInterface {
    var count: Int  // 抽象的属性
    val num        // 具体的属性
        get() = 2

    fun foo()       // 抽象方法
    fun foo1() {   // 具体实现
        println("ok")
    }

}

/*

关于 num 只能是val  不能是var  否则会编译失败

你可以在接口中定义属性。在接口中声明的属性要么是抽象的，要么提供访问器的实现。
在接口中声明的属性不能有幕后字段（backing field），因此接口中声明的访问器不能引用它们。*/


// 接口的实现  要实现抽象的属性以及方法
class Child : MyInterface {
    override var count: Int = 1
    override fun foo() {
        println("Child")
    }
}