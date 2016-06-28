package com.diligroup.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.diligroup.R;
import com.diligroup.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 门店供应  餐品
 * Created by Kevin on 2016/6/23.
 */
public class ShopSupplyFragment extends Fragment {
    private Context mContext;
    @Bind(R.id.lv_foodclass)
    ListView lv_classes;
//    @Bind(R.id.frame_conntainer)
//    FrameLayout frameLayout;
    List<String> foodClassList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        foodClassList = new ArrayList<>();
        foodClassList.add("热菜大荤");
        foodClassList.add("热菜半荤");
        foodClassList.add("热素菜");
        foodClassList.add("凉素菜");
        foodClassList.add("主食");
        foodClassList.add("水果");
        foodClassList.add("饮品");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_fragment_vp1, null);
        ButterKnife.bind(this, view);
//        TextView tv = (TextView) view.findViewById(R.id.tv_supply);
//        tv.setText("门店供应");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        lv_classes.setAdapter(new ArrayAdapter<>());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.tv_item, foodClassList);
        lv_classes.setAdapter(adapter);
        lv_classes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.showShort(getActivity(), "position=====" + position);
                switch (position) {
                    case 0:
//                        FragmentManager manager = getActivity().getSupportFragmentManager();
//                        FragmentTransaction transaction = manager.beginTransaction();
//                        transaction.add(R.id.frame_conntainer,new FoodListFragment());
////                        transaction.addToBackStack("fragment");
//                        transaction.commit();
                    break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        });
    }


}
