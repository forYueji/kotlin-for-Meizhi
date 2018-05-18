package com.example.hyp.core

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.lidroid.xutils.ViewUtils

abstract class BaseLayout(context: Context) : FrameLayout(context) {

    private var mLayoutInflater: LayoutInflater? = null

    var mContext: Context

    init {
        if (null == mLayoutInflater) {
            mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        mContext = context

        val view = mLayoutInflater!!.inflate(getLayoutId(), null)

        val contentParams = FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        addView(view, contentParams)
        ViewUtils.inject(this)

        initPresenter()

        initView()

        initData()

        invalidate()
    }

    abstract fun getLayoutId(): Int

    abstract fun initPresenter()

    abstract fun initView()

    abstract fun initData()

    abstract fun destroy()
}