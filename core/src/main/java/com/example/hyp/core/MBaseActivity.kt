package com.example.hyp.core

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import com.lidroid.xutils.ViewUtils

abstract class MBaseActivity : AppCompatActivity() {

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        val contentFrameLayout = findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup
        val parentView = contentFrameLayout.getChildAt(0)
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.fitsSystemWindows = true
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initField()

    abstract fun initView()

    abstract fun initData()

}