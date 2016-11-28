package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lingchen52 on 2016/11/24.
 */

public class SlideViewPager extends ViewPager {

    public SlideViewPager(Context context) {
        super(context);
        init();
    }

    public SlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        setViewPagerScroller();
    }

    @Override
    public void setAdapter(final PagerAdapter adapter) {
        super.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return adapter.isViewFromObject(view,object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return adapter.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                adapter.destroyItem(container, position, object);
            }
        });
        startAutoScroller();
    }
    private void setViewPagerScroller(){
        try {
            Field scrollerField = ViewPager.class.getDeclaredField("mScroller");
            scrollerField.setAccessible(true);
            mScroller = new CustomDurationScroller(getContext());
            scrollerField.set(this,mScroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private CustomDurationScroller mScroller;
    private class CustomDurationScroller extends Scroller{
        public CustomDurationScroller(Context context) {
            super(context);
        }

        public CustomDurationScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public CustomDurationScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 1000);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                stopAutoScroll();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                startAutoScroller();
                break;

        }
        return super.onTouchEvent(ev);
    }

    private Timer mTimer = new Timer();
    private TimerTask mTask;
    private void startAutoScroller(){
        if(mTask == null){
            mTask = new TimerTask() {
                @Override
                public void run() {
                    nextPage();
                }
            };
            mTimer.schedule(mTask,2000,2000);
        }
    }

    private void nextPage() {
        post(new Runnable() {
            @Override
            public void run() {
                setCurrentItem(getCurrentItem() + 1);
            }
        });
    }
    private void stopAutoScroll(){
        if(mTask != null){
            mTask.cancel();
            mTask = null;
        }
    }
}
