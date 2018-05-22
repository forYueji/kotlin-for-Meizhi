package com.example.hyp.meizhi;

import android.test.AndroidTestCase;

import com.example.hyp.meizhi.home.api.HomeAPI;
import com.example.hyp.meizhi.home.bean.HomeData;
import com.example.hyp.net.BaseResult;
import com.example.hyp.net.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeText extends AndroidTestCase{

    public static void requestHomeList (){
        RetrofitManager.INSTANCE.create(HomeAPI.class).requestHomePage()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResult<HomeData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResult<HomeData> homeDataBaseResult) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
