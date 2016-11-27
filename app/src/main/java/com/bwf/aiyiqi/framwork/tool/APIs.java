package com.bwf.aiyiqi.framwork.tool;

/**
 * 接口
 * Created by lingchen52 on 2016/11/24.
 */

public interface APIs {
    //##########################首页模块接口##########################

    //        1.1  首页轮播接口地址：
    public static final String API_MAIN_FRAGMENT_VIEWPAGER = "http://118.178.142.34/YiQiHouse/HomeAD";

    //1.3.1 装修公司界面接口
    //    轮播广告
    public  static final  String  API_DECORATION_COMPANY_ACTIVITY_VIEWPAGER = "http://118.178.142.34/YiQiHouse/CompanyAD";

    //   装修直播
    public  static final  String  API_DECORATION_COMPANY_ACTIVITY_LISTVIEW = "http://118.178.142.34/YiQiHouse/DecorateLive";

    //新房整装(h5网页)
    String API_NEW_HOUSE_DECORATION = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";

    //老房整装 (h5网页)
     String  API_OLD_HOUSE_DECORATION  =  "http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android";

    //同城活动

    String API_CITY_ACTIVE = "http://118.178.142.34/YiQiHouse/CityActive";
    //
    String API_MAIN_FRAGMENT__RECYCLEVIE = "http://118.178.142.34/YiQiHouse/HomeBBS?";
   //建材家具
    String API_BUILDING_FURNITURE = "http://bbs.17house.com/motnt/index.php?" +
            "a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1";
    //装修学堂 获取tag列表的地址：
    public static final String DEOORATESCHOOL_TAGE_URL= " http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage={0}&model=android";
    //装修学堂。获取news的地址
    final String DECORATESCHOOL_NEWS_URL="http://appapi.17house.com/NewsApi.php?";
}
