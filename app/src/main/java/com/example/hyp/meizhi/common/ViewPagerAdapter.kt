package com.example.hyp.meizhi.common

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.example.hyp.core.BaseLayout

class ViewPagerAdapter(data: ArrayList<BaseLayout>) : PagerAdapter() {

    private var mList: ArrayList<BaseLayout>? = null

    init {
        mList = data
    }

    override fun getCount(): Int {
        return mList?.size ?: 0
    }

    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = mList!![position]
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(mList!![position])
    }
}