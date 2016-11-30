package com.bwf.aiyiqi.framwork.tool;

/**
 * 接口
 * Created by lingchen52 on 2016/11/24.
 */

public interface APIs {
    //##########################首页模块接口##########################

    //        1.1  首页轮播接口地址：
    public static final String API_MAIN_FRAGMENT_VIEWPAGER =
            "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";

    //1.3.1 装修公司界面接口
    //    轮播广告
    public  static final  String  API_DECORATION_COMPANY_ACTIVITY_VIEWPAGER =
            "http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";

    //   装修直播
    public  static final  String  API_DECORATION_COMPANY_ACTIVITY_LISTVIEW =
            "http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";

    //新房整装(h5网页)
    String API_NEW_HOUSE_DECORATION = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";

    //老房整装 (h5网页)
     String  API_OLD_HOUSE_DECORATION  =  "http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android";
    //一起团队
    String API_YIQIGROUP = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors";
    //同城活动
    String API_CITY_ACTIVE =
            "http://bbs.17house.com/motnt/index.php?a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    //
    String API_MAIN_FRAGMENT__RECYCLEVIE = "http://118.178.142.34/YiQiHouse/HomeBBS?";
   //建材家具
    String API_BUILDING_FURNITURE = "http://bbs.17house.com/motnt/index.php?" +
            "a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1";

    //装修学堂 获取tag列表的地址：
    public static final String DEOORATESCHOOL_TAGE_URL= " http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage={0}&model=android";
    //装修学堂。获取news的地址
    final String DECORATESCHOOL_NEWS_URL="http://appapi.17house.com/NewsApi.php?";

    //装修预算 装修报价地址：
    String DECORATEBUDGET_OFFER_URL=" http://m.beijing.17house.com/baojia/?sem=android&model=android";
    //业主说 精华的地址：
    String SAY_ESSENCE_URL="http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&mode=digest&uuid=86305803367590&pageSize=10&m=forum&page={0}&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";


    //效果图 --> 专题
    String API_EFFECT_PICTURE_SUJECT="http://appapi.17house.com/xiaoguotuApi.php?version=1&page={0}&action=albumList2&pageSize=10&tagid=1&model=android";

    //首页 搜索的url
    String API_SEARCH = "http://bbs.17house.com/motnt/index.php?";

    //工地直播--》基本信息
    String API_SITELIVE_BASE_INFO = "http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite";
    //工地直播 --》评论晒图
    String API_SITELIVE_COMMENTS = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteTrackByProgress";

    //帖子详情
    String API_POSTDETAIL = "http://bbs.17house.com/motnt/index.php?";
}
