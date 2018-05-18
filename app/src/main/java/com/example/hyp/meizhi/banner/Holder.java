package com.example.hyp.meizhi.banner;

import android.content.Context;
import android.view.View;

/**
 * Created by hyp on 2017/9/15.
 */

public interface Holder<T> {
    View createView(Context context);

    void UpdateUI(Context context, int position, T url);

    void onItemClick(int position);
}