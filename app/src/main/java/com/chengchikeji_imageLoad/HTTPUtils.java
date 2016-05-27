package com.chengchikeji_imageLoad;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chengchikeji_register_verification.TextUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/25.
 * 数据请求
 */
public class HTTPUtils {

    private static RequestQueue mRequestQueue;

    private HTTPUtils() {

    }

    private static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);

    }

    /**
     * GET带参数请求
     * @param context
     * @param url
     * @param params
     * @param listener
     */
    public static void get(Context context, String url, Map<String, String> params, final VolleyListener listener) {
        url = buildParams(url, params);
        get(context, url, listener);
    }

    public static String buildParams(String url, Map<String, String> params) {
        if (TextUtils.isEmpty(url)){
            return url;
        }
        if (params == null || params.size() == 0){
            return url;
        }
        url += "?";
        Set<String> keySet = params.keySet();
        Iterator<String> itr = keySet.iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            url += key + "=" + params.get(key) + "&";
        }
        url = url.substring(0, url.length() - 1);
        return url;
    }

    /**
     * GET请求
     * @param context
     * @param url
     * @param listener
     */
    public static void get(Context context, String url, final VolleyListener listener) {
        // 判断当前如果没有网络，则返回null
        if (!ConnectionUtils.isConnected(context)) {
            VolleyError error = new VolleyError("no connection");
            listener.onErrorResponse(error);
            return;
        }

        StringRequest myReq = new UTFStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                listener.onErrorResponse(error);
            }
        });
        if (mRequestQueue == null) {
            init(context);
        }
        mRequestQueue.add(myReq);
    }

    /**
     * POST请求
     * @param context
     * @param url
     * @param params
     * @param listener
     */
    public static void post(Context context, String url, final Map<String, String> params,
                            final VolleyListener listener) {
        StringRequest myReq = new UTFStringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                listener.onErrorResponse(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                return params;
            }
        };
        if (mRequestQueue == null) {
            init(context);
        }

        // 请用缓存
        myReq.setShouldCache(true);
        // 设置缓存时间10分钟
        // myReq.setCacheTime(10*60);
        mRequestQueue.add(myReq);
    }
}
