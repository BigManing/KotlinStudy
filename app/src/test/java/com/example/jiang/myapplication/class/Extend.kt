package com.example.jiang.myapplication.`class`

import org.junit.Test
import java.util.logging.Logger

/**
 * Created by jiang on 17-11-1.
 * 类和继承
 */
class Extend {
    @Test
    fun print() {
        Teacher5().c()
    }
}
///////////////// 主构造函数
/**
 * 可以定义空的类    大括号都可以省略*/
class  Empty
/**默认的构造函数，如果要初始话东西 只能在init方法里*/
class Customer(name:String){
    init {
        println("AppStore")
    }
}
//class Customer1 public  @Inject constructor(name: String){

//}
///////////////// 次要构造函数

class Customer2{

    constructor(age:String){
        println("age = [${age}]")
    }
}
class Customer3(name:String){

    constructor(age:String,name:String) : this(name) {
        println("age = [${age}]")
    }
}
///////////////// 继承
//类上的 open 标注与 Java 中 final 相反，它允许其他类从这个类继承。默认情况下，在 Kotlin 中所有的类都是 final，
// 对应于 Effective Java书中的第 17 条：要么为继承而设计，并提供文档说明，要么就禁止继承。


open  class  Base(age: Int)
class Teacher (var  name:String, var age: Int) : Base(age){

}
///////////////// 没有open关键字  覆盖方法


abstract class Base1{
    abstract fun a();
}
class Teacher1 : Base1() {
    override fun a() {

    }
}
///////////////// 有open关键字  覆盖方法(必须open 才能被子类覆盖)
open class Base2{
    open fun a(){}
}
open class Teacher2 : Base2() {
  /*final*/  override fun a() {  //  如果不想让Teacher3 覆盖此方法只需要  final 即可
        super.a()
    }
}

class Teacher3 : Teacher2() {
    override fun a() {
        super.a()
    }
}
///////////////// 覆盖属性(和覆盖方法类似 需要指明  open 关键字)
//你也可以用一个 var 属性覆盖一个 val 属性，但反之则不行。这是允许的，因为一个 val 属性本质上声明了一个 getter 方法，
// 而将其覆盖为 var 只是在子类中额外声明一个 setter 方法。



open class Base4{
    open val a:Int get() {return  10}
}
open class Teacher4 : Base4() {
    override val a: Int
        get() = super.a+1
}
open class Teacher41(override val a: Int) : Base4() {
    open fun b(){
        println("超类Teacher41在打印")
    }
}

/////////////////  调用超类实现



open class Base5{
    open val a:Int get() {return  10}
    open fun b(){
        println("超类Base5在打印")
    }
}
open class Teacher5 : Base5() {
    override val a: Int
        get() = super.a+1   //a 直接调用super.    和java 一样

    override fun b() {
        super.b()
    }

    // 内部类
    inner  class Teacher51()  {
        fun g() {
            super@Teacher5.b()    //b  内部类调用外部类的method  需要 super@类名.method

        }
    }

     fun c() {
        Teacher51().g()
    }

}


/////////////////  覆盖原则  如果两个超类都有相同的方法   在覆盖这个方法的时候  调用super<超类> 来显示指定哪个超类
interface T {
    fun b() {   // interface内的方法默认都是open的
        println("超类T在打印")
    }
}


   class Teacher6 : Teacher5(),T  {

       override fun b() {
           //----------------
           super<T>.b()
       }
}


