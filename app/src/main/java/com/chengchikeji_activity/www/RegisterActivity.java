package com.chengchikeji_activity.www;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chengchikeji_imageLoad.HTTPUtils;
import com.chengchikeji_imageLoad.VolleyListener;
import com.chengchikeji_register_verification.RegexValidateUtil;
import com.chengchikeji_register_verification.TextUtils;
import com.chengchikeji_util.Constans;
import com.example.ex_projectitem2.R;

import java.util.HashMap;
import java.util.Map;

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
                getVerificationCode();
//                getSharedPreferences()
                break;
            case R.id.txtRegisterClick:
                //注册
                register();
                break;
            case R.id.txtServiceClause:
                //服务条款
                clause();
                break;
        }
    }

    /**
     * 服务条款
     */
    private void clause() {
    }

    /**
     * 注册，判断条件
     */
    private void register() {
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
        if (!EditLoginPwd.equals(EditConfirmLogin)) {
            registEditConfirmLogin.setError("确认密码与登入密码不一致");
            return;
        }

////        Toast.makeText(this, "登入完成", Toast.LENGTH_SHORT).show();
        HashMap<String, String> registe = new HashMap<>();
        registe.put("phone_number","registEditPhone");
        registe.put("password","registEditLoginPwd");
        registe.put("sms_code","registEditVerification");
        HTTPUtils.post(this,Constans.REGISTER_PATH,registe,new VolleyListener(){

            @Override
            public void onResponse(String arg0) {
                Log.e("注册成功","arg0:"+arg0);
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onErrorResponse(VolleyError arg0) {
                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                Log.e("注册失败","arg0:"+arg0);
            }
        });

//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constans.REGISTER_PATH, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Log.e("注册成功","arg0:"+s);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//                Log.e("注册失败","arg0:"+volleyError);
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> map = new HashMap<>();
//                map.put("phone_number","registEditPhone");
//                map.put("password","registEditLoginPwd");
//                map.put("sms_code","registEditVerification");
//                return map;
//            }
//        };
//        requestQueue.add(stringRequest);



    }

    /**
     * TODO
     * 获取手机短信验证码并在五分钟后可再次获取
     */
    private void getVerificationCode() {
        String EditPhone = registEditPhone.getText().toString();
        if (TextUtils.isEmpty(EditPhone)) {
            registEditPhone.setError("请输入手机号");
            return;
        }
        if (!RegexValidateUtil.checkMobileNumber(EditPhone)) {
            registEditPhone.setError("手机号码格式错误");
            return;
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("phone_number", EditPhone);
        params.put("type", "reg");
        HTTPUtils.get(this, Constans.VERIFICATION_PATH, params, new VolleyListener() {
            @Override
            public void onResponse(String arg0) {
                Log.e("onResponse", "arg0:" + arg0);
            }

            @Override
            public void onErrorResponse(VolleyError arg0) {
                System.out.println("请求错误:" + arg0.toString());
            }
        });
        btnObtainVerification.setClickable(false);
        btnObtainVerification.postDelayed(new Runnable() {
            @Override
            public void run() {
                i++;
                if (i <= 60) {
                    btnObtainVerification.setText("验证码已发送(" + (60 - i) + ")");
                    btnObtainVerification.setTextColor(Color.parseColor("#E6E6E6"));
                    btnObtainVerification.setBackgroundResource(R.drawable.register_verification_code);
                    btnObtainVerification.postDelayed(this, 1000);
                } else {
                    btnObtainVerification.setClickable(true);
                    btnObtainVerification.setText("重新获取验证码");
                    btnObtainVerification.setTextColor(Color.parseColor("#ED483A"));
                    btnObtainVerification.setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        }, 1000);


    }
}
