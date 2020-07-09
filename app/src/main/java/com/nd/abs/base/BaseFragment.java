package com.nd.abs.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nd.abs.utils.ToastUtil;
import com.nd.abs.widget.LoadingDialog;


/**
 * File descripition:   ftagment 基类
 *
 * @author lp
 * @date 2018/6/19
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public View view;
    public Context mContext;
    protected P mPresenter;
    private LoadingDialog loadingDialog;

    protected abstract P createPresenter();

    public void showToast(String str) {
        ToastUtil.showToast(getContext(),str);
    }

    @Override
    public void showError(String msg) {
        ToastUtil.showToast(getContext(),msg);
    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        dissMissDialog();
    }

    public void showLoadingDialog() {
        showLoadingDialog("加载中...");
    }

    /**
     * 加载  黑框...
     */
    public void showLoadingDialog(String msg) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getContext());
            loadingDialog.setCancelable(false);
//            loadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//                @Override
//                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                    if (keyCode == KeyEvent.KEYCODE_SEARCH) {
//                        return true;
//                    } else {
//                        return false; //默认返回 false
//                    }
//                }
//            });
        }
        loadingDialog.setMessage(msg);
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    /**
     * 消失  黑框...
     */
    public void dissMissDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.view = null;
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
