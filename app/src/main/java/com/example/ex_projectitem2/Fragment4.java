package com.example.ex_projectitem2;

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
public class Fragment4 extends Fragment {


	private String[] geren_up= new String[]{"正在进行","已经揭晓","中奖记录","我的收藏"};
	public Fragment4() {
		// Required empty public constructor
	}
	View inflate;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		inflate = inflater.inflate(R.layout.fragment_fragment4, container, false);
		ListView listView = (ListView)inflate.findViewById(R.id.listUp_Personal_Center);
		return inflate;
	}

	class MyPersonalCenterAdapter extends BaseAdapter{
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View inflate2 = inflate.inflate(getContext(), R.layout.personal_center_item, null);
			TextView tv_geren_up = (TextView) inflate2.findViewById(R.id.tv_geren_up);
			tv_geren_up.setText(geren_up[position].toString());
			return inflate2;
		}

		@Override
		public int getCount() {
			return 4;
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
