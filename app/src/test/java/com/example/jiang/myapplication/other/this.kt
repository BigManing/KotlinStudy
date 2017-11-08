package com.example.jiang.myapplication.other

/**
 * Created by BigManing on 17-11-8.
 * this表达式

1 类中 ---本类
2 扩展函数/ 带有接受者的函数字面值---- .符号前面的对象

 */

/**
 *   @lable   限定this
 *
 *    this@..   限定某个对象的this
 * */
class A {
    inner class B {
        fun Int.foo() {

            val a = this@A   // A
            val b = this@B   //B

            val c = this     //Int
            val c1 = this@foo   //Int

            val funLit = lambda@ fun String.() {
                val d = this  //String
            }

            val funLit2 = { s: String ->
                val c2 = this   //Int
            }

        }
    }

}