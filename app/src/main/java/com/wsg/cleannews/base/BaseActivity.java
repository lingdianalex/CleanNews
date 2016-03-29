package com.wsg.cleannews.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.wsg.cleannews.BuildConfig;
import com.wsg.cleannews.app.ActivityManager;

/**
 * Created by Wangsg on 16/3/16.
 * Description:  activity 基类
 * UpdateUser:
 * UpdateDate:
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {


    /**
     * 标示该activity是否可滑动退出,默认false
     */
    protected boolean mEnableSlidr;

    /**
     * 是否存在NavigationView
     */
    protected boolean mHasNavigationView;

    /**
     * 滑动布局
     */
    protected DrawerLayout mDrawerLayout;
    /**
     * 侧滑导航布局
     */
    protected NavigationView mNavigationView;


    /**
     * Toolbar标题
     */
    private int mToolbarTitle;


    /**
     * Toolbar左侧按钮的样式
     */
    private int mToolbarIndicator;

    protected BaseActivity mContext;

    /**
     * 控制滑动与否的接口
     */
//    protected SlidrInterface mSlidrInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = this;
        ActivityManager.getInstance().pushActivity(this);
        Logger.i("创建");
        setContentView(getLayoutId());

        /**
         * 严苛模式
         */
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(
                    new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }
//        if (this instanceof SettingsActivity) {
//            SkinManager.getInstance().register(this);
//        }
//
//        if (!mEnableSlidr && mHasNavigationView) {
//            setTheme(SpUtil.readBoolean(
//                    "enableNightMode") ? R.style.BaseAppThemeNight_AppTheme : R.style.BaseAppTheme_AppTheme);
//        } else {
//            setTheme(SpUtil.readBoolean(
//                    "enableNightMode") ? R.style.BaseAppThemeNight_SlidrTheme : R.style.BaseAppTheme_SlidrTheme);
//        }
//
//
//        if (mEnableSlidr && !SpUtil.readBoolean("disableSlide")) {
//             默认开启侧滑，默认是整个页码侧滑
//            mSlidrInterface = SlidrUtil
//                    .initSlidrDefaultConfig(this, SpUtil.readBoolean("enableSlideEdge"));
//        }
//
        initToolbar();
        initView();

    }

    /**
     * 设置布局
     */
    protected abstract  int getLayoutId();


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        if (this instanceof SettingsActivity) {
//            SkinManager.getInstance().unregister(this);
//        }

        ActivityManager.getInstance().popActivity(this);
        Logger.i("销毁");
    }

    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            if (mToolbarTitle != -1) setToolbarTitle(mToolbarTitle);
//            if (mToolbarIndicator != -1) {
//                setToolbarIndicator(mToolbarIndicator);
//            } else {
//                setToolbarIndicator(R.drawable.ic_menu_back);
//            }
//        }
    }

    protected void setToolbarIndicator(int resId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(resId);
        }
    }

    protected void setToolbarTitle(String str) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(str);
        }
    }

    protected void setToolbarTitle(int strId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(strId);
        }
    }

    protected ActionBar getToolbar() {
        return getSupportActionBar();
    }

    protected View getDecorView() {
        return getWindow().getDecorView();
    }

    protected abstract void initView();

    private void initNavigationView() {

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            // 为4.4透明状态栏布局延伸到状态栏做适配
//            mDrawerLayout.setFitsSystemWindows(false);
//            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(
//                    R.id.coordinator_layout);
//            if (coordinatorLayout != null) {
//                // CoordinatorLayout设为true才能把布局延伸到状态栏
//                coordinatorLayout.setFitsSystemWindows(true);
//            }
//        }

    }

    protected void showSnackbar(String msg) {
        Snackbar.make(getDecorView(), msg, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackbar(int id) {
        Snackbar.make(getDecorView(), id, Snackbar.LENGTH_SHORT).show();
    }


    public void showActivity(Activity aty, Intent it) {
        aty.startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(mMenuId, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerLayout != null && item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(Gravity.LEFT);
        } else if (item.getItemId() == android.R.id.home && mToolbarIndicator == -1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                // 返回键时未关闭侧栏时关闭侧栏
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * 继承BaseView抽出显示信息通用行为
     *
     * @param msg
     */
    @Override
    public void toast(String msg) {
        showSnackbar(msg);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
