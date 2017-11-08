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
    val c = this::class  // Kclass
    val jc = this.javaClass  // java class
    @Test
    fun print() {
        println(c.simpleName)
        ///////////////////////////////////////////////////////////////////////////
        //2 绑定的类引用   在类型判断的时候可以更加的具体
        ///////////////////////////////////////////////////////////////////////////
        var a = AAA()
        assert(a is AAA) { "返回成功：${a::class.simpleName}" }

    }

}
