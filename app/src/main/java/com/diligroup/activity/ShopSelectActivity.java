package com.diligroup.activity;

import android.widget.Button;
import android.widget.TextView;

import com.diligroup.HomeActivity;
import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.net.NetUtils;
import com.diligroup.utils.ToastUtil;
import com.diligroup.view.CityPicker;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 手动选择  位置地址
 * 省市区 三级联动 选择
 */
public class ShopSelectActivity extends BaseAcitvity {
    @Bind(R.id.citypicker)
    CityPicker cityPicker;
    @Bind(R.id.bt_ok_shop)
    Button bt_ok;
    @Bind(R.id.comm_title)
    TextView tv_title;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_shop_select;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @OnClick(R.id.bt_ok_shop)
    public void reportShop() {
        readyGo(HomeActivity.class);
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shop_select);
//        ButterKnife.bind(this);
//        cityPicker.setOnSelectingListener(this);
//    }

    @Override
    protected void initViewAndData() {
        tv_title.setText("选择门店");
        cityPicker.setOnSelectingListener(new CityPicker.OnSelectingListener() {
            @Override
            public void selected(boolean selected) {
                ToastUtil.showShort(ShopSelectActivity.this, cityPicker.getCity_string());

            }
        });
    }


}
