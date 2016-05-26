package com.chengchikeji_imageLoad;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Administrator on 2016/5/25.
 */
public class UTFStringRequest extends StringRequest{

    public UTFStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }
}
