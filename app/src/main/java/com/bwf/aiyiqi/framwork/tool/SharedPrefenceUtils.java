package com.bwf.aiyiqi.framwork.tool;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/6.
 */

public class SharedPrefenceUtils {

    public static void setString(Context context,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences("yiqihouse", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key,value).commit();
    }

    public static String getString(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences("yiqihouse", Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, "");
        return value;
    }

    public static void setBoolean(Context context,String key,boolean b){
        SharedPreferences sharedPreferences = context.getSharedPreferences("yiqihouse", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key,b).commit();
    }

    public static boolean getBoolean(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences("yiqihouse", Context.MODE_PRIVATE);
        boolean aBoolean = sharedPreferences.getBoolean(key, true);
        return aBoolean;
    }

}
