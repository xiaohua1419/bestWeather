package com.example.xiaohua.bestweather.util;

/**
 * Created by xiaohua on 2016/11/8.
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);

}
