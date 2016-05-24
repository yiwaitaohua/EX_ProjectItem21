package com.example.ex_projectitem2;

//import com.xinbo.utils.TextViewUtils;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.content.Context;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class PhoneTabActivity extends FragmentActivity {

	public PhoneTabActivity() {
		// Required empty public constructor
	}
	private FragmentTabHost mTabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_tab);
		// ActionBar actionBar = getActionBar();
		// actionBar.setTitle("����");
		// actionBar.setIcon(R.drawable.ic_launcher);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		SharedPreferences aTrue = getSharedPreferences("true", 0);
		initUI();
	}
	
	private void initUI() {
		initTab();
	}

	private void initTab() {
		LayoutInflater inflater = getLayoutInflater();
		View fragmentTab1 = inflater.inflate(R.layout.tab_click_item, null);
		findUI(fragmentTab1, "首页", R.drawable.shouye_home);
		View fragmentTab2 = inflater.inflate(R.layout.tab_click_item, null);
		findUI(fragmentTab2, "即将开奖", R.drawable.shouye_kaijian);
		View fragmentTab3 = inflater.inflate(R.layout.tab_click_item, null);
		findUI(fragmentTab3, "清单", R.drawable.shouye_qingdan);
		View fragmentTab4 = inflater.inflate(R.layout.tab_click_item, null);
		findUI(fragmentTab4, "我的", R.drawable.shouye_wode);
		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator(fragmentTab1), Fragment1.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator(fragmentTab2), Fragment2.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator(fragmentTab3), Fragment3.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("throttle").setIndicator(fragmentTab4), Fragment4.class, null);
	}
	
	private void findUI(View fragmentTab1, String str, int drawable) {
		TextView mTextView = (TextView) fragmentTab1.findViewById(R.id.textView1);
		setTextDrawable(this, drawable, mTextView);
		mTextView.setText(str);
		
	}

	public static void setTextDrawable(Context context, int drawableRes,
									   TextView tvName) {
		Drawable drawableTop = context.getResources().getDrawable(drawableRes);
		// 必须设置图片大小，否则不显示
		drawableTop.setBounds(0, 0, drawableTop.getMinimumWidth(),
				drawableTop.getMinimumHeight());
		tvName.setCompoundDrawables(null, drawableTop, null, null);
	}


}
