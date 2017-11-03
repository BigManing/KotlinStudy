package com.example.jiang.myapplication.`fun`

import android.support.v4.R
import com.example.jiang.myapplication.`class`.T
import org.junit.Test
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Created
by BigManing on 17-11-3.
 *lambda 表达式
 */
class AAA {
    @Test
    fun p() {
        myOperation()
        myTransactionOperation()
    }
}

///////////////////////////////////////////////////////////////////////////
// 高阶函数---把函数作为参数 或者 返回类型
///////////////////////////////////////////////////////////////////////////
/*
*  1 如果函数的最后一个参数是函数，那么可以把他写在方法{} 中
*  2  函数作为参数  在调用的时候   要(xx,xx,{...}) lambda 表达式总是被大括号括着
*
*
* */
// 定义高级函数--  线程锁
fun <T> lock(lock: Lock, operation: () -> T): T {
    lock.lock()
    try {
        return operation()
    } finally {
        lock.unlock()
    }
}

// 调用高级函数
fun myOperation() {

    println("lock：" + lock(ReentrantLock(), { "调用lock ，普通写法-lambda" }))
    println("lock：" + lock(ReentrantLock()) {
        "调用lock ， 参数方法的具体实现写在了最外面的{} 里面"
    }
    )
}


///////////////////////////////////////////////////////////////////////////
// map 例子 分析
///////////////////////////////////////////////////////////////////////////

//  list的 map 效果  这里用到了 泛型
fun <T, R> List<T>.myTransaction(ff: (T) -> R): List<R> {
    val list = arrayListOf<R>()
    forEach { list.add(ff(it)) }
    return list
}

// 调用高级函数
fun myTransactionOperation() {
    println()
    val orignal = listOf<Int>(1, 2, 3)
    println(orignal.myTransaction { it.times(2) })   // 结果位2 4 6
}