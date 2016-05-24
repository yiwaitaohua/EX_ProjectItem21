package com.example.ex_projectitem2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chengchikeji_activity.www.ClassificationActivity;
import com.chengchikeji_fragment.www.HomePagerBannerFragment;
import com.chengchikeji_imageLoad.UilUtils;
import com.chengchikeji_pulldown.PullDownElasticImp;
import com.chengchikeji_pulldown.PullDownScrollView;
import com.chengchikeji_scrollview.www.MyScrollView;
import com.chengchikeji_scrollview.www.PagerIndicator;
import com.chengchikeji_bannerdata.Datum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener, MyScrollView.OnScrollListener, PullDownScrollView.RefreshListener {

    private ViewPager mViewPager;
    private FragmentManager fm;
    private boolean isUserDrag;
    private boolean needAuto = true;
    private PagerIndicator pagerIndicator;
    private TextView homePagerNewest;
    private TextView homePagerPopularity;
    private TextView homePagerSpeed;
    private RelativeLayout homePagerTotal;
    private RelativeLayout relativeLayout_suspension;
    private MyScrollView mScrollView;
    private PullDownScrollView mPullDownScrollView;
    private ArrayList<Datum> bannerDate = new ArrayList<Datum>();
    private ArrayList<com.chengchikeji_homepager.Datum> homePagerDate = new ArrayList<com.chengchikeji_homepager.Datum>();
    private String pathPrefix = "";
    private MyHomePagerAdpter myHomePagerAdpter;
    private RequestQueue requestQueue;


    public Fragment1() {
        // Required empty public constructor
    }

    private View inflate = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
            initUI();
        }
        return inflate;
    }

    private void initUI() {
        requestQueue = Volley.newRequestQueue(getActivity());
        initPullDown();
        /*ViewPager*/
        initBanner();
        initIndicator();
        initClick();
        initControl();
        initData();
        Log.e("Fragment1","initData");

    }


    private void initPullDown() {
        mPullDownScrollView = (PullDownScrollView) inflate.findViewById(R.id.homePagerPullDown);
        mPullDownScrollView.setRefreshListener(this);
        mPullDownScrollView.setPullDownElastic(new PullDownElasticImp(getContext()));
    }

    private void initControl() {
        GridView view2 = (GridView) inflate.findViewById(R.id.view2);
        myHomePagerAdpter = new MyHomePagerAdpter();
        view2.setAdapter(myHomePagerAdpter);
        homePagerPopularity = (TextView) inflate.findViewById(R.id.homePagerPopularity);
        homePagerNewest = (TextView) inflate.findViewById(R.id.homePagerNewest);
        homePagerSpeed = (TextView) inflate.findViewById(R.id.homePagerSpeed);
        homePagerTotal = (RelativeLayout) inflate.findViewById(R.id.homePagerTotal);
        relativeLayout_suspension = (RelativeLayout) inflate.findViewById(R.id.relativeLayout_suspension);
        homePagerPopularity.setOnClickListener(this);
        homePagerNewest.setOnClickListener(this);
        homePagerSpeed.setOnClickListener(this);
        homePagerTotal.setOnClickListener(this);
        mScrollView = (MyScrollView) inflate.findViewById(R.id.ScrollView);
        mScrollView.setOnScrollListener(this);
        //回到顶部
        mScrollView.smoothScrollTo(0, 0);

    }


    private void initIndicator() {
        pagerIndicator = (PagerIndicator) inflate.findViewById(R.id.pagerIndicator);

    }

    private void initBanner() {
        mViewPager = (ViewPager) inflate.findViewById(R.id.viewPager);
        fm = getChildFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fm) {

            @Override
            public Fragment getItem(int position) {
                if (position > 3) {
                    position = position % 4;
                }
                return new HomePagerBannerFragment(position);
            }

            @Override
            public int getCount() {
                return 4 * 10000;
            }
        });

        autoBanner();
        handBanner();

    }

    private void handBanner() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                pagerIndicator.move(position % 4, positionOffset);
//                Log.e("position:","position:"+position);
//                Log.e("positionOffset:","positionOffset:"+positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        isUserDrag = true;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        isUserDrag = false;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        isUserDrag = false;
                        break;
                }

            }
        });
    }


    private void autoBanner() {
        mViewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                int item = mViewPager.getCurrentItem() + 1;
                if (!isUserDrag && needAuto) {
                    mViewPager.setCurrentItem(item);
                    mViewPager.postDelayed(this, 3000);
                }
            }
        }, 3000);
    }

    @Override
    public void onStart() {
        super.onStart();
        needAuto = true;
        isUserDrag = false;
        //切换tab,在其它tab页停留三秒以上，首页banner滑动停止
//        autoBanner();
    }

    @Override
    public void onResume() {
        super.onResume();
        needAuto = true;
        isUserDrag = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        needAuto = false;
        isUserDrag = true;
    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        needAuto = false;
//        isUserDrag = true;
//    }

    private void initClick() {
        inflate.findViewById(R.id.linearL_FenLei).setOnClickListener(this);
        inflate.findViewById(R.id.seach_home_page).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearL_FenLei:
                Intent intent = new Intent(getContext(), ClassificationActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.seach_home_page:
//                Intent intent1 = new Intent();
//                getContext().startActivity(intent1);
                break;
            case R.id.homePagerPopularity:

                break;
            case R.id.homePagerNewest:
                break;
            case R.id.homePagerSpeed:
                break;
            case R.id.homePagerTotal:
                break;

        }
    }

    /**
     * 判断ScrollView是否滑动悬停
     *
     * @param scrollY
     */
    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= 660) {
            relativeLayout_suspension.setVisibility(View.VISIBLE);
        } else {
            relativeLayout_suspension.setVisibility(View.GONE);
        }
    }

    /**
     * 重写下拉刷新
     *
     * @param view
     */
    @Override
    public void onRefresh(PullDownScrollView view) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                String str = formatter.format(curDate);
                mPullDownScrollView.finishRefresh("上次刷新时间:"+str);
