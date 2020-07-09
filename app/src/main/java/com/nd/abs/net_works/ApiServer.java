package com.nd.abs.net_works;


import com.nd.abs.base.BaseModel;
import com.nd.abs.ui.module.login.LoginBean;
import com.nd.abs.ui.module.login.RegisterBean;
import com.nd.abs.ui.module.main.bean.BannerInfo;
import com.nd.abs.ui.module.main.bean.MyClassInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServer {

    //注册
    @POST("backstage/passwordRegisterAppUser")
    @FormUrlEncoded
    Observable<BaseModel<Object>> register(@Field("phone") String phone, @Field("password") String password
    );

    //登陆
    @POST("backstage/passwordLoginAppUser")
    @FormUrlEncoded
    Observable<BaseModel<LoginBean>> login(@Field("phone") String phone, @Field("password") String password
    );


    @POST("backstage/getSlideshow")
    @FormUrlEncoded
    Observable<BaseModel<List<BannerInfo>>> getBanner(@Field("type") String type
    );


    @POST("backstage/getClass")
    @FormUrlEncoded
    Observable<BaseModel<List<MyClassInfo>>> getMyClass(@Field("userId") String type
    );

  /*  //验证码
    @GET("tools/User.ashx")
    Observable<BaseModel<YzMBean>> sendMsg(@Query("action") String action
            , @Query("mobile") String mobile);

    //注册
    @GET("tools/User.ashx")
    Observable<BaseModel<LoginBean>> regist(@Query("action") String action
            , @Query("mobile") String mobile  //手机号
            , @Query("pwd") String pwd  // 密码
            , @Query("tjCode") String tjCode  //推荐码
            , @Query("tjrid") String tjrid  //推挤人id
    );

    //忘记密码
    @GET("tools/User.ashx")
    Observable<BaseModel<ForgetPwdBean>> forgetPwd(@Query("action") String action
            , @Query("mobile") String mobile  //手机号
            , @Query("pwd") String pwd  // 密码
    );

    //个人登陆
    @GET("tools/User.ashx")
    Observable<BaseModel<LoginBean>> login(@Query("action") String action
            , @Query("mobile") String mobile  //手机号
            , @Query("pwd") String pwd  // 密码
            , @Query("tjrid") String tjrid  //推荐人
    );

    //微信登录。是否注册
    @GET("tools/User.ashx")
    Observable<BaseModel<LoginBean>> wxlogin(@Query("action") String action
            , @Query("unionid") String code  //微信uid
            , @Query("uid") String uid  //  //推荐人
    );

    //微信是否注册
    @GET("tools/User.ashx")
    Observable<BaseModel<LoginBean>> wxBdMobile(@Query("action") String action
            , @Query("unionid") String unionid  //手机号
            , @Query("uid") String uid  //  //推荐人
            , @Query("nickname") String nickname  //昵称
            , @Query("sex") String sex  //性别
            , @Query("headimgurl") String headimgurl  //微信头像
            , @Query("mobile") String mobile  //微信头像
    );


    //员工登录  mobile=账号, pwd=密码
    @GET("tools/User.ashx")
    Observable<BaseModel<LoginBean>> yglogin(@Query("action") String action
            , @Query("mobile") String code
            , @Query("pwd") String uid  //
    );


    //编辑个人资料
    @GET("tools/User.ashx")
    Observable<BaseModel<LoginBean>> updateUserInfo(@QueryMap Map<String, String> paramas);*/


}
