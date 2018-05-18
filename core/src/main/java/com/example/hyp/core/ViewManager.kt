package com.example.hyp.core

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.lidroid.xutils.ViewUtils

class ViewManager(context: Context, var layoutId: Int) {

    private var mContext: Context = context

    private var mInflater: LayoutInflater
    /**
     * 当前容器的 params
     */
    private lateinit var mCurrentParams: FrameLayout.LayoutParams

    private lateinit var mToastParams: FrameLayout.LayoutParams

    private lateinit var mLoadParams: FrameLayout.LayoutParams


    init {
        mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    fun initView(): FrameLayout {
        val mFrameLayout = FrameLayout(mContext)

        mCurrentParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT)

        mToastParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        mToastParams.gravity = Gravity.CENTER

        mLoadParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        mLoadParams.gravity = Gravity.CENTER

        mFrameLayout.addView(initCurrentView(), mCurrentParams)
        mFrameLayout.addView(initToastView(), mToastParams)
        mFrameLayout.addView(initLoadingView(), mLoadParams)

        return mFrameLayout
    }

    private fun initCurrentView(): View {
        val currentView = mInflater.inflate(layoutId, null)
        return currentView
    }

    private fun initToastView(): View {
        val toastView = ToastView(mContext)
        return toastView
    }

    private fun initLoadingView(): View {
        val loadingView = LoadingView(mContext)
        return loadingView
    }
}