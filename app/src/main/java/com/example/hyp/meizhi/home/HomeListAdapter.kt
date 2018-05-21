package com.example.hyp.meizhi.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hyp.core.BaseRecyclerAdapter
import com.example.hyp.meizhi.R
import com.example.hyp.meizhi.detail.DetailActivityM
import com.example.hyp.meizhi.home.bean.HomeData

class HomeListAdapter(context: Context, data: List<HomeData>) : BaseRecyclerAdapter<HomeData,
        HomeListAdapter.HomeListViewHolder>(context, data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_home_view, parent, false)
        return HomeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        Glide.with(context).load(mList[position].url).into(holder.mImageView)

        holder.mNameView.text = mList[position].who

        holder.mImageView.setOnClickListener {

            val intent = Intent(context, DetailActivityM::class.java)
            val bundle = Bundle()
            bundle.putString(DetailActivityM.Key.KEY_URL_PAHE, mList[position].url)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mImageView: ImageView = view.findViewById(R.id.imageview_pic)
        var mNameView: TextView = view.findViewById(R.id.textview_name)
    }
}