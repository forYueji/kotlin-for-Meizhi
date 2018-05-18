package com.example.hyp.meizhi.home

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.hyp.core.BaseLayout
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.banner.ConvenientBanner
import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.meizhi.home.presenter.HomeContract
import com.example.hyp.meizhi.home.presenter.HomePresenter
import com.example.hyp.meizhi.home.view.HomeBannerView
import com.example.hyp.net.BaseResult
import com.lidroid.xutils.view.annotation.ViewInject

class HomePage(context: Context) : BaseLayout(context), HomeContract.HomeView<HomeData> {

    @ViewInject(R.id.recyclerview_home)
    private lateinit var mRecyclerView: RecyclerView

    private var mHomePresenter: HomePresenter? = null

    override fun getLayoutId(): Int {
        return R.layout.layout_home_page
    }

    override fun initPresenter() {
        mHomePresenter = HomePresenter(context, this)
        mHomePresenter!!.start()
    }

    override fun initView() {
        mRecyclerView.layoutManager = GridLayoutManager(context, 2)
    }

    override fun initData() {
        mHomePresenter!!.requestHomeList()
    }

    override fun destroy() {
    }

    override fun showToast(msg: String) {
    }

    override fun showLoading() {
    }

    override fun cancelLoading() {
    }

    override fun onNext(data: BaseResult<HomeData>) {
        val mHomeAdapter = HomeListAdapter(mContext, data.results!!)
        mRecyclerView.adapter = mHomeAdapter
    }

    override fun onError() {
    }

    override fun setPresenter(presenter: HomeData) {
    }

}