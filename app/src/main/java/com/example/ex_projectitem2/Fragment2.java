package com.example.ex_projectitem2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private View inflate;

    public Fragment2() {
        // Required empty public constructor
    }

    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_fragment2, container, false);
            initUI();
            initData();
        }
        ListView mListView = (ListView) inflate.findViewById(R.id.list_jijiankaijiang_listView);
        Lsynds lsynds = new Lsynds();
        MyListYiKaiJ myListYiKaiJ = new MyListYiKaiJ();
        mListView.setAdapter(lsynds);
        ListView mList_yikaijiang = (ListView) inflate.findViewById(R.id.list_yikaijiang_listView);
        mList_yikaijiang.setAdapter(myListYiKaiJ);
        return inflate;
    }

    private void initUI() {

    }

    private void initData() {
        //post请求  获取即将开奖记录 POST 方法 参数： 空
        String path = "http://yydb.willfun.com.cn/module/yiyuangou/api/home_jjkj.php";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e(" s", " s:" + s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    class Lsynds extends BaseAdapter {

        @SuppressLint("ViewHolder")
        @SuppressWarnings("static-access")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate2 = inflate.inflate(getContext(), R.layout.list_jijiankaijian_item, null);
            return inflate2;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }

    class MyListYiKaiJ extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View inflate3 = inflate.inflate(getContext(), R.layout.list_jijiankaijian_item, null);
            TextView mTextView = (TextView) inflate3.findViewById(R.id.tv_yikaijiang);
            TextView tv_kaijiang = (TextView) inflate3.findViewById(R.id.tv_kaijiang);
            TextView tv_shijian = (TextView) inflate3.findViewById(R.id.tv_shijian);
            mTextView.setVisibility(View.VISIBLE);
            tv_kaijiang.setText("获奖者：");
            tv_kaijiang.setTextColor(Color.parseColor("#AAAAAA"));
            tv_shijian.setTextSize(15);
            tv_shijian.setText("用户000000");

            return inflate3;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 2;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }


    }

}
