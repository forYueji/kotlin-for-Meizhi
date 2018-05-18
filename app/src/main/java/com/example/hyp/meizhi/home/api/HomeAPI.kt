package com.example.hyp.meizhi.home.api

import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.net.BaseResult
import io.reactivex.Observable
import retrofit2.http.GET

interface HomeAPI {

    @GET("/api/data/福利/100/2")
    fun requestHomePage(): Observable<BaseResult<HomeData>>
}
