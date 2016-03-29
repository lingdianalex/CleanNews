package com.wsg.cleannews.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Wangsg on 16/3/29.
 * Description:  添加了滑动到底部自动加载的RecyclerView
 * UpdateUser:
 * UpdateDate:
 */
public class AutoLoadMoreRecyclerView extends RecyclerView {
    public AutoLoadMoreRecyclerView(Context context) {
        super(context);
    }

    public AutoLoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoLoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
