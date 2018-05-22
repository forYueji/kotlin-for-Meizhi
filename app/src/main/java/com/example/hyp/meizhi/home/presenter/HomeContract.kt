package com.example.hyp.meizhi.home.presenter

import com.example.hyp.core.BasePresenter
import com.example.hyp.core.BaseView
import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.net.BaseResult

interface HomeContract {

    interface HomeView<T> : BaseView<T> {

        fun showToast(msg: String)

        fun showLoading()

        fun cancelLoading()

        fun onNext(data: List<HomeData>)

        fun onError()
    }

    interface HomePresenter : BasePresenter {

        fun requestHomeList()

        fun refreshHomeList()
    }

    interface HomeModel {

        fun results(data: List<HomeData>)

        fun error()

        fun complete()
    }

}