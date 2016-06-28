package com.diligroup.activity;

import com.diligroup.R;
import com.diligroup.activity.user.ReportBirthday;
import com.diligroup.activity.user.ReportHeight;
import com.diligroup.activity.user.ReportMinZu;
import com.diligroup.activity.user.ReportNoeat;
import com.diligroup.activity.user.ReportOther;
import com.diligroup.activity.user.ReportSex;
import com.diligroup.activity.user.ReportSpecial;
import com.diligroup.activity.user.ReportTaste;
import com.diligroup.activity.user.ReportWeight;
import com.diligroup.activity.user.ReportWhere;
import com.diligroup.activity.user.ReportWork;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.net.NetUtils;
import com.diligroup.utils.ToastUtil;

import butterknife.OnClick;

/**
 * Created by Kevin on 2016/6/14.
 * 用户信息详情
 */
public class UserInfoActivity extends BaseAcitvity {
//    @Bind(R.id.rl_sex)
//    RelativeLayout rl_sex;
//    @Bind(R.id.rl_birthday)
//    RelativeLayout rl_birthday;
//    @Bind(R.id.rl_height)
//    RelativeLayout rl_height;
//    @Bind(R.id.rl_mingzu)
//    RelativeLayout rl_minzu;
//    @Bind(R.id.rl_other)
//    RelativeLayout rl_other;
//    @Bind(R.id.rl_taste)
//    RelativeLayout rl_taste;
//    @Bind(R.id.rl_tsrq)
//    RelativeLayout rl_tsrq;
//    @Bind(R.id.rl_work)
//    RelativeLayout rl_work;
//    @Bind(R.id.rl_ysjj)
//    RelativeLayout rl_ysjj;
//    @Bind(R.id.rl_weight)
//    RelativeLayout rl_weight;
//    @Bind(R.id.rl_where)
//    RelativeLayout rl_where;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.user_info;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("我的信息");
    }

    @Override
    protected void initViewAndData() {

    }

    @OnClick(R.id.rl_mingzu)
    public void ClickMinzu() {
        ToastUtil.showShort(this,"ClickedMinZU");
        jumpView(this, ReportMinZu.class);
    }

    @OnClick(R.id.rl_sex)
    public void ClickSex() {
        ToastUtil.showShort(this,"ReportSex");
        jumpView(this, ReportSex.class);
    }

    @OnClick(R.id.rl_birthday)
    public void ClickBirthday() {
        jumpView(this, ReportBirthday.class);
    }

    @OnClick(R.id.rl_height)
    public void ClickHeight() {
        jumpView(this, ReportHeight.class);
    }

    @OnClick(R.id.rl_other)
    public void ClickOther() {
        jumpView(this, ReportOther.class);
    }

    @OnClick(R.id.rl_tsrq)
    public void ClickTsrq() {
        jumpView(this, ReportSpecial.class);
    }

    @OnClick(R.id.rl_taste)
    public void ClickTaste() {
        jumpView(this, ReportTaste.class);
    }

    @OnClick(R.id.rl_where)
    public void ClickWhere() {
        jumpView(this, ReportWhere.class);
    }

    @OnClick(R.id.rl_weight)
    public void ClickWeight() {
        jumpView(this, ReportWeight.class);
    }

    @OnClick(R.id.rl_ysjj)
    public void ClickYsjj() {
        jumpView(this, ReportNoeat.class);
    }

    @OnClick(R.id.rl_work)
    public void ClickWork() {
        jumpView(this, ReportWork.class);
    }

}
