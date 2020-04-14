package com.nd.abs.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast操作工具类
 * 
 */
public class ToastUtil {

	private static Toast toast;

	/**
	 * 显示提示信息
	 * 
	 * @version 1.0
	 * @date 2013-03-19
	 * @param text
	 *        提示内容
	 */
	public static void showToast(Context context, String text) {
		if (toast == null) {
			toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER,0,0);
		} else {
			toast.setText(text);
		}
		toast.show();

	}

	public static void showLongToast(Context context, String text) {
		if (toast == null) {
			toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER,0,0);
		} else {
			toast.setText(text);
		}
		toast.show();

	}

	public static void showNetErr(Context context) {
		if (toast == null) {
			toast = Toast.makeText(context, "网络请求错误,请检查网络是否正常!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER,0,0);
		} else {
			toast.setText("网络请求错误,请检查网络是否正常！");
		}
		toast.show();

	}

	public static void showNetMsg(Context context, String msg) {
		if (toast == null) {
			toast = Toast.makeText(context, "网络请求错误!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER,0,0);
		} else {
			toast.setText("网络请求错误");
		}
		if (msg != null && !msg.equals("")) {
			toast.setText(msg);
		}
		toast.show();
	}
}
