package com.example.hyp.meizhi.detail

import com.bumptech.glide.Glide
import com.example.hyp.core.MBaseActivity
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.banner.ConvenientBanner
import com.example.hyp.meizhi.core.BaseActivity
import com.github.chrisbanes.photoview.PhotoView
import com.lidroid.xutils.view.annotation.ViewInject

class DetailActivityM : BaseActivity() {

    object Key {
        val KEY_URL_PAHE: String = "url"
    }

    private var mUri: String? = ""

    @ViewInject(R.id.photo_view)
    private lateinit var mPhotoView: PhotoView

    @ViewInject(R.id.convenient_banner_view)
    private lateinit var mBannerView: ConvenientBanner<String>

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_view
    }

    override fun initField() {
        mUri = intent.getStringExtra(Key.KEY_URL_PAHE)
    }

    override fun initView() {
        Glide.with(this).load(mUri).into(mPhotoView)
    }

    override fun initData() {
    }

}