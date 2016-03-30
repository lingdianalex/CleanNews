package com.wsg.cleannews.news.presenter.inter;

/**
 * Created by Wangsg on 16/3/29.
 * Description:
 * UpdateUser:
 * UpdateDate:
 */
public interface INewsListPresenter {

    void onResume();

    void onDestroy();

    void refreshData();

    void loadMoreData();
}
