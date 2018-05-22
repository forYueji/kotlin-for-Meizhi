package com.example.hyp.meizhi.common

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.hyp.core.MBaseDialog
import com.example.hyp.meizhi.R
import com.lidroid.xutils.view.annotation.ViewInject
import com.lidroid.xutils.view.annotation.event.OnClick

class PhotoPicker(activity: Activity) : MBaseDialog(activity, R.style.dialog_bottom_anim) {

    @ViewInject(R.id.textView_open_camera_view)
    private lateinit var mOpenCameraView: TextView

    @ViewInject(R.id.textView_open_photo_view)
    private lateinit var mOpenPhotoView: TextView

    @ViewInject(R.id.textView_picker_cancel_view)
    private lateinit var mCancelView: TextView

    override fun isCancelable(): Boolean {
        return true
    }

    override fun isCanceledOnTouchOutside(): Boolean {
        return true
    }

    override fun getGravity(): Int {
        return Gravity.BOTTOM
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_picker_view
    }

    override fun initDialog() {

    }

    @OnClick(value = [
        (R.id.textView_open_camera_view),
        (R.id.textView_open_photo_view),
        (R.id.textView_picker_cancel_view)],

            parentId = [
                (R.id.textView_open_camera_view),
                (R.id.textView_open_photo_view),
                (R.id.textView_picker_cancel_view)
            ])
    private fun openPicker(view: View) {
        when (view.id) {
            R.id.textView_open_camera_view -> {
                dismiss()
            }
            R.id.textView_open_photo_view -> {
                dismiss()
            }
            R.id.textView_picker_cancel_view -> {
                dismiss()
            }
            else -> {
            }
        }
    }
}