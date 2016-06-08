package com.bm.zoomimage.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Copyright © 2016. All rights reserved.
 *
 * @author yangjie
 *         create at 2016/6/8 11:32
 * @Description 自定义viewpage 防止出现放大异常
 */
public class ImageViewPager extends ViewPager {

    public ImageViewPager(Context context) {
        super(context);
    }

    public ImageViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        boolean b = false;
        try {
            b = super.onInterceptTouchEvent(arg0);
        } catch (Exception e) {

        }
        return b; //网上看的方法是直接返回false，但是会导致ViewPager翻页有BUG
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        boolean b = false;
        try {
            b = super.onTouchEvent(arg0);
        } catch (Exception e) {

        }
        return b;
    }
}