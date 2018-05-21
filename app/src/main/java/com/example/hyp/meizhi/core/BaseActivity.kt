package com.example.hyp.meizhi.core

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.example.hyp.core.MBaseActivity
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.common.ViewManager
import com.lidroid.xutils.ViewUtils

abstract class BaseActivity : MBaseActivity() {

    private lateinit var mViewManager: ViewManager

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewManager = ViewManager(this, getLayoutId())
        setContentView(mViewManager.initView())
        ViewUtils.inject(this)

        initField()

        initView()

        initData()
    }

    fun showLoadingView (){
        mViewManager.showLoadingView()
    }

    fun cancelLoading(){
        mViewManager.cancelLoadingView()
    }
}