package com.chengchikeji_activity.www;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chengchikeji_register_verification.RegexValidateUtil;
import com.chengchikeji_register_verification.TextUtils;
import com.example.ex_projectitem2.R;

public class RegisterActivity extends Activity implements View.OnClickListener {

    private EditText registEditPhone;
    private EditText registEditVerification;
    private EditText registEditLoginPwd;
    private EditText registEditConfirmLogin;
    private int i = 0;
    private Button btnObtainVerification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
    }

    private void initUI() {
        initControl();
        initClick();
    }

    private void initControl() {
        registEditPhone = (EditText) findViewById(R.id.registEditPhone);
        registEditVerification = (EditText) findViewById(R.id.registEditVerification);
        registEditLoginPwd = (EditText) findViewById(R.id.registEditLoginPwd);
        registEditConfirmLogin = (EditText) findViewById(R.id.registEditConfirmLogin);
        btnObtainVerification = (Button) findViewById(R.id.btnObtainVerification);
    }

    private void initClick() {
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.txtRegisterClick).setOnClickListener(this);
        findViewById(R.id.txtServiceClause).setOnClickListener(this);
        btnObtainVerification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btnObtainVerification:
                //获取验证码
                btnObtainVerification.setClickable(false);
                btnObtainVerification.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                        if(i<=60){
                            btnObtainVerification.setText("验证码已发送("+(60-i)+")");
                            btnObtainVerification.setTextColor(Color.parseColor("#E6E6E6"));
                            btnObtainVerification.setBackgroundResource(R.drawable.register_verification_code);
                            btnObtainVerification.postDelayed(this,1000);
                        }else{
                            btnObtainVerification.setClickable(true);
                            btnObtainVerification.setText("重新获取验证码");
                            btnObtainVerification.setTextColor(Color.parseColor("#ED483A"));
                            btnObtainVerification.setBackgroundColor(Color.parseColor("#00000000"));
                        }
                    }
                },1000);

//                getSharedPreferences()

                break;
            case R.id.txtRegisterClick:
                //注册
                String EditPhone = registEditPhone.getText().toString();
                String EditVerification = registEditVerification.getText().toString();
                String EditLoginPwd = registEditLoginPwd.getText().toString();
                String EditConfirmLogin = registEditConfirmLogin.getText().toString();
                if (TextUtils.isEmpty(EditPhone)) {
                    registEditPhone.setError("请输入手机号");
                    return;
                }
                if (!RegexValidateUtil.checkMobileNumber(EditPhone)) {
                    registEditPhone.setError("手机号码格式错误");
                    return;
                }
                if (EditVerification == null || EditVerification == "" || EditVerification.equals("")) {
                    registEditVerification.setError("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(EditLoginPwd)) {
                    registEditLoginPwd.setError("请输入密码");
                    return;
                }
                if (!RegexValidateUtil.checkCharacter(EditLoginPwd)) {
                    registEditLoginPwd.setError("密码格式错误");
                    return;
                }
                if (TextUtils.isEmpty(EditConfirmLogin)) {
                    registEditConfirmLogin.setError("请输入确认登入密码");
                    return;
                }
                if (!RegexValidateUtil.checkCharacter(EditConfirmLogin)) {
                    registEditConfirmLogin.setError("密码格式错误");
                    return;
                }
                if(!EditLoginPwd.equals(EditConfirmLogin)){
                    registEditConfirmLogin.setError("确认密码与登入密码不一致");
                    return;
                }

                Toast.makeText(this,"登入完成",Toast.LENGTH_SHORT).show();

                break;
            case R.id.txtServiceClause:
                //服务条款

                break;
        }
    }
}
