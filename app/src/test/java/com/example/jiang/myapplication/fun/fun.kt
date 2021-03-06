package com.example.jiang.myapplication.`fun`

/**
 * Created by BigManing on 17-11-3.
 * 函数
 */

fun read(b: Array<Byte>, off: Int = 0): Unit {

}

open class funA {
    open fun foo(a: Int = 0) {}
}


fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,  //0 默认参数  可以写好默认值
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
//    ……
}

class funB : funA() {
    override fun foo(a: Int) {  //1  这里不允许  给a 设置默认值

        reformat("ok")// 2 其他参数使用默认值
        reformat(str = "okkk", wordSeparator = 'd') //  参数名-value   这样也是可以的

    }
}

///////////////////////////////////////////////////////////////////////////
// 中缀表示法
///////////////////////////////////////////////////////////////////////////
/*
* 函数还可以用中缀表示法调用，当

他们是成员函数或扩展函数；
他们只有一个参数；
他们用 infix 关键字标注。
* */
infix fun Int.shl(x: Int): Int {
    return 1
}
///////////////////////////////////////////////////////////////////////////
// 函数作用域
///////////////////////////////////////////////////////////////////////////
/*
* 1 顶层函数（随便一个文件夹里面）
* 2 类里面
* 3 函数里面
* */


///////////////////////////////////////////////////////////////////////////
// 尾递归
///////////////////////////////////////////////////////////////////////////

/*限制条件
1  最后一行代码 是本方法的自调用    使用tailrec关键字
2 仅使用在jvm后端中
* */
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(x)

//它等同于下面的方法
fun findFixPoint1(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (x == y) {
            return y
        }
        x = y
    }
}

