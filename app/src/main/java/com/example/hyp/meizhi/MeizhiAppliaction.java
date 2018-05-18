package com.example.hyp.meizhi;

import android.app.Application;

import com.example.hyp.net.RetrofitManager;

public class MeizhiAppliaction extends Application {

    private static String BaseUrl = "http://gank.io/";
    private static String cacheDir = "meizhi";
    private static String cacheName = "mei-zhi";
    private static long size = 1024 * 1024 * 100;

    @Override
    public void onCreate() {
        super.onCreate();

        initRetrofit();
    }

    private void initRetrofit() {
        RetrofitManager.INSTANCE.initRetrofit(this)
                .baseUrl(BaseUrl)
                .cacheDir(cacheDir)
                .cacheName(cacheName)
                .cacheSize(size)
                .readTimeout(500)
                .build();
    }
}
