package com.example.pub.greendao;

import com.example.pub.bean.TeacherBaseInfo;
import com.example.pub.common.MyApplication;
import com.example.pub.greendao.gen.GreenDaoManager;
import com.example.pub.greendao.gen.TeacherBaseInfoDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * description 教师数据库帮助类
 * author hanlei
 * version 1.0
 * created at 2016/11/24 11:09
 */
public class TeacherDaoHelper {

    private static TeacherDaoHelper mInstance;

    TeacherBaseInfoDao teacherBaseInfoDao;

    public TeacherDaoHelper(){
        teacherBaseInfoDao = GreenDaoManager.getInstance().getSession().getTeacherBaseInfoDao();
    }


    public static TeacherDaoHelper getInstance() {

        if (mInstance == null) {
            mInstance = new TeacherDaoHelper();
        }
        return mInstance;
    }

    /**
     * 插入当前用户信息
     * @param teacherBaseInfo
     */
    public void insertBaseInfo(TeacherBaseInfo teacherBaseInfo){

        if (null == teacherBaseInfo){
            return;
        }

        TeacherBaseInfo teacherBean = findBaseInfo();

        if (teacherBean == null){
            teacherBaseInfo.setUuid(MyApplication.getUUID());
            teacherBaseInfoDao.insert(teacherBaseInfo);
        }
    }

    /**
     * 查找当前用户
     * @return
     */
    public TeacherBaseInfo findBaseInfo(){

        QueryBuilder qb = teacherBaseInfoDao.queryBuilder();
        qb.where(TeacherBaseInfoDao.Properties.Uuid.eq(MyApplication.getUUID()));
        List<TeacherBaseInfo> teacherBaseInfoList = qb.list();
        if (!teacherBaseInfoList.isEmpty()){
            return teacherBaseInfoList.get(0);
        }
        return null;
    }

    /**
     * 更新当前用户
     * @param teacherBaseInfo
     */
    public void updateBaseInfo(TeacherBaseInfo teacherBaseInfo){

        if (null == teacherBaseInfo){
            return;
        }

        TeacherBaseInfo teacherBean = findBaseInfo();
        if (teacherBean != null){
            teacherBaseInfo.setUuid(MyApplication.getUUID());
            teacherBaseInfoDao.update(teacherBaseInfo);

        }
    }

    /**
     * 删除当前用户
     */
    public void deleteBaseInfo(){

        TeacherBaseInfo teacherBean = findBaseInfo();
        if (teacherBean != null){
            teacherBaseInfoDao.deleteByKey(teacherBean.getId());
        }
    }
}
























