package com.chengchikeji_activity.www;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.ex_projectitem2.R;

public class GeRenShezhiActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge_ren_shezhi);
        initID();
    }

    private void initID() {
        initClick();
    }

    private void initClick() {
        findViewById(R.id.back_gerenSetting).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_gerenSetting:
                finish();
                break;
        }
    }
}
