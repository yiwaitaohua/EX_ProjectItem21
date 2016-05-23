package com.chengchikeji_imageLoad;

import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.example.ex_projectitem2.R;

/**
 * Created by Administrator on 2016/5/23.
 */
public class UilUtils {
    private static ImageLoader imageLoader;
    private static ImageLoader.ImageListener listener;
    public static void displayImage(RequestQueue queue, String path, ImageView imageView1){
        imageLoader = new com.android.volley.toolbox.ImageLoader(queue, new BitmapCache());
        listener = com.android.volley.toolbox.ImageLoader.getImageListener(imageView1, R.drawable.ic_launcher, R.drawable.ic_launcher);
        imageLoader.get(path, listener);
    }

}
