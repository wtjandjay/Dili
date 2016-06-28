package com.diligroup.base;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.diligroup.service.LocationService;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Kevin on 2016/6/22.
 */
public class MyApplication extends Application {
    public LocationService locationService;
    private String permissionInfo;
    @Override
    public void onCreate() {
        super.onCreate();
        locationService = new LocationService(getApplicationContext());
        SDKInitializer.initialize(this);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }


}
