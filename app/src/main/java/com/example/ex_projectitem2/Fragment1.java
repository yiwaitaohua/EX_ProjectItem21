package com.example.ex_projectitem2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chengchikeji_activity.www.ClassificationActivity;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

	public Fragment1() {
		// Required empty public constructor
	}

	private View inflate = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
		initUI();
		return inflate;

	}

	private void initUI() {
		initClick();
	}

	private void initClick() {
		inflate.findViewById(R.id.linearL_FenLei).setOnClickListener(this);
		inflate.findViewById(R.id.seach_home_page).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.linearL_FenLei:
				Intent intent = new Intent(getContext(), ClassificationActivity.class);
				getContext().startActivity(intent);
				break;
			case R.id.seach_home_page:
				Intent intent1 = new Intent();
				getContext().startActivity(intent1);
				break;

		}
	}
}
