package com.nd.abs.ui.module.main.frament;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.bean.SearchKeyWordBean;
import com.nd.abs.widget.TagsLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnLineMBAFragment extends BaseFragment {

    @BindView(R.id.tl_tags)
    TagsLayout tl_tags;

    List<SearchKeyWordBean> searchKeyWordBeenList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online_mba, null);
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
    public void init() {

        tl_tags.setVisibility(View.VISIBLE);
        tl_tags.removeAllViews();

        searchKeyWordBeenList = new ArrayList<>();
        searchKeyWordBeenList.add(new SearchKeyWordBean("全部520"));
        searchKeyWordBeenList.add(new SearchKeyWordBean("最新课程520"));
        searchKeyWordBeenList.add(new SearchKeyWordBean("EMBA专业课520"));
        searchKeyWordBeenList.add(new SearchKeyWordBean("综合素质课程520"));
        for(int i = 0; i < searchKeyWordBeenList.size();i++) {
            SearchKeyWordBean searchKeyWordBean = searchKeyWordBeenList.get(i);
            final TextView textView = new TextView(getContext());
            textView.setText(searchKeyWordBean.getKeywordName());
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setTextSize(Dimension.SP, 12);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(25, 15, 25, 15);
            textView.setBackgroundResource(R.drawable.round_square_gray_big);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            tl_tags.addView(textView);
        }
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
