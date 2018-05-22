package com.example.hyp.core

import android.app.Activity
import android.app.Dialog
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import com.lidroid.xutils.ViewUtils

abstract class MBaseDialog(activity: Activity, themeResId: Int) : Dialog(activity, themeResId) {

    private var mActivity: Activity = activity

    init {

        initView()
    }

    private fun initView() {

        val view = LayoutInflater.from(mActivity).inflate(getLayoutId(), null)

        setContentView(view)
        ViewUtils.inject(this, view)

        window!!.setGravity(getGravity())
        val params = window!!.attributes
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        window!!.attributes = params

        setCancelable(isCancelable())
        setCanceledOnTouchOutside(isCanceledOnTouchOutside())

        initDialog()
    }

    abstract fun getGravity(): Int

    abstract fun isCancelable(): Boolean

    abstract fun isCanceledOnTouchOutside(): Boolean

    abstract fun getLayoutId(): Int

    abstract fun initDialog()
}