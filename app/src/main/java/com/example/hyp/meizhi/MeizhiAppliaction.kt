package com.example.hyp.meizhi

import android.app.Application

import com.example.hyp.net.RetrofitManager

class MeizhiAppliaction : Application() {

    override fun onCreate() {
        super.onCreate()

        initRetrofit()
    }

    private fun initRetrofit() {
        RetrofitManager.initRetrofit(this)
                .baseUrl(BaseUrl)
                .cacheDir("meizhi")
                .cacheName(cacheName)
                .cacheSize(size)
                .readTimeout(500)
                .build()
    }

    companion object {

        private val BaseUrl = "http://gank.io/"
        private val cacheName = "mei-zhi"
        private val size = (1024 * 1024 * 100).toLong()
    }
}
