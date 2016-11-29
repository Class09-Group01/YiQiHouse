package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/11/24.
 */

public class ScrollViewCustom extends ScrollView {
    public ScrollViewCustom(Context context) {
        super(context);
    }

    public ScrollViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(listener != null){
            listener.onMyScrollChanged(l, t, oldl, oldt);
        }
    }

    private OnMyScrollChangedListener listener;

    public void setOnMyScrollChanged(OnMyScrollChangedListener listener) {
        this.listener = listener;
    }
    public interface OnMyScrollChangedListener{
        void onMyScrollChanged(int x, int y, int oldX, int oldY);
    }

//    public void setIntercept(boolean intercept) {
//        isIntercept = intercept;
//    }
//    private boolean isIntercept;
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (isIntercept){
//            return true;
//        }else{
//            return false;
////            return super.onInterceptTouchEvent(ev);
//        }
//
//    }
}
