package com.bwf.aiyiqi.framwork.tool;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lingchen52 on 2016/12/2.
 */

public class TimeTools {
    //String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(timestamp));
    public static String timestampToDate(long timestamp) {
        String date = new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(timestamp));
        String[] strs = date.split("/");
        String str = strs[0] + "年" + strs[1] + "月" + strs[2] + "日";
        return str;
    }
    public static String timestampToDate(String timestamp) {
        long time = Long.valueOf(timestamp);
        String date = new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(time*1000));
        String[] strs = date.split("/");
        String str = strs[0] + "年" + strs[1] + "月" + strs[2] + "日";
        return str;
    }
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime_Today() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return sdf.format(new java.util.Date());
    }
    /**
     * 调此方法输入所要转换的时间输入例如（"2014-06-14-16-09-00"）返回时间戳
     *
     * @param time
     * @return
     */
    public static String dataOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }
    public static String showTime(String timestamp){
        String myCommuniteTime = null;
        long time = Long.valueOf(timestamp);
        long timeMillis = System.currentTimeMillis();
        long communiteTime = (timeMillis/1000 - time)/3600;
        if(communiteTime == 0){
            myCommuniteTime = "刚刚";
        }else if(communiteTime >= 1 && communiteTime <= 24){
            myCommuniteTime = myCommuniteTime+"小时前";
        }else if (communiteTime > 24){
            myCommuniteTime = "几天前";
        }
        return myCommuniteTime;
    }

}
