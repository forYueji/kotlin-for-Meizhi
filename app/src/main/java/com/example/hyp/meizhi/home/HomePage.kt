package com.example.hyp.meizhi.home

import android.content.Context
import android.os.Handler
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.hyp.meizhi.core.BaseLayout
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

    @ViewInject(R.id.convenient_banner_view)
    private lateinit var mConvenientBanner: ConvenientBanner<HomeData>

    @ViewInject(R.id.collapsing_toolbar_layout)
    private lateinit var mCollapsingToolbarLayout: CollapsingToolbarLayout

    private var mHomePresenter: HomePresenter? = null

    private lateinit var mBannerList: ArrayList<HomeData>

    override fun getLayoutId(): Int {
        return R.layout.layout_home_page
    }

    override fun initPresenter() {
        mHomePresenter = HomePresenter(this)
        mHomePresenter!!.start()

        mBannerList = ArrayList()
    }

    override fun initView() {
        mRecyclerView.layoutManager = GridLayoutManager(context, 2)
        mCollapsingToolbarLayout.isTitleEnabled = false
    }

    override fun initData() {

        mHomePresenter!!.requestHomeList()

        val data1 = HomeData("http://ww4.sinaimg.cn/large/7a8aed7bjw1f1klhuc8w5j20d30h9gn8.jpg", "标题一  2017-05-26 我只是测试数据", "", "")
        val data2 = HomeData("https://ws1.sinaimg.cn/large/d23c7564ly1fg6qckyqxkj20u00zmaf1.jpg", "标题二  2016-05-26 我只是测试数据", "", "")
        val data3 = HomeData("https://ws1.sinaimg.cn/large/610dc034ly1fg5dany6uzj20u011iq60.jpg", "标题三 2017-02-16 我只是测试数据", "", "")
        val data4 = HomeData("https://ws1.sinaimg.cn/large/610dc034ly1ffyp4g2vwxj20u00tu77b.jpg", "标题四 2015-01-01 我只是测试数据", "", "")

        mBannerList.add(data1)
        mBannerList.add(data2)
        mBannerList.add(data3)
        mBannerList.add(data4)

        mConvenientBanner.setPages({ HomeBannerView() }, mBannerList).startTurning(5000)

    }

    override fun destroy() {
    }

    override fun showToast(msg: String) {
        showToastView(msg)
    }

    override fun showLoading() {
    }

    override fun cancelLoading() {
    }

    override fun onNext(data: BaseResult<HomeData>) {
        val mHomeAdapter = HomeListAdapter(mContext!!, data.results!!)
        mRecyclerView.adapter = mHomeAdapter
    }

    override fun onError() {
    }

    override fun setPresenter(presenter: HomeData) {
    }

}