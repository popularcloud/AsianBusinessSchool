package com.nd.abs.base;


public interface BaseView {
    /**
     * 显示dialog
     */
    void showLoading();
    /**
     * 隐藏 dialog
     */

    void hideLoading();
    /**
     * 显示错误信息
     * @param msg
     */
    void showError(String msg);
}
