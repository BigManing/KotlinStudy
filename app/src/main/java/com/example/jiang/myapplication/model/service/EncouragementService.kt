package com.example.jiang.myapplication.model.service

import com.example.jiang.myapplication.Const
import com.example.jiang.myapplication.model.bean.Joke
import com.example.jiang.myapplication.model.bean.JokeResult
import com.example.jiang.myapplication.model.bean.Rhesis
import com.example.jiang.myapplication.model.bean.RhesisResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 *  励志retrofit
 */

class EncouragementService {
    companion object {
        val baseUrl = "http://route.showapi.com/1211-1"
        fun buildBaseUrl(page: Int, maxResult: Int): String {
            return Const.buildUrl("$baseUrl?page=$page&maxResult=$maxResult")
        }

        fun getData(page: Int, maxResutl: Int = 10): List<Rhesis>? {
            val readText: String
            try {
                readText = URL(buildBaseUrl(page, maxResutl)).readText()
                println(readText)
            } catch (e: Exception) {
                return null
            }
            val data = Gson().fromJson(readText, RhesisResult::class.java)
            val contentlist: List<Rhesis> = data.showapi_res_body.data
            return if (contentlist.isNotEmpty()) contentlist else null
        }
    }
}