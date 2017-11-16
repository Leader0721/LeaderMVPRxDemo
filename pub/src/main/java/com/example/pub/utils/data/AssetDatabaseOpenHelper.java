package com.example.pub.utils.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:1.复制可读写的数据库 2.复制只能读的数据库
 * 3.获取数据库名
 * @Prject:
 * @Package: com.example.pub.utils.data
 * @author: Leader
 * @date: 2017/11/16   15:31
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * 使用:
 * AssetDatabaseOpenHelper ad=new AssetDatabaseOpenHelper(context,dbName);
 * ad.getWritableDatabase();
 */

public class AssetDatabaseOpenHelper {
    private Context context;
    private String databaseName;

    public AssetDatabaseOpenHelper(Context context, String databaseNme) {
        this.context = context;
        this.databaseName = databaseName;
    }

    /**
     * Create and/or open a database that will be used for reading and writing.
     *
     * @return SQLiteDatabase对象
     * @throws RuntimeException if cannot copy database from assets
     * @throws SQLiteException  if the database cannot be opened
     */
    public synchronized SQLiteDatabase getWritableDatabase() {
        File dbFile = context.getDatabasePath(databaseName);
        if (dbFile != null && !dbFile.exists()) {
            try {
                copyDatabase(dbFile);
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        assert dbFile != null;
        return SQLiteDatabase.openDatabase(dbFile.getPath(), null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * Create and/or open a database that will be used for reading only.
     *
     * @return SQLiteDatabase对象
     * @throws RuntimeException if cannot copy database from assets
     * @throws SQLiteException  if the database cannot be opened
     */
    public synchronized SQLiteDatabase getReadableDatabase() {
        File dbFile = context.getDatabasePath(databaseName);
        if (dbFile != null && !dbFile.exists()) {
            try {
                copyDatabase(dbFile);
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null,
                SQLiteDatabase.OPEN_READONLY);
    }

    /**
     * 获取数据库名称
     *
     * @return the database name
     */
    public String getDatabaseName() {
        return databaseName;
    }

    private void copyDatabase(File dbFile) throws IOException {
        InputStream stream = context.getAssets().open(databaseName);
        FileUtils.writeFileFromIS(dbFile.getPath(), stream, false);
        stream.close();
    }
}
