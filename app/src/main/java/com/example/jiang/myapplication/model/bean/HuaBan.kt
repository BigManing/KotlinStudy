package com.example.jiang.myapplication.model.bean

import com.google.gson.JsonObject

/**
 * Created by BigManing on 17-11-20.
 * 邮箱：lingshui2008@qq.com
 *
 */
data class HuabanResult(val showapi_res_code: String,
                        val showapi_res_error: String,
                        val showapi_res_body: JsonObject)

data class Huaban(val title: String,
                  val thumb: String,
                  val url: String)
