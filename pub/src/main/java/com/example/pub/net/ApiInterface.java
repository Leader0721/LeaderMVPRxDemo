package com.example.pub.net;

/**
 * description 接口控制中心，定义接口地址，传输类型和参数结构
 * author hanlei
 * version 1.0
 * created at 2016/11/14 10:27
 */
public interface ApiInterface {

//
//    // 视频
//    @FormUrlEncoded
//    @POST(API.SET_USER_NET_INFO)
//    Observable<BaseBean<String>> setUserNetInfo(@Field("uuid") String uuid, @Field("userSid") String userSid, @Field("userIp") String userIp);
//
//    //  检测教师是否在上课
//    @FormUrlEncoded
//    @POST(API.CHECK_ON_CLASS)
//    Observable<BaseBean<OnClassState>> checkOnClass(@Field("uuid") String uuid);
//
//    // 教师推送素材和自己上传的资源
//    @FormUrlEncoded
//    @POST(API.PUSH_RES)
//    Observable<BaseBean<String>> pushRes(@Field("uuid") String uuid, @Field("classId") String classId, @Field("resourseId") String resourseId
//            , @Field("resourseType") String resourseType, @Field("courseResourseId") String courseResourseId, @Field("lessionLogId") String lessionLogId);
//
//    // 教师推送素材和自己上传的资源
//    @FormUrlEncoded
//    @POST(API.PUSH_RES_SELF)
//    Observable<BaseBean<String>> pushResSelf(@Field("uuid") String uuid, @Field("classId") String classId, @Field("resFileId") String resFileId
//            , @Field("resourseType") String resourseType, @Field("courseResourseId") String courseResourseId, @Field("lessionLogId") String lessionLogId);
//
//    // 教师推送试卷
//    @FormUrlEncoded
//    @POST(API.PUSH_HOME_WORK)
//    Observable<BaseBean<String>> pushHomeWork(@Field("uuid") String uuid, @Field("classId") String classId, @Field("paperId") String paperId
//            , @Field("paperType") String paperType, @Field("courseResourseId") String courseResourseId, @Field("lessionLogId") String lessionLogId);
//
//    // 教师开始上课
//    @FormUrlEncoded
//    @POST(API.START_CLASS)
//    Observable<BaseBean<String>> startClass(@Field("uuid") String uuid, @Field("classId") String classId, @Field("courseId") String courseId, @Field("knowledgeId") String knowledgeId);
//
//    // 教师开始下课
//    @FormUrlEncoded
//    @POST(API.END_CLASS)
//    Observable<BaseBean<String>> endClass(@Field("uuid") String uuid, @Field("classId") String classId);
//
//    // 教师结束练习
//    @FormUrlEncoded
//    @POST(API.STOP_PRACTICE)
//    Observable<BaseBean<String>> stopPractice(@Field("uuid") String uuid, @Field("classId") String classId, @Field("paperAssignId") String paperAssignId, @Field("lessionLogId") String lessionLogId);
//
//    // 随堂练习客观题提交情况
//    @FormUrlEncoded
//    @POST(API.QUESTION_DETAIL)
//    Observable<BaseBean<PQuestionDetail>> getQuestionDetail(@Field("uuid") String uuid, @Field("paperAssignId") String paperAssignId, @Field("questionId") String questionId, @Field("questionType") String questionType);
//
//    // 教师结束互批
//    @FormUrlEncoded
//    @POST(API.STOP_EO_CORRECT)
//    Observable<BaseBean<String>> stopEOCorrect(@Field("uuid") String uuid, @Field("classId") String classId, @Field("paperAssignId") String paperAssignId, @Field("lessionLogId") String lessionLogId);
//
//    // 教师互批作业
//    @FormUrlEncoded
//    @POST(API.EACH_OTHER_CORRECT)
//    Observable<BaseBean<String>> echoOtherCorrect(@Field("uuid") String uuid, @Field("classId") String classId, @Field("paperAssignId") String paperAssignId, @Field("lessionLogId") String lessionLogId);
//
//    // 教师锁屏
//    @FormUrlEncoded
//    @POST(API.CLOSSS_SCREEN)
//    Observable<BaseBean<String>> closeScreen(@Field("uuid") String uuid, @Field("classId") String classId);
//
//    // 教师解锁
//    @FormUrlEncoded
//    @POST(API.OPEN_SCREEN)
//    Observable<BaseBean<String>> openScreen(@Field("uuid") String uuid, @Field("classId") String classId);
//
//    // 获取随堂练习提交情况
//    @FormUrlEncoded
//    @POST(API.LESS_WK_COUNT)
//    Observable<BaseBean<PracticeCount>> getPracticeCount(@Field("uuid") String uuid, @Field("paperAssignId") String paperAssignId);
//
//    // 在线预览接口(参数为标识)
//    @FormUrlEncoded
//    @POST(API.ONLINE_VIEW_BY_FILE)
//    Observable<BaseBean<OnlineDoc>> onlineViewByFile(@Field("resFileId") String resFileId, @Field("expirationInSeconds") String expirationInSeconds);
//
//
//    // 在线预览接口(参数为标识)
//    @FormUrlEncoded
//    @POST(API.ONLINE_VIEW_NAME)
//    Observable<BaseBean<OnlineDoc>> onlineViewName(@Field("resourseId") String resourseId, @Field("expirationInSeconds") String expirationInSeconds);
//
//    // 音频
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_ARTICLE_EN)
//    Observable<BaseBean<ResourceDetailBean>> getENAudio(@Field("uuid") String uuid, @Field("resId") String resId);
//
//    // 音频
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_ARTICLE_CH)
//    Observable<BaseBean<ResourceDetailBean>> getCHAudio(@Field("uuId") String uuId, @Field("categoryId") String categoryId, @Field("knowledgeId") String knowledgeId);
//
//    // 音频
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_SRC_AUDIO)
//    Observable<BaseBean<ResourceDetailBean>> getSrcAudio(@Field("uuId") String uuid, @Field("resId") String resId);
//
//    // 素材图片
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_SRC_IMAGE)
//    Observable<BaseBean<ResourceDetailBean>> getSrcImage(@Field("uuId") String uuid, @Field("resId") String resId);
//
//    // 视频
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_VIDEO_INFO)
//    Observable<BaseBean<ResourceDetailBean>> getVideoInfo(@Field("uuid") String uuid, @Field("resId") String resId);
//
//    // 备课 start
//
//    //获得在线人数列表
//    @FormUrlEncoded
//    @POST(API.ONLINE_STUDENTS)
//    Observable<BaseBean<OnLineStudentListBean>> getOnlineStudents(@Field("uuid") String uuid, @Field("classId") String classId);
//
//
//    // 可以推荐的班级
//    @FormUrlEncoded
//    @POST(API.RECOMMEND_LIST)
//    Observable<BaseBean<List<RecommendClassBean>>> getCommonRecommendClass(@Field("uuid") String uuid, @Field("resId") String resId);
//
//    // 资源推荐
//    @POST(API.RECOMMEND)
//    Observable<BaseBean<String>> commonRecommend(@Body ParamRecommend recommendResouce);
//
//    // 加入课堂
//    @POST(API.ADD_COURSE_RESOURSE)
//    Observable<BaseBean<String>> addCourseResourse(@Body LessonItem courseResourseReq);
//
//    // APP获取版本  1老师 2学生 3家长
//    @FormUrlEncoded
//    @POST(API.COMMON_APP_VERSION)
//    Observable<BaseBean<AppVersion>> getAppVersion(@Field("appType") String appType, @HeaderMap Map<String, String> headerMap);
//
//    // 获得某个目录下的所有英语音频
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_EN_AUDIOS)
//    Observable<BaseBean<List<ResourceBean>>> getEnAudios(@Field("uuId") String uuid, @Field("knowledgeList") String knowledgeList, @Field("categoryId") String categoryId);
//
//    // 获得某个目录下的所有随堂练习
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_PRACTICES)
//    Observable<BaseBean<List<ResourceBean>>> getPractices(@Field("uuid") String uuid, @Field("konwledgeId") String knowledgeId, @Field("categoryId") String categoryId);
//
//
//    // 获得某个目录下的所有素材资源
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_MATERIALS)
//    Observable<BaseBean<List<ResourceBean>>> getMaterials(@Field("uuid") String uuid, @Field("knowledgeId") String knowledgeId, @Field("categoryId") String categoryId);
//
//    // 教师推送图片
//    @Multipart
//    @POST(API.PUSH_PICTURE)
//    Observable<BaseBean<String>> pushPicture(@PartMap() Map<String, RequestBody> partMap, @Part() MultipartBody.Part file);
//
//
//    // 上传文件，音频，课件，图片，文档
//    @Multipart
//    @POST(API.UPLOAD_FILE)
//    Observable<BaseBean<String>> uploadFile(@PartMap() Map<String, RequestBody> partMap, @Part() MultipartBody.Part file);
//
//    // 获得某个目录下的所有课件资源
//    @FormUrlEncoded
//    @POST(API.UPLOAD_VIDEO)
//    Observable<BaseBean<String>> uploadVideo(@Field("uuid") String uuid, @Field("courseId") String courseId, @Field("fileName") String fileName
//            , @Field("knowledgeId") String knowledgeId, @Field("fileType") String fileType
//            , @Field("serviceId") String serviceId);
//
//    // 获得某个目录下的所有视频资源
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_VIDEOS)
//    Observable<BaseBean<List<ResourceBean>>> getVideos(@Field("uuid") String uuid, @Field("knowledgeId") String knowledgeId, @Field("categoryId") String categoryId);
//
//    // 获得回调url
//    @FormUrlEncoded
//    @POST(API.GET_URL)
//    Observable<BaseBean<String>> getUrl(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    // 获得某个目录下的所有课件资源
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_COUREWARE)
//    Observable<BaseBean<List<ResourceBean>>> getCoureware(@Field("uuid") String uuid, @Field("konwledgeIds") String konwledgeIds, @Field("categoryId") String categoryId);
//
//    // 根据课程获得对应的章节知识点
//    @FormUrlEncoded
//    @POST(API.GET_KNOWLEDGE_BY_ID)
//    Observable<BaseBean<List<SimpleTreeBean>>> getKnowledgeById(@Field("uuid") String uuid, @Field("code") String code, @Field("knowledgeId") String knowledgeId);
//
//    // 获取英语单词数据
//    @FormUrlEncoded
//    @POST(API.GET_RESOURSE_TYPES)
//    Observable<BaseBean<List<ResourceType>>> getResourseTypes(@Field("uuid") String uuid, @Field("menuCode") String menuCode);
//
//    // 获取英语单词数据
//    @FormUrlEncoded
//    @POST(API.EN_WORDS_DETAIL)
//    Observable<BaseBean<List<WordDetail>>> enWordDetail(@Field("uuid") String uuid, @Field("resIdList") String resIdList);
//
//    // 课程资源列表的排序
//    @POST(API.SET_COURSE_RESOURSE_SORT)
//    Observable<BaseBean<String>> setCourseResourseSort(@Body ParamResourseSort courseResourseReqMap);
//
//    // 上课对应的资源列表
//    @FormUrlEncoded
//    @POST(API.GET_ONLINE_RESOURSE)
//    Observable<BaseBean<List<LessonItem>>> getOnlineResourse(@Field("uuid") String uuid, @Field("courseId") String courseId, @Field("classId") String classId, @Field("lessionLogId") String lessionLogId);
//
//
//    // 课程对应的资源列表
//    @FormUrlEncoded
//    @POST(API.GET_COURSE_RESOURSE)
//    Observable<BaseBean<List<LessonItem>>> getCourseResourse(@Field("uuid") String uuid, @Field("knowledgeId") String knowledgeId, @Field("courseId") String courseId);
//
//    // 获得目录下面的所有课程
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_COURSE_LIST)
//    Observable<BaseBean<List<CourseBean>>> getCourseList(@Field("uuid") String uuid, @Field("knowledgeId") String knowledgeId);
//
//    // 添加课程
//    @POST(API.PRE_LESS_COURSE_ADD)
//    Observable<BaseBean<String>> addCourseList(@Body List<AddCourseBean> addCourseBeanList);
//
//    // 删除课程
//    @FormUrlEncoded
//    @POST(API.PRE_LESS_COURSE_DEL)
//    Observable<BaseBean<String>> delCourse(@Field("uuid") String uuid, @Field("courseId") String courseId);
//
//    // 修改课程
//    @POST(API.PRE_LESS_COURSE_UPDATE)
//    Observable<BaseBean<String>> updateCourseList(@Body List<AddCourseBean> addCourseBeanList);
//
//
//    // 备课 end
//    // 用户账户个人中心接口 start
//
//    //登录
//    @FormUrlEncoded
//    @POST(API.USER_LOGIN)
//    Observable<BaseBean<List<LoginBean>>> userLogin(@Field("registrationId") String registrationId, @Field("mobile") String mobile, @Field("password") String password, @Field("uuid") String uuid, @Field("imageCaptcha") String imageCaptcha, @Field("userType") String userType, @HeaderMap Map<String, String> headerMap);
//
//    // 重置密码-获取验证码
//    @FormUrlEncoded
//    @POST(API.RESET_PASSWORD_MESSAGE)
//    Observable<BaseBean<String>> resetPasswordMessage(@Field("mobile") String mobile, @HeaderMap Map<String, String> headerMap);
//
//    //校验验证码是否正确
//    @FormUrlEncoded
//    @POST(API.CHECK_SMS)
//    Observable<BaseBean<String>> checkSms(@Field("mobile") String mobile, @Field("smsCaptcha") String smsCaptcha, @HeaderMap Map<String, String> headerMap);
//
//    // 重置密码
//    @FormUrlEncoded
//    @POST(API.RESET_PASSWORD)
//    Observable<BaseBean<String>> resetPassword(@Field("mobile") String mobile, @Field("smsCaptcha") String smsCaptcha, @Field("password") String password, @HeaderMap Map<String, String> headerMap);
//
//    //获取教师基本资料
//    @FormUrlEncoded
//    @POST(API.CENTER_BASEINFO)
//    Observable<BaseBean<TeacherBaseInfo>> getBaseInfo(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    // 更换头像
//    @Multipart
//    @POST(API.CHANGE_PORTRAIT)
//    Observable<BaseBean<String>> changePortrait(@PartMap() Map<String, RequestBody> partMap,
//                                                @Part() MultipartBody.Part file, @HeaderMap Map<String, String> headerMap);
//
//    //修改密码
//    @FormUrlEncoded
//    @POST(API.UPDATE_PASSWORD)
//    Observable<BaseBean<String>> updatePsd(@Field("uuid") String uuid, @Field("oldpwd") String oldpwd, @Field("password") String password, @HeaderMap Map<String, String> headerMap);
//
//    // 绑定手机号发送验证码
//    @FormUrlEncoded
//    @POST(API.BIND_PHONENUM_SMS)
//    Observable<BaseBean<String>> bindPhoneNumSms(@Field("uuid") String uuid, @Field("mobile") String mobile, @HeaderMap Map<String, String> headerMap);
//
//    // 绑定手机号
//    @FormUrlEncoded
//    @POST(API.BIND_PHONENUM)
//    Observable<BaseBean<String>> bindPhoneNum(@Field("uuid") String uuid, @Field("mobile") String mobile, @Field("smsCaptcha") String smsCaptcha, @HeaderMap Map<String, String> headerMap);
//
//    // 修改手机号发送验证码
//    @FormUrlEncoded
//    @POST(API.CHANGE_PHONENUM_SMS)
//    Observable<BaseBean<String>> changePhoneNumSms(@Field("uuid") String uuid, @Field("password") String password, @Field("mobile") String mobile, @HeaderMap Map<String, String> headerMap);
//
//    // 更换手机号
//    @FormUrlEncoded
//    @POST(API.CHANGE_PHONENUM)
//    Observable<BaseBean<String>> changePhoneNum(@Field("uuid") String uuid, @Field("mobile") String mobile, @Field("password") String password, @Field("smsCaptcha") String smsCaptcha, @HeaderMap Map<String, String> headerMap);
//
//    // 获取出版社列表
//    @FormUrlEncoded
//    @POST(API.GET_PRESS)
//    Observable<BaseBean<List<PressBean>>> getPress(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    //获取教材
//    @FormUrlEncoded
//    @POST(API.GET_MATERIAL)
//    Observable<BaseBean<List<MaterialBean>>> getMaterial(@Field("subjectId") String subjectId, @Field("pressId") String pressId, @HeaderMap Map<String, String> headerMap);
//
//    // 修改教材
//    @FormUrlEncoded
//    @POST(API.UPDATE_MATERIAL)
//    Observable<BaseBean<String>> updateMaterial(@Field("uuid") String uuid, @Field("materialId") String materialId, @HeaderMap Map<String, String> headerMap);
//
//    // 系统消息列表
//    @FormUrlEncoded
//    @POST(API.GET_SYSTEM_MESSAGE)
//    Observable<BaseBean<SystemMessageBean>> getSystemMessage(@Field("uuid") String uuid, @Field("pageIndex") String pageIndex, @Field("pageSize") String pageSize, @HeaderMap Map<String, String> headerMap);
//
//    // 系统消息操作
//    @FormUrlEncoded
//    @POST(API.SET_SYSTEM_MESSAGE)
//    Observable<BaseBean<String>> setSystemMessage(@Field("userMessageId") String userMessageId, @HeaderMap Map<String, String> headerMap);
//
//    // 申请消息列表
//    @FormUrlEncoded
//    @POST(API.GET_APPLY_MESSAGE)
//    Observable<BaseBean<ApplyMessageBean>> getApplyMessage(@Field("uuid") String uuid, @Field("pageIndex") String pageIndex, @Field("pageSize") String pageSize, @HeaderMap Map<String, String> headerMap);
//
//    // 申请消息操作同意
//    @FormUrlEncoded
//    @POST(API.SET_APPLY_MSG_YES)
//    Observable<BaseBean<String>> setApplyYes(@Field("uuid") String uuid, @Field("userType") String userType, @Field("userMessageId") String userMessageId, @Field("senderId") String senderId, @HeaderMap Map<String, String> headerMap);
//
//    // 申请消息操作拒绝
//    @FormUrlEncoded
//    @POST(API.SET_APPLY_MSG_NO)
//    Observable<BaseBean<String>> setApplyNo(@Field("uuid") String uuid, @Field("userType") String userType, @Field("userMessageId") String userMessageId, @Field("senderId") String senderId, @HeaderMap Map<String, String> headerMap);
//
//    // 申请消息操作删除
//    @FormUrlEncoded
//    @POST(API.SET_APPLY_MSG_DEL)
//    Observable<BaseBean<String>> setApplyDel(@Field("uuid") String uuid, @Field("userType") String userType, @Field("userMessageId") String userMessageId, @Field("senderId") String senderId, @HeaderMap Map<String, String> headerMap);
//
//    // 系统消息未读条数
//    @FormUrlEncoded
//    @POST(API.SYS_MSG_UNREAD_COUNT)
//    Observable<BaseBean<String>> getSysUnreadCount(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    // 申请消息未读条数
//    @FormUrlEncoded
//    @POST(API.APPLY_MSG_UNREAD_COUNT)
//    Observable<BaseBean<String>> getApplyUnreadCount(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    // 消息未操作条数
//    @FormUrlEncoded
//    @POST(API.GET_MESSAGE_NUM)
//    Observable<BaseBean<String>> getMessageNum(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    // 保存用户意见
//    @POST(API.SUGGESTION)
//    Observable<BaseBean<String>> suggestion(@Body ParaSuggestionBean paraSuggestionBean, @HeaderMap Map<String, String> headerMap);
//
//    // 用户账户个人中心接口 end
//
//    // 拓展提升的接口   start
//
//    // 文章推荐的班级
//    @FormUrlEncoded
//    @POST(API.ARTCLE_RECOM_CLASS)
//    Observable<BaseBean<List<RecommendClassBean>>> getRecommendClass(@Field("uuid") String uuid, @Field("articleId") String articleId, @HeaderMap Map<String, String> headerMap);
//
//    // 资源推荐
//    @FormUrlEncoded
//    @POST(API.COMMON_RECOMMEND2CLS)
//    Observable<BaseBean<String>> recommend2Class(@Field("classIds") String classIds, @Field("uuid") String uuid, @Field("articleId") String articleId, @Field("requireMent") String requireMent, @HeaderMap Map<String, String> headerMap);
//
//    // 拓展提升的接口   end
//
//    // 班级管理的接口   start
//
//
//    //查看当前用户的年级
//    @FormUrlEncoded
//    @POST(API.GET_GRADE)
//    Observable<BaseBean<String>> getGrade(@Field("uuid") String uuid);
//
//    //搜索班级
//    @FormUrlEncoded
//    @POST(API.CLASS_SEARCH)
//    Observable<BaseBean<SearchClassBean>> classSearch(@Field("uuid") String uuid, @Field("classCode") String classCode, @HeaderMap Map<String, String> headerMap);
//
//    //根据提供的班级ID加入班级
//    @FormUrlEncoded
//    @POST(API.CLASS_JOIN)
//    Observable<BaseBean<String>> classJoin(@Field("uuid") String uuid, @Field("classId") String classId, @HeaderMap Map<String, String> headerMap);
//
//    //获取已经创建的班级
//    @FormUrlEncoded
//    @POST(API.CREATEDCLASS_LIST)
//    Observable<BaseBean<List<CreateClassBean>>> createdClassList(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    //还能创建几个班级
//    @FormUrlEncoded
//    @POST(API.CLASS_LEFT_NUMBER)
//    Observable<BaseBean<Integer>> classleftNumber(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    //创建班级
//    @POST(API.CLASS_CREATE)
//    Observable<BaseBean<String>> classCreate(@HeaderMap Map<String, String> headerMap, @Body ParamCreateClass paramCreateClass);
//
//    //获取班级列表
//    @FormUrlEncoded
//    @POST(API.CLASS_LIST)
//    Observable<BaseBean<List<ClassBean>>> getClassList(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    //根据传入的班级Id,获取班级的信息
//    @FormUrlEncoded
//    @POST(API.CLASS_DETAIL)
//    Observable<BaseBean<ClassInfoBean>> getClassInfo(@Field("uuid") String uuid, @Field("classId") String classId,
//                                                     @HeaderMap Map<String, String> headerMap);
//
//    //删除班级成员
//    @POST(API.DELETE_CLASSMEMBER)
//    Observable<BaseBean<String>> deleteClassMember(@Body DeleteClassMemberBean deleteClassMemberBean, @HeaderMap Map<String, String> headerMap);
//
//
//    //设置某个老师为班主任
//    @FormUrlEncoded
//    @POST(API.CLASS_TEACHER_SET)
//    Observable<BaseBean<String>> teacherSet(@Field("uuid") String uuid, @Field("classId") String classId, @Field("teacherId") String teacherId, @HeaderMap Map<String, String> headerMap);
//
//    //老师解散班级
//    @FormUrlEncoded
//    @POST(API.CLASS_TEACHER_DISSOLVE)
//    Observable<BaseBean<String>> teacherDissolve(@Field("uuid") String uuid, @Field("classId") String classId, @Field("password") String password, @HeaderMap Map<String, String> headerMap);
//
//    //解散小组
//    @FormUrlEncoded
//    @POST(API.DISSOLVE_GROUP)
//    Observable<BaseBean<String>> dissolveGroup(@Field("uuid") String uuid, @Field("groupId") String groupId, @HeaderMap Map<String, String> headerMap);
//
//    //更新小组
//    @POST(API.UPDATEGROUP)
//    Observable<BaseBean<String>> updateGroup(@Body UpdateGroupBean updateGroupBean, @HeaderMap Map<String, String> headerMap);
//
//    //创建小组
//    @POST(API.CREATE_GROUP)
//    Observable<BaseBean<String>> createGroup(@Body CreateGroupBean createGroupBean, @HeaderMap Map<String, String> headerMap);
//
//    //是否可以引用班主任的小组
//    @FormUrlEncoded
//    @POST(API.CHECKHEADER)
//    Observable<BaseBean<List<ClassInfoBean.StudentGroupResListBean>>> checkHeader(@Field("uuid") String uuid, @Field("classId") String classId, @HeaderMap Map<String, String> headerMap);
//
//    //引用班主任的小组
//    @FormUrlEncoded
//    @POST(API.USEHEADER)
//    Observable<BaseBean<String>> useHeader(@Field("uuid") String uuid, @Field("classId") String classId, @HeaderMap Map<String, String> headerMap);
//
//    //老师退出班级
//    @FormUrlEncoded
//    @POST(API.EXITCLASS)
//    Observable<BaseBean<String>> exitClass(@Field("uuid") String uuid, @Field("classId") String classId, @HeaderMap Map<String, String> headerMap);
//
//    //根据传入的班级Id,获取所有的学生的信息
//    @FormUrlEncoded
//    @POST(API.GETSTUDENTINFO)
//    Observable<BaseBean<List<StudentInfoBean>>> getStudentInfo(@Field("uuid") String uuid, @Field("classId") String classId,
//                                                               @HeaderMap Map<String, String> headerMap);
//
//    //根据传入的班级Id,获取所有的测试的信息
//    @FormUrlEncoded
//    @POST(API.REPORTTEST)
//    Observable<BaseBean<List<TestListBean>>> getTestList(@Field("classId") String classId, @Field("teacherId") String teacherId,
//                                                         @HeaderMap Map<String, String> headerMap);
//
//    //获取最近30天未上交的学生名单
//    @FormUrlEncoded
//    @POST(API.UNSUBMIT)
//    Observable<BaseBean<List<UnSubmitBean>>> getUnSubmitList(@Field("classId") String classId, @Field("teacherId") String teacherId,
//                                                             @HeaderMap Map<String, String> headerMap);
//
//
//    //根据传入的班级Id,获取所有的作业的信息
//    @FormUrlEncoded
//    @POST(API.REPORTWORK)
//    Observable<BaseBean<List<TestListBean>>> getWorkList(@Field("classId") String classId, @Field("teacherId") String teacherId,
//                                                         @HeaderMap Map<String, String> headerMap);
//
//    // 班级管理接口    end
//
////    作业和测试的接口  start
//
//    //根据传入的班级Id,获取所有的作业的信息
//    @FormUrlEncoded
//    @POST(API.KNOWLEDGETREE)
//    Observable<BaseBean<List<KnowledgeTreeBean>>> getKnowledgeTree(@Field("uuid") String uuid, @Field("code") String code,
//                                                                   @HeaderMap Map<String, String> headerMap);
//
//    //查询栏目类型
//    @FormUrlEncoded
//    @POST(API.ASSIGNTYPES)
//    Observable<BaseBean<List<WorkTypeBean>>> getAssignType(@Field("uuid") String uuid, @Field("code") String code,
//                                                           @HeaderMap Map<String, String> headerMap);
//
//    //查询作业或者测试列表
//    @FormUrlEncoded
//    @POST(API.ASSIGNLIST)
//    Observable<BaseBean<WorkPaperBean>> getAssignList(@Field("uuid") String uuid, @Field("knowledgeId") String knowledgeId,
//                                                      @Field("pageNo") String pageIndex, @Field("pageSize") String pageSize,
//                                                      @HeaderMap Map<String, String> headerMap);
//
//    //获取菜单最后查看的记录名称列表
//    @FormUrlEncoded
//    @POST(API.GETLASTNAMELIST)
//    Observable<BaseBean<NameListBean>> getLastNameList(@Field("uuid") String uuid, @Field("code") String code,
//                                                       @HeaderMap Map<String, String> headerMap);
//
//    //获取错题本菜单最后查看的记录名称列表
//    @FormUrlEncoded
//    @POST(API.GETWRONGBOOKLASTNAMELIST)
//    Observable<BaseBean<NameListBean>> getWrongBookLastNameList(@Field("uuid") String uuid, @Field("code") String code,
//                                                                @HeaderMap Map<String, String> headerMap);
//
//    //保存菜单最后查看的记录
//    @FormUrlEncoded
//    @POST(API.SAVELASTCODE)
//    Observable<BaseBean<String>> SaveLastCode(@Field("uuid") String uuid, @Field("code") String code,
//                                              @Field("lastCode") String lastCode, @HeaderMap Map<String, String> headerMap);
//
//    //删除一条未布置的作业、测试记录
//    @FormUrlEncoded
//    @POST(API.DELETEASSIGN)
//    Observable<BaseBean<String>> DeleteAssign(@Field("uuid") String uuid, @Field("assignId") String assignId,
//                                              @Field("paperId") String paperId, @HeaderMap Map<String, String> headerMap);
//
//    //根据布置ID和类型查询对象列表
//    @FormUrlEncoded
//    @POST(API.GETASSIGNOBJLIST)
//    Observable<BaseBean<List<AssignObjListBean>>> getAssignObjList(@Field("uuid") String uuid, @Field("assignId") String assignId,
//                                                                   @Field("objType") String objType, @HeaderMap Map<String, String> headerMap);
//
//    //布置作业、测试，查询布置对象班级
//    @FormUrlEncoded
//    @POST(API.ASSIGNCLASS)
//    Observable<BaseBean<List<GiveWorkClassBean>>> getAssignClassList(@Field("uuid") String uuid, @Field("paperId") String paperId, @HeaderMap Map<String, String> headerMap);
//
//    //布置作业、测试，查询布置对象小组
//    @FormUrlEncoded
//    @POST(API.ASSIGNGROUP)
//    Observable<BaseBean<List<GiveWorkGroupBean>>> getAssignGroupList(@Field("uuid") String uuid, @Field("paperId") String paperId, @HeaderMap Map<String, String> headerMap);
//
//    //布置作业、测试，查询布置对象学生
//    @FormUrlEncoded
//    @POST(API.ASSIGNINDIVIDUAL)
//    Observable<BaseBean<List<GiveWorkGroupBean>>> getAssignStudentList(@Field("uuid") String uuid, @Field("paperId") String paperId, @HeaderMap Map<String, String> headerMap);
//
//    // 布置作业、测试，布置给班级
//    @POST(API.ASSIGN_PAPERS_TO_CLASS)
//    Observable<BaseBean<String>> assignPapersToClass(@Body AssignPapersToClass assignPapersToClass, @HeaderMap Map<String, String> headerMap);
//
//    // 布置作业、测试，布置给小组或个人
//    @POST(API.ASSIGN_PAPERS_TO_GROUP)
//    Observable<BaseBean<String>> assignPapersToGroup(@Body AssignPapersToGroup assignPapersToGroup, @HeaderMap Map<String, String> headerMap);
//
//    //查询作业或者测试列表
//    @FormUrlEncoded
//    @POST(API.CORRECTLIST)
//    Observable<BaseBean<CorrectListBean>> getCorrectList(@Field("uuid") String uuid, @Field("type") String type,
//                                                         @Field("pageNum") String pageNum, @Field("pageSize") String pageSize,
//                                                         @HeaderMap Map<String, String> headerMap);
//
//    //布置测试，查询模拟套卷列表
//    @FormUrlEncoded
//    @POST(API.MONIPAPERLIST)
//    Observable<BaseBean<List<MoniPaperListBean>>> getMoniPaperList(@Field("uuid") String uuid, @Field("knowledgeId") String knowledgeId,
//                                                                   @Field("categoryId") String categoryId, @HeaderMap Map<String, String> headerMap);
//
//    //查询作业或者测试列表
//    @FormUrlEncoded
//    @POST(API.REPORTLIST)
//    Observable<BaseBean<ReportListBean>> getReportList(@Field("uuid") String uuid, @Field("pageNum") String pageNum, @Field("pageSize") String pageSize,
//                                                       @HeaderMap Map<String, String> headerMap);
//
//    //获得错误率
//    @FormUrlEncoded
//    @POST(API.GETWRONGRATE)
//    Observable<BaseBean<String>> getWrongRate(@Field("uuid") String uuid, @HeaderMap Map<String, String> headerMap);
//
//    //更新错误率
//    @FormUrlEncoded
//    @POST(API.UPDATEWRONGRATE)
//    Observable<BaseBean<String>> updateWrongDate(@Field("uuid") String uuid, @Field("wrongRate") String wrongRate, @HeaderMap Map<String, String> headerMap);
//
//    //催作业/测试
//    @FormUrlEncoded
//    @POST(API.URGEHOMEWORK)
//    Observable<BaseBean<String>> urgeHomework(@Field("uuid") String uuid, @Field("assignId") String assignId);
//
//    //作业/测试所有学生
//    @FormUrlEncoded
//    @POST(API.CORRECTSTUDENTLIST)
//    Observable<BaseBean<List<CorrectStudentBean>>> correctStudentList(@Field("assignId") String assignId);
//
//    //保存当前批改到那个学生的位置
//    @FormUrlEncoded
//    @POST(API.SAVECURRENTSTUDENT)
//    Observable<BaseBean<String>> saveCurrentStudent(@Field("uuid") String uuid, @Field("assignId") String assignId, @Field("studentId") String studentId);
//
//    //获取学生的需要批改的题的列表
//    @FormUrlEncoded
//    @POST(API.GETCORRECTQUESTIONLIST)
//    Observable<BaseBean<List<CorrectQuestionBean>>> getCorrectQuestionList(@Field("uuid") String uuid,
//                                                                           @Field("assignId") String assignId, @Field("userId") String userId);
//
//    //学生的上传主观题图片信息
//    @FormUrlEncoded
//    @POST(API.GETCORRECTPIC)
//    Observable<BaseBean<CorrectPicBean>> getCorrectPic(@Field("assignId") String assignId, @Field("userId") String userId);
//
//    //当批改完一个学生的答案的，将批改的信息上传
//    @POST(API.SUBMITCORRECTINFO)
//    Observable<BaseBean<String>> submitCorrectInfo(@Body CorrectSubmitInfoBean correctSubmitInfoBean);
//
//    //当批改完一个学生的答案的，将批改的信息上传
//    @POST(API.EDU_SUBMITCORRECTINFO)
//    Observable<BaseBean<String>> submitEduCorrectInfo(@Body CorrectSubmitInfoBean correctSubmitInfoBean);
//
////    作业和测试的接口  end
//
//
//    //    新版作业和测试的接口  start
//    //批改界面获取图片列表
//    @GET(API.server + API.CORRECT_PICS)
//    Observable<BaseBean<CorrectPicBean1>> getCorrectPics(@Path("userId") String userId, @Path("assignId") String assignId);
//
//    //查询该次批改的学生列表
//    @GET(API.server + API.CORRECT_STUDENTLIST)
//    Observable<BaseBean<CorrectStudentBean1>> getCorrectStudents(@Path("assignId") String assignId);
//
//    //查询当前用户作业测试列表
//    @GET(API.server + API.CORRECT_LIST)
//    Observable<BaseBean<CorrectListBean1>> getCorrectLists(@Path("uuid") String uuid, @Query("type") String type, @Query("endDate") String endDate);
//
//    //上传图片录音
////    @Multipart
////    @POST(API.server + API.CORRECT_UPLOADAUDIO)
////    Observable<BaseBean<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>> uploadAudio(@Part() MultipartBody.Part file, @Path("uuid") String uuid,
////                                                                                           @Path("assignId") String assignId, @Query("userId") String userId,
////                                                                                           @Query("pictureId") String pictureId, @Query("duration") String duration,
////                                                                                           @HeaderMap Map<String, String> headerMap);
//    //上传图片录音
//    @Multipart
//    @POST(API.server + API.CORRECT_UPLOADAUDIO)
//    Observable<BaseBean<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>> uploadAudio(
//            @PartMap() Map<String, RequestBody> partMap, @Part() MultipartBody.Part file, @Path("uuid") String uuid, @Path("assignId") String assignId);
//
//    //删除图片录音
//    @DELETE(API.server + API.CORRECT_DELETEAUDIO)
//    Observable<BaseBean<List<CorrectPicBean1.AnswerFieldsBean.AudioListBean>>> deleteAudio(@Path("assignId") String assignId, @Query("userId") String userId,
//                                                                                           @Query("pictureId") String pictureId, @Query("audioId") String audioId);
//
//    //查询该次学生的批改结果
//    @GET(API.server + API.CORRECT_PROBLEMLIST)
//    Observable<BaseBean<List<CorrectQuestionBean>>> getCorrectProblemList(@Path("uuid") String uuid, @Path("assignId") String assignId, @Query("userId") String userId);
//
//    //学生的上传主观题图片信息
//    @Multipart
//    @POST(API.server + API.CORRECT_UPLOADPIC)
//    Observable<BaseBean<CorrectUploadPicBean>> correct_uploadPic(@Part() MultipartBody.Part file, @Query("uuid") String uuid);
//
//    //当批改完一个学生的答案的，将批改的信息上传
//    @POST(API.server + API.CORRECT_UPLOADRECORD)
//    Observable<BaseBean<String>> submitCorrectRecord(@Body CorrectSubmitInfoBean1 correctSubmitInfoBean1);
//
//    //批改完成，点击结束批改的时候进行调用
//    @POST(API.server + API.CORRECT_FINISHCORRECT)
//    Observable<BaseBean<String>> finishThisCorrect(@Path("assignId") String assignId, @Query("uuid") String uuid);
//
//    //切换学生保存批改标志
//    @POST(API.server + API.CORRECT_EXCHANGESTUDENT)
//    Observable<BaseBean<String>> exchangeStudent(@Path("userId") String userId, @Path("assignId") String assignId);
//
//    //判断是否可以执行批改操作
//    @GET(API.server + API.CORRECT_CAN)
//    Observable<BaseBean<String>> doCorrect(@Path("assignId") String assignId);
//
//    //作业测试报告列表
//    @GET(API.server + API.REPORT_LIST)
//    Observable<BaseBean<ReportListBean1>> getReportLists(@Path("uuid") String uuid, @Query("endDate") String endDate, @Query("type") String type);
//
//    //报告部分的讲评提醒
//    @PUT(API.server + API.REPORT_REMIND)
//    Observable<BaseBean<String>> remindReport(@Path("assignId") String assignId, @Query("questionId") String questionId, @Query("groupCode") String groupCode, @Query("comment") String comment);
//

//    新版作业和测试的接口  end


}
