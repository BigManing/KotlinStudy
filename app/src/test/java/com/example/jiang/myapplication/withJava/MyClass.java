package com.example.jiang.myapplication.withJava;

import kotlin.jvm.functions.Function5;

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

///////////////////////////////////////////////////////////////////////////
// 实例字段
///////////////////////////////////////////////////////////////////////////
class JavaClient {
    public String getId(C c) {
        return c.ID + c.getA();  //如果没有@JvmField修饰 就只能用get...
    }
}

///////////////////////////////////////////////////////////////////////////
// 静态字段
///////////////////////////////////////////////////////////////////////////
class MyStatic {
    public void cccc() {
//      jvmfield修饰后的字段   可以在外部静态直接调用
        System.out.println(Key.comparator.compare(new Key(1), new Key(2)));

        // 单例 调用静态
        Singleton.provider = new Key(3);
        // 普通的写法
        Singleton.INSTANCE.getProvider();
        Singleton.INSTANCE.setProvider(new Key(2));

//        const 的调用
        int aConst = Obj.CONST;  // 命名对象/单例 里 的属性
        int version = C1.VERSION;  // 伴生对象里面的属性
        int max = JavaInKotlinKt.MAX;  // 包级别的 字段

    }
}