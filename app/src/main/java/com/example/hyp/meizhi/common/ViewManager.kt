package com.example.hyp.meizhi.common

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.lidroid.xutils.ViewUtils

class ViewManager(var context: Context, var layoutId: Int) {

    /**
     * toast view
     */
    private var mToastView: ToastView? = null

    /**
     * loading view
     */
    private var mLoadingView: LoadingView? = null

    fun initView(): FrameLayout {
        val mFrameLayout = FrameLayout(context)

        val mCurrentParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT)
        val currentView = LayoutInflater.from(context).inflate(layoutId, null)


        val mToastParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        mToastParams.gravity = Gravity.CENTER

        mToastView = ToastView(context)

        val mLoadParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        mLoadParams.gravity = Gravity.CENTER

        mLoadingView = LoadingView(context)


        mFrameLayout.addView(currentView, mCurrentParams)
        mFrameLayout.addView(mToastView, mToastParams)
        mFrameLayout.addView(mLoadingView, mLoadParams)

        return mFrameLayout
    }

    /**
     * show
     */
    fun showToast(msg: String) {
        if (null == mToastView) {
            return
        }
        mToastView!!.showToast(msg)
    }

    /**
     * cancel
     */
    fun cancelToast() {
        if (null == mToastView) {
            return
        }
        mToastView!!.cancelToast()
    }

    fun showLoadingView() {
        if (null == mLoadingView) {
            return
        }
        mLoadingView!!.showLoading()
    }

    fun cancelLoadingView() {
        if (null == mLoadingView) {
            return
        }
        mLoadingView!!.cancelLoading()
    }

}