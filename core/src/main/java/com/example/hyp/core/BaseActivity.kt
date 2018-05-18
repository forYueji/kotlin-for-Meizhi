package com.example.hyp.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lidroid.xutils.ViewUtils

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewManager = ViewManager(this, getLayoutId())
        setContentView(viewManager.initView())
        ViewUtils.inject(this)

        initField()

        initView()

        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initField()

    abstract fun initView()

    abstract fun initData()

}