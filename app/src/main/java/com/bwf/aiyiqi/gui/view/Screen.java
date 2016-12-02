package com.bwf.aiyiqi.gui.view;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/12/1.
 * 功能描述：
 * 作者：
 */

public class Screen {
        private int width;
        private int height;
        public Screen(Activity context) {
            DisplayMetrics metrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getMetrics(metrics );
            width = metrics.widthPixels;
            height = metrics.heightPixels;
        }
        /**
         * @return 屏幕宽度 in pixel
         */
        public int getWidth() {
            return width;
        }

        /**
         *
         * @return 屏幕高度 in pixel
         */
        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "Screen{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }

}
