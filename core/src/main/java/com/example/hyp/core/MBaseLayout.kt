package com.example.hyp.core

import android.content.Context
import android.widget.FrameLayout

abstract class MBaseLayout(context: Context) : FrameLayout(context) {

    var mContext: Context? = null

    init {
        mContext = context
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun destroy()
}