package com.wsg.cleannews.app;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Wangsg on 16/3/16.
 * Description: 自定义activity管理器
 * UpdateUser:
 * UpdateDate:
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager instance;
    /**
     * TAG
     */
    protected final String TAG = this.getClass().getSimpleName();

    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
/**
 * 此种方案适合单线程,当引入多线程时即线程不安全
 */
//        if (instance == null) {
//            instance = new ActivityManager();
//        }
//        return instance;

        /**
         * 双重锁 解决线程安全问题以及效率问题
         */
        if (instance == null) {
            synchronized (ActivityManager.class) {
                if (instance == null) {
                    instance = new ActivityManager();
                }
            }
        }
        return instance;
    }

    public int getActivitySize() {
        if (activityStack != null && !activityStack.empty()) {
            return activityStack.size();
        }
        return 0;
    }

    /**
     * 退出栈顶Activity
     *
     * @param @param activity
     * @return void
     */
    public void popActivity(Activity activity) {
        if (activity != null) {
            // 在从自定义集合中取出当前Activity时，也进行了Activity的关闭操作
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    /**
     * 获得当前栈顶Activity
     *
     * @param @return
     * @return Activity
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (activityStack != null && !activityStack.empty())
            activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 将当前Activity推入栈中
     *
     * @param @param activity
     * @return void
     */
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 退出栈中class上面的所有Activity。
     *
     * @param @param cls
     * @return void
     */
    public void popAllActivityExceptOne(Class cls) {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
        }
    }

    /**
     * 退出栈中除了包名外的所有Activity，
     *
     * @param @param packageName
     * @return void
     */
    public void popAllActivityExceptPackageName(String packageName) {
        for (Activity activity : activityStack) {
            if (activity != null) {
                String name = activity.getComponentName().getPackageName();
                if (!name.contains(packageName)) {
                    popActivity(activity);
                }
            }
        }
    }

    /**
     * 退出栈中所有Activity
     *
     * @param
     * @return void
     */
    public void popAllActivity() {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            popActivity(activity);
        }
    }
}
