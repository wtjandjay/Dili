package com.diligroup;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.mapapi.cloud.CloudListener;
import com.baidu.mapapi.cloud.CloudManager;
import com.baidu.mapapi.cloud.CloudPoiInfo;
import com.baidu.mapapi.cloud.CloudSearchResult;
import com.baidu.mapapi.cloud.DetailSearchResult;
import com.baidu.mapapi.cloud.NearbySearchInfo;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.net.NetUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseAcitvity implements CloudListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    //    @Bind(R.id.id_imageview)
//    ImageView iv_show;
//    @Bind(R.id.id_textview)
//    TextView tv_text;
    @Bind(R.id.open_location)
    Button open_location;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewAndData() {

    }

    @OnClick(R.id.open_location)
    public void startLocation() {
        CloudManager.getInstance().init(MainActivity.this);
        NearbySearchInfo info = new NearbySearchInfo();
        info.ak = "D9ace96891048231e8777291cda45ca0";
        info.geoTableId = 32038;
        info.radius = 30000;
        info.location = "116.478054,39.91951";
        CloudManager.getInstance().nearbySearch(info);
    }

    @Override
    public void onGetSearchResult(CloudSearchResult cloudSearchResult, int i) {
        if (cloudSearchResult != null && cloudSearchResult.poiList != null
                && cloudSearchResult.poiList.size() > 0) {
            Log.d(TAG, "onGetSearchResult, result length: " + cloudSearchResult.poiList.size());
            for (CloudPoiInfo info : cloudSearchResult.poiList) {
                String address = info.address;
                String city = info.city;
                String province = info.province;
                int distance = info.distance;
                String title = info.title;
                String district = info.district;

                Log.e("address==", address);
                Log.e("city==", city);
                Log.e("province==", province);
                Log.e("title==", title);
                Log.e("district==", district);
                Log.e("dinstance====", String.valueOf(distance));
            }
        }
    }

    @Override
    public void onGetDetailSearchResult(DetailSearchResult result, int i) {
        if (result != null) {
            if (result.poiInfo != null) {
                Toast.makeText(MainActivity.this, result.poiInfo.title,
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "status:" + result.status, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
