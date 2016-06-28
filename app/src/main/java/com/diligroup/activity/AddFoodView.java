package com.diligroup.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.fragment.ShopSupplyFragment;
import com.diligroup.net.NetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 添加 餐品
 */
public class AddFoodView extends BaseAcitvity {

    @Bind(R.id.tab_classes)
    TabLayout tabLayout;
    @Bind(R.id.tab_viewpager)
    ViewPager viewPager;

    MyTableAdapter myAdapter;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_add_food_view;
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
        tv_title.setText("添加餐品");
    }

    @Override
    protected void initViewAndData() {

        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        fragmentList.add(new ShopSupplyFragment());
        fragmentList.add(new ShopSupplyFragment());
        titleList.add("门店供应");
        titleList.add("自己定义");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        myAdapter = new MyTableAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MyTableAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;
        private List<String> titles;


        public MyTableAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titles) {
            super(fm);
            this.fragments = fragmentList;
            this.titles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
