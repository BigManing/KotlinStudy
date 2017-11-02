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

interface  MyInterface {
    fun foo()       // 抽象方法
    fun foo1() {   // 具体实现
        println("ok")
    }
}