package com.bwf.aiyiqi.gui.activity;

import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by LG on 2016/10/14.
 * Tips:
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //
        initBeforeSetView();
        //为Activity绑定xml视图
        setContentView(getContentViewResId());

        initViews(); //初始化控件
        initDatas();//初始化数据
    }

    protected abstract void initDatas();
    protected void initBeforeSetView(){};
    /**
     * 初始化控件
     */
    protected abstract void initViews();
    /**
     * 提供Activity要绑定的xml资源id
     * @return
     */
    protected abstract int getContentViewResId();
    /**
     * 不用强转的findviewbyid
     */
    public <T extends View> T findViewByIdNoCast(int id) {
        return (T) super.findViewById(id);
    }
    /**
     * dip转像素
     */
    public  int dip2px(float dpValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    /**
     * 像素转dip
     */
    public  int px2dip(float pxValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }
    /**
     * 判断是否有网络
     */
    public boolean isNetWork() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager != null
                && connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isAvailable();
    }

    /**
     * 获取状态栏高度
     */
    public int getStatusHeight() {
        final Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int n = rect.top;
        if (n != 0) {
            return n;
        }
        try {
            final Class<?> forName = Class.forName("com.android.internal.R$dimen");
            n = getResources().getDimensionPixelSize(Integer.parseInt(forName.getField("status_bar_height").get(forName.newInstance()).toString()));
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
        }catch (InstantiationException ex3) {
            ex3.printStackTrace();
        }catch (NumberFormatException ex4) {
            ex4.printStackTrace();
        }catch (IllegalArgumentException ex5) {
            ex5.printStackTrace();
        }catch (SecurityException ex6) {
            ex6.printStackTrace();
        }catch (NoSuchFieldException ex7) {
            ex7.printStackTrace();
        }
        return n;
    }

    /**
     * 设置为全屏
     */
    protected void setFullScreen(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /***
     * 再按一次退出
     */
//    private long oldTime;
//    private long currentTime;
//    private int exitTime = 3000;//3秒退出
//    @Override
//    public void onBackPressed() {
//        currentTime = System.currentTimeMillis();
//        if( currentTime - oldTime >= exitTime){
//            oldTime = currentTime;
//            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//            return;
//        }else {
//            android.os.Process.killProcess(android.os.Process.myPid());
//            System.exit(0);
//        }
//    }
}