package com.example.jiang.myapplication.pre

import org.junit.Test

/**
 * Created by jiang on 17-10-31.
 * 对象的创建
 */
class Class {
    @Test
    fun print() {
        val rectangle = Rectangle(3.0, 4.0)
        val triangle = Triangle(3.0, 4.0, 5.0)
        println(rectangle.isSquare)
        println(rectangle.calculateArea())

        val customer = Customer("zhangsan", "2")


    }
}

/* 定义shap  抽象类*/
abstract class Shap(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

/*接口*/
interface RectangleProperties {
    val isSquare: Boolean
}

class Rectangle(var h: Double, var l: Double) : Shap(listOf(h, l, h, l)), RectangleProperties {
    override fun calculateArea(): Double = h.times(l)

    override val isSquare: Boolean
        get() = h == l

}

class Triangle(var a: Double, var b: Double, var c: Double) : Shap(listOf(a, b, c)) {
    override fun calculateArea(): Double {
        var s = perimeter / 2
        return Math.sqrt(s * (s - a) * s * (s - b) * s * (s - c))
    }

}


data class Customer(var name: String, var age: String)
