package com.example.pub.net.core.manager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Activity栈控制
 */
public class ActivityManager {
    public static ArrayList<Activity> mActivities = new ArrayList<>();

    public ActivityManager() {
    }

    /**
     * 获取最近的Class
     */
    public static Activity getActivityByClass(Class<?> cl) {
        ArrayList<Activity> tmpActivityList = getActivitysByClass(cl);
        int size = tmpActivityList.size();
        return size > 0 ? tmpActivityList.get(size - 1) : null;
    }

    /**
     * 获取所有Class
     */
    public static ArrayList<Activity> getActivitysByClass(Class<?> cl) {
        ArrayList<Activity> tmpActivityList = new ArrayList<>();
        Iterator<Activity> iterator = mActivities.iterator();
        while (iterator.hasNext()) {
            Activity tmpActivity = iterator.next();
            if (tmpActivity.getClass().equals(cl)) {
                tmpActivityList.add(tmpActivity);
            }
        }
        return tmpActivityList;
    }

    /**
     * 清空所有Activity
     */
    public static void finishAll() {
        ArrayList<Activity> tmpActivitys = new ArrayList<>();
        tmpActivitys.addAll(mActivities);
        Iterator<Activity> iterator = tmpActivitys.iterator();
        while (iterator.hasNext()) {
            iterator.next().finish();
        }
        mActivities.clear();
    }

    /**
     * 添加Activity到ArrayList中
     */
    public static void addActivity(Activity activity) {
        if (!mActivities.contains(activity)) {
            mActivities.add(activity);
        }
    }

    /**
     * 由ArrayList中删除Activity
     */
    public static void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    /**
     * 由ArrayList中删除Activity
     */
    public static void removeActivity(Class<?> cl) {
        ArrayList tempList = new ArrayList();
        tempList.addAll(mActivities);
        Iterator<Activity> iterator = tempList.iterator();

        while (iterator.hasNext()) {
            Activity other = iterator.next();
            if (other.getClass().equals(cl)) {
                other.finish();
                mActivities.remove(other);
            }
        }
    }

    /**
     * 删除其他Activity
     */
    public static void removeOtherActivity(Activity activity) {
        ArrayList tempList = new ArrayList();
        tempList.addAll(mActivities);
        Iterator var3 = tempList.iterator();

        while (var3.hasNext()) {
            Activity other = (Activity) var3.next();
            if (!other.equals(activity)) {
                other.finish();
                mActivities.remove(other);
            }
        }
    }

    /**
     * 获取最后一个Activity
     */
    public static Activity getLastActivity() {
        int size = mActivities == null ? 0 : mActivities.size();
        return size > 0 ? (Activity) mActivities.get(size - 1) : null;
    }

    /**
     * 获取倒数第几个Activity
     * @param index
     * @return
     */
    public static Activity getLastActivity(int index) {
        int size = mActivities == null ? 0 : mActivities.size();
        return size > (index-1) ? (Activity) mActivities.get(size - index) : null;
    }
}
