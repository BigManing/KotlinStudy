package com.example.jiang.myapplication.model.bean

/**
 * Created by BigManing on 17-11-16.
 * 邮箱：lingshui2008@qq.com
 * 励志数据类
 *
 */
data class RhesisResult(val showapi_res_code: String,
                        val showapi_res_error: String,
                        val showapi_res_body: RhesisBody)

data class RhesisBody(val ret_code: String,
                      val ret_message: String,
                      val data: List<Rhesis>)

data class Rhesis(val english: String,
                  val chinese: String)

