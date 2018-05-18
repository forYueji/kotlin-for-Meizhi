package com.example.hyp.net

import android.content.Context

import java.io.File
import java.util.concurrent.TimeUnit

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    private var mRetrofit: Retrofit? = null

    private var mHttpClient: OkHttpClient? = null

    fun initRetrofit(context: Context?): Builder {
        checkNull("context", context)
        return Builder()
    }
    private fun build(builder: Builder) {

        if (null != mRetrofit && null != mHttpClient) {
            return
        }
        synchronized(Any::class.java) {
            if (null != mRetrofit && null != mHttpClient) {
                return
            }

            mHttpClient = OkHttpClient.Builder()
                    .cache(Cache(File(builder.cacheDir, builder.cacheName!!), builder.cacheSize))
                    .connectTimeout(builder.readTimeout, TimeUnit.SECONDS)
                    .readTimeout(builder.readTimeout, TimeUnit.SECONDS)
                    .writeTimeout(builder.readTimeout, TimeUnit.SECONDS)
                    .build()

            mRetrofit = Retrofit.Builder()
                    .baseUrl(builder.baseUrl!!)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(mHttpClient!!)
                    .build()
        }
    }

    fun <T> create(tClass: Class<T>): T {
        checkNull(mRetrofit)
        return mRetrofit!!.create(tClass)
    }

    private fun checkNull(msg: String, context: Context?) {
        if (null == context) {
            throw NullPointerException(msg + "is null ?")
        }
    }

    private fun checkNull(retrofit: Retrofit?) {
        if (null == retrofit) {
            throw NullPointerException("retrofit is builder ? ")
        }
    }

    class Builder {
        var baseUrl: String? = ""
        var cacheDir: String? = ""
        var cacheName: String? = ""
        var cacheSize: Long = 0
        var readTimeout: Long = 0

        fun cacheSize(size: Long): Builder {
            cacheSize = size
            return this
        }

        fun cacheName(name: String): Builder {
            cacheName = name
            return this
        }

        fun cacheDir(dir: String): Builder {
            cacheDir = dir
            return this
        }

        fun baseUrl(url: String): Builder {
            baseUrl = url
            return this
        }

        fun readTimeout(time: Long): Builder {
            readTimeout = time
            return this
        }

        fun build() {
            RetrofitManager.build(this)
        }
    }
}
