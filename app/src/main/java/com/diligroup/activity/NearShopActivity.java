package com.diligroup.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.baidu.mapapi.cloud.CloudListener;
import com.baidu.mapapi.cloud.CloudManager;
import com.baidu.mapapi.cloud.CloudPoiInfo;
import com.baidu.mapapi.cloud.CloudSearchResult;
import com.baidu.mapapi.cloud.DetailSearchResult;
import com.baidu.mapapi.cloud.NearbySearchInfo;
import com.diligroup.R;
import com.diligroup.app.Constant;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.base.MyApplication;
import com.diligroup.bean.ShopInfosBean;
import com.diligroup.net.NetUtils;
import com.diligroup.utils.LogUtils;
import com.diligroup.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 根据 位置 获取周边 门店
 */
public class NearShopActivity extends BaseAcitvity implements CloudListener {
    private static final String LTAG = NearShopActivity.class.getSimpleName();
    private final int SDK_PERMISSION_REQUEST = 127;
    @Bind(R.id.sp_select_shop)
    Spinner spinner;
    ArrayAdapter<String> spinner_adapter;
    private List<String> data_list;
    @Bind(R.id.tv_result)
    TextView LocationResult;
    List<CloudPoiInfo> cloudPoiInfoList;
    List<ShopInfosBean> shopInfoList;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            cloudPoiInfoList = (List<CloudPoiInfo>) msg.obj;
            data_list = new ArrayList<>();
            shopInfoList = new ArrayList<>();
            for (CloudPoiInfo info : cloudPoiInfoList) {
                ShopInfosBean shopinfo = new ShopInfosBean();
                shopinfo.setTitle(info.title);
                data_list.add(shopinfo.getTitle());
                shopInfoList.add(shopinfo);
            }
            initViewAndData();
        }
    };

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_near_shop;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {
//        switch (type) {
//            case CMNET:
//                ToastUtil.showShort(NearShopActivity.this, "当前网络类型CMNET......");
//                break;
//            case WIFI:
//                ToastUtil.showShort(NearShopActivity.this, "当前网络类型.....WIFI.....");
//                break;
//            case CMWAP:
//                ToastUtil.showShort(NearShopActivity.this, "当前网络类型CMWAP......");
//                break;
//        }

    }

    @Override
    protected void onStart() {
        getPersimmions();
        CloudManager.getInstance().init(NearShopActivity.this);
        NearbySearchInfo searchInfo = new NearbySearchInfo();
        searchInfo.ak = Constant.APP_KEY;
        searchInfo.geoTableId = Constant.GENTABID;
        searchInfo.radius = 30000;
        searchInfo.location = getLocation(MyApplication.Longitude, MyApplication.latitude);
        searchInfo.location = "116.478155,39.919298";
        CloudManager.getInstance().nearbySearch(searchInfo);
        super.onStart();

    }

    public String getLocation(double latitude, double longitude) {
        LogUtils.e("==============当前经纬度=================" + latitude + "vvvvvvvvv" + longitude);
        String location = String.valueOf(longitude) + "," + String.valueOf(latitude);
        LogUtils.e("==============当前经纬度=================" + location);
        return location;
    }

    @Override
    protected void onNetworkDisConnected() {
        ToastUtil.showShort(NearShopActivity.this, "网络异常请检查连接.....");
    }

    @Override
    protected void initViewAndData() {

        if (data_list != null) {
            spinner_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data_list);
            spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinner_adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selece = (String) spinner.getSelectedItem();
                    ToastUtil.showShort(NearShopActivity.this, selece);
                    LogUtils.e("curry====" + shopInfoList.size());
                    LogUtils.e("curry====" + shopInfoList.get(position).getAddress());
                    LogUtils.e("curry====" + shopInfoList.get(position).getCity());
                    LogUtils.e("curry====" + shopInfoList.get(position).getDistrict());
                    LogUtils.e("curry====" + shopInfoList.get(position).getProvince());
                    LogUtils.e("curry====" + shopInfoList.get(position).getTitle());
//                    ToastUtil.showShort(NearShopActivity.this, 4+4);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }


    }

    @OnClick(R.id.bt_more)
    public void goNextView() {
        readyGo(ShopSelectActivity.class);
    }

    @Override
    public void setTitle() {
        tv_title.setText("请选择门店");
    }

    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            /*
             * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }

        } else {
            return true;
        }
    }

    @Override
    public void onGetSearchResult(CloudSearchResult result, int i) {
        if (result != null && result.poiList != null
                && result.poiList.size() > 0) {
            Log.d(LTAG, "onGetSearchResult, result length: " + result.poiList.size());
            Message msg = new Message();
            msg.obj = result.poiList;
            handler.sendMessage(msg);
            for (CloudPoiInfo info : result.poiList) {
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
                Log.e("dinstance==", String.valueOf(distance));
            }
        }
    }

    @Override
    public void onGetDetailSearchResult(DetailSearchResult result, int i) {

    }
}
