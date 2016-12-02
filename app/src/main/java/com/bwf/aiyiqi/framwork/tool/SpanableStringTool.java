package com.bwf.aiyiqi.framwork.tool;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

/**
 * Created by Administrator on 2016/12/2.
 */

public class SpanableStringTool {
    public static SpannableString spanToString(String content,int startLength, int endLength){
        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new ForegroundColorSpan(Color.GREEN),startLength,endLength,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
