package com.example.jiang.myapplication.commen.util

import com.bumptech.glide.Glide
import com.example.jiang.myapplication.APP
import java.io.File

/**
 * Created by BigManing on 17-11-17.
 * 邮箱：lingshui2008@qq.com
 *
 */
class FileUtils {
    companion object {
        @JvmStatic
        fun getCacheFileSize(file: File): Long {
            var c: Long = 0
            for (file in file.listFiles()) {
                if (!file.isDirectory) {
                    c += file.length()
                } else {
                    c += getCacheFileSize(file)
                }
            }
            return c
        }

        @JvmStatic
        fun getPrintSize(s: Long): String {
            var size = s.toFloat()
            if (size < 1024) {
                return save2float(size) + "B" + ")"
            } else {
                size /= 1024
            }
            if (size < 1024) {
                return save2float(size) + "K" + ")"
            } else {
                size /= 1024
            }
            if (size < 1024) {
                return save2float(size) + "M" + ")"
            } else {
                size /= 1024
            }
            return save2float(size) + "G" + ")"
        }

        private fun save2float(n: Float): String {
            return "(" + (Math.round(n * 100).toFloat() / 100).toString()
        }

        fun cleanCache(): Boolean {
            val photoCacheDir = Glide.getPhotoCacheDir(APP.instance)
            if (photoCacheDir != null) {
                return photoCacheDir.deleteRecursively()

            }
            return true

        }
    }
}
