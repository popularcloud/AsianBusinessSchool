package com.nd.abs.ui.module.main.adpter.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DriedGoodViewHolder extends BaseViewHolder{

    @BindView(R.id.rv_teacher)
    RecyclerView rv_teacher;
    @BindView(R.id.rv_student)
    RecyclerView rv_student;

    public DriedGoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindViewHolder(Object data, final Context context) {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_teacher.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManagerStudent = new LinearLayoutManager(context);
        linearLayoutManagerStudent.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_student.setLayoutManager(linearLayoutManagerStudent);

        List<String> datas = new ArrayList<>();
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        RecentCoursesAdapter recentCoursesAdapter = new RecentCoursesAdapter(context,datas,R.layout.item_recycle_img);

        rv_teacher.setAdapter(recentCoursesAdapter);
        rv_student.setAdapter(recentCoursesAdapter);
    }

}
