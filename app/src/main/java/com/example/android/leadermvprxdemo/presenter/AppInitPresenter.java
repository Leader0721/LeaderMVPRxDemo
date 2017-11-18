package com.example.android.leadermvprxdemo.presenter;


import com.example.pub.net.core.retrofit.netError.ApiException;


/**
 * description 通用初始化
 * author hanlei
 * version 1.0
 * created at 2016/11/17 18:52
 */
public class AppInitPresenter implements AppInitContract.Presenter {

    private AppInitContract.View view;

    public AppInitPresenter(AppInitContract.View view) {
        this.view = view;
    }

    @Override
    public void onStart(String url) {
        view.start(url);
    }

    @Override
    public void onSuccess(String url, Object t) {

        view.success(url,t);
    }

    @Override
    public void onError(String url, ApiException e) {
        view.error(url,e);
    }

//    @Override
//    public void downloadFile(CustomDownLoadBean downLoadBean) {if (MyApplication.isNetValidation())
//        ApiService.downloadFile(downLoadBean).subscribe(new NetSubscriber<CustomDownLoadBean>(API.FILE_LOAD, this));
//    }
//
//    @Override
//    public void checkOnClass() {
//        if (MyApplication.isNetValidation())
//            ApiService.getAppService().checkOnClass().subscribe(new NetSubscriber<OnClassState>(API.CHECK_ON_CLASS, this));
//    }
//
//    @Override
//    public void setUserNetInfo(String userSid, String userIp) {
//        if (MyApplication.isNetValidation())
//            ApiService.getAppService().setUserNetInfo(userSid, userIp).subscribe(new NetSubscriber<String>(API.SET_USER_NET_INFO, this));
//    }
//
//    @Override
//    public void getAppVersion() {
//        ApiService.getAppService().getAppVersion().subscribe(new NetSubscriber<AppVersion>(API.COMMON_APP_VERSION, this));
//    }
//
//    //    下面进行接口的定义
//    //获取知识点树
//    @Override
//    public void getKnowledgeTree(String code) {
//        if (MyApplication.isNetValidation())
//            ApiService.getAppService().getKnowledgeTree(code).subscribe(new NetSubscriber<List<KnowledgeTreeBean>>(API.KNOWLEDGETREE, this));
//    }
//
//    @Override
//    public void commonRecommend(ParamRecommend recommendResouce) {
//        if (MyApplication.isNetValidation())
//            ApiService.getAppService().commonRecommend(recommendResouce).subscribe(new NetSubscriber<String>(API.RECOMMEND, this));
//    }
//
//    @Override
//    public void getCommonRecommendClass(String resId) {
//        if (MyApplication.isNetValidation())
//            ApiService.getAppService().getCommonRecommendClass(resId).subscribe(new NetSubscriber<List<RecommendClassBean>>(API.RECOMMEND_LIST, this));
//    }

}
