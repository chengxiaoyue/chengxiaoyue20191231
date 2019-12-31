package com.bawei.chengxiaoyue20191231.util;

import android.widget.ImageView;

import com.bawei.chengxiaoyue20191231.R;
import com.bawei.chengxiaoyue20191231.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public class GlideUtil {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
