package com.example.hyp.meizhi.common

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.example.hyp.meizhi.R
import com.lidroid.xutils.ViewUtils
import com.lidroid.xutils.view.annotation.ViewInject

class ToastView(context: Context) : FrameLayout(context) {

    @ViewInject(R.id.textview_toast_msg_view)
    private lateinit var mToastView: TextView

    init {
        initView()
    }

    private fun initView() {

        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.layout_toast_view, this, false)

        addView(view, FrameLayout.LayoutParams.MATCH_PARENT)

        ViewUtils.inject(view, this)

        visibility = View.GONE
    }

    fun showToast(msg: String) {
        mToastView.text = if (TextUtils.isEmpty(msg)) "" else msg
        visibility = View.VISIBLE
    }

    fun cancelToast() {
        visibility = View.INVISIBLE
    }
}