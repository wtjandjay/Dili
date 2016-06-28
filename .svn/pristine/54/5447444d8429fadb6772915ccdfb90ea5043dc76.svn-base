package com.diligroup.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diligroup.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 餐品 list 列表
 * Created by Kevin on 2016/6/23.
 */
public class FoodListFragment extends Fragment {
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout sw_fresh;
    @Bind(R.id.recyler_view)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_foodlist, null);
        ButterKnife.bind(this, view);
        return view;
    }
}
