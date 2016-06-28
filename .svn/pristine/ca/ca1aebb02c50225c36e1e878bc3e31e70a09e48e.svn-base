package com.diligroup;

import com.diligroup.activity.LoginActivity;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.net.NetUtils;

import butterknife.OnClick;

/**
 * Created by Kevin on 2016/6/24.
 */
public class HomeActivity extends BaseAcitvity {
//    @Bind(R.id.comm_title)
//    TextView tv_title;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.home_activity;
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

    @Override
    public void setTitle() {
        tv_title.setText("首页");
    }

    @OnClick(R.id.bt_jump_login)
    public void GoLogin() {
        readyGo(LoginActivity.class);
    }

//    @OnClick(R.id.bt_regist)
//    public void GoRegist() {
//        readyGo(RegistActivity.class);
//    }
}
