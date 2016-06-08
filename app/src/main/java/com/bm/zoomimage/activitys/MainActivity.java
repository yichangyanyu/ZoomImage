package com.bm.zoomimage.activitys;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.zoomimage.R;
import com.bm.zoomimage.photos.PhotoView;
import com.bm.zoomimage.views.ImageViewPager;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016. All rights reserved.
 *
 * @author yangjie
 *         create at 2016/6/8 11:30
 * @Description  图片的缩放
 * @email jiezi68@126.com
 */
public class MainActivity extends AppCompatActivity {

    private ImageViewPager mVp_big_image;
    private ImageLoader mImageLoader;
    private List<String> comment_pics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageLoader = ImageLoader.getInstance();
        comment_pics = new ArrayList<>();
        comment_pics.add("http://p4.so.qhimg.com/t0102672bd8a6bd290e.jpg");
        comment_pics.add("http://p4.so.qhimg.com/t0102672bd8a6bd290e.jpg");
        comment_pics.add("http://p4.so.qhimg.com/t0102672bd8a6bd290e.jpg");
        comment_pics.add("http://p4.so.qhimg.com/t0102672bd8a6bd290e.jpg");
        mVp_big_image = (ImageViewPager) findViewById(R.id.vp_big_image);
        BigImageAdapter bigImageAdapter = new BigImageAdapter();
        mVp_big_image.setAdapter(bigImageAdapter);
        bigImageAdapter.notifyDataSetChanged();
    }

    private class BigImageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return comment_pics.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            PhotoView imageView = new PhotoView(MainActivity.this);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mImageLoader.displayImage(comment_pics.get(position), imageView);
            container.addView(imageView);
            return imageView;
        }
    }
}
