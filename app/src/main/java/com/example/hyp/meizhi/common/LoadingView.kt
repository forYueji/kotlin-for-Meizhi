package com.example.hyp.meizhi.common

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.example.hyp.meizhi.R
import com.lidroid.xutils.ViewUtils

/**
 * 这里采用 view 构建 loadingView
 */
class LoadingView(context: Context) : FrameLayout(context), View.OnTouchListener {

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return true
    }

    init {
        initView()
    }

    private fun initView() {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.layout_loading_view, this, false)

        addView(view, FrameLayout.LayoutParams.MATCH_PARENT)

        ViewUtils.inject(view)


        setOnTouchListener(this)
        visibility = View.GONE
    }

    fun showLoading() {
        visibility = View.VISIBLE
    }

    fun cancelLoading() {
        visibility = View.GONE
    }

}