package com.example.jiang.myapplication

/**
 * Created by BigManing on 17-11-15.
 * 邮箱：lingshui2008@qq.com
 * 定义常量
 */
class Const {
    companion object {
        private val yiyuan_appid = "45578"
        private val yiyuan_secret = "4e6e7a13e16a42059a75a9a8931a779f"
        private val yiyuanAuth = "&showapi_sign=$yiyuan_secret&showapi_appid=$yiyuan_appid"

        fun buildUrl(url: String): String {
            return "$url&$yiyuanAuth"
        }
    }
}