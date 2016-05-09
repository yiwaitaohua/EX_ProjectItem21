package com.example.ex_projectitem2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment2 extends Fragment {

	private View inflate;

	public Fragment2() {
		// Required empty public constructor
	}

	@SuppressLint("CutPasteId")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		inflate = inflater.inflate(R.layout.fragment_fragment2, container, false);
		ListView mListView = (ListView) inflate.findViewById(R.id.list_jijiankaijiang_listView);
		Lsynds lsynds = new Lsynds();
		MyListYiKaiJ myListYiKaiJ = new MyListYiKaiJ();
		mListView.setAdapter(lsynds);
		ListView mList_yikaijiang = (ListView) inflate.findViewById(R.id.list_yikaijiang_listView);
		mList_yikaijiang.setAdapter(myListYiKaiJ);
		return inflate;
	}
	
	class Lsynds extends BaseAdapter{

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
	
	class MyListYiKaiJ extends BaseAdapter{

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
			 tv_shijian.setText("用户842731");
			 
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
