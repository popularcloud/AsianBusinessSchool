package com.nd.abs.ui.module.login.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nd.abs.R;
import com.nd.abs.base.BaseActivity;
import com.nd.abs.base.BaseModel;
import com.nd.abs.ui.module.login.LoginBean;
import com.nd.abs.ui.module.login.LoginPresenter;
import com.nd.abs.ui.module.login.LoginView;
import com.nd.abs.ui.module.login.RegisterBean;
import com.nd.abs.ui.module.main.activity.MainActivity;
import com.nd.abs.utils.CommonUtils;
import com.nd.abs.utils.IntentUtil;
import com.nd.abs.utils.JsonUtil;
import com.nd.abs.utils.SharedPreferencesUtils;
import com.nd.abs.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

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

    @BindView(R.id.btnSureLogin)
    TextView btnSureLogin;


    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录方式 1密码登录  2账号登录 3.注册
     */
    private int loginType = 1;
    public final int LOGIN_TYPE_BY_PWD = 1;
    public final int LOGIN_TYPE_BY_CODE = 2;
    public final int REGISTER_TYPE_BY_PWD = 3;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {


        ll_code.setVisibility(View.GONE);
        ll_pwd.setVisibility(View.VISIBLE);
        txtFindPassWord.setVisibility(View.VISIBLE);
        setTitle("账号登录");


        String userId = (String) SharedPreferencesUtils.getParam(this,"userId","0");
        if(!"0".equals(userId)){
           IntentUtil.gotoActivity(this, MainActivity.class);
        }

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
                    btnSureLogin.setText("登录");
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
                    btnSureLogin.setText("登录");
                }
                break;
            case R.id.txtFindPassWord:
                //IntentUtil.gotoActivity(this, FindPasswordActivity.class);
                break;
            case R.id.btnSureLogin:
              //  IntentUtil.gotoActivity(this, MainActivity.class);

                if(loginType == REGISTER_TYPE_BY_PWD){ //
                    register(true);
                }else if(loginType == LOGIN_TYPE_BY_PWD){
                    register(false);
                }else if(loginType == LOGIN_TYPE_BY_CODE){
                   ToastUtil.showToast(LoginActivity.this,"请选择密码登陆");
                }


                break;
            case R.id.tvRegist:
                //IntentUtil.gotoActivityForResult(this, RegisterActivity.class, RESULT_FIRST_USER);
                loginType = REGISTER_TYPE_BY_PWD;
                   /* tv_zhdl.setBackgroundResource(R.drawable.button_login_select);
                    tv_dxdl.setBackgroundResource(R.drawable.button_login_select2);
                    tv_zhdl.setTextColor(getResources().getColor(R.color.blue_00aaf5));
                    tv_dxdl.setTextColor(getResources().getColor(R.color.white));*/
                // ll_regist.setVisibility(View.VISIBLE);
                ll_code.setVisibility(View.GONE);
                ll_pwd.setVisibility(View.VISIBLE);
                txtFindPassWord.setVisibility(View.VISIBLE);
                setTitle("注册");
                btnSureLogin.setText("注册");
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

    private void register(Boolean isRegister){
        phone = edtPhone.getText().toString().trim();
        String psd = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showToast(this, "请输入手机号码");
            return;
        }
        if (TextUtils.isEmpty(psd)) {
            ToastUtil.showToast(this, "请输入密码");
            return;
        }

        if(isRegister){
            mPresenter.register(phone,psd);
        }else{
            mPresenter.login(phone,psd);
        }



    }


    @Override
    public void onLoginSuccess(BaseModel<LoginBean> data) {
        if(data != null){
            LoginBean loginBean = data.getData();
            String loginStr = JsonUtil.parserObjectToGson(loginBean);
            SharedPreferencesUtils.setParam(this,"user",loginStr);
            SharedPreferencesUtils.setParam(this,"userId",loginBean.getUserId());

            IntentUtil.gotoActivity(this, MainActivity.class);
        }
    }

    @Override
    public void onRegisterSuccess(BaseModel<Object> data) {
        ToastUtil.showToast(LoginActivity.this,"注册成功！请登陆");

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
        btnSureLogin.setText("登录");
    }

    @Override
    public void onGetDataFail() {

    }
}
