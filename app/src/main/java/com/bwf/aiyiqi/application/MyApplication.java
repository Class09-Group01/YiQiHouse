package com.bwf.aiyiqi.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by lingchen52 on 2016/11/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        //初始化Okhttp
        initOk();
    }
    private void initOk(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
