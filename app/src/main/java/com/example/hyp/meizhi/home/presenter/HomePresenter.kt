package com.example.hyp.meizhi.home.presenter

import android.content.Context
import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.net.BaseResult

class HomePresenter(context: Context, var homeView: HomeContract.HomeView<HomeData>)
    : HomeContract.HomePresenter, HomeContract.HomeModel {

    private var mContext: Context = context

    private var mHomeModel: HomeModel? = null

    override fun requestHomeList() {
        if (null == mHomeModel) {
            homeView.onError()
            return
        }
        mHomeModel!!.requestHomeListData()
    }

    override fun refreshHomeList() {
        if (null == mHomeModel) {
            homeView!!.onError()
            return
        }
        mHomeModel!!.requestHomeListData()
    }


    override fun start() {
        mHomeModel = HomeModel(this)
    }

    override fun results(data: BaseResult<HomeData>) {
        homeView.onNext(data)
    }

    override fun error() {
        homeView.onError()
    }

    override fun complete() {
    }

}