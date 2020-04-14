package com.nd.abs.ui.module.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.BaseActivity;
import com.nd.abs.ui.module.main.activity.MainActivity;
import com.nd.abs.utils.CommonUtils;
import com.nd.abs.utils.IntentUtil;
import com.nd.abs.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.edtPhone)
    EditText edtPhone;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.edtCode)
    EditText edtCode;
    @BindView(R.id.btnCode)
    TextView btnCode;
    @BindView(R.id.txtFindPassWord)
    TextView txtFindPassWord;
    @BindView(R.id.tvRegist)
    TextView btnRegist;
    @BindView(R.id.ll_regist)
    LinearLayout ll_regist;
    @BindView(R.id.ll_code)
    LinearLayout ll_code;
    @BindView(R.id.ll_pwd)
    LinearLayout ll_pwd;
    @BindView(R.id.txtChangeLogin)
    TextView txtChangeLogin;


    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录方式 1密码登录  2账号登录
     */
    private int loginType;
    public final int LOGIN_TYPE_BY_PWD = 1;
    public final int LOGIN_TYPE_BY_CODE = 2;

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

        //设置短信登录优先
        ll_pwd.setVisibility(View.GONE);
        ll_code.setVisibility(View.VISIBLE);
        txtFindPassWord.setVisibility(View.INVISIBLE);
        setTitle("短信登录");

    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }


    @OnClick({R.id.btnCode, R.id.txtFindPassWord, R.id.tvRegist,R.id.btnSureLogin,
            R.id.txtChangeLogin,R.id.iv_third_qq,R.id.iv_third_wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtChangeLogin:
                if("密码登录".equals(txtChangeLogin.getText().toString())){
                    txtChangeLogin.setText("短信登录");
                    loginType = LOGIN_TYPE_BY_PWD;
                   /* tv_zhdl.setBackgroundResource(R.drawable.button_login_select);
                    tv_dxdl.setBackgroundResource(R.drawable.button_login_select2);
                    tv_zhdl.setTextColor(getResources().getColor(R.color.blue_00aaf5));
                    tv_dxdl.setTextColor(getResources().getColor(R.color.white));*/
                    // ll_regist.setVisibility(View.VISIBLE);
                    ll_code.setVisibility(View.GONE);
                    ll_pwd.setVisibility(View.VISIBLE);
                    txtFindPassWord.setVisibility(View.VISIBLE);
                    setTitle("账号登录");
                }else{
                    txtChangeLogin.setText("密码登录");
                    loginType = LOGIN_TYPE_BY_CODE;
              /*      tv_zhdl.setBackgroundResource(R.drawable.button_login_select2);
                    tv_dxdl.setBackgroundResource(R.drawable.button_login_select);
                    tv_dxdl.setTextColor(getResources().getColor(R.color.blue_00aaf5));
                    tv_zhdl.setTextColor(getResources().getColor(R.color.white));*/
                    // ll_regist.setVisibility(View.INVISIBLE);
                    ll_pwd.setVisibility(View.GONE);
                    ll_code.setVisibility(View.VISIBLE);
                    txtFindPassWord.setVisibility(View.INVISIBLE);
                    setTitle("短信登录");
                }

                break;
            case R.id.txtFindPassWord:
                //IntentUtil.gotoActivity(this, FindPasswordActivity.class);
                break;
            case R.id.btnSureLogin:
                IntentUtil.gotoActivity(this, MainActivity.class);
                break;
            case R.id.tvRegist:
                //IntentUtil.gotoActivityForResult(this, RegisterActivity.class, RESULT_FIRST_USER);
                break;
            case R.id.btnCode:
                phone = edtPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(this, "请输入手机号码");
                    return;
                }
                if (!CommonUtils.isPhoneNum(phone)) {
                    ToastUtil.showToast(this, "请输入正确的手机号码");
                    return;
                }
                //getCode(phone);
                break;
            case R.id.iv_third_qq:
               // umShareAPI.getPlatformInfo(this, SHARE_MEDIA.QQ,authListener);
                break;
            case R.id.iv_third_wechat:
              //  umShareAPI.getPlatformInfo(this, SHARE_MEDIA.WEIXIN,authListener);
                break;
        }
    }
}
