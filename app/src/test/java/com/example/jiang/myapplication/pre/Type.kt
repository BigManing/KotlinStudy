package com.example.jiang.myapplication.pre

import org.junit.Test

/**
 * Created by jiang on 17-10-31.
 *  is 判断类型以后 在本分支 就是该类型的子类  不需要显示的转换
 */
class Type {
    fun getLength(x: Any) : Int?= if (x is String) x.length else null
    @Test
    fun print() {
        print(getLength(6))
        print(getLength("asdfasdf"))

    }
}