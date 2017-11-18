package com.example.pub.net;


/**
 * description 在此定义API
 * author hanlei
 * version 1.0
 * created at 2016/11/14 10:27
 */
public class API {

    // 测试URL
    public static String TEST_HOST = "http://whdx.bcbook.cn/";
    // 开发URL
    public static String DEV_HOST = "http://dev.bcbook.cn/";
    //    public static String DEV_HOST = "http://192.168.10.36:8088/"; //彭玲玲本机地址
//    public static String DEV_HOST = "http://192.168.10.154:8080/"; //任统帅本机地址
    // 发布URL
    public static String RELEASE_HOST = "https://www.wuhaodaoxue.com/";


    // 开发MPUSH的URL
    public static String DEV_PUSH_HOST = "http://192.168.50.8:9999";
    // 测试MPUSH的URL
    public static String TEST_PUSH_HOST = "http://192.168.50.11:9999";
    // 发布MPUSH的URL
    public static String RELEASE_PUSH__HOST = "http://www.wuhaodaoxue.com:9999";

    // mPush接口URL
    public static String MPUSH_HOST = RELEASE_PUSH__HOST;

    // 接口URL
    public static String HOST = getURL(BaseConfig.TEST, true); // "http://192.168.10.60:8080/";//getURL(BaseConfig.TEST, true);
    //服务器地址，为restful类型的接口提供
    public static final String server = "http://whdx.bcbook.cn/";//测试
//    public static final String server = "http://dev.bcbook.cn/";//开发
//    public static final String server = "http://192.168.10.36:8088/";//彭玲玲本机地址
//    public static final String server = "http://192.168.10.154:8080/"; //任统帅本机地址
//    public static final String server = "https://www.wuhaodaoxue.com/";//生产

    public static String VERSION_NAME = "";


    /**
     * 接口配置
     *
     * @param environment 环境 开发:BaseConfig.DEV  |  测试:BaseConfig.TEST  | 生产:BaseConfig.RELEASE
     * @param isPrintLog  是否打印网络请求日志 true的优先级高于environment
     * @return
     */


