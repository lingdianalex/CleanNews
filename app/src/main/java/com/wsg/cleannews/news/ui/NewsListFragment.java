package com.wsg.cleannews.news.ui;

import android.os.Bundle;

import com.wsg.cleannews.R;
import com.wsg.cleannews.base.BaseFragment;
import com.wsg.cleannews.bean.NeteastNewsSummary;
import com.wsg.cleannews.common.DataLoadType;
import com.wsg.cleannews.news.view.INewsListView;

import java.util.List;

/**
 * Created by Wangsg on 16/3/22.
 * Description:  新闻列表
 * UpdateUser:
 * UpdateDate:
 */
public class NewsListFragment extends BaseFragment implements INewsListView {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }


    @Override
    public void updateNewsList(List<NeteastNewsSummary> data, DataLoadType type) {

    }
}
