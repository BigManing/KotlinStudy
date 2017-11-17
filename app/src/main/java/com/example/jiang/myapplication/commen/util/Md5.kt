package com.example.jiang.myapplication.commen.util

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by BigManing on 17-11-17.
 * 邮箱：lingshui2008@qq.com
 * md5  工具类
 */
object MD5Util {
    /**
     * 对url或path进行MD5编码，避免特殊字符导致非法命名文件
     */
    fun getHashKey(key: String): String {
        var cacheKey: String
        try {
            val mDigest = MessageDigest.getInstance("MD5")
            mDigest.update(key.toByteArray())
            cacheKey = bytesToHexString(mDigest.digest())
        } catch (e: NoSuchAlgorithmException) {
            cacheKey = key.hashCode().toString()
        }

        return cacheKey
    }

    private fun bytesToHexString(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (i in bytes.indices) {
            val hex = Integer.toHexString(0xFF and bytes[i].toInt())
            if (hex.length == 1) {
                sb.append('0')
            }
            sb.append(hex)
        }
        return sb.toString()
    }
}
