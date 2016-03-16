package com.wsg.cleannews.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Wangsg on 16/3/16.
 * Description:  activity 基类
 * UpdateUser:
 * UpdateDate:
 */
//TODO 此类需要更多修改 使用mvp模式
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements View.OnClickListener, BaseView {

    /**
     * 将代理类通用行为抽出来
     */
    protected T mPresenter;

    /**
     * 标示该activity是否可滑动退出,默认false
     */
    protected boolean mEnableSlidr;

    /**
     * 布局的id
     */
    protected int mContentViewId;

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

    private Class mClass;

    /**
     * 菜单的id
     */
    private int mMenuId;

    /**
     * Toolbar标题
     */
    private int mToolbarTitle;

    /**
     * 默认选中的菜单项
     */
    private int mMenuDefaultCheckedItem;

    /**
     * Toolbar左侧按钮的样式
     */
    private int mToolbarIndicator;

//    /**
//     * 控制滑动与否的接口
//     */
//    protected SlidrInterface mSlidrInterface;

//    /**
//     * 结束Activity的可观测对象
//     */
//    private Observable<Boolean> mFinishObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        if (getClass().isAnnotationPresent(ActivityFragmentInject.class)) {
//            ActivityFragmentInject annotation = getClass()
//                    .getAnnotation(ActivityFragmentInject.class);
//            mContentViewId = annotation.contentViewId();
//            mEnableSlidr = annotation.enableSlidr();
//            mHasNavigationView = annotation.hasNavigationView();
//            mMenuId = annotation.menuId();
//            mToolbarTitle = annotation.toolbarTitle();
//            mToolbarIndicator = annotation.toolbarIndicator();
//            mMenuDefaultCheckedItem = annotation.menuDefaultCheckedItem();
//        } else {
//            throw new RuntimeException(
//                    "Class must add annotations of ActivityFragmentInitParams.class");
//        }
//
//        if (BuildConfig.DEBUG) {
//            StrictMode.setThreadPolicy(
//                    new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
//            StrictMode.setVmPolicy(
//                    new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
//        }
//
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
//        setContentView(mContentViewId);
//
//        if (mEnableSlidr && !SpUtil.readBoolean("disableSlide")) {
//             默认开启侧滑，默认是整个页码侧滑
//            mSlidrInterface = SlidrUtil
//                    .initSlidrDefaultConfig(this, SpUtil.readBoolean("enableSlideEdge"));
//        }
//
//        initToolbar();
//
//        if (mHasNavigationView) {
//            initNavigationView();
//            initFinishRxBus();
//        }
//
//        initView();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        if (this instanceof SettingsActivity) {
//            SkinManager.getInstance().unregister(this);
//        }
//
//        if (mPresenter != null) {
//            mPresenter.onDestroy();
//        }
//
//        if (mFinishObservable != null) {
//            RxBus.get().unregister("finish", mFinishObservable);
//        }
//
//        ViewUtil.fixInputMethodManagerLeak(this);
    }

//    private void initToolbar() {
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
//    }

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
//
//        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
//        if (mMenuDefaultCheckedItem != -1) mNavigationView.setCheckedItem(mMenuDefaultCheckedItem);
//        mNavigationView.setNavigationItemSelectedListener(
//                new NavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(MenuItem item) {
//                        if (item.isChecked()) return true;
//                        switch (item.getItemId()) {
//                            case R.id.action_news:
//                                mClass = NewsActivity.class;
//                                break;
//                            case R.id.action_video:
//                                mClass = VideoActivity.class;
//                                break;
//                            case R.id.action_photo:
//                                mClass = PhotoActivity.class;
//                                break;
//                            case R.id.action_settings:
//                                mClass = SettingsActivity.class;
//                                break;
//                        }
//                        mDrawerLayout.closeDrawer(Gravity.LEFT);
//                        return false;
//                    }
//                });
//        mNavigationView.post(new Runnable() {
//            @Override
//            public void run() {
//                final ImageView imageView = (ImageView) BaseActivity.this.findViewById(R.id.avatar);
//                Glide.with(mNavigationView.getContext()).load(R.drawable.ic_header).crossFade()
//                        .transform(new GlideCircleTransform(mNavigationView.getContext()))
//                        .into(imageView);
//            }
//        });
//        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                if (mClass != null) {
//                    showActivityReorderToFront(BaseActivity.this, mClass, false);
//                    mClass = null;
//                }
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        });

    }

    /**
     * 订阅结束自己的事件，这里使用来结束导航的Activity
     */
    private void initFinishRxBus() {
//        mFinishObservable = RxBus.get().register("finish", Boolean.class);
//        mFinishObservable.subscribe(new Action1<Boolean>() {
//            @Override
//            public void call(Boolean themeChange) {
//                try {
//                    if (themeChange && !AppManager.getAppManager().getCurrentNavActivity().getName()
//                            .equals(BaseActivity.this.getClass().getName())) {
//                        //  切换皮肤的做法是设置页面通过鸿洋大大的不重启换肤，其他后台导航页面的统统干掉，跳转回去的时候，
//                        //  因为用了FLAG_ACTIVITY_REORDER_TO_FRONT，发现栈中无之前的activity存在了，就重启设置了主题，
//                        // 这样一来就不会所有都做无重启去刷新控件造成的卡顿现象
//                        finish();
//                    } else if (!themeChange) {
//                        // 这个是入口新闻页面退出时发起的通知所有导航页面退出的事件
//                        finish();
//                        KLog.e("结束：" + BaseActivity.this.getClass().getName());
//                    }
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                    KLog.e("找不到此类");
//                }
//            }
//        });
    }

    protected void showSnackbar(String msg) {
//        Snackbar.make(getDecorView(), msg, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackbar(int id) {
//        Snackbar.make(getDecorView(), id, Snackbar.LENGTH_SHORT).show();
    }

    public void showActivityReorderToFront(Activity aty, Class<?> cls, boolean backPress) {

//        AppManager.getAppManager().orderNavActivity(cls.getName(), backPress);
//
//        KLog.e("跳转回去：" + cls.getName());
//
//        Intent intent = new Intent();
//        intent.setClass(aty, cls);
//        // 此标志用于启动一个Activity的时候，若栈中存在此Activity实例，则把它调到栈顶。不创建多一个
//        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//        aty.startActivity(intent);
//        overridePendingTransition(0, 0);
    }

    public void showActivity(Activity aty, Intent it) {
        aty.startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(mMenuId, menu);
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
//            if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
//                // 返回键时未关闭侧栏时关闭侧栏
//                mDrawerLayout.closeDrawer(Gravity.LEFT);
//                return true;
//            } else if (!(this instanceof NewsActivity) && mHasNavigationView) {
//                try {
//                    showActivityReorderToFront(this,
//                            AppManager.getAppManager().getLastNavActivity(), true);
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                    KLog.e("找不到类名啊");
//                }
//                return true;
//            } else if (this instanceof NewsActivity) {
//                // NewsActivity发送通知结束所有导航的Activity
//                RxBus.get().post("finish", false);
//                return true;
//            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {

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