//                mPullDownScrollView.finishRefresh("上次刷新时间:12:23");
            }
        }, 2000);
    }

//    @Override
//    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
////        Log.e("scrollX", "scrollX:"+scrollX);
////        Log.e("scrollY", "scrollY:"+scrollY);
////        Log.e("oldScrollX", "oldScrollX:"+oldScrollX);
////        Log.e("oldScrollY", "oldScrollY:"+oldScrollY);
//    }


    class MyHomePagerAdpter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            if(inflate==null){
                inflate = Fragment1.this.inflate.inflate(getContext(), R.layout.qingdan_caininihuan_griditem, null);
            }
            ImageView homePagerImageTenYuan = (ImageView) inflate.findViewById(R.id.homePagerImageTenYuan);
            ImageView homePagerPhoneImage = (ImageView) inflate.findViewById(R.id.homePagerPhoneImage);
            TextView homePagerPhoneName = (TextView) inflate.findViewById(R.id.homePagerPhoneName);
            TextView homePagerPercentage = (TextView) inflate.findViewById(R.id.homePagerPercentage);
            ProgressBar homePagerPBar = (ProgressBar) inflate.findViewById(R.id.homePagerPBar);
            TextView homePagerJoinIn = (TextView) inflate.findViewById(R.id.homePagerJoinIn);
//            homePagerDate
            if(homePagerDate!=null){
                UilUtils.displayImage(requestQueue,pathPrefix+homePagerDate.get(position).getIMGURL(),homePagerPhoneImage);
                homePagerPhoneName.setText(homePagerDate.get(position).getTITLE());
                int zrs = Integer.parseInt(homePagerDate.get(position).getZRS());
                int syrs = Integer.parseInt(homePagerDate.get(position).getSYRS());
                homePagerPercentage.setText((zrs-syrs)*100/zrs+"%");
                homePagerPBar.setMax(zrs);
                homePagerPBar.setProgress(zrs-syrs);

            }
            return inflate;
        }

        @Override
        public int getCount() {
            return homePagerDate.size();
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

    /**
     * 数据请求
     */
    private void initData() {

        StringRequest stringRequest = new StringRequest("http://yydb.willfun.com.cn/module/yiyuangou/api/home_img.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String s) {
//                        Log.e("onResponse","s:"+s);
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            String host = jsonObject.getString("host");
                            pathPrefix = host;
                            String message = jsonObject.getString("message");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                String id = jsonObject1.getString("ID");
                                String aid = jsonObject1.getString("AID");
                                String title = jsonObject1.getString("TITLE");
                                String type = jsonObject1.getString("TYPE");
                                String content = jsonObject1.getString("CONTENT");
                                String url = jsonObject1.getString("URL");
                                String checked = jsonObject1.getString("CHECKED");
                                String addtime = jsonObject1.getString("ADDTIME");
                                String endtime = jsonObject1.getString("ENDTIME");
                                Log.e("title", "title:" + title);
                                Log.e("content", "content:" + content);
                                bannerDate.add(new Datum(id, aid, title, type, content, url, checked, addtime, endtime));
                            }
                            Log.e("host", "host:" + host);
                            Log.e("message", "message:" + message);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(volleyError.getMessage(), "volleyError:" + volleyError);
            }
        });
        StringRequest stringRequest2 = new StringRequest("http://yydb.willfun.com.cn/module/yiyuangou/api/home_index.php?option=zrs",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray data = jsonObject.getJSONArray("data");
                            for (int i = 0; i < data.length(); i++){
                                JSONObject jsonObject1 = data.getJSONObject(i);
                                String id = jsonObject1.getString("ID");
                                String sid = jsonObject1.getString("SID");
                                String title = jsonObject1.getString("TITLE");
                                Object descr = jsonObject1.getString("DESCR");
                                String imgurl = jsonObject1.getString("IMGURL");
                                String zrs = jsonObject1.getString("ZRS");
                                String syrs = jsonObject1.getString("SYRS");
                                String jindu = jsonObject1.getString("JINDU");
                                String name = jsonObject1.getString("NAME");
                                String cateid = jsonObject1.getString("CATEID");
                                homePagerDate.add(new com.chengchikeji_homepager.Datum(id,sid,title,descr,imgurl,zrs,syrs,jindu,name,cateid));
                            }

                            myHomePagerAdpter.notifyDataSetChanged();
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }


                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(volleyError.getMessage(), "volleyError:" + volleyError);
            }
        });

        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest2);

    }
}
