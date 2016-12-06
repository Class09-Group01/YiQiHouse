package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by lingchen52 on 2016/12/6.
 */

public class MyNestedScrollView extends NestedScrollView {
    public MyNestedScrollView(Context context) {
        super(context);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    boolean isMove = false;
    private float touchDownX,touchDownY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchDownX = ev.getX();
                touchDownY = ev.getY();
                isMove = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if(!isMove) {
                    float cx = ev.getX();
                    float cy = ev.getY();
                    float dx = cx - touchDownX;
                    float dy = cy - touchDownY;
                    if(dx*dx + dy*dy > 100){
                        isMove = true;
                    }
                }
                if(isMove) {
//                    if (DesignActivity.state == DesignActivity.CollapsingToolbarLayoutState.COLLAPSED) {
                        return false;
//                    } else {
//                        return true;
//                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
