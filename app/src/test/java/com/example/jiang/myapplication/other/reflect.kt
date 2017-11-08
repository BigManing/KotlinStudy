package com.example.jiang.myapplication.other

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

    }

}
