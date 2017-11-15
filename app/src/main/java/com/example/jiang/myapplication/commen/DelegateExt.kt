package com.example.jiang.myapplication.commen

import android.content.Context
import android.content.SharedPreferences
import android.preference.Preference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by BigManing on 17-11-14.
 * 邮箱：lingshui2008@qq.com
 * 代理扩展
 */
///////////////////////////////////////////////////////////////////////////
// 委托给SharedPreferences
///////////////////////////////////////////////////////////////////////////
fun <T : Any> preference(context: Context, name: String, default: T): ReadWriteProperty<Any?, T> = MyPreference(context, name, default)

class MyPreference<T>(val context: Context, val name: String, val default: T) : ReadWriteProperty<Any?, T> {
    // 懒加载 sp对象
    val pref: SharedPreferences by lazy { context.getSharedPreferences(name, Context.MODE_PRIVATE) }

    //     获取value
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        // with （A）{ 可以直接调用A的方法 }
        return with(pref) {
            val v: Any = when (default) {
                is Long -> getLong(name, default)
                is Int -> getInt(name, default)
                is Boolean -> getBoolean(name, default)
                is String -> getString(name, default)
                is Float -> getFloat(name, default)
                else -> throw IllegalArgumentException("this type  can  resolved")
            }
            v as T
        }
    }

    //     设置value
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = with(pref.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()

    }
}

