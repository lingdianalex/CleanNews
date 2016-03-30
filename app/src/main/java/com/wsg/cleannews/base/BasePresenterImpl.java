package com.wsg.cleannews.base;

import com.orhanobut.logger.Logger;
import com.wsg.cleannews.callback.RequestCallback;
import com.wsg.cleannews.news.view.INewsListView;

import rx.Subscription;

/**
 * Created by Wangsg on 16/3/30.
 * Description:
 * UpdateUser:
 * UpdateDate:
 */
public class BasePresenterImpl<T extends INewsListView, V> implements IBasePresenter, RequestCallback<V> {
    protected Subscription mSubscription;
    protected T mView;

    public BasePresenterImpl(T view) {
        mView = view;
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        mView = null;
    }


    @Override
    public void beforeRequest() {
        mView.showProgress();
    }

    @Override
    public void requestError(String msg) {
        Logger.e(msg);
        mView.toast(msg);
        mView.hideProgress();
    }

    @Override
    public void requestComplete() {
        mView.hideProgress();
    }

    @Override
    public void requestSuccess(V data) {

    }
}
