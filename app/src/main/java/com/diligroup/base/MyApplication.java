package com.diligroup.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.diligroup.app.Constant;
import com.diligroup.utils.BDLocationUtil;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by Kevin on 2016/6/22.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    public static double latitude;
    public static double Longitude;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this);
        BDLocationUtil.getInstance().registerLocationListener();
        BDLocationUtil.getInstance().startLocation();
        BDLocationUtil.getInstance().setFinish(new BDLocationUtil.LocationFinish() {

            @Override
            public void callBack(int state) {
                Log.i("location callback:", "state=" + state);
            }
        });
        BDLocationUtil.getInstance().isLocallocation = true;
        //微信 appid appsecret
        PlatformConfig.setWeixin(Constant.WX_APPID, Constant.WX_APPSECRET);
        //新浪微博 appkey appsecret
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        // QQ和Qzone appid appkey
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

    public static Context getContext() {
        return instance;
    }
}
