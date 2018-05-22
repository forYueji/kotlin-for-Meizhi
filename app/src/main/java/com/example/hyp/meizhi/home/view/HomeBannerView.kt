package com.example.hyp.meizhi.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.banner.Holder
import com.example.hyp.meizhi.home.bean.HomeData
import com.lidroid.xutils.ViewUtils
import com.lidroid.xutils.view.annotation.ViewInject

class HomeBannerView : Holder<HomeData> {

    override fun UpdateUI(context: Context?, position: Int, bean: HomeData?) {
        if (context != null) {
            if (bean != null) {
                Glide.with(context).load(bean.url).into(mImageView)

                mTextView.text = bean.desc
            }
        }
    }

    private lateinit var mImageView: ImageView

    private lateinit var mTextView: TextView

    override fun onItemClick(position: Int) {
    }

    override fun createView(context: Context?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_home_banner_view, null)
        mImageView = view.findViewById(R.id.imageview_pic)
        mTextView = view.findViewById(R.id.textView_desc)
        return view
    }

}