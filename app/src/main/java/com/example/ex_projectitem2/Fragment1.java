package com.example.ex_projectitem2;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chengchikeji_activity.www.ClassificationActivity;
import com.chengchikeji_fragment.www.HomePagerBannerFragment;
import com.chengchikeji_scrollview.www.PagerIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    private ViewPager mViewPager;
    private FragmentManager fm;
    private boolean isUserDrag;
    private boolean needAuto = true;
    private PagerIndicator pagerIndicator;


    public Fragment1() {
        // Required empty public constructor
    }

    private View inflate = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        }
        initUI();
        return inflate;
    }

    private void initUI() {
        /*ViewPager*/
        initBanner();
        initIndicator();
        initClick();
        initControl();
    }

    private void initControl() {
        GridView view2 = (GridView) inflate.findViewById(R.id.view2);
        MyHomePagerAdpter myHomePagerAdpter = new MyHomePagerAdpter();
        view2.setAdapter(myHomePagerAdpter);
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
//        needAuto = true;
//        isUserDrag = false;
        Log.e("onResume", "onResume");

    }

    @Override
    public void onStop() {
        super.onStop();
        needAuto = false;
//        isUserDrag = true;
        Log.e("onStop", "onStop");
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

        }
    }

    class MyHomePagerAdpter extends BaseAdapter{

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = Fragment1.this.inflate.inflate(getContext(), R.layout.qingdan_caininihuan_griditem, null);
            return inflate;
        }

        @Override
        public int getCount() {
            return 1;
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
