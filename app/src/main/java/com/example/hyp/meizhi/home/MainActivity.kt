package com.example.hyp.meizhi.home

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.FrameLayout
import com.example.hyp.core.BaseActivity
import com.example.hyp.core.BaseLayout
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.banner.ConvenientBanner
import com.example.hyp.meizhi.common.ViewPagerAdapter
import com.example.hyp.meizhi.home.bean.HomeData
import com.example.hyp.meizhi.home.view.HomeBannerView
import com.example.hyp.meizhi.user.UserPage
import com.lidroid.xutils.view.annotation.ViewInject

class MainActivity : BaseActivity() {

    @ViewInject(R.id.layout_home)
    private lateinit var mConstraintLayout: ViewPager

    @ViewInject(R.id.toolbar)
    private lateinit var mToolbar: Toolbar

    @ViewInject(R.id.convenient_banner_view)
    private lateinit var mConvenientBanner: ConvenientBanner<HomeData>

    @ViewInject(R.id.collapsing_toolbar_layout)
    private lateinit var mCollapsingToolbarLayout: CollapsingToolbarLayout

    @ViewInject(R.id.bottom_navigation_view)
    private lateinit var mBottomNavigationView: BottomNavigationView

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private var mBannerList = ArrayList<HomeData>()

    private var mViewList = ArrayList<BaseLayout>()

    override fun initView() {

        mViewList.add(HomePage(this))
        mViewList.add(HomePage(this))
        mViewList.add(UserPage(this))

        mConstraintLayout.adapter = ViewPagerAdapter(mViewList)
        mConstraintLayout.setCurrentItem(0, true)

        mCollapsingToolbarLayout.isTitleEnabled = false

        mToolbar.title = "MeiZhi"

        mBottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationListener)
    }

    private val bottomNavigationListener = BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mConstraintLayout.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list -> {
                mConstraintLayout.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                mConstraintLayout.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                false
            }
        }
    }

    override fun initField() {
    }

    override fun initData() {

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
}