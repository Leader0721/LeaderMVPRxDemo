package com.example.pub.net.core.retrofit.net;

import com.example.pub.bean.BaseBean;
import com.example.pub.net.core.retrofit.netError.ERROR;
import com.example.pub.net.core.retrofit.netError.ExceptionEngine;
import com.example.pub.net.core.retrofit.netError.ServerException;
import com.example.pub.utils.function.LogUtils;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;

/**
 * GitHub: https://github.com/xcc3641
 * Info: 封装 Rx 的一些方法
 */
public class RxUtils {

    public static String retGold = "0"; // 返回的金币奖励
    /**
     * 线程确定（主线程执行）
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 线程确定（IO线程执行）
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper2() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io());
            }
        };
    }

    /**
     * 基本类型转换为所需要的类型，并对Error进行封装
     */
    public static <T> Observable.Transformer<BaseBean<T>, T> transformerHelper() {
        return new Observable.Transformer<BaseBean<T>, T>() {

            @Override
            public Observable<T> call(Observable<BaseBean<T>> baseBeanObservable) {
                return baseBeanObservable.map(new Func1<BaseBean<T>, T>() {
                    @Override
                    public T call(BaseBean<T> baseBean) {

                        if (ERROR.NO_ERROR.equals(baseBean.getRetCode())) {

                            // 如果有金币信息
                            if (baseBean.getRetGold() != null && !baseBean.getRetGold().isEmpty()){
                                RxUtils.retGold = baseBean.getRetGold();
                            }

                            return baseBean.getRetData();
                        }
                        throw new ServerException(baseBean.getRetCode(), baseBean.getRetMsg());
                    }
                }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
                    @Override
                    public Observable<? extends T> call(Throwable throwable) {
                        return Observable.error(ExceptionEngine.handleException(throwable));
                    }
                });
            }
        };
    }

    /**
     * 基本类型转换为所需要的类型，并对Error进行封装
     */
    public static <T> Observable.Transformer<T, T> transformerDownLoadHelper() {
        return new Observable.Transformer<T, T>() {

            @Override
            public Observable<T> call(Observable<T> baseBeanObservable) {
                return baseBeanObservable.map(new Func1<T, T>() {
                    @Override
                    public T call(T baseBean) {
                        return baseBean;
                    }
                }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
                    @Override
                    public Observable<? extends T> call(Throwable throwable) {
                        return Observable.error(ExceptionEngine.handleException(throwable));
                    }
                });
            }
        };
    }

    /**
     * 可自定义线程
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper(final Scheduler scheduler) {
        final Scheduler observableScheduler = scheduler;
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(observableScheduler)
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 自定义处理 Rx 错误线程
     */
    public static void unifiedErrorHandler() {
        RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
            @Override
            public void handleError(Throwable e) {
                LogUtils.e("RxUtils", e.toString());
            }
        });
    }

    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
