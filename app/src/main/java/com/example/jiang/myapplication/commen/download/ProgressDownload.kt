package com.example.jiang.myapplication.commen.download

import com.example.jiang.myapplication.APP
import com.example.jiang.myapplication.commen.util.MD5Util
import okhttp3.*
import okio.Okio
import java.io.File
import java.io.IOException

/**
 * Created by BigManing on 17-11-17.
 * 邮箱：lingshui2008@qq.com
 *  进度加载类
 */


object ProgressDownload {

    private var progressListener: ProgressListener? = null


    private val mClient: OkHttpClient by lazy {
        OkHttpClient.Builder().addNetworkInterceptor(ProgressInterceptor(listener)).build()
    }


    private val listener: ProgressListener = object : ProgressListener {
        override fun onProgress(readByte: Long, totalByte: Long, done: Boolean) {
            progressListener?.onProgress(readByte, totalByte, done)
        }

        override fun onSave(filePath: String) {}
    }

    fun downloadPhoto(url: String, progressListener: ProgressListener) {
        val existFilePath: String? = exist(url)
        if (existFilePath != null) {
            progressListener.onSave(existFilePath)
            return
        }
        this.progressListener = progressListener
        val request = Request.Builder()
                .url(url)
                .build()
        mClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val file = File(APP.instance.cacheDir, MD5Util.getHashKey(url))
                val sink = Okio.buffer(Okio.sink(file))
                val source = response.body()!!.source()
                sink.writeAll(source)
                sink.flush()
                progressListener.onSave(file.absolutePath)
            }

        })
    }

    fun exist(url: String): String? {
        val file = File(APP.instance.cacheDir, MD5Util.getHashKey(url))
        return if (file.exists()) file.absolutePath else null
    }

}
