package com.wsg.cleannews.news.view;

import com.wsg.cleannews.base.IBaseView;
import com.wsg.cleannews.bean.NeteastNewsSummary;
import com.wsg.cleannews.common.DataLoadType;

import java.util.List;

/**
 * ClassName: INewsListView<p>
 * Author: oubowu<p>
 * Fuction: 新闻列表视图接口<p>
 * CreateDate: 2016/2/18 14:42<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsListView extends IBaseView {


    void updateNewsList(List<NeteastNewsSummary> data, DataLoadType type);
}
