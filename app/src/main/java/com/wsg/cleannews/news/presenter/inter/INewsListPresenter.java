package com.wsg.cleannews.news.presenter.inter;

import com.wsg.cleannews.bean.NeteastNewsSummary;

import java.util.List;

/**
 * Created by Wangsg on 16/3/29.
 * Description:
 * UpdateUser:
 * UpdateDate:
 */
public interface INewsListPresenter {

    void onResume();

    void onDestroy();

    void requestSuccess(List<NeteastNewsSummary> data);

    void refreshData();

    void loadMoreData();
}
