package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2016/11/26.
 */

public class RecycleViewCustom extends RecyclerView {
    public RecycleViewCustom(Context context) {
        super(context);
    }

    public RecycleViewCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecycleViewCustom(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
