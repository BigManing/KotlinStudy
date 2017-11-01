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
class Customer1 public  @Inject constructor(name: String){

}
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
    override fun a() {  //  如果不想让Teacher3 覆盖此方法只需要  final 即可
        super.a()
    }
}

class Teacher3 : Teacher2() {
    override fun a() {

        super.a()
    }
}
