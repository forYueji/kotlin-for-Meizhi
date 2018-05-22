package com.example.hyp.meizhi.core

import android.widget.Toast
import com.example.hyp.meizhi.common.Constant
import com.example.hyp.net.BaseResult
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * 处理 请求结果
 */
abstract class BaseObserver<T> : Observer<BaseResult<T>> {

    override fun onComplete() {
        completed()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(data: BaseResult<T>) {
        if (null == data) {
            onFailure(Constant.RequestCode.CODE_SERVICE_ERROR, "请求错误")
            completed()
            return
        }
        if (Constant.RequestCode.CODE_SUCCESS.equals(data.code)) {
            onSuccess(data.results)
            completed()
            return
        }
        if (Constant.RequestCode.CODE_LOGIN_ERROR.equals(data.code)) {
            onFailure(data.code, "登录异常")
            completed()
            return
        }
        if (Constant.RequestCode.CODE_LOGIN_TIME_OUT.equals(data.code)) {
            onFailure(data.code, "登录超时，请稍后再试!")
            completed()
            return
        }
        if (Constant.RequestCode.CODE_UPDATE.equals(data.code)) {
            completed()
            return
        }
    }

    override fun onError(e: Throwable) {
        if (e is SocketTimeoutException) {
            onFailure(Constant.RequestCode.CODE_SERVICE_ERROR, "网络中断，请检查您的网络状态")
        } else if (e is ConnectException) {
            onFailure(Constant.RequestCode.CODE_SERVICE_ERROR, "网络中断，请检查您的网络状态")
        } else {
            onFailure(Constant.RequestCode.CODE_SERVICE_ERROR, e.message!!)
        }
        completed()
    }

    abstract fun onSuccess(bean: List<T>)

    abstract fun completed()

    abstract fun onFailure(code: String, msg: String)
}