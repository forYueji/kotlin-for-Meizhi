package com.example.hyp.meizhi.home

import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.common.ViewPagerAdapter
import com.example.hyp.meizhi.core.BaseActivity
import com.example.hyp.meizhi.core.BaseLayout
import com.example.hyp.meizhi.user.UserPage
import com.lidroid.xutils.view.annotation.ViewInject

class MainActivity : BaseActivity() {

    @ViewInject(R.id.layout_home)
    private lateinit var mConstraintLayout: ViewPager

    @ViewInject(R.id.bottom_navigation_view)
    private lateinit var mBottomNavigationView: BottomNavigationView

    private lateinit var mHomePage: HomePage

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private var mViewList = ArrayList<BaseLayout>()

    override fun initView() {

        mHomePage = HomePage(this)

        mViewList.add(mHomePage)
        mViewList.add(mHomePage)
        mViewList.add(UserPage(this))

        mConstraintLayout.adapter = ViewPagerAdapter(mViewList)
        mConstraintLayout.setCurrentItem(0, true)

        mBottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationListener)

        showLoadingView()

    }

    override fun initField() {
    }

    override fun initData() {
        mHomePage.initData()
        Handler().postDelayed({ cancelLoading() }, 300)
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
}