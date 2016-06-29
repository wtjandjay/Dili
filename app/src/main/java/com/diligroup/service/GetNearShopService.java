//package com.diligroup.service;
//
//import com.baidu.mapapi.cloud.CloudListener;
//import com.baidu.mapapi.cloud.CloudManager;
//import com.baidu.mapapi.cloud.CloudPoiInfo;
//import com.baidu.mapapi.cloud.CloudSearchResult;
//import com.baidu.mapapi.cloud.DetailSearchResult;
//import com.baidu.mapapi.cloud.NearbySearchInfo;
//import com.diligroup.app.Constant;
//
//import java.util.List;
//
///**
// * Created by Kevin on 2016/6/29.
// */
//public class GetNearShopService {
//    static List<CloudPoiInfo>  shopList;
//
//    public static void ClogetNearShopList(String location){
//
//        CloudManager.getInstance().init(new CloudListener() {
//            @Override
//            public void onGetSearchResult(CloudSearchResult cloudSearchResult, int i) {
//
//            }
//
//            @Override
//            public void onGetDetailSearchResult(DetailSearchResult detailSearchResult, int i) {
//
//            }
//        });
//        NearbySearchInfo searchInfo=new NearbySearchInfo();
//        searchInfo.ak= Constant.APP_KEY;
//        searchInfo.geoTableId= Constant.GENTABID;
//        searchInfo.radius=30000;
//        searchInfo.location=location;
//        CloudManager.getInstance().nearbySearch(searchInfo);
//
//    }
//
//}
