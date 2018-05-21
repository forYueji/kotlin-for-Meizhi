package com.example.hyp.meizhi.core

import android.content.Context
import android.widget.FrameLayout
import com.example.hyp.core.MBaseLayout
import com.example.hyp.meizhi.common.ViewManager
import com.lidroid.xutils.ViewUtils

abstract class BaseLayout(context: Context) : MBaseLayout(context) {

    private var mViewManager: ViewManager? = null

    init {

        mViewManager = ViewManager(mContext!!, getLayoutId())
        val view = mViewManager!!.initView()

        addView(view, FrameLayout.LayoutParams.MATCH_PARENT)

        ViewUtils.inject(this)

        initPresenter()

        initView()

        invalidate()
    }

    abstract fun initPresenter()

    fun showProgressDialog() {
        if (null == mViewManager) {
            return
        }
        mViewManager!!.showLoadingView()
    }

    fun dismissProgressDialog() {
        if (null == mViewManager) {
            return
        }
        mViewManager!!.cancelLoadingView()
    }

    fun showToastView(msg: String) {
        if (null == mViewManager) {
            return
        }
        mViewManager!!.showToast(msg)
    }

    fun cancelToastView() {
        if (null == mViewManager) {
            return
        }
        mViewManager!!.cancelToast()
    }
}