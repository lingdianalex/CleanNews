package com.wsg.cleannews.callback;

/**
 * Created by Wangsg on 16/3/21.
 * Description: 网络请求回调
 * UpdateUser:
 * UpdateDate:
 */
public interface RequestCallback<T> {

    /**
     * 请求之前调用
     */
    void beforeRequest();

    /**
     * 请求错误调用
     *
     * @param msg 错误信息
     */
    void requestError(String msg);

    /**
     * 请求完成调用
     */
    void requestComplete();

    /**
     * 请求成功调用
     *
     * @param data 数据
     */
    void requestSuccess(T data);
}
