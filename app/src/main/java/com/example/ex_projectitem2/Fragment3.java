package com.example.ex_projectitem2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chengchikeji_scrollview.www.MyGridView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment3 extends Fragment {

	public Fragment3() {
		// Required empty public constructor
	}
	View inflate = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		inflate = inflater.inflate(R.layout.fragment_fragment3, container, false);
		MyGridView myGridView = (MyGridView) inflate.findViewById(R.id.MyGridView_cainixihuanb);
		MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter();
		myGridView.setAdapter(myGridViewAdapter);
		return inflate;
	}

	class MyGridViewAdapter extends BaseAdapter{

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View inflate1 = Fragment3.this.inflate.inflate(getContext(), R.layout.qingdan_caininihuan_griditem, null);
			return inflate1;
		}

		@Override
		public int getCount() {
			return 10;
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
