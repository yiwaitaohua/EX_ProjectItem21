package com.chengchikeji_activity.www;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ex_projectitem2.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initID();

    }

    private void initID() {
        initClick();
    }

    private void initClick() {
        findViewById(R.id.back_Login).setOnClickListener(this);
        findViewById(R.id.Login_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_Login:
                finish();
                break;
            case R.id.Login_register:
                Intent intent2 = new Intent(this, RegisterActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
