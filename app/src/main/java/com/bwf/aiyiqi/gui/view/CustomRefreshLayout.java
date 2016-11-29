package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.cjj.MaterialRefreshLayout;

/**
 * Created by Administrator on 2016/11/29.
 * 功能描述：
 * 作者：
 */

public class CustomRefreshLayout extends MaterialRefreshLayout {
    public CustomRefreshLayout(Context context) {
        super(context);
    }

    public CustomRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(!canPull){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
    private boolean canPull=true;

    public void setCanPull(boolean canPull) {
        this.canPull = canPull;
    }
}
