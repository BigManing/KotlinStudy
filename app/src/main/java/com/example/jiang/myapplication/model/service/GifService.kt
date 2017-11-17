package com.example.jiang.myapplication.model.service

import com.example.jiang.myapplication.Const.Companion.buildUrl
import com.example.jiang.myapplication.model.bean.Gif
import com.example.jiang.myapplication.model.bean.GifResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by BigManing on 17-11-16.
 * 邮箱：lingshui2008@qq.com
 * gif 网络请求
 */


class GifService {
    companion object {
        val baseUrl = "http://route.showapi.com/341-3"
        fun buildBaseUrl(page: Int, maxResult: Int): String {
            return buildUrl("$baseUrl?page=$page&maxResult=$maxResult")
        }

        fun getData(page: Int, maxResult: Int = 5): List<Gif>? {
            var forecastJsonStr: String? = null
            try {
                forecastJsonStr = URL(buildBaseUrl(page, maxResult)).readText()
                println(forecastJsonStr)
            } catch (e: Exception) {
                return null
            }
            val data = Gson().fromJson(forecastJsonStr, GifResult::class.java)
            val gifs: List<Gif> = data.showapi_res_body.contentlist
            return if (gifs.isNotEmpty()) gifs else null
        }
    }
}