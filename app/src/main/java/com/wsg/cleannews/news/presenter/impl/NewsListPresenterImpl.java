package com.wsg.cleannews.news.presenter.impl;

import com.orhanobut.logger.Logger;
import com.wsg.cleannews.base.BasePresenterImpl;
import com.wsg.cleannews.bean.NeteastNewsSummary;
import com.wsg.cleannews.common.DataLoadType;
import com.wsg.cleannews.news.model.NewsInteractor;
import com.wsg.cleannews.news.presenter.inter.INewsListPresenter;
import com.wsg.cleannews.news.view.INewsListView;

import java.util.List;

/**
 * Created by Wangsg on 16/3/29.
 * Description:
 * UpdateUser:
 * UpdateDate:
 */
public class NewsListPresenterImpl extends BasePresenterImpl<INewsListView,List<NeteastNewsSummary>> implements INewsListPresenter {

    private String mNewsType;
    private String mNewsId;
    private int mStartPage;

    private boolean mIsRefresh = true;
    private boolean mHasInit;

    public NewsListPresenterImpl(INewsListView view, String newsId, String newsType) {
        super(view);
//        mNewsListInteractor = new INewsListInteractorImpl();
        mSubscription = NewsInteractor.requestNewsList(this, newsType, newsId, mStartPage);
        mNewsType = newsType;
        mNewsId = newsId;
    }

    @Override
    public void beforeRequest() {
        if (!mHasInit) {
            mView.showProgress();
        }
    }

    @Override
    public void requestError(String e) {
        super.requestError(e);
        mView.updateNewsList(null,
                mIsRefresh ? DataLoadType.TYPE_REFRESH_FAIL : DataLoadType.TYPE_LOAD_MORE_FAIL);
    }

    @Override
    public void requestSuccess(List<NeteastNewsSummary> data) {
        Logger.e("请求成功");
        mHasInit = true;
        if (data != null) {
            mStartPage += 20;
        }
        mView.updateNewsList(data,
                mIsRefresh ? DataLoadType.TYPE_REFRESH_SUCCESS : DataLoadType.TYPE_LOAD_MORE_SUCCESS);

    }

    @Override
    public void refreshData() {
        mStartPage = 0;
        mIsRefresh = true;
        mSubscription = NewsInteractor.requestNewsList(this, mNewsType, mNewsId, mStartPage);
    }

    @Override
    public void loadMoreData() {
        mIsRefresh = false;
        mSubscription = NewsInteractor.requestNewsList(this, mNewsType, mNewsId, mStartPage);
    }

}
