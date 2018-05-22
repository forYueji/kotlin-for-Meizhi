package com.example.hyp.meizhi.home.presenter

import com.example.hyp.meizhi.core.BaseObserver
import com.example.hyp.meizhi.home.api.HomeAPI
import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.net.BaseResult
import com.example.hyp.net.RetrofitManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeModel(model: HomeContract.HomeModel) {

    private var mHomeModel: HomeContract.HomeModel = model

    fun requestHomeListData() {

        RetrofitManager.create(HomeAPI::class.java).requestHomePage()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<HomeData>() {
                    override fun onSuccess(bean: List<HomeData>) {
                        mHomeModel.results(bean)
                    }

                    override fun completed() {
                        mHomeModel.complete()
                    }

                    override fun onFailure(code: String, msg: String) {
                        mHomeModel.error()
                    }

                })
    }
}