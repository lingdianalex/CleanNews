package com.wsg.cleannews;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.wsg.cleannews.base.BaseActivity;
import com.wsg.cleannews.base.BaseFragment;
import com.wsg.cleannews.news.adapter.NewsAdapter;
import com.wsg.cleannews.news.ui.NewsListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.viewpager)
    ViewPager mviewPager;
    @Bind(R.id.tabs)
    TabLayout mtabLayout;

    NewsAdapter madapter;
    List<BaseFragment> fragments;
    List<String> title;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        initViewPager();

    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(new NewsListFragment());
        fragments.add(new NewsListFragment());
        title = new ArrayList<>();
        title.add("新闻");
        title.add("哈哈");

        madapter = new NewsAdapter(getSupportFragmentManager(), fragments, title);
        mviewPager.setAdapter(madapter);

        mviewPager.setCurrentItem(0, false);
        mtabLayout.setupWithViewPager(mviewPager);
        mtabLayout.setScrollPosition(0, 0, true);
        // 根据Tab的长度动态设置TabLayout的模式
//        ViewUtil.dynamicSetTablayoutMode(mtabLayout);
    }
}