    public static String getURL(int environment, boolean isPrintLog) {

        BaseConfig.PRENTF_LOG = isPrintLog;
        String host = DEV_HOST;
        BaseConfig.ENVIRONMENT = environment;

        switch (environment) {

            case BaseConfig.DEV: {
                host = DEV_HOST;
                MPUSH_HOST = DEV_PUSH_HOST;
                VERSION_NAME = " 开发版";
            }
            break;

            case BaseConfig.RELEASE: {
                host = RELEASE_HOST;
                MPUSH_HOST = RELEASE_PUSH__HOST;
                VERSION_NAME = " 发布版";
            }
            break;

            case BaseConfig.TEST: {
                host = TEST_HOST;
                MPUSH_HOST = TEST_PUSH_HOST;
                VERSION_NAME = " 测试版";
            }
            break;
        }

        return host;
    }

//
//    // 备课接口 start
//
//    // 获取用户的网络信息保存到服务器
//    public static final String SET_USER_NET_INFO = "pad/teacher/educate/getUserNetInfo";
//    // 随堂练习客观题提交情况
//    public static final String QUESTION_DETAIL = "pad/teacher/educate/getObjectQuestionDetail";
//    // 教师互批作业
//    public static final String EACH_OTHER_CORRECT = "pad/teacher/educate/pushOtherCorrect";
//    // 教师结束练习
//    public static final String STOP_PRACTICE = "pad/teacher/educate/stopPractice";
//    // 教师结束互批
//    public static final String STOP_EO_CORRECT = "pad/teacher/educate/stopOtherCorrect";
//    // 教师提交情况
//    public static final String LESS_WK_COUNT = "pad/teacher/educate/getPracticeCount";
//    // 教师推送素材
//    public static final String PUSH_RES = "pad/teacher/educate/pushMaterial";
//    // 教师推送自己上传的资源
//    public static final String PUSH_RES_SELF = "pad/teacher/educate/pushSelfUploadRes";
//    // 教师推送试卷
//    public static final String PUSH_HOME_WORK = "pad/teacher/educate/pushHomeWork";
//    // 检测教师是否在上课
//    public static final String CHECK_ON_CLASS = "pad/teacher/educate/checkTeacherState";
//    // 获得在线人数列表
//    public static final String ONLINE_STUDENTS = "pad/teacher/educate/getOnlineStudent";
//    // 教师开始上课
//    public static final String START_CLASS = "pad/teacher/educate/startClass";
//    // 教师下课
//    public static final String END_CLASS = "pad/teacher/educate/endClass";
//    // 教师锁屏
//    public static final String CLOSSS_SCREEN = "pad/teacher/educate/closeScreen";
//    // 教师解锁
//    public static final String OPEN_SCREEN = "pad/teacher/educate/openScreen";
//
//    // 可以推荐的班级（必须登录一个用户）
//    public static final String RECOMMEND_LIST = "pad/common/res/recommend/class";
//    // 资源推荐（必须登录一个用户）
//    public static final String RECOMMEND = "pad/common/res/recommend";
//    // 教师推送图片
//    public static final String PUSH_PICTURE = "pad/teacher/educate/pushPicture";
//    // 上传文件，音频，课件，图片，文档
//    public static final String UPLOAD_FILE = "pad/teacher/prepare/customUpload/uploadFile";
//    // 上传视频
//    public static final String UPLOAD_VIDEO = "pad/teacher/prepare/customUpload/uploadVideo";
//    //获得回调url
//    public static final String GET_URL = "pad/teacher/prepare/customUpload/getNotifyUrl";
//    // 教师获取知识点树
//    public static final String GET_KNOWLEDGE = "pad/teacher/prepare/resourse/knowledgetree";
//    // 根据课程获得对应的章节知识点
//    public static final String GET_KNOWLEDGE_BY_ID = "pad/teacher/prepare/resourse/knowledgetreeById";
//    // 添加资源库资源到课程
//    public static final String ADD_COURSE_RESOURSE = "pad/teacher/courseResourse/addCourseResourse";
//    // 获取英语单词数据
//    public static final String EN_WORDS_DETAIL = "pad/teacher/prepare/audio/word/detail";
//    // 课程对应的资源列表
//    public static final String GET_COURSE_RESOURSE = "pad/teacher/courseResourse/getCourseResourses";
//    // 上课对应的资源列表
//    public static final String GET_ONLINE_RESOURSE = "pad/teacher/educate/getCourseResourseList";
//    // 课程资源列表的排序
//    public static final String SET_COURSE_RESOURSE_SORT = "pad/teacher/courseResourse/setCourseResourseSortAndDel";
//    // 获得某个菜单下的所有栏目
//    public static final String GET_RESOURSE_TYPES = "pad/teacher/prepare/resourse/getResourseTypes ";
//
//    // 获得目录下面的所有课程
//    public static final String PRE_LESS_COURSE_LIST = "pad/teacher/course/getCourseByknowledge";
//    // 获得某个目录下的所有课件资源 /teacher/prepare/practice
//    public static final String PRE_LESS_COUREWARE = "pad/teacher/prepare/Coureware/getCoureware";
//    // 获得某个目录下的所有视频资源
//    public static final String PRE_LESS_VIDEOS = "pad/teacher/prepare/video/getVideos";
//    // 获取英语单词的栏目
//    public static final String PRE_LESS_EN_AUDIOS = "pad/teacher/prepare/audio/category";
//    // 获得视频
//    public static final String PRE_LESS_VIDEO_INFO = "pad/teacher/prepare/video/video/play";
//    // 获得素材图片
//    public static final String PRE_LESS_SRC_IMAGE = "pad/teacher/prepare/SourceMaterials/getImage";
//    // 获得素材音频
//    public static final String PRE_LESS_SRC_AUDIO = "pad/teacher/prepare/SourceMaterials/getAudio";
//    // 获得语文素材音频
//    public static final String PRE_LESS_ARTICLE_CH = "pad/teacher/prepare/audio/ch/article";
//    // 获得英语素材音频
//    public static final String PRE_LESS_ARTICLE_EN = "pad/teacher/prepare/audio/en/article";
//    // 获得某个目录下的所有素材资源
//    public static final String PRE_LESS_MATERIALS = "pad/teacher/prepare/SourceMaterials/getSourceMaterials";
//    // 获得某个目录下的所有随堂练习
//    public static final String PRE_LESS_PRACTICES = "pad/teacher/prepare/practice/getPractice";
//
//    // 在线预览接口(自主上传的时候，参数为resFileId)
//    public static final String ONLINE_VIEW_BY_FILE = "pad/common/office/onlineViewFile";
//    // 在线预览接口(系统资源的时候，参数 resId)
//    public static final String ONLINE_VIEW_NAME = "pad/common/office/onlineViewRes";
//
//    // 添加课程
//    public static final String PRE_LESS_COURSE_ADD = "pad/teacher/course/add";
//    // 删除课程
//    public static final String PRE_LESS_COURSE_DEL = "pad/teacher/course/delete";
//    // 修改课程
//    public static final String PRE_LESS_COURSE_UPDATE = "pad/teacher/course/update";
//
//
//    // 备课接口 end
//    // app版本
//    public static final String COMMON_APP_VERSION = "pad/user/appVersion";
//
//
//    // 文件下载接口
//    public static final String FILE_LOAD = "pad/common/download";
//
//    // 用户账户个人中心接口 start
//
//    // 登录接口
//    public static final String USER_LOGIN = "pad/user/login";
//    // 重置密码-获取验证码
//    public static final String RESET_PASSWORD_MESSAGE = "pad/user/forget/pwd/mobile";
//    // 校验验证码是否正确
//    public static final String CHECK_SMS = "pad/user/forget/pwd/mobileAndsms";
//    // 重置密码
//    public static final String RESET_PASSWORD = "pad/user/forget/pwd/updateByMobile";
//    // 获取老师基本资料
//    public static final String CENTER_BASEINFO = "pad/teacher/center/info";
//    // 更换头像
//    public static final String CHANGE_PORTRAIT = "pad/user/update/headimg";
//    // 修改密码
//    public static final String UPDATE_PASSWORD = "pad/user/safe/resetpwd";
//    // 绑定手机号发送验证码
//    public static final String BIND_PHONENUM_SMS = "pad/user/info/mobilesms";
//    // 绑定手机号
//    public static final String BIND_PHONENUM = "pad/user/safe/bindMobile";
//    // 修改手机号发送验证码
//    public static final String CHANGE_PHONENUM_SMS = "pad/user/safe/smscode";
//    // 更换手机号
//    public static final String CHANGE_PHONENUM = "pad/user/safe/updatemobile";
//    // 获取出版社列表
//    public static final String GET_PRESS = "pad/common/press";
//    // 获取教材
//    public static final String GET_MATERIAL = "pad/common/material";
//    // 修改教材
//    public static final String UPDATE_MATERIAL = "pad/common/updateMaterial";
//    // 系统消息列表
//    public static final String GET_SYSTEM_MESSAGE = "pad/user/teacherMessage";
//    // 系统消息操作
//    public static final String SET_SYSTEM_MESSAGE = "pad/user/appDelMessage";
//    // 申请消息列表
//    public static final String GET_APPLY_MESSAGE = "pad/user/appUserMessage";
//    // 申请消息操作同意
//    public static final String SET_APPLY_MSG_YES = "pad/user/appMessageApplyAgree";
//    // 申请消息操作拒绝
//    public static final String SET_APPLY_MSG_NO = "pad/user/appMessageApplyRefuse";
//    // 申请消息操作删除
//    public static final String SET_APPLY_MSG_DEL = "pad/user/appDelApplyMessage";
//    // 教师系统消息未读数量
//    public static final String SYS_MSG_UNREAD_COUNT = "pad/user/appTeacherSysNotMessageSize";
//    // 教师申请消息未读数量
//    public static final String APPLY_MSG_UNREAD_COUNT = "pad/user/appTeacherUserNotMessageSize";
//    // 消息未操作条数
//    public static final String GET_MESSAGE_NUM = "pad/user/appTeacherUserMessageSize";
//    // 保存用户意见
//    public static final String SUGGESTION = "pad/teacher/center/suggestion";
//
//    // 用户账户个人中心接口 end
//
//    // 拓展提升的接口   start
//
//    // 文章推荐的班级
//    public static final String ARTCLE_RECOM_CLASS = "pad/teacher/catlogarticle/allClass";
//    // 资源推荐（必须登录一个用户）
//    public static final String COMMON_RECOMMEND2CLS = "pad/teacher/catlogarticle/recommend";
//
//    // H5页面地址:
//    //美文
//    public static String ARTCLE_ESSAY = HOST + "padh5/model/extend/essay.html?uuid=%s&codeId=%s";
//    //国学
//    public static String ARTCLE_CHINESE = HOST + "padh5/model/extend/chinese.html?uuid=%s&codeId=%s";
//    //期刊
//    public static String ARTCLE_MAGZINE = HOST + "padh5/model/extend/magzine.html?uuid=%s&codeId=%s";
//    //拓展学习
//    public static String ARTCLE_MATH = HOST + "padh5/model/extend/math.html?uuid=%s&codeId=%s";
//    //走遍英美
//    public static String ARTCLE_ENGREAD = HOST + "padh5/model/extend/engread.html?uuid=%s&codeId=%s";
//    //预习测试
//    public static String PREPARE_TEST = HOST + "padh5/model/prepare/preparetest.html?uuid=%s&resId=%s";
//    //查看试卷
//    public static String PRACTICE_PAPER = HOST + "padh5/model/practice/practicepaper.html?uuid=%s&paperId=%s";
//    //编辑试卷
//    public static String PRACTICE_EDIT = HOST + "padh5/model/practice/practiceedit.html?uuid=%s&courseId=%s";
//    //随堂练习客观题答案
//    public static String PRACTICE_OBJ_DETAIL = HOST + "padh5/model/teach/objectresult.html?uuid=%s&paperAssignId=%s&questionId=%s&selectable=%s&s=%s";
//    //添加题目
//    public static String PRACTICE_ADD = HOST + "padh5/model/practice/addpractice.html?uuid=%s&categoryId=%s&knowledgeId=%s&courseId=%s";
//
//    //从课时练 分层作业等调到H5界面
//    public static String H5_KESHILIAN = HOST + "padh5/model/JobTest/TestPaper.html";
//    //从已经布置的测试和作业调到H5界面
//    public static String H5_ASSIGN = HOST + "padh5/model/JobTest/englishPaper.html";
//    //从模拟套卷界面调到H5界面
//    public static String H5_MONIPAPER = HOST + "padh5/model/JobTest/volume.html";
//
//
//    //跳转到错题本界面
//    public static String H5_WRONGNOTE = HOST + "padh5/model/wrongnote/wrongnote.html";
//    //跳转到阅读作业名称界面
//    public static String H5_REPORTREADING = HOST + "padh5/model/JobTest/ReadingReport.html";
//    //跳转到预习界面
//    public static String H5_REPORTPREVIEW = HOST + "padh5/model/JobTest/PreviewReport.html";
//    //跳转到作业界面
//    public static String H5_REPORTWORK = HOST + "padh5/model/workreport/index.html";
//    //跳转到测试界面
//    public static String H5_REPORTTEST = HOST + "padh5/model/testpaper/index.html";
//    //跳转到班级管理测试界面
//    public static String H5_CLASSMANAGE_TEST = HOST + "padh5/model/classmanage/testreport.html";
//    //跳转到班级管理作业界面
//    public static String H5_CLASSMANAGE_WORK = HOST + "padh5/model/classmanage/workreport.html";
//    //跳转到题目答案界面
//    public static String H5_CORRECT_QUESTIONANSWER = HOST + "padh5/model/JobTest/CorrecAnswer.html";
//    // 拓展提升的接口   end
//
//
//    //新版作业和测试部分   start
//    //跳转到答案界面
//    public static String H5_CORRECT_NEW_ANSWER = HOST + "padh5/model/MyAnswer1.1/AnswerCorrect1.1.html";
//    //预习报告
//    public static String H5_CORRECT_NEW_PREREPORT = HOST + "padh5/model/JobTest/PreviewReport1.1.html";
//    //阅读报告
//    public static String H5_CORRECT_NEW_READINGREPORT = HOST + "padh5/model/JobTest/ReadingReport1.1.html";
//    //作业报告
//    public static String H5_CORRECT_NEW_WORKREPORT = HOST + "padh5/model/workReport1.1/reportIndex.html";
//    //参考讲评
//    public static String H5_CORRECT_NEW_REFERENCE = HOST + "padh5/model/workReport1.1/Reference.html";
//    //学生个人详情
//    public static String H5_CORRECT_NEW_DETAIL = HOST + "padh5/model/workReport1.1/everyOneReport.html";
//    //原文没有音频条
//    public static String H5_ARTICLE_NOAUDIO = HOST + "padh5/model/extend/comart.html";
//    //原文有音频条
//    public static String H5_ARTICLE_WITHAUDIO = HOST + "padh5/model/extend/engart.html";
//
//
//    //新版作业和测试部分   end
//
//
//    public static void initH5API() {
//
//        //美文
//        ARTCLE_ESSAY = HOST + "padh5/model/extend/essay.html?uuid=%s&codeId=%s";
//        //国学
//        ARTCLE_CHINESE = HOST + "padh5/model/extend/chinese.html?uuid=%s&codeId=%s";
//        //期刊
//        ARTCLE_MAGZINE = HOST + "padh5/model/extend/magzine.html?uuid=%s&codeId=%s";
//        //拓展学习
//        ARTCLE_MATH = HOST + "padh5/model/extend/math.html?uuid=%s&codeId=%s";
//        //走遍英美
//        ARTCLE_ENGREAD = HOST + "padh5/model/extend/engread.html?uuid=%s&codeId=%s";
//        //预习测试
//        PREPARE_TEST = HOST + "padh5/model/prepare/preparetest.html?uuid=%s&resId=%s";
//        //查看试卷
//        PRACTICE_PAPER = HOST + "padh5/model/practice/practicepaper.html?uuid=%s&paperId=%s";
//        //编辑试卷
//        PRACTICE_EDIT = HOST + "padh5/model/practice/practiceedit.html?uuid=%s&courseId=%s";
//        //随堂练习客观题答案
//        PRACTICE_OBJ_DETAIL = HOST + "padh5/model/teach/objectresult.html?uuid=%s&paperAssignId=%s&questionId=%s&selectable=%s&s=%s";
//        //添加题目
//        PRACTICE_ADD = HOST + "padh5/model/practice/addpractice.html?uuid=%s&categoryId=%s&knowledgeId=%s&courseId=%s";
//
//        //从课时练 分层作业等调到H5界面
//        H5_KESHILIAN = HOST + "padh5/model/JobTest/TestPaper.html";
//        //从已经布置的测试和作业调到H5界面
//        H5_ASSIGN = HOST + "padh5/model/JobTest/englishPaper.html";
//        //从模拟套卷界面调到H5界面
//        H5_MONIPAPER = HOST + "padh5/model/JobTest/volume.html";
//        //跳转到错题本界面
//        H5_WRONGNOTE = HOST + "padh5/model/wrongnote/wrongnote.html";
//        //跳转到阅读作业名称界面
//        H5_REPORTREADING = HOST + "padh5/model/JobTest/ReadingReport.html";
//        //跳转到预习界面
//        H5_REPORTPREVIEW = HOST + "padh5/model/JobTest/PreviewReport.html";
//        //跳转到作业界面
//        H5_REPORTWORK = HOST + "padh5/model/workreport/index.html";
//        //跳转到测试界面
//        H5_REPORTTEST = HOST + "padh5/model/testpaper/index.html";
//        //跳转到班级管理测试界面
//        H5_CLASSMANAGE_TEST = HOST + "padh5/model/classmanage/testreport.html";
//        //跳转到班级管理作业界面
//        H5_CLASSMANAGE_WORK = HOST + "padh5/model/classmanage/workreport.html";
//        //跳转到题目答案界面
//        H5_CORRECT_QUESTIONANSWER = HOST + "padh5/model/JobTest/CorrecAnswer.html";
//
//
//        //新版作业和测试部分   start
//        //跳转到答案界面
//        H5_CORRECT_NEW_ANSWER = HOST + "padh5/model/MyAnswer1.1/AnswerCorrect1.1.html";
//
//        //预习报告
//        H5_CORRECT_NEW_PREREPORT = HOST + "padh5/model/JobTest/PreviewReport1.1.html";
//
//        //阅读报告
//        H5_CORRECT_NEW_READINGREPORT = HOST + "padh5/model/JobTest/ReadingReport1.1.html";
//
//        //作业报告
//        H5_CORRECT_NEW_WORKREPORT = HOST + "padh5/model/workReport1.1/reportIndex.html";
//
//        //参考讲评
//        H5_CORRECT_NEW_REFERENCE = HOST + "padh5/model/workReport1.1/Reference.html";
//
//        //学生个人详情
//        H5_CORRECT_NEW_DETAIL = HOST + "padh5/model/workReport1.1/everyOneReport.html ";
//        //新版作业和测试部分   end
//    }
//
//    // 班级管理的接口   start
//    // 用户根据班级码搜索班级
//    public static final String CLASS_SEARCH = "pad/teacher/class/search";
//    // 根据提供的班级ID加入班级
//    public static final String CLASS_JOIN = "pad/teacher/class/join";
//    // 获取已经创建的班级
//    public static final String CREATEDCLASS_LIST = "pad/teacher/class/exist";
//    // 还能创建几个班级
//    public static final String CLASS_LEFT_NUMBER = "pad/teacher/class/class/size";
//    // 根据提供的年级ID，班级名称创建班级
//    public static final String CLASS_CREATE = "pad/teacher/class/create";
//    // 获取班级列表
//    public static final String CLASS_LIST = "pad/teacher/class/list";
//    // 获取班级信息
//    public static final String CLASS_DETAIL = "pad/teacher/class/getDetail";
//    // 删除班级成员
//    public static final String DELETE_CLASSMEMBER = "pad/teacher/class/group/deleteClassMember";
//    // 设置某个老师为班主任
//    public static final String CLASS_TEACHER_SET = "pad/teacher/class/teacher/set";
//    // 老师解散班级
//    public static final String CLASS_TEACHER_DISSOLVE = "pad/teacher/class/teacher/dissolve";
//    // 解散小组
//    public static final String DISSOLVE_GROUP = "pad/teacher/class/group/delete";
//
//    // 更新小组信息(成员和名称)
//    public static final String UPDATEGROUP = "pad/teacher/class/group/update";
//
//    // 创建小组
//    public static final String CREATE_GROUP = "pad/teacher/class/group/create";
//
//    // 检查是否可以引用班主任的小组
//    public static final String CHECKHEADER = "pad/teacher/class/group/checkHeader";
//    // 引用班主任的小组
//    public static final String USEHEADER = "pad/teacher/class/group/useHeader";
//    // 老师退出班级
//    public static final String EXITCLASS = "pad/teacher/class/teacher/exit";
//    // 根据班级Id获取当前班级的所有的学生的信息
//    public static final String GETSTUDENTINFO = "pad/teacher/class/student";
//
//    // 不同老师获取测试的列表
//    public static final String REPORTTEST = "pad/teacher/class/report/test";
//    // 获取30天内未提交的人员和次数
//    public static final String UNSUBMIT = "pad/teacher/class/report/unsubmit";
//
//    // 不同老师获取作业的列表
//    public static final String REPORTWORK = "pad/teacher/class/report/work";
//
//    //查看当前用户的年级
//    public static final String GET_GRADE = "pad/teacher/class/current/grade";
//
//    // 班级管理接口    end
//
//
//    //    作业和测试的接口  start
//    // 获取作业，测试和错题本的知识点
//    public static final String KNOWLEDGETREE = "pad/common/teacher/knowledgetree";
//    //查询栏目类型
//    public static final String ASSIGNTYPES = "pad/teacher/paper/assign/types";
//    //获取作业和测试列表
//    public static final String ASSIGNLIST = "pad/teacher/paper/assign/paperslist";
//    //获取菜单最后查看的记录名称列表
//    public static final String GETLASTNAMELIST = "pad/common/teacherandstudent/getLastNameList";
//    //获取错题本菜单最后查看的记录名称列表
//    public static final String GETWRONGBOOKLASTNAMELIST = "pad/common/teacherandstudent/getWrongBookLastList";
//    //保存菜单最后查看的记录
//    public static final String SAVELASTCODE = "pad/common/teacherandstudent/savelastcode";
//    //删除一条未布置的作业、测试记录
//    public static final String DELETEASSIGN = "pad/teacher/paper/assign/delete";
//    //根据布置ID和类型查询对象列表
//    public static final String GETASSIGNOBJLIST = "pad/teacher/paper/assign/getAssignObjList";
//    //布置作业、测试，查询布置对象班级
//    public static final String ASSIGNCLASS = "pad/teacher/paper/assign/assignclass";
//    //布置作业、测试，查询布置对象小组
//    public static final String ASSIGNGROUP = "pad/teacher/paper/assign/assigngroup";
//    //布置作业、测试，查询布置对象学生
//    public static final String ASSIGNINDIVIDUAL = "pad/teacher/paper/assign/assignindividual";
//    // 布置作业、测试，布置给班级
//    public static final String ASSIGN_PAPERS_TO_CLASS = "pad/teacher/paper/assign/assignpaperstoclass";
//    // 布置作业、测试，布置给小组或个人
//    public static final String ASSIGN_PAPERS_TO_GROUP = "pad/teacher/paper/assign/assignpaperstogroup";
//    // 获取批改列表
//    public static final String CORRECTLIST = "pad/teacher/correct/selectCorrect";
//    // 布置测试，查询模拟套卷列表
//    public static final String MONIPAPERLIST = "pad/teacher/paper/assign/simulatepapers";
//    // 作业测试报告列表
//    public static final String REPORTLIST = "pad/teacher/paper/report/homeworkList";
//    // 获取错误率
//    public static final String GETWRONGRATE = "pad/teacher/center/wrongbook/wrongrate";
//    //更新错误率
//    public static final String UPDATEWRONGRATE = "pad/teacher/center/wrongrate";
//    //催作业/测试
//    public static final String URGEHOMEWORK = "pad/teacher/correct/urgeHomework";
//    //作业/测试所有学生的学生列表
//    public static final String CORRECTSTUDENTLIST = "pad/teacher/correct/selectDetails";
//    //保存当前批改到那个学生的位置
//    public static final String SAVECURRENTSTUDENT = "pad/teacher/correct/saveCurrentCorrectFlag";
//    //获取学生的需要批改的题的列表
//    public static final String GETCORRECTQUESTIONLIST = "pad/teacher/correct/selectPaper";
//    //学生的上传主观题图片信息
//    public static final String GETCORRECTPIC = "pad/teacher/correct/selectAnswerPicture";
//    //当批改完一个学生的答案的，将批改的信息上传
//    public static final String SUBMITCORRECTINFO = "pad/teacher/correct/nextStudent";
//    //保存当前批改到那个学生的位置
//    public static final String EDU_SUBMITCORRECTINFO = "pad/teacher/educate/nextStudent";
//
////    作业和测试的接口  end
//
//    //    新版作业和测试的接口   start
//    //当前学生此次布置上传的图片
//    public static final String CORRECT_PICS = "pad/teacher/homework/answerPictures/{userId}/{assignId}";
//    //查询该次批改的学生列表
//    public static final String CORRECT_STUDENTLIST = "pad/teacher/homework/studentList/{assignId}";
//    //查询当前用户作业测试列表
//    public static final String CORRECT_LIST = "pad/teacher/homework/correctList/{uuid}";
//    //删除录音
//    public static final String CORRECT_DELETEAUDIO = "pad/teacher/homework/subjectiveAdvio/{assignId}";
//    //上传图片录音
//    public static final String CORRECT_UPLOADAUDIO = "pad/teacher/homework/picAudio/{uuid}/{assignId}";
//    //查询该次学生的批改结果
//    public static final String CORRECT_PROBLEMLIST = "pad/teacher/homework/resultList/{uuid}/{assignId}";
//    //切换学生保存批改标志
//    public static final String CORRECT_UPLOADPIC = "pad/teacher/homework/correctedPic";
//    //切换图片，保存记录
//    public static final String CORRECT_UPLOADRECORD = "pad/teacher/homework/correctedData";
//    //批改完成，点击结束批改的时候进行调用
//    public static final String CORRECT_FINISHCORRECT = "pad/teacher/homework/correctResult/{assignId}";
//    //切换学生保存批改标志
//    public static final String CORRECT_EXCHANGESTUDENT = "pad/teacher/homework/currentStudent/{userId}/{assignId}";
//    //判断是否可以执行批改操作
//    public static final String CORRECT_CAN = "pad/teacher/homework/correctFlag/{assignId}";
//
//
//    //作业测试报告列表
//    public static final String REPORT_LIST = "pad/teacher/report/reportList/{uuid}";
//    //报告部分的讲评提醒
//    public static final String REPORT_REMIND = "pad/teacher/report/commentRemind/{assignId}";
//

    //    新版作业和测试的接口   end

}

