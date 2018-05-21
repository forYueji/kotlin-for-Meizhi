package com.example.hyp.meizhi.home.presenter

import android.content.Context
import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.net.BaseResult

class HomePresenter(var homeView: HomeContract.HomeView<HomeData>)
    : HomeContract.HomePresenter, HomeContract.HomeModel {

    private var mHomeModel: HomeModel? = null

    override fun requestHomeList() {
        if (null == mHomeModel) {
            homeView.onError()
            return
        }
        homeView.showLoading()
        mHomeModel!!.requestHomeListData()
    }

    override fun refreshHomeList() {
        if (null == mHomeModel) {
            homeView.onError()
            return
        }
        mHomeModel!!.requestHomeListData()
    }


    override fun start() {
        mHomeModel = HomeModel(this)
    }

    override fun results(data: BaseResult<HomeData>) {
        homeView.cancelLoading()
        homeView.onNext(data)
    }

    override fun error() {
        homeView.cancelLoading()
        homeView.onError()
    }

    override fun complete() {
    }

}