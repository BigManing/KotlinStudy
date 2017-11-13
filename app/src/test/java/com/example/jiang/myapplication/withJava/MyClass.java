package com.example.jiang.myapplication.withJava;

/**
 * Created by BigManing on 17-11-13.
 * 引用kotlin中的东西
 */

public class MyClass {
    public void remove(int... x) {
        System.out.println(x.length);
        //1 kotlin中的JavaInKotlin类
        new JavaInKotlin().aa();
        //2 kotlin中包级别的函数：文件名+Kt+fun名称
        JavaInKotlinKt.kebiancanshu();
    }
}
///////////////////////////////////////////////////////////////////////////
// 在kotlin中
// @file:JvmName("aaa")   标示文件名字
// @JvmMultifileClass     允许相同的名字的文件出现
///////////////////////////////////////////////////////////////////////////

/**
 * demo.Utils.foo();
 * demo.Utils.bar();
 */