package com.chengchikeji_activity.www;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ex_projectitem2.R;

public class ClassificationActivity extends Activity implements View.OnClickListener {

    private int[] classification_picture = new int[]{R.drawable.fenlei_all_prizes, R.drawable.fenlei_ten_yuan_area, R.drawable.fenlei_mobile_tablet, R.drawable.fenlei_computer_office, R.drawable.fenlei_digital_video, R.drawable.fenlei_new_trend, R.drawable.fenlei_women_fashion, R.drawable.fenlei_home_life, R.drawable.fenlei_other_commodities};
    private String[] classification_text = new String[]{"全部奖品", "10元专区", "手机平板", "电脑办公", "数码影音", "潮流新品", "女性时尚", "家具生活", "其他商品"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        ListView listClassification = (ListView) findViewById(R.id.listClassification);
        MyClassificationAdapter myClassificationAdapter = new MyClassificationAdapter();
        listClassification.setAdapter(myClassificationAdapter);
        inint();
    }

    private void inint() {
        initClick();
    }

    private void initClick() {
        findViewById(R.id.back_Classification).setOnClickListener(this);
    }


    class MyClassificationAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate;
            ImageView fenlei_all_picture;
            TextView fenlei_all_text;
            if (position == 0) {
                inflate = getLayoutInflater().inflate(R.layout.classification_all, null);
                fenlei_all_picture = (ImageView) inflate.findViewById(R.id.fenlei_all_picture);
                fenlei_all_text = (TextView) inflate.findViewById(R.id.fenlei_all_text);
            } else {
                inflate = getLayoutInflater().inflate(R.layout.classification_down, null);
                fenlei_all_picture = (ImageView) inflate.findViewById(R.id.fenlei_down_picture);
                fenlei_all_text = (TextView) inflate.findViewById(R.id.fenlei_down_text);
            }
            fenlei_all_picture.setImageResource(classification_picture[position]);
            fenlei_all_text.setText(classification_text[position]);
            return inflate;
        }

        @Override
        public int getCount() {
            return classification_picture.length;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_Classification:
                finish();
                break;
        }
    }
}
