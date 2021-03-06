package com.example.jiang.myapplication.`fun`

import org.junit.Test

/**
 * Created by BigManing on 17-11-7.
 * 内联函数
 *
 * 可以内联的 lambda 表达式只能在内联函数内部调用或者作为可内联的参数传递，
 *
 * 高阶函数 中 参数 或者 返回值的 类型为函数的话 会增加运行时的开销 ， 他们都会形成一个闭包
 * 1 使用 inline 修饰高阶函数   此属性会自动传递给 内部的 函数参数，  使其运行在调用处  尤其是在循环中
 * 2 如果不使用内联   使用notInline来修饰
 */

class Inline {
    @Test
    fun myReturn() {
        ///////////////////////////////////////////////////////////////////////////
        // 这种返回（位于 lambda 表达式中，但退出包含它的函数）称为非局部返回。
        // 我们习惯了在循环中用这种结构，其内联函数通常包含：
        ///////////////////////////////////////////////////////////////////////////
        fun isOK(): Boolean {
//            return listOf(1, 2).filter { it == 0 }.size > 0
            listOf(1, 2).forEach { if (it == 0) return true }
            return false
        }
        println("集合中是否有为0的元素：" + isOK())

    }

    ///////////////////////////////////////////////////////////////////////////
// 请注意，一些内联函数可能调用传给它们的不是直接来自函数体、而是来自另一个执行上下文的 lambda 表达式参数，
// 例如来自局部对象或嵌套函数。在这种情况下，该 lambda 表达式中也不允许非局部控制流。为了标识这种情况，
// 该 lambda 表达式参数需要用
// todo crossinline 修饰符标记:
///////////////////////////////////////////////////////////////////////////
    inline fun f(crossinline body: () -> Unit) {
        var f = object : Runnable {
            override fun run() = body()
        }
    }
    ///////////////////////////////////////////////////////////////////////////
    // 具体化的类型参数
    ///////////////////////////////////////////////////////////////////////////
    /*1 普通的写法以及调用 */

//    fun <T> TreeNode.findParentOfType(clazz: Class<T>):T? {
//        var  p=parent
//        while (p != null && clazz.isInstance(p)) {
//            p=p.parent
//        }
//        return  p as T?
//
//    }
//    TreeNode.findParentOfType(MyTreeNode::class.java)

    /*2 具体化的类型参数 （方法必须是inline修饰的） 的写法以及调用

    inline fun <reified T> TreeNode.findParentOfType(): T? {
        var p = parent
        while (p != null && p !is T) {
            p = p.parent
        }
        return p as T?
    }

我们使用 reified 修饰符来限定类型参数，现在可以在函数内部访问它了， 几乎就像是一个普通的类一样。
 由于函数是内联的，不需要反射，正常的操作符如 !is 和 as 现在都能用了。
 此外，我们还可以按照上面提到的方式调用它：
 myTree.findParentOfType<MyTreeNodeType>()。
 */
}

///////////////////////////////////////////////////////////////////////////
// 内联属性  since 1.1
// inline 修饰符可用于没有幕后字段的属性的访问器。 你可以标注独立的属性访问器：
///////////////////////////////////////////////////////////////////////////
/*
val foo:Foo
  inline  get() = ..

inline  var  bar:Bar
   get()=...
   set(v)={...}


*/


