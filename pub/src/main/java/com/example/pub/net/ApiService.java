package com.example.pub.net;

/**
 * description 执行接口请求数据的类
 * author hanlei
 * version 1.0
 * created at 2016/11/14 10:27
 */
public class ApiService extends ApiSign {

//    private static ApiInterface appInterface;
//    public static ApiService appService;
//
//    public static ApiService getAppService() {
//        if (appService == null) {
//            synchronized (ApiService.class) {
//                if (appService == null) {
//                    appService = new ApiService();
//                    appInterface = new RetrofitSingleton(API.HOST, MyApplication.getInstance()).getRetrofit().create(ApiInterface.class);
//                }
//            }
//        }
//        return appService;
//    }
//
//
//    public Observable<String> getGrade() {
//        return appInterface.getGrade(MyApplication.getUUID()).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    // 备课 start
//
//    public Observable<String> commonRecommend(ParamRecommend recommendResouce) {
//        return appInterface.commonRecommend(recommendResouce).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    public Observable<List<RecommendClassBean>> getCommonRecommendClass(String resId) {
//        return appInterface.getCommonRecommendClass(MyApplication.getUUID(), resId).compose(RxUtils.<List<RecommendClassBean>>transformerHelper()).compose(RxUtils.<List<RecommendClassBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 在线预览接口(参数为resFileId)
//     *
//     * @param resFileId
//     * @return
//     */
//    public Observable<OnlineDoc> onlineViewByFile(String resFileId) {
//        initSignHeader(API.ONLINE_VIEW_BY_FILE);
//        return appInterface.onlineViewByFile(resFileId, "11400").compose(RxUtils.<OnlineDoc>transformerHelper()).compose(RxUtils.<OnlineDoc>rxSchedulerHelper());
//    }
//
//    /**
//     * 在线预览接口
//     *
//     * @param resourseId
//     * @return
//     */
//    public Observable<OnlineDoc> onlineViewName(String resourseId) {
//        initSignHeader(API.ONLINE_VIEW_NAME);
//        return appInterface.onlineViewName(resourseId, "11400").compose(RxUtils.<OnlineDoc>transformerHelper()).compose(RxUtils.<OnlineDoc>rxSchedulerHelper());
//    }
//
//    /**
//     * 加入课堂
//     *
//     * @param courseResourseReq
//     * @return
//     */
//    public Observable<String> addCourseResourse(LessonItem courseResourseReq) {
//        return appInterface.addCourseResourse(courseResourseReq).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 课程资源列表的排序
//     *
//     * @param paramResourseSort
//     * @return
//     */
//    public Observable<String> setCourseResourseSort(ParamResourseSort paramResourseSort) {
//        return appInterface.setCourseResourseSort(paramResourseSort).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 设置用户网络信息
//     *
//     * @param userSid
//     * @param userIp
//     * @return
//     */
//    public Observable<String> setUserNetInfo(String userSid, String userIp) {
//        return appInterface.setUserNetInfo(MyApplication.getUUID(), userSid, userIp).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 是否在上课
//     *
//     * @return
//     */
//    public Observable<OnClassState> checkOnClass() {
//        return appInterface.checkOnClass(MyApplication.getUUID()).compose(RxUtils.<OnClassState>transformerHelper()).compose(RxUtils.<OnClassState>rxSchedulerHelper());
//    }
//
//    /**
//     * 推送试题
//     *
//     * @param classId
//     * @param paperId
//     * @param paperType
//     * @param courseResourseId
//     * @param lessionLogId
//     * @return
//     */
//    public Observable<String> pushHomeWork(String classId, String paperId, String paperType, String courseResourseId, String lessionLogId) {
//        return appInterface.pushHomeWork(MyApplication.getUUID(), classId, paperId, paperType, courseResourseId, lessionLogId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师推送自己上传的资源
//     *
//     * @param classId
//     * @param resFileId
//     * @param resourseType
//     * @param courseResourseId
//     * @param lessionLogId
//     * @return
//     */
//    public Observable<String> pushResSelf(String classId, String resFileId, String resourseType, String courseResourseId, String lessionLogId) {
//        return appInterface.pushResSelf(MyApplication.getUUID(), classId, resFileId, resourseType, courseResourseId, lessionLogId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师推送素材
//     *
//     * @param classId
//     * @param resourseId
//     * @param resourseType
//     * @param courseResourseId
//     * @param lessionLogId
//     * @return
//     */
//    public Observable<String> pushRes(String classId, String resourseId, String resourseType, String courseResourseId, String lessionLogId) {
//        return appInterface.pushRes(MyApplication.getUUID(), classId, resourseId, resourseType, courseResourseId, lessionLogId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师开始上课
//     *
//     * @param classId
//     * @param courseId
//     * @param knowledgeId
//     * @return
//     */
//    public Observable<String> startClass(String classId, String courseId, String knowledgeId) {
//        return appInterface.startClass(MyApplication.getUUID(), classId, courseId, knowledgeId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 随堂练习提交的咋样
//     *
//     * @param paperAssignId
//     * @return
//     */
//    public Observable<PracticeCount> getPracticeCount(String paperAssignId) {
//        return appInterface.getPracticeCount(MyApplication.getUUID(), paperAssignId).compose(RxUtils.<PracticeCount>transformerHelper()).compose(RxUtils.<PracticeCount>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得在线人数列表
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<OnLineStudentListBean> getOnlineStudents(String classId) {
//        return appInterface.getOnlineStudents(MyApplication.getUUID(), classId).compose(RxUtils.<OnLineStudentListBean>transformerHelper()).compose(RxUtils.<OnLineStudentListBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 随堂练习客观题提交情况
//     *
//     * @param paperAssignId
//     * @param questionId
//     * @param questionType
//     * @return
//     */
//    public Observable<PQuestionDetail> getQuestionDetail(String paperAssignId, String questionId, String questionType) {
//        return appInterface.getQuestionDetail(MyApplication.getUUID(), paperAssignId, questionId, questionType).compose(RxUtils.<PQuestionDetail>transformerHelper()).compose(RxUtils.<PQuestionDetail>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师结束练习
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> stopPractice(String classId, String paperAssignId, String lessionLogId) {
//        return appInterface.stopPractice(MyApplication.getUUID(), classId, paperAssignId, lessionLogId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 结束互批
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> stopEOCorrect(String classId, String paperAssignId, String lessionLogId) {
//        return appInterface.stopEOCorrect(MyApplication.getUUID(), classId, paperAssignId, lessionLogId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师互批作业
//     *
//     * @param classId
//     * @param paperAssignId
//     * @return
//     */
//    public Observable<String> echoOtherCorrect(String classId, String paperAssignId, String lessionLogId) {
//        return appInterface.echoOtherCorrect(MyApplication.getUUID(), classId, paperAssignId, lessionLogId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师开始上课
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> endClass(String classId) {
//        return appInterface.endClass(MyApplication.getUUID(), classId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师锁屏
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> closeScreen(String classId) {
//        return appInterface.closeScreen(MyApplication.getUUID(), classId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 教师解锁
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> openScreen(String classId) {
//        return appInterface.openScreen(MyApplication.getUUID(), classId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 随堂练习
//     *
//     * @param konwledgeIds
//     * @param categoryId
//     * @return
//     */
//    public Observable<List<ResourceBean>> getPractices(String konwledgeIds, String categoryId) {
//        return appInterface.getPractices(MyApplication.getUUID(), konwledgeIds, categoryId).compose(RxUtils.<List<ResourceBean>>transformerHelper()).compose(RxUtils.<List<ResourceBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得某个目录下的所有素材资源
//     *
//     * @param konwledgeIds
//     * @param categoryId
//     * @return
//     */
//    public Observable<List<ResourceBean>> getMaterials(String konwledgeIds, String categoryId) {
//        return appInterface.getMaterials(MyApplication.getUUID(), konwledgeIds, categoryId).compose(RxUtils.<List<ResourceBean>>transformerHelper()).compose(RxUtils.<List<ResourceBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得某个目录下的所有视频资源
//     *
//     * @param konwledgeIds
//     * @param categoryId
//     * @return
//     */
//    public Observable<List<ResourceBean>> getVideos(String konwledgeIds, String categoryId) {
//        return appInterface.getVideos(MyApplication.getUUID(), konwledgeIds, categoryId).compose(RxUtils.<List<ResourceBean>>transformerHelper()).compose(RxUtils.<List<ResourceBean>>rxSchedulerHelper());
//    }
//
//    public Observable<ResourceDetailBean> getSrcImage(String resId) {
//        return appInterface.getSrcImage(MyApplication.getUUID(), resId).compose(RxUtils.<ResourceDetailBean>transformerHelper()).compose(RxUtils.<ResourceDetailBean>rxSchedulerHelper());
//    }
//
//    public Observable<ResourceDetailBean> getSrcAudio(String resId) {
//        return appInterface.getSrcAudio(MyApplication.getUUID(), resId).compose(RxUtils.<ResourceDetailBean>transformerHelper()).compose(RxUtils.<ResourceDetailBean>rxSchedulerHelper());
//    }
//
//    public Observable<ResourceDetailBean> getENAudio(String resId) {
//        return appInterface.getENAudio(MyApplication.getUUID(), resId).compose(RxUtils.<ResourceDetailBean>transformerHelper()).compose(RxUtils.<ResourceDetailBean>rxSchedulerHelper());
//    }
//
//    public Observable<ResourceDetailBean> getCHAudio(String categoryId, String knowledgeId) {
//        return appInterface.getCHAudio(MyApplication.getUUID(), categoryId, knowledgeId).compose(RxUtils.<ResourceDetailBean>transformerHelper()).compose(RxUtils.<ResourceDetailBean>rxSchedulerHelper());
//    }
//
//
//    /**
//     * 通过视频的资源ID获取视频播放的相关信息
//     *
//     * @param resId
//     * @return
//     */
//    public Observable<ResourceDetailBean> getVideoInfo(String resId) {
//        return appInterface.getVideoInfo(MyApplication.getUUID(), resId).compose(RxUtils.<ResourceDetailBean>transformerHelper()).compose(RxUtils.<ResourceDetailBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 英语音频
//     *
//     * @param knowledgeList
//     * @param categoryId
//     * @return
//     */
//    public Observable<List<ResourceBean>> getEnAudios(String knowledgeList, String categoryId) {
//        return appInterface.getEnAudios(MyApplication.getUUID(), knowledgeList, categoryId).compose(RxUtils.<List<ResourceBean>>transformerHelper()).compose(RxUtils.<List<ResourceBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得某个目录下的所有课件资源
//     *
//     * @param konwledgeIds
//     * @param categoryId
//     * @return
//     */
//    public Observable<List<ResourceBean>> getCoureware(String konwledgeIds, String categoryId) {
//        return appInterface.getCoureware(MyApplication.getUUID(), konwledgeIds, categoryId).compose(RxUtils.<List<ResourceBean>>transformerHelper()).compose(RxUtils.<List<ResourceBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得目录下面的所有课程
//     *
//     * @param menuCode
//     * @return
//     */
//    public Observable<List<ResourceType>> getResourseTypes(String menuCode) {
//        return appInterface.getResourseTypes(MyApplication.getUUID(), menuCode).compose(RxUtils.<List<ResourceType>>transformerHelper()).compose(RxUtils.<List<ResourceType>>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据课程获得对应的章节知识点
//     *
//     * @param code
//     * @param knowledgeId
//     * @return
//     */
//    public Observable<List<SimpleTreeBean>> getKnowledgeById(String code, String knowledgeId) {
//        return appInterface.getKnowledgeById(MyApplication.getUUID(), code, knowledgeId).compose(RxUtils.<List<SimpleTreeBean>>transformerHelper()).compose(RxUtils.<List<SimpleTreeBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 学生端 获取英语单词数据
//     *
//     * @param resIdList
//     * @return
//     */
//    public Observable<List<WordDetail>> enWordDetail(String resIdList) {
//        return appInterface.enWordDetail(MyApplication.getUUID(), resIdList).compose(RxUtils.<List<WordDetail>>transformerHelper()).compose(RxUtils.<List<WordDetail>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得目录下面的所有课程
//     *
//     * @param knowledgeId
//     * @return
//     */
//    public Observable<List<CourseBean>> getCourseList(String knowledgeId) {
//        return appInterface.getCourseList(MyApplication.getUUID(), knowledgeId).compose(RxUtils.<List<CourseBean>>transformerHelper()).compose(RxUtils.<List<CourseBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 添加课程
//     *
//     * @param addCourseBeanList
//     * @return
//     */
//    public Observable<String> addCourseList(List<AddCourseBean> addCourseBeanList) {
//        return appInterface.addCourseList(addCourseBeanList).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 删除课程
//     *
//     * @param courseId
//     * @return
//     */
//    public Observable<String> delCourse(String courseId) {
//        return appInterface.delCourse(MyApplication.getUUID(), courseId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 上传视频
//     *
//     * @param courseId
//     * @param fileName
//     * @param knowledgeId
//     * @param fileType
//     * @param
//     * @param service
//     * @param
//     * @param
//     * @return
//     */
//    public Observable<String> uploadVideo(String courseId, String fileName, String knowledgeId, String fileType, String service) {
//        return appInterface.uploadVideo(MyApplication.getUUID(), courseId, fileName, knowledgeId, fileType, service).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 获得回调url
//     */
//
//    public Observable<String> getUrl() {
//        return appInterface.getUrl(MyApplication.getUUID(), headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 推送图片
//     *
//     * @param filePath
//     * @param classId
//     * @param lessionLogId
//     * @return
//     */
//    public Observable<String> pushPicture(String filePath, String classId, String lessionLogId) {
//
//        File file = new File(filePath);
//
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
//
//        RequestBody uuidBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), MyApplication.getUUID());
//        RequestBody classIdBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), classId);
//        RequestBody lessionLogIdBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), lessionLogId);
//
//        HashMap<String, RequestBody> map = new HashMap<>();
//        map.put("uuid", uuidBody);
//        map.put("classId", classIdBody);
//        map.put("lessionLogId", lessionLogIdBody);
//
//        return appInterface.pushPicture(map, filePart).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 上传视频
//     *
//     * @param filePath
//     * @param courseId
//     * @param knowledgeId
//     * @param fileType
//     * @return
//     */
//    public Observable<String> uploadFile(String filePath, String courseId, String knowledgeId, String fileType) {
//
//        File file = new File(filePath);
//
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
//
//        RequestBody uuidBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), MyApplication.getUUID());
//        RequestBody courseIdBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), courseId);
//        RequestBody knowledgeIdBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), knowledgeId);
//        RequestBody fileTypeBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), fileType);
//
//        HashMap<String, RequestBody> map = new HashMap<>();
//        map.put("uuid", uuidBody);
//        map.put("courseId", courseIdBody);
//        map.put("knowledgeId", knowledgeIdBody);
//        map.put("fileType", fileTypeBody);
//
//        return appInterface.uploadFile(map, filePart).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 添加课程
//     *
//     * @param addCourseBeanList
//     * @return
//     */
//    public Observable<String> updateCourseList(List<AddCourseBean> addCourseBeanList) {
//        return appInterface.updateCourseList(addCourseBeanList).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 课对应的资源列表
//     *
//     * @param courseId
//     * @return
//     */
//    public Observable<List<LessonItem>> getOnlineResourse(String courseId, String classId, String lessionLogId) {
//        return appInterface.getOnlineResourse(MyApplication.getUUID(), courseId, classId, lessionLogId).compose(RxUtils.<List<LessonItem>>transformerHelper()).compose(RxUtils.<List<LessonItem>>rxSchedulerHelper());
//    }
//
//    /**
//     * 课程对应的资源列表 1
//     *
//     * @param knowledgeId
//     * @param courseId
//     * @return
//     */
//    public Observable<List<LessonItem>> getCourseResourse(String knowledgeId, String courseId) {
//        return appInterface.getCourseResourse(MyApplication.getUUID(), knowledgeId, courseId).compose(RxUtils.<List<LessonItem>>transformerHelper()).compose(RxUtils.<List<LessonItem>>rxSchedulerHelper());
//    }
//
//    // 备课 end
//
//    /**
//     * APP获取版本  1老师 2学生 3家长 4 教师pad ，5 学生pad
//     *
//     * @return
//     */
//    public Observable<AppVersion> getAppVersion() {
//        return appInterface.getAppVersion("4", headerMap).compose(RxUtils.<AppVersion>transformerHelper()).compose(RxUtils.<AppVersion>rxSchedulerHelper());
//    }
//
//    /**
//     * 用户登录
//     * 用户类型，1老师 2学生 3家长
//     *
//     * @return
//     */
//    public Observable<List<LoginBean>> userLogin(String mobile, String password) {
//        initSignHeader(API.USER_LOGIN);
//
//        String id = JPushInterface.getRegistrationID(MyApplication.getInstance());
//        LogUtils.e("getRegistrationID", "id:" + id);
//        return appInterface.userLogin(id, mobile, password, MyApplication.getUUID(), "1111", "1", headerMap).compose(RxUtils.<List<LoginBean>>transformerHelper()).compose(RxUtils.<List<LoginBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 重置密码-获取验证码
//     *
//     * @param mobile
//     * @return
//     */
//    public Observable<String> resetPasswordMessage(String mobile) {
//        return appInterface.resetPasswordMessage(mobile, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 校验验证码是否正确
//     *
//     * @param mobile     手机号
//     * @param smsCaptcha 验证码
//     * @return
//     */
//    public Observable<String> checkSms(String mobile, String smsCaptcha) {
//        initSignHeader(API.CHECK_SMS);
//        return appInterface.checkSms(mobile, smsCaptcha, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 重置密码
//     *
//     * @param mobile
//     * @param smsCaptcha
//     * @param password
//     * @return
//     */
//    public Observable<String> resetPassword(String mobile, String smsCaptcha, String password) {
//        return appInterface.resetPassword(mobile, smsCaptcha, password, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取教师个人基本资料
//     *
//     * @return
//     */
//    public Observable<TeacherBaseInfo> getBaseInfo() {
//        initSignHeader(API.CENTER_BASEINFO);
//        return appInterface.getBaseInfo(MyApplication.getUUID(), headerMap).compose(RxUtils.<TeacherBaseInfo>transformerHelper()).compose(RxUtils.<TeacherBaseInfo>rxSchedulerHelper());
//    }
//
//    /**
//     * 更换头像
//     *
//     * @param imgPath
//     * @return
//     */
//    public Observable<String> changePortrait(String imgPath) {
//
//        initSignHeader(API.CHANGE_PORTRAIT);
//
//        File file = new File(imgPath);
//
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
//
//        RequestBody uuidBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), MyApplication.getUUID());
//        RequestBody userTypeBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), "1");
//
//        HashMap<String, RequestBody> map = new HashMap<>();
//        map.put("uuid", uuidBody);
//        map.put("userType", userTypeBody);
//
//        return appInterface.changePortrait(map, filePart, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 修改密码
//     *
//     * @param oldpwd
//     * @param password
//     * @return
//     */
//    public Observable<String> updatePsd(String oldpwd, String password) {
//        initSignHeader(API.UPDATE_PASSWORD);
//        return appInterface.updatePsd(MyApplication.getUUID(), oldpwd, password, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 绑定手机号发送验证码
//     *
//     * @param mobile
//     * @return
//     */
//    public Observable<String> bindPhoneNumSms(String mobile) {
//        return appInterface.bindPhoneNumSms(MyApplication.getUUID(), mobile, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 绑定手机号
//     *
//     * @param mobile
//     * @param smsCaptcha
//     * @return
//     */
//    public Observable<String> bindPhoneNum(String mobile, String smsCaptcha) {
//        return appInterface.bindPhoneNum(MyApplication.getUUID(), mobile, smsCaptcha, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 修改手机号发送验证码
//     *
//     * @param password
//     * @param mobile
//     * @return
//     */
//    public Observable<String> changePhoneNumSms(String password, String mobile) {
//        return appInterface.changePhoneNumSms(MyApplication.getUUID(), password, mobile, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 更换手机号
//     *
//     * @param mobile
//     * @param smsCaptcha
//     * @return
//     */
//    public Observable<String> changePhoneNum(String mobile, String password, String smsCaptcha) {
//        return appInterface.changePhoneNum(MyApplication.getUUID(), mobile, password, smsCaptcha, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取出版社列表
//     */
//    public Observable<List<PressBean>> getPress() {
//        initSignHeader(API.GET_PRESS);
//        return appInterface.getPress(MyApplication.getUUID(), headerMap).compose(RxUtils.<List<PressBean>>transformerHelper()).compose(RxUtils.<List<PressBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取教材
//     *
//     * @param subjectId
//     * @param pressId
//     * @return
//     */
//    public Observable<List<MaterialBean>> getMaterial(String subjectId, String pressId) {
//        initSignHeader(API.GET_MATERIAL);
//        return appInterface.getMaterial(subjectId, pressId, headerMap).compose(RxUtils.<List<MaterialBean>>transformerHelper()).compose(RxUtils.<List<MaterialBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 修改教材
//     *
//     * @param materialId
//     * @return
//     */
//    public Observable<String> updateMaterial(String materialId) {
//        return appInterface.updateMaterial(MyApplication.getUUID(), materialId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 系统消息列表
//     *
//     * @return
//     */
//    public Observable<SystemMessageBean> getSystemMessage(String pageIndex, String pageSize) {
//        initSignHeader(API.GET_SYSTEM_MESSAGE);
//        return appInterface.getSystemMessage(MyApplication.getUUID(), pageIndex, pageSize, headerMap).compose(RxUtils.<SystemMessageBean>transformerHelper()).compose(RxUtils.<SystemMessageBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 系统消息操作
//     *
//     * @return
//     */
//    public Observable<String> setSystemMessage(String userMessageId) {
//        return appInterface.setSystemMessage(userMessageId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 申请消息列表
//     *
//     * @return
//     */
//    public Observable<ApplyMessageBean> getApplyMessage(String pageIndex, String pageSize) {
//        initSignHeader(API.GET_APPLY_MESSAGE);
//        return appInterface.getApplyMessage(MyApplication.getUUID(), pageIndex, pageSize, headerMap).compose(RxUtils.<ApplyMessageBean>transformerHelper()).compose(RxUtils.<ApplyMessageBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 申请消息操作同意
//     *
//     * @return
//     */
//    public Observable<String> setApplyYes(String userType, String userMessageId, String senderId) {
//        return appInterface.setApplyYes(MyApplication.getUUID(), userType, userMessageId, senderId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 申请消息操作拒绝
//     *
//     * @return
//     */
//    public Observable<String> setApplyNo(String userType, String userMessageId, String senderId) {
//        return appInterface.setApplyNo(MyApplication.getUUID(), userType, userMessageId, senderId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 申请消息操作删除
//     *
//     * @return
//     */
//    public Observable<String> setApplyDel(String userType, String userMessageId, String senderId) {
//        return appInterface.setApplyDel(MyApplication.getUUID(), userType, userMessageId, senderId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 系统消息未读数量
//     *
//     * @return
//     */
//    public Observable<String> getSysUnreadCount() {
//        return appInterface.getSysUnreadCount(MyApplication.getUUID(), headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 申请消息未读数量
//     *
//     * @return
//     */
//    public Observable<String> getApplyUnreadCount() {
//        return appInterface.getApplyUnreadCount(MyApplication.getUUID(), headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 消息未操作条数
//     *
//     * @return
//     */
//    public Observable<String> getMessageNum() {
//        return appInterface.getMessageNum(MyApplication.getUUID(), headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 保存用户意见
//     *
//     * @param paraSuggestionBean
//     * @return
//     */
//    public Observable<String> suggestion(ParaSuggestionBean paraSuggestionBean) {
//        initSignHeader(API.SUGGESTION);
//
//        return appInterface.suggestion(paraSuggestionBean, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//    // 用户账户个人中心接口 end
//
//    // 拓展提升的接口   start
//
//    /**
//     * 栏目文章
//     *
//     * @param articleId
//     * @return
//     */
//    public Observable<List<RecommendClassBean>> getRecommendClass(String articleId) {
//        initSignHeader(API.ARTCLE_RECOM_CLASS);
//        return appInterface.getRecommendClass(MyApplication.getUUID(), articleId, headerMap).compose(RxUtils.<List<RecommendClassBean>>transformerHelper()).compose(RxUtils.<List<RecommendClassBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 资源推荐
//     *
//     * @return
//     */
//    public Observable<String> recommend2Class(String classIds, String articleId, String requireMent) {
//        initSignHeader(API.COMMON_RECOMMEND2CLS);
//        return appInterface.recommend2Class(classIds, MyApplication.getUUID(), articleId, requireMent, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    // 拓展提升的接口   end
//
//    // 班级管理的接口   start
//
//    /**
//     * 搜索班级
//     *
//     * @param classCode
//     * @return
//     */
//    public Observable<SearchClassBean> classSearch(String classCode) {
//        initSignHeader(API.CLASS_SEARCH);
//        return appInterface.classSearch(MyApplication.getUUID(), classCode, headerMap).compose(RxUtils.<SearchClassBean>transformerHelper()).compose(RxUtils.<SearchClassBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据提供的班级ID加入班级
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> classJoin(String classId) {
//        initSignHeader(API.CLASS_JOIN);
//        return appInterface.classJoin(MyApplication.getUUID(), classId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取已经创建的班级
//     *
//     * @return
//     */
//    public Observable<List<CreateClassBean>> createdClassList() {
//        initSignHeader(API.CREATEDCLASS_LIST);
//        return appInterface.createdClassList(MyApplication.getUUID(), headerMap).compose(RxUtils.<List<CreateClassBean>>transformerHelper()).compose(RxUtils.<List<CreateClassBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 还能创建几个班级
//     *
//     * @return
//     */
//    public Observable<Integer> classleftNumber() {
//        initSignHeader(API.CLASS_LEFT_NUMBER);
//        return appInterface.classleftNumber(MyApplication.getUUID(), headerMap).compose(RxUtils.<Integer>transformerHelper()).compose(RxUtils.<Integer>rxSchedulerHelper());
//    }
//
//    /**
//     * 创建班级
//     *
//     * @param paramCreateClass
//     * @return
//     */
//    public Observable<String> classCreate(ParamCreateClass paramCreateClass) {
//        initSignHeader(API.CLASS_CREATE);
//        return appInterface.classCreate(headerMap, paramCreateClass).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取班级列表
//     *
//     * @return
//     */
//    public Observable<List<ClassBean>> getClassList() {
//        initSignHeader(API.CLASS_LIST);
//        return appInterface.getClassList(MyApplication.getUUID(), headerMap).compose(RxUtils.<List<ClassBean>>transformerHelper()).compose(RxUtils.<List<ClassBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据提供的班级ID获取班级信息
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<ClassInfoBean> getClassInfo(String classId) {
//        initSignHeader(API.CLASS_DETAIL);
//        return appInterface.getClassInfo(MyApplication.getUUID(), classId, headerMap).compose(RxUtils.<ClassInfoBean>transformerHelper()).compose(RxUtils.<ClassInfoBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 删除班级成员接口
//     *
//     * @param deleteClassMemberBean
//     * @return
//     */
//    public Observable<String> deleteClassMember(DeleteClassMemberBean deleteClassMemberBean) {
//        initSignHeader(API.DELETE_CLASSMEMBER);
//        return appInterface.deleteClassMember(deleteClassMemberBean, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 设置某个老师为班主任
//     *
//     * @param classId
//     * @param teacherId
//     * @return
//     */
//    public Observable<String> teacherSet(String classId, String teacherId) {
//        initSignHeader(API.CLASS_TEACHER_SET);
//        return appInterface.teacherSet(MyApplication.getUUID(), classId, teacherId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 老师解散班级
//     *
//     * @param classId
//     * @param password
//     * @return
//     */
//    public Observable<String> teacherDissolve(String classId, String password) {
//        initSignHeader(API.CLASS_TEACHER_DISSOLVE);
//        return appInterface.teacherDissolve(MyApplication.getUUID(), classId, password, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 老师解散小组
//     *
//     * @param groupId
//     * @return
//     */
//    public Observable<String> teacherDissolveGroup(String groupId) {
//        initSignHeader(API.DISSOLVE_GROUP);
//        return appInterface.dissolveGroup(MyApplication.getUUID(), groupId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 更新小组界面
//     *
//     * @param updateGroupBean
//     * @return
//     */
//    public Observable<String> updateGroup(UpdateGroupBean updateGroupBean) {
//        initSignHeader(API.UPDATEGROUP);
//        return appInterface.updateGroup(updateGroupBean, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 创建小组界面
//     *
//     * @param createGroupBean
//     * @return
//     */
//    public Observable<String> createGroup(CreateGroupBean createGroupBean) {
//        initSignHeader(API.CREATE_GROUP);
//        return appInterface.createGroup(createGroupBean, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//
//    /**
//     * 是否可以引用班主任的小组
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<List<ClassInfoBean.StudentGroupResListBean>> checkHeader(String classId) {
//        initSignHeader(API.CHECKHEADER);
//        return appInterface.checkHeader(MyApplication.getUUID(), classId, headerMap).compose(RxUtils.<List<ClassInfoBean.StudentGroupResListBean>>transformerHelper()).compose(RxUtils.<List<ClassInfoBean.StudentGroupResListBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 引用班主任的小组
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> userHeader(String classId) {
//        initSignHeader(API.USEHEADER);
//        return appInterface.useHeader(MyApplication.getUUID(), classId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 老师退出班级
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<String> exitClass(String classId) {
//        initSignHeader(API.EXITCLASS);
//        return appInterface.exitClass(MyApplication.getUUID(), classId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据提供的班级Id获取所有的学生信息
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<List<StudentInfoBean>> getStudentInfo(String classId) {
//        initSignHeader(API.GETSTUDENTINFO);
//        return appInterface.getStudentInfo(MyApplication.getUUID(), classId, headerMap).compose(RxUtils.<List<StudentInfoBean>>transformerHelper()).compose(RxUtils.<List<StudentInfoBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据提供的班级Id获取所有的测试列表
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<List<TestListBean>> getTestList(String classId, String teacherId) {
//        initSignHeader(API.REPORTTEST);
//        return appInterface.getTestList(classId, teacherId, headerMap).compose(RxUtils.<List<TestListBean>>transformerHelper()).compose(RxUtils.<List<TestListBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取最近30天未上交的学生名单
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<List<UnSubmitBean>> getUnSubmitList(String classId, String teacherId) {
//        initSignHeader(API.UNSUBMIT);
//        return appInterface.getUnSubmitList(classId, teacherId, headerMap).compose(RxUtils.<List<UnSubmitBean>>transformerHelper()).compose(RxUtils.<List<UnSubmitBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据提供的班级Id获取所有的测试列表
//     *
//     * @param classId
//     * @return
//     */
//    public Observable<List<TestListBean>> getWorkList(String classId, String teacherId) {
//        initSignHeader(API.REPORTWORK);
//        return appInterface.getWorkList(classId, teacherId, headerMap).compose(RxUtils.<List<TestListBean>>transformerHelper()).compose(RxUtils.<List<TestListBean>>rxSchedulerHelper());
//    }
//
//
//    // 班级管理接口    end
//    // 作业与测试接口    start
//
//    /**
//     * 获取知识点树
//     *
//     * @param code
//     * @return
//     */
//    public Observable<List<KnowledgeTreeBean>> getKnowledgeTree(String code) {
//        initSignHeader(API.KNOWLEDGETREE);
//        return appInterface.getKnowledgeTree(MyApplication.getUUID(), code, headerMap).compose(RxUtils.<List<KnowledgeTreeBean>>transformerHelper()).compose(RxUtils.<List<KnowledgeTreeBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 查询栏目类型
//     *
//     * @param code
//     * @return
//     */
//    public Observable<List<WorkTypeBean>> getAssignType(String code) {
//        initSignHeader(API.ASSIGNTYPES);
//        return appInterface.getAssignType(MyApplication.getUUID(), code, headerMap).compose(RxUtils.<List<WorkTypeBean>>transformerHelper()).compose(RxUtils.<List<WorkTypeBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取作业和测试列表
//     *
//     * @param knowledgeId
//     * @return
//     */
//    public Observable<WorkPaperBean> getAssignList(String knowledgeId, String pageIndex, String pageSize) {
//        initSignHeader(API.ASSIGNLIST);
//        return appInterface.getAssignList(MyApplication.getUUID(), knowledgeId, pageIndex, pageSize, headerMap).compose(RxUtils.<WorkPaperBean>transformerHelper()).compose(RxUtils.<WorkPaperBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取菜单最后查看的记录名称列表
//     *
//     * @param code
//     * @return
//     */
//    public Observable<NameListBean> getLastNameList(String code) {
//        initSignHeader(API.GETLASTNAMELIST);
//        return appInterface.getLastNameList(MyApplication.getUUID(), code, headerMap).compose(RxUtils.<NameListBean>transformerHelper()).compose(RxUtils.<NameListBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取错题本菜单最后查看的记录名称列表
//     *
//     * @param code
//     * @return
//     */
//    public Observable<NameListBean> getWrongBookLastNameList(String code) {
//        initSignHeader(API.GETWRONGBOOKLASTNAMELIST);
//        return appInterface.getWrongBookLastNameList(MyApplication.getUUID(), code, headerMap).compose(RxUtils.<NameListBean>transformerHelper()).compose(RxUtils.<NameListBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 保存菜单最后查看的记录
//     *
//     * @param code
//     * @return
//     */
//    public Observable<String> saveLastCode(String code, String lastCode) {
//        initSignHeader(API.SAVELASTCODE);
//        return appInterface.SaveLastCode(MyApplication.getUUID(), code, lastCode, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 删除一条未布置的作业、测试记录
//     *
//     * @return
//     */
//    public Observable<String> deleteAssign(String assignId, String paperId) {
//        initSignHeader(API.DELETEASSIGN);
//        return appInterface.DeleteAssign(MyApplication.getUUID(), assignId, paperId, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 根据布置ID和类型查询对象列表
//     *
//     * @return
//     */
//    public Observable<List<AssignObjListBean>> getAssignObjList(String assignId, String objType) {
//        initSignHeader(API.GETASSIGNOBJLIST);
//        return appInterface.getAssignObjList(MyApplication.getUUID(), assignId, objType, headerMap).compose(RxUtils.<List<AssignObjListBean>>transformerHelper()).compose(RxUtils.<List<AssignObjListBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 布置作业、测试，查询布置对象班级
//     *
//     * @return
//     */
//    public Observable<List<GiveWorkClassBean>> getAssignClassList(String paperId) {
//        initSignHeader(API.ASSIGNCLASS);
//        return appInterface.getAssignClassList(MyApplication.getUUID(), paperId, headerMap).compose(RxUtils.<List<GiveWorkClassBean>>transformerHelper()).compose(RxUtils.<List<GiveWorkClassBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 布置作业、测试，查询布置对象小组
//     *
//     * @return
//     */
//    public Observable<List<GiveWorkGroupBean>> getAssignGroupList(String paperId) {
//        initSignHeader(API.ASSIGNGROUP);
//        return appInterface.getAssignGroupList(MyApplication.getUUID(), paperId, headerMap).compose(RxUtils.<List<GiveWorkGroupBean>>transformerHelper()).compose(RxUtils.<List<GiveWorkGroupBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 布置作业、测试，查询布置对象学生
//     *
//     * @return
//     */
//    public Observable<List<GiveWorkGroupBean>> getAssignStudentList(String paperId) {
//        initSignHeader(API.ASSIGNINDIVIDUAL);
//        return appInterface.getAssignStudentList(MyApplication.getUUID(), paperId, headerMap).compose(RxUtils.<List<GiveWorkGroupBean>>transformerHelper()).compose(RxUtils.<List<GiveWorkGroupBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 布置作业、测试，布置给班级
//     *
//     * @return
//     */
//    public Observable<String> assignPapersToClass(AssignPapersToClass assignPapersToClass) {
//        initSignHeader(API.ASSIGN_PAPERS_TO_CLASS);
//        return appInterface.assignPapersToClass(assignPapersToClass, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 布置作业、测试，布置给小组或个人
//     *
//     * @return
//     */
//    public Observable<String> assignPapersToGroup(AssignPapersToGroup assignPapersToGroup) {
//        initSignHeader(API.ASSIGN_PAPERS_TO_GROUP);
//        return appInterface.assignPapersToGroup(assignPapersToGroup, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//
//    /**
//     * 获取批改列表
//     *
//     * @param type
//     * @return
//     */
//    public Observable<CorrectListBean> getCorrectList(String type, String pageNum, String pageSize) {
//        initSignHeader(API.CORRECTLIST);
//        return appInterface.getCorrectList(MyApplication.getUUID(), type, pageNum, pageSize, headerMap).compose(RxUtils.<CorrectListBean>transformerHelper()).compose(RxUtils.<CorrectListBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 布置测试，查询模拟套卷列表
//     *
//     * @return
//     */
//    public Observable<List<MoniPaperListBean>> getMoniPaperList(String knowledgeId, String categoryId) {
//        initSignHeader(API.MONIPAPERLIST);
//        return appInterface.getMoniPaperList(MyApplication.getUUID(), knowledgeId, categoryId, headerMap).compose(RxUtils.<List<MoniPaperListBean>>transformerHelper()).compose(RxUtils.<List<MoniPaperListBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取批改列表
//     *
//     * @return
//     */
//    public Observable<ReportListBean> getReportList(String pageNum, String pageSize) {
//        initSignHeader(API.REPORTLIST);
//        return appInterface.getReportList(MyApplication.getUUID(), pageNum, pageSize, headerMap).compose(RxUtils.<ReportListBean>transformerHelper()).compose(RxUtils.<ReportListBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取错误率
//     *
//     * @return
//     */
//    public Observable<String> getWrongRate() {
//        initSignHeader(API.GETWRONGRATE);
//        return appInterface.getWrongRate(MyApplication.getUUID(), headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 更新错误率
//     *
//     * @return
//     */
//    public Observable<String> updateWrongRate(String wrongRate) {
//        initSignHeader(API.UPDATEWRONGRATE);
//        return appInterface.updateWrongDate(MyApplication.getUUID(), wrongRate, headerMap).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 催作业/测试
//     *
//     * @return
//     */
//    public Observable<String> urgeHomework(String assignId) {
//        initSignHeader(API.URGEHOMEWORK);
//        return appInterface.urgeHomework(MyApplication.getUUID(), assignId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 作业/测试所有学生
//     *
//     * @return
//     */
//    public Observable<List<CorrectStudentBean>> correctStudentList(String assignId) {
//        initSignHeader(API.CORRECTSTUDENTLIST);
//        return appInterface.correctStudentList(assignId).compose(RxUtils.<List<CorrectStudentBean>>transformerHelper()).compose(RxUtils.<List<CorrectStudentBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 保存当前批改到那个学生的位置
//     *
//     * @return
//     */
//    public Observable<String> saveCurrentStudent(String assignId, String studentId) {
//        initSignHeader(API.SAVECURRENTSTUDENT);
//        return appInterface.saveCurrentStudent(MyApplication.getUUID(), assignId, studentId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 获取学生的需要批改的题的列表
//     *
//     * @return
//     */
//    public Observable<List<CorrectQuestionBean>> getCorrectQuestionList(String assignId, String userId) {
//        initSignHeader(API.GETCORRECTQUESTIONLIST);
//        return appInterface.getCorrectQuestionList(MyApplication.getUUID(), assignId, userId).compose(RxUtils.<List<CorrectQuestionBean>>transformerHelper()).compose(RxUtils.<List<CorrectQuestionBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 学生的上传主观题图片信息
//     *
//     * @return
//     */
//    public Observable<CorrectPicBean> getCorrectPic(String assignId, String userId) {
//        initSignHeader(API.GETCORRECTPIC);
//        return appInterface.getCorrectPic(assignId, userId).compose(RxUtils.<CorrectPicBean>transformerHelper()).compose(RxUtils.<CorrectPicBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 当批改完一个学生的答案的，将批改的信息上传
//     *
//     * @return
//     */
//    public Observable<String> submitCorrectInfo(CorrectSubmitInfoBean correctSubmitInfoBean) {
//        initSignHeader(API.SUBMITCORRECTINFO);
//        return appInterface.submitCorrectInfo(correctSubmitInfoBean).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    public Observable<String> submitEduCorrectInfo(CorrectSubmitInfoBean correctSubmitInfoBean) {
//        initSignHeader(API.EDU_SUBMITCORRECTINFO);
//        return appInterface.submitEduCorrectInfo(correctSubmitInfoBean).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//
//    public static Observable<CustomDownLoadBean> downloadFile(final CustomDownLoadBean downLoadBean) {
//
//        return Observable.create(
//                new Observable.OnSubscribe<CustomDownLoadBean>() {
//                    @Override
//                    public void call(final Subscriber<? super CustomDownLoadBean> subscriber) {
//
//
//                        OkHttpClient mOkHttpClient = new OkHttpClient();
//                        Request request = new Request.Builder().url(downLoadBean.getUrl()).build();
//                        mOkHttpClient.newCall(request).enqueue(new Callback() {
//                            @Override
//                            public void onFailure(Call call, IOException e) {
//                                subscriber.onNext(downLoadBean);
//                                subscriber.onCompleted();
//                            }
//
//
//                            @Override
//                            public void onResponse(Call call, okhttp3.Response response) throws IOException {
//
//                                if (downLoadBean.getFileName() == null) {
//                                    String fileName = StringUtils.getFileNameFromBaiduURL(downLoadBean.getUrl());
//                                    downLoadBean.setFileName(fileName);
//                                }
//
//                                File file = FileUtils.downLoadFile(MyApplication.getInstance(), response.body(), downLoadBean.getFileName());
//
//                                if (file.exists()) {
//                                    downLoadBean.setLoadSucess(true);
//                                    downLoadBean.setFilePath(file.getAbsolutePath());
//                                } else {
//                                    downLoadBean.setLoadSucess(false);
//                                }
//
//                                subscriber.onNext(downLoadBean);
//                                subscriber.onCompleted();
//                            }
//
//
//                        });
//
//
//                    }
//                }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
//    }
//
//    // 作业与测试接口    end
//
//
//    //    新版作业和测试的接口  start
//
//    /**
//     * 批改界面获取图片列表
//     *
//     * @return
//     */
//    public Observable<CorrectPicBean1> getCorrectPics(String userId, String assignId) {
//        initSignHeader(API.CORRECT_PICS);
//        return appInterface.getCorrectPics(userId, assignId).compose(RxUtils.<CorrectPicBean1>transformerHelper()).compose(RxUtils.<CorrectPicBean1>rxSchedulerHelper());
//    }
//
//    /**
//     * 查询该次批改的学生列表
//     *
//     * @return
//     */
//    public Observable<CorrectStudentBean1> getCorrectStudents(String assignId) {
//        return appInterface.getCorrectStudents(assignId).compose(RxUtils.<CorrectStudentBean1>transformerHelper()).compose(RxUtils.<CorrectStudentBean1>rxSchedulerHelper());
//    }
//
//    /**
//     * 查询当前用户作业测试列表
//     *
//     * @return
//     */
//    public Observable<CorrectListBean1> getCorrectLists(String uuid, String type, String endDate) {
//        return appInterface.getCorrectLists(uuid, type, endDate).compose(RxUtils.<CorrectListBean1>transformerHelper()).compose(RxUtils.<CorrectListBean1>rxSchedulerHelper());
//    }
//
//    /**
//     * 批改界面上传录音
//     *
//     * @param filePath
//     * @param uuid
//     * @param assignId
//     * @param userId
//     * @param pictureId
//     * @param duration
//     * @return
//     */
//
//
//    public Observable<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>> uploadAudio(String filePath, String uuid,
//                                                                                        String assignId, String userId,
//                                                                                        String pictureId, String duration) {
//        initSignHeader(API.CORRECT_UPLOADAUDIO);
//        File file = new File(filePath);
//        RequestBody requestFile =
////                RequestBody.create(MediaType.parse("application/octet-stream"), file);
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
//
//        RequestBody idBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), userId);
//        RequestBody subjectIdBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), pictureId);
//        RequestBody durationBody = RequestBody.create(
//                MediaType.parse("multipart/form-data"), duration);
//
//        HashMap<String, RequestBody> map = new HashMap<>();
//        map.put("userId", idBody);
//        map.put("pictureId", subjectIdBody);
//        map.put("duration", durationBody);
////        return appInterface.uploadAudio(filePart, uuid, assignId, userId, pictureId, duration, headerMap).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>transformerHelper()).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>rxSchedulerHelper());
//        return appInterface.uploadAudio(map, filePart, uuid, assignId).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>transformerHelper()).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 删除图片录音
//     *
//     * @return
//     */
//    public Observable<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>> deleteAudio(String assignId, String userId, String pictureId, String audioId) {
//        initSignHeader(API.CORRECT_DELETEAUDIO);
//        return appInterface.deleteAudio(assignId, userId, pictureId, audioId).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>transformerHelper()).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 查询该次学生的批改结果
//     *
//     * @return
//     */
//    public Observable<List<CorrectQuestionBean>> getCorrectProblemList(String uuid, String assignId, String userId) {
//        return appInterface.getCorrectProblemList(uuid, assignId, userId).compose(RxUtils.<List<CorrectQuestionBean>>transformerHelper()).compose(RxUtils.<List<CorrectQuestionBean>>rxSchedulerHelper());
//    }
//
//    /**
//     * 上传批改界面批改过的图片
//     *
//     * @param filePath
//     * @param uuid
//     * @return
//     */
//
//
//    public Observable<CorrectUploadPicBean> correct_uploadPic(File file, String uuid) {
//        initSignHeader(API.CORRECT_UPLOADPIC);
//        RequestBody requestFile =
////                RequestBody.create(MediaType.parse("application/octet-stream"), file);
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
////        return appInterface.uploadAudio(filePart, uuid, assignId, userId, pictureId, duration, headerMap).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>transformerHelper()).compose(RxUtils.<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>rxSchedulerHelper());
//        return appInterface.correct_uploadPic(filePart, uuid).compose(RxUtils.<CorrectUploadPicBean>transformerHelper()).compose(RxUtils.<CorrectUploadPicBean>rxSchedulerHelper());
//    }
//
//    /**
//     * 当批改完一个学生的答案的，将批改的信息上传
//     *
//     * @return
//     */
//    public Observable<String> submitCorrectRecord(CorrectSubmitInfoBean1 correctSubmitInfoBean1) {
//        initSignHeader(API.CORRECT_UPLOADRECORD);
//        return appInterface.submitCorrectRecord(correctSubmitInfoBean1).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//
//    /**
//     * 批改完成，点击结束批改的时候进行调用
//     *
//     * @return
//     */
//    public Observable<String> finishThisCorrect(String assignId, String uuid) {
//        return appInterface.finishThisCorrect(assignId, uuid).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 切换学生保存批改标志
//     *
//     * @return
//     */
//    public Observable<String> exchangeStudent(String userId, String assignId) {
//        return appInterface.exchangeStudent(userId, assignId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 判断是否可以执行批改操作
//     *
//     * @return
//     */
//    public Observable<String> doCorrect(String assignId) {
//        return appInterface.doCorrect(assignId).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }
//
//    /**
//     * 作业测试报告列表
//     *
//     * @return
//     */
//    public Observable<ReportListBean1> getReportLists(String uuid, String endDate, String type) {
//        return appInterface.getReportLists(uuid, endDate, type).compose(RxUtils.<ReportListBean1>transformerHelper()).compose(RxUtils.<ReportListBean1>rxSchedulerHelper());
//    }
//
//    /**
//     * 报告部分的讲评提醒
//     *
//     * @return
//     */
//    public Observable<String> remindReport(String assignId, String questionId, String groupCode, String comment) {
//        return appInterface.remindReport(assignId, questionId, groupCode,comment).compose(RxUtils.<String>transformerHelper()).compose(RxUtils.<String>rxSchedulerHelper());
//    }


//    新版作业和测试的接口  end

}
