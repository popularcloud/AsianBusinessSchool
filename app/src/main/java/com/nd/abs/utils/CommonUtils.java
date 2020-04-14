package com.nd.abs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 何栋 on 2017/10/15.
 * 294663966@qq.com
 */
public class CommonUtils {

    /**
     * 判断是否是身份证
     *
     * @param idNum 身份证号码
     * @return 是，true ； 否 ， false
     */
    public static boolean isID(String idNum) {
        // 定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）
        Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
        // 通过Pattern获得Matcher
        Matcher idNumMatcher = idNumPattern.matcher(idNum);
        // 判断用户输入是否为身份证号
        return idNumMatcher.matches();
    }

    public static boolean isPhoneNum(String mobiles) {
        //Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        //修改后的手机号码正则表达式
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9])|(147))\\d{8}$");

        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    /**
     * 判断是否是电子邮箱
     *
     * @return
     */
    public static boolean isEmail(String email) {

        //电子邮件
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();

        return isMatched;
    }


    /**
     * 防止重复点击
     */
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;

    }
}