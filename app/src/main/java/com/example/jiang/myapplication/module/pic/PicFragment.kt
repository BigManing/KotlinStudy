package com.example.jiang.myapplication.module.pic


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jiang.myapplication.R


/**
 * Created by BigManing on 17-11-14.
 * 邮箱：lingshui2008@qq.com
 * 图片详情
 */

class PicFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_pic, container, false)
    }

}// Required empty public constructor
