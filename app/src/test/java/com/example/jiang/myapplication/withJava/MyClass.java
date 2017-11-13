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

///////////////////////////////////////////////////////////////////////////
// 静态方法
///////////////////////////////////////////////////////////////////////////
/*
如上所述，Kotlin 将包级函数表示为静态方法。
 Kotlin 还可以为命名对象或伴生对象中定义的函数生成静态方法，如果你将这些函数标注为 @JvmStatic 的话。 如果你使用该注解，编译器既会在相应对象的类中生成静态方法，也会在对象自身中生成实例方法。 例如：
*/
class MyStaticMethod {
    public void cccc() {
        // 伴生对象
        C2.foo();  // 静态调用
//        C2.bar();   这个是通不过的
        C2.Companion.foo();   // 保留实例方法
        C2.Companion.bar();   // 唯一的工作方式

//        命名对象
        Obj1.foo();
        Obj1.INSTANCE.bar();
    }
}