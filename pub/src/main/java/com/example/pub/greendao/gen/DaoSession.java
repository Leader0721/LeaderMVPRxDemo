package com.example.pub.greendao.gen;

import com.example.pub.bean.AppVersion;
import com.example.pub.bean.TeacherBaseInfo;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;



/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig appVersionDaoConfig;
    private final DaoConfig teacherBaseInfoDaoConfig;

    private final AppVersionDao appVersionDao;
    private final TeacherBaseInfoDao teacherBaseInfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        appVersionDaoConfig = daoConfigMap.get(AppVersionDao.class).clone();
        appVersionDaoConfig.initIdentityScope(type);

        teacherBaseInfoDaoConfig = daoConfigMap.get(TeacherBaseInfoDao.class).clone();
        teacherBaseInfoDaoConfig.initIdentityScope(type);

        appVersionDao = new AppVersionDao(appVersionDaoConfig, this);
        teacherBaseInfoDao = new TeacherBaseInfoDao(teacherBaseInfoDaoConfig, this);

        registerDao(AppVersion.class, appVersionDao);
        registerDao(TeacherBaseInfo.class, teacherBaseInfoDao);
    }
    
    public void clear() {
        appVersionDaoConfig.clearIdentityScope();
        teacherBaseInfoDaoConfig.clearIdentityScope();
    }

    public AppVersionDao getAppVersionDao() {
        return appVersionDao;
    }

    public TeacherBaseInfoDao getTeacherBaseInfoDao() {
        return teacherBaseInfoDao;
    }

}
