package com.example.ex_projectitem2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chengchikeji_activity.www.ClassificationActivity;
import com.chengchikeji_fragment.www.HomePagerBannerFragment;
import com.chengchikeji_pulldown.PullDownElasticImp;
import com.chengchikeji_pulldown.PullDownScrollView;
import com.chengchikeji_scrollview.www.MyScrollView;
import com.chengchikeji_scrollview.www.PagerIndicator;

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
        initPullDown();
        /*ViewPager*/
        initBanner();
        initIndicator();
        initClick();
        initControl();
        initData();
    }

    private void initData() {
    }

    private void initPullDown() {
        mPullDownScrollView = (PullDownScrollView) inflate.findViewById(R.id.homePagerPullDown);
        mPullDownScrollView.setRefreshListener(this);
        mPullDownScrollView.setPullDownElastic(new PullDownElasticImp(getContext()));
    }

    private void initControl() {
        GridView view2 = (GridView) inflate.findViewById(R.id.view2);
        MyHomePagerAdpter myHomePagerAdpter = new MyHomePagerAdpter();
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
        mScrollView.smoothScrollTo(0,0);

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
    public void onResume() {
        super.onResume();
        needAuto = true;
        isUserDrag = false;

    }

    @Override
    public void onStop() {
        super.onStop();
        needAuto = false;
        isUserDrag = true;
    }

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
     * @param scrollY
     */
    @Override
    public void onScroll(int scrollY) {
        if(scrollY>=660){
            relativeLayout_suspension.setVisibility(View.VISIBLE);
        }else{
            relativeLayout_suspension.setVisibility(View.GONE);
        }
    }

    /**
     * 重写下拉刷新
     * @param view
     */
    @Override
    public void onRefresh(PullDownScrollView view) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                mPullDownScrollView.finishRefresh("上次刷新时间:12:23");
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
            View inflate = Fragment1.this.inflate.inflate(getContext(), R.layout.qingdan_caininihuan_griditem, null);
            return inflate;
        }

        @Override
        public int getCount() {
            return 7;
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
}
