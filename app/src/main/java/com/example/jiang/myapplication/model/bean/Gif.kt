package com.example.jiang.myapplication.model.bean

/**
 * Created by BigManing on 17-11-16.
 * 邮箱：lingshui2008@qq.com
 *  gif 模块相关的bean
 */
data class GifResult(val showapi_res_code: String,
                     val showapi_res_error: String,
                     val showapi_res_body: GifBody)


data class GifBody(val allNum: String,
                   val allPages: String,
                   val currentPage: String,
                   val maxResult: String,
                   val contentlist: List<Gif>)


data class Gif(val title: String,
               val img: String)
