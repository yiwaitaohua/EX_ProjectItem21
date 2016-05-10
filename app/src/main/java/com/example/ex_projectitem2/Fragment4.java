package com.example.ex_projectitem2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {


    private String[] geren_up = new String[]{"正在进行", "已经揭晓", "中奖记录", "我的收藏", "", "晒单", "我的红包", "充值记录"};
    private int[] geren_up_picture = new int[]{R.drawable.geren_being_carried, R.drawable.geren_is_the_lottery, R.drawable.geren_winning_record, R.drawable.geren_my_collection, R.drawable.ic_launcher, R.drawable.geren_the_sun, R.drawable.geren_my_red_envelope, R.drawable.geren_recharge_record};

    public Fragment4() {
        // Required empty public constructor
    }

    View inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_fragment4, container, false);
        ListView listView = (ListView) inflate.findViewById(R.id.listUp_Personal_Center);
        MyPersonalCenterAdapter myListUp = new MyPersonalCenterAdapter();
        listView.setAdapter(myListUp);
        return inflate;
    }

    class MyPersonalCenterAdapter extends BaseAdapter {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate2 = null;
            if (position == 4) {
                inflate2 = Fragment4.this.inflate.inflate(getContext(), R.layout.fengeline, null);
            } else {
                inflate2 = inflate.inflate(getContext(), R.layout.personal_center_item, null);
                TextView tv_geren_up = (TextView) inflate2.findViewById(R.id.tv_geren_up);
                ImageView image_geren = (ImageView) inflate2.findViewById(R.id.imge_geren_list);
                tv_geren_up.setText(geren_up[position].toString());
                image_geren.setImageResource(geren_up_picture[position]);

            }

            return inflate2;
        }

        @Override
        public int getCount() {
            return geren_up.length;
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
