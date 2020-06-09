package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 学生证
 */
public class StudentIdCardActivity extends BaseActivity{


    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    List<LearnPlanBean> datas = new ArrayList<>();
    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_student_id_card;
    }

    @Override
    protected void init() {
        setTitle("学生证");

    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {

    }
}
