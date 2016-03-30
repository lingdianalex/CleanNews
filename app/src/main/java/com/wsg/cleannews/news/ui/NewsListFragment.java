package com.wsg.cleannews.news.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.wsg.cleannews.R;
import com.wsg.cleannews.base.BaseFragment;
import com.wsg.cleannews.base.BaseSpacesItemDecoration;
import com.wsg.cleannews.bean.NeteastNewsSummary;
import com.wsg.cleannews.common.DataLoadType;
import com.wsg.cleannews.news.adapter.NewsListRecyclerAdapter;
import com.wsg.cleannews.news.adapter.RecyclerViewHolder;
import com.wsg.cleannews.news.presenter.impl.NewsListPresenterImpl;
import com.wsg.cleannews.news.view.INewsListView;
import com.wsg.cleannews.utils.MeasureUtil;
import com.wsg.cleannews.widget.AutoLoadMoreRecyclerView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Wangsg on 16/3/22.
 * Description:  新闻列表
 * UpdateUser:
 * UpdateDate:
 */
public class NewsListFragment extends BaseFragment implements INewsListView {

    @Bind(R.id.recycler_view)
    AutoLoadMoreRecyclerView mRecyclerView;

    private NewsListRecyclerAdapter<NeteastNewsSummary> mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        mPresenter = new NewsListPresenterImpl(this, "T1348647909107", "headline");


    }

    private void initNewsList(final List<NeteastNewsSummary> data) {
        // mAdapter为空肯定为第一次进入状态
        mAdapter = new NewsListRecyclerAdapter<NeteastNewsSummary>(getActivity(), data) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_news_summary;
            }

            @Override
            public void bindData(RecyclerViewHolder holder, int position, NeteastNewsSummary item) {

//                SkinManager.getInstance().injectSkin(holder.itemView);

//                Glide.with(NewsListFragment.this.getActivity()).load(item.imgsrc).crossFade()
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .placeholder(R.drawable.ic_loading_small_bg).error(R.drawable.ic_fail)
//                        .into(holder.getImageView(R.id.iv_news_summary_photo));
                holder.getTextView(R.id.tv_news_summary_title).setText(item.title);
                holder.getTextView(R.id.tv_news_summary_digest).setText(item.digest);
                holder.getTextView(R.id.tv_news_summary_ptime).setText(item.ptime);
            }
        };


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setAutoLayoutManager(linearLayoutManager).setAutoHasFixedSize(true)
                .addAutoItemDecoration(
                        new BaseSpacesItemDecoration(MeasureUtil.dip2px(getActivity(), 4)))
                .setAutoItemAnimator(new DefaultItemAnimator()).setAutoAdapter(mAdapter);

//        mRecyclerView.setOnLoadMoreListener(new AutoLoadMoreRecyclerView.OnLoadMoreListener() {
//            @Override
//            public void loadMore() {
//                // 状态停止，并且滑动到最后一位
//                mPresenter.loadMoreData();
//                // 显示尾部加载
//                mAdapter.showFooter();
//                mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
//            }
//        });

//        mRefreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefreshing() {
//                mPresenter.refreshData();
//            }
//        });

    }


    @Override
    public void updateNewsList(List<NeteastNewsSummary> data, DataLoadType type) {
        switch (type) {
            case TYPE_REFRESH_SUCCESS:
//                mRefreshLayout.refreshFinish();
                if (mAdapter == null) {
                    initNewsList(data);
                } else {
                    mAdapter.setData(data);
                }
                if (mRecyclerView.isAllLoaded()) {
//                     之前全部加载完了的话，这里把状态改回来供底部加载用
                    mRecyclerView.notifyMoreLoaded();
                }
                break;
            case TYPE_REFRESH_FAIL:
//                mRefreshLayout.refreshFinish();
                break;
            case TYPE_LOAD_MORE_SUCCESS:
                // 隐藏尾部加载
                mAdapter.hideFooter();
                if (data == null || data.size() == 0) {
                    mRecyclerView.notifyAllLoaded();
                    toast("全部加载完毕噜(☆＿☆)");
                } else {
                    mAdapter.addMoreData(data);
                    mRecyclerView.notifyMoreLoaded();
                }
                break;
            case TYPE_LOAD_MORE_FAIL:
                mAdapter.hideFooter();
                mRecyclerView.notifyMoreLoaded();
                break;
        }
    }
}
