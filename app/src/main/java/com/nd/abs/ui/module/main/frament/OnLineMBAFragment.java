package com.nd.abs.ui.module.main.frament;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.SeeVideoActivity;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;
import com.nd.abs.ui.module.main.bean.MBAInfo;
import com.nd.abs.ui.module.main.bean.SearchKeyWordBean;
import com.nd.abs.ui.module.online_mba.activity.OnlienMBATypeActivity;
import com.nd.abs.utils.IntentUtil;
import com.nd.abs.widget.TagsLayout;

import org.byteam.superadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnLineMBAFragment extends BaseFragment {

    @BindView(R.id.tl_tags)
    TagsLayout tl_tags;
    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.img_back)
    ImageView img_back;

    List<SearchKeyWordBean> searchKeyWordBeenList;
    private List<MBAInfo> datas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online_mba, null);
        txtActionbarTitle = view.findViewById(R.id.txtActionbarTitle);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        if(getActivity() != null){
        }
    }

    @Override
    protected void lazyLoad() {
        if(getActivity() != null){
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && getActivity() != null){
            ImmersionBar.with(getActivity())
                    .statusBarColor(R.color.white)
                    .statusBarDarkFont(true).init();
        }
    }

    @Override
    public void init() {

        txtActionbarTitle.setText("线上课程");
        tl_tags.setVisibility(View.VISIBLE);
        tl_tags.removeAllViews();
        img_back.setVisibility(View.GONE);

        searchKeyWordBeenList = new ArrayList<>();
        searchKeyWordBeenList.add(new SearchKeyWordBean("全部520"));
        searchKeyWordBeenList.add(new SearchKeyWordBean("最新课程520"));
        searchKeyWordBeenList.add(new SearchKeyWordBean("EMBA专业课520"));
        searchKeyWordBeenList.add(new SearchKeyWordBean("综合素质课程520"));
        for(int i = 0; i < searchKeyWordBeenList.size();i++) {
            SearchKeyWordBean searchKeyWordBean = searchKeyWordBeenList.get(i);
            final TextView textView = new TextView(getContext());
            textView.setText(searchKeyWordBean.getKeywordName());
            if(i == 0){
                textView.setTextColor(Color.parseColor("#d42e2c"));
            }else{
                textView.setTextColor(Color.parseColor("#999999"));
            }

            textView.setTextSize(Dimension.SP, 14);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(25, 15, 25, 15);
            //textView.setBackgroundResource(R.drawable.round_square_gray_big);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    IntentUtil.gotoActivity(getContext(), OnlienMBATypeActivity.class);
                }
            });
            tl_tags.addView(textView);
        }

        initRecycleView();
    }

    private void initRecycleView() {
        rv_data.setLayoutManager(new LinearLayoutManager(getContext()));

        RecentCoursesAdapter recentCoursesAdapter = new RecentCoursesAdapter(getContext(),datas,R.layout.item_new_course);
        rv_data.setAdapter(recentCoursesAdapter);

        recentCoursesAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                IntentUtil.gotoActivity(getActivity(), SeeVideoActivity.class);
            }
        });
    }


    @Override
    public void initEngines(View view) {

    }

    @Override
    public void getIntentData() {

    }

    @Override
    public void setListener() {

    }
}
