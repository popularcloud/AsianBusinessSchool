package com.nd.abs.ui.module.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.nd.abs.R;
import com.nd.abs.base.BaseActivity;
import com.nd.abs.base.BaseModel;
import com.nd.abs.ui.module.main.adpter.FollowAdapter;
import com.nd.abs.ui.module.main.adpter.MyCertificateAdapter;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;
import com.nd.abs.ui.module.main.bean.MyCertificateBean;
import com.nd.abs.ui.module.main.present.MyCertificatePresenter;
import com.nd.abs.ui.module.main.view.MyCertificateView;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 我的证书
 */
public class MyCertificateActivity extends BaseActivity<MyCertificatePresenter> implements MyCertificateView {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    List<MyCertificateBean> datas = new ArrayList<>();
    private MyCertificateAdapter followAdapter;

    @Override
    protected MyCertificatePresenter createPresenter() {
        return new MyCertificatePresenter(this);
    }

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_follow;
    }

    @Override
    protected void init() {
        setTitle("我的证书");
        setRight("上传", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * create()方法参数一是上下文，在activity中传activity.this，在fragment中传fragment.this。参数二为请求码，用于结果回调onActivityResult中判断
                 * selectPicture()方法参数分别为 是否裁剪、裁剪后图片的宽(单位px)、裁剪后图片的高、宽比例、高比例。都不传则默认为裁剪，宽200，高200，宽高比例为1：1。
                 */
                PictureSelector
                        .create(MyCertificateActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });

        initRecycleView();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {

        rv_data.setLayoutManager(new LinearLayoutManager(this));
        followAdapter = new MyCertificateAdapter(this,datas,R.layout.item_my_certificate);
        rv_data.setAdapter(followAdapter);

        mPresenter.getCertificate("10010");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);

                Log.d("picAddress",picturePath);
                File file = new File(picturePath);

                RequestBody requestFile =
                        RequestBody.create(MediaType.parse("multipart/form-data"), file);

                MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

                mPresenter.uploadPicToService(part);
            }
        }
    }

    @Override
    public void onGetDateSuccess(BaseModel<Object> data) {

    }

    @Override
    public void onGetMyCertificate(BaseModel<List<MyCertificateBean>> data) {
        if(data != null && data.getData() != null && data.getData().size() > 0){
            datas = data.getData();
            followAdapter.replaceAll(datas);
        }

    }

    @Override
    public void onGetDataFail() {

    }
}
