package com.example.pub.utils.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import com.example.pub.utils.constant.AppInfo;
import com.example.pub.utils.data.CleanUtils1;
import com.example.pub.utils.data.FileUtils;
import com.example.pub.utils.function.EncryptUtils;
import com.example.pub.utils.function.LogUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.pub.utils.function.StringUtils.isSpace;

/**
 * @Description:1.获取App信息/所有已安装App信息 2.清除App数据
 * 3.判断App是否处于前台(必须是系统应用)
 * 4.判断是否为系统App/APP是否安装
 * 5.获取App版本号/版本名称/版本码/Icon/包名/路径/签名/32位签名/SHA1值
 * 6.安装/卸载/打开 app
 * 7.静默安装/卸载 app (需要权限)
 * 8.gc 清除进程,服务
 * 9.得到最大内存
 * 10.Service 是否运行
 * 11.停止Service
 * 12.是否包含当前进程
 * 13.是否Dalvik模式/ART模式
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:16
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */


public class AppUtils {

    /**
     * 获取应用的 SHA1 值， 可据此判断高德，百度地图 key 是否正确
     *
     * @return 应用的 SHA1 字符串, 比如： 53:FD:54:DC:19:0F:11:AC:B5:22:9E:F1:1A:68:88:1B:8B:E8:54:42
     */
    public static String getSHA1() {
        try {
            PackageInfo info = Utils.getApp().getPackageManager().getPackageInfo(
                    Utils.getApp().getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuilder hexString = new StringBuilder();
            for (byte aPublicKey : publicKey) {
                String appendString = Integer.toHexString(0xFF & aPublicKey).toUpperCase();
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length() - 1);
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 判断App是否安装
     *
     * @param packageName 包名
     * @return {@code true}: 已安装<br>{@code false}: 未安装
     */
    public static boolean isInstallApp(String packageName) {
        return !isSpace(packageName) && IntentUtils.getLaunchAppIntent(packageName) != null;
    }

    /**
     * 安装App(支持6.0)
     *
     * @param filePath 文件路径
     */
    public static void installApp(String filePath) {
        installApp(FileUtils.getFileByPath(filePath));
    }

    /**
     * 安装App(支持6.0)
     *
     * @param file 文件
     */
    public static void installApp(File file) {
        if (!FileUtils.isFileExists(file))
            return;
        Utils.getApp().startActivity(IntentUtils.getInstallAppIntent(file));
    }

    /**
     * 安装App(支持6.0)
     *
     * @param activity    activity
     * @param filePath    文件路径
     * @param requestCode 请求值
     */
    public static void installApp(Activity activity, String filePath, int requestCode) {
        installApp(activity, FileUtils.getFileByPath(filePath), requestCode);
    }

    /**
     * 安装App(支持6.0)
     *
     * @param activity    activity
     * @param file        文件
     * @param requestCode 请求值
     */
    public static void installApp(Activity activity, File file, int requestCode) {
        if (!FileUtils.isFileExists(file))
            return;
        activity.startActivityForResult(IntentUtils.getInstallAppIntent(file), requestCode);
    }

    /**
     * 静默安装App
     * <p>
     * 非root需添加权限
     * <uses-permission android:name="android.permission.INSTALL_PACKAGES" />
     *
     * @param filePath 文件路径
     * @return {@code true}: 安装成功<br>{@code false}: 安装失败
     */
    public static boolean installAppSilent(String filePath) {
        File file = FileUtils.getFileByPath(filePath);
        if (!FileUtils.isFileExists(file))
            return false;
        String command = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install " + filePath;
        ShellUtils.CommandResult commandResult = ShellUtils.execCmd(command, !isSystemApp(), true);
        return commandResult.successMsg != null && commandResult.successMsg.toLowerCase().contains("success");
    }

    /**
     * 卸载App
     *
     * @param packageName 包名
     */
    public static void uninstallApp(String packageName) {
        if (isSpace(packageName))
            return;
        Utils.getApp().startActivity(IntentUtils.getUninstallAppIntent(packageName));
    }

    /**
     * 卸载App
     *
     * @param activity    activity
     * @param packageName 包名
     * @param requestCode 请求值
     */
    public static void uninstallApp(Activity activity, String packageName, int requestCode) {
        if (isSpace(packageName))
            return;
        activity.startActivityForResult(IntentUtils.getUninstallAppIntent(packageName), requestCode);
    }

    /**
     * 静默卸载App
     * <p>非root需添加权限 {@code <uses-permission android:name="android.permission.DELETE_PACKAGES" />}</p>
     *
     * @param packageName 包名
     * @param isKeepData  是否保留数据
     * @return {@code true}: 卸载成功<br>{@code false}: 卸载成功
     */
    public static boolean uninstallAppSilent(String packageName, boolean isKeepData) {
        if (isSpace(packageName))
            return false;
        String command = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm uninstall " + (isKeepData ? "-k " : "") +
                packageName;
        ShellUtils.CommandResult commandResult = ShellUtils.execCmd(command, !isSystemApp(), true);
        return commandResult.successMsg != null && commandResult.successMsg.toLowerCase().contains("success");
    }

    /**
     * 打开App
     *
     * @param packageName 包名
     */
    public static void launchApp(String packageName) {
        if (isSpace(packageName))
            return;
        Utils.getApp().startActivity(IntentUtils.getLaunchAppIntent(packageName));
    }

    /**
     * 打开App
     *
     * @param activity    activity
     * @param packageName 包名
     * @param requestCode 请求值
     */
    public static void launchApp(Activity activity, String packageName, int requestCode) {
        if (isSpace(packageName))
            return;
        activity.startActivityForResult(IntentUtils.getLaunchAppIntent(packageName), requestCode);
    }

    /**
     * 获取App包名
     *
     * @return App包名
     */
    public static String getAppPackageName() {
        return Utils.getApp().getPackageName();
    }

    /**
     * 获取App具体设置
     */
    public static void getAppDetailsSettings() {
        getAppDetailsSettings(Utils.getApp().getPackageName());
    }

    /**
     * 获取App具体设置
     *
     * @param packageName 包名
     */
    public static void getAppDetailsSettings(String packageName) {
        if (isSpace(packageName))
            return;
        Utils.getApp().startActivity(IntentUtils.getAppDetailsSettingsIntent(packageName));
    }

    /**
     * 获取App名称
     *
     * @return App名称
     */
    public static String getAppName() {
        return getAppName(Utils.getApp().getPackageName());
    }

    /**
     * 获取App名称
     *
     * @param packageName 包名
     * @return App名称
     */
    public static String getAppName(String packageName) {
        if (isSpace(packageName))
            return null;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App图标
     *
     * @return App图标
     */
    public static Drawable getAppIcon() {
        return getAppIcon(Utils.getApp().getPackageName());
    }

    /**
     * 获取App图标
     *
     * @param packageName 包名
     * @return App图标
     */
    public static Drawable getAppIcon(String packageName) {
        if (isSpace(packageName))
            return null;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App路径
     *
     * @return App路径
     */
    public static String getAppPath() {
        return getAppPath(Utils.getApp().getPackageName());
    }

    /**
     * 获取App路径
     *
     * @param packageName 包名
     * @return App路径
     */
    public static String getAppPath(String packageName) {
        if (isSpace(packageName))
            return null;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App版本号
     *
     * @return App版本号
     */
    public static String getAppVersionName() {
        return getAppVersionName(Utils.getApp().getPackageName());
    }

    /**
     * 获取App版本号
     *
     * @param packageName 包名
     * @return App版本号
     */
    public static String getAppVersionName(String packageName) {
        if (isSpace(packageName))
            return null;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App版本码
     *
     * @return App版本码
     */
    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getApp().getPackageName());
    }

    /**
     * 获取App版本码
     *
     * @param packageName 包名
     * @return App版本码
     */
    public static int getAppVersionCode(String packageName) {
        if (isSpace(packageName))
            return -1;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取App签名
     *
     * @return App签名
     */
    public static Signature[] getAppSignature() {
        return getAppSignature(Utils.getApp().getPackageName());
    }

    /**
     * 获取App签名
     *
     * @param packageName 包名
     * @return App签名
     */
    public static Signature[] getAppSignature(String packageName) {
        if (isSpace(packageName))
            return null;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取应用签名的的SHA1值
     * <p>可据此判断高德，百度地图key是否正确</p>
     *
     * @return 应用签名的SHA1字符串, 比如：53:FD:54:DC:19:0F:11:AC:B5:22:9E:F1:1A:68:88:1B:8B:E8:54:42
     */
    public static String getAppSignatureSHA1() {
        return getAppSignatureSHA1(Utils.getApp().getPackageName());
    }

    /**
     * 获取应用签名的的SHA1值
     * <p>可据此判断高德，百度地图key是否正确</p>
     *
     * @param packageName 包名
     * @return 应用签名的SHA1字符串, 比如：53:FD:54:DC:19:0F:11:AC:B5:22:9E:F1:1A:68:88:1B:8B:E8:54:42
     */
    public static String getAppSignatureSHA1(String packageName) {
        Signature[] signature = getAppSignature(packageName);
        if (signature == null)
            return null;
        return EncryptUtils.encryptSHA1ToString(signature[0].toByteArray()).
                replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
    }

    /**
     * 获取APP 32位的签名
     *
     * @param packageName 包名
     * @return 32位的签名
     */
    public static String getAPP32Singnature(String packageName) {
        try {
            PackageInfo pis = Utils.getApp().getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_SIGNATURES);
            return hexdigest(pis.signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将签名字符串转换成需要的32位签名
     *
     * @param paramArrayOfByte 签名byte数组
     * @return 32位签名字符串
     */
    private static String hexdigest(byte[] paramArrayOfByte) {
        final char[] hexDigits = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97,
                98, 99, 100, 101, 102};
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            byte[] arrayOfByte = localMessageDigest.digest();
            char[] arrayOfChar = new char[32];
            for (int i = 0, j = 0; ; i++, j++) {
                if (i >= 16) {
                    return new String(arrayOfChar);
                }
                int k = arrayOfByte[i];
                arrayOfChar[j] = hexDigits[(0xF & k >>> 4)];
                arrayOfChar[++j] = hexDigits[(k & 0xF)];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 判断App是否是系统应用
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isSystemApp() {
        return isSystemApp(Utils.getApp().getPackageName());
    }

    /**
     * 判断App是否是系统应用
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isSystemApp(String packageName) {
        if (isSpace(packageName))
            return false;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断App是否处于前台
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppForeground() {
        return ProcessUtils.isAppForeground(Utils.getApp());
    }

    /**
     * 判断某个App是否处于前台（系统应用调用）
     * <p>API < 21，需要添加 {@code <uses-permission android:name="android.permission.GET_TASKS"/>} 权限</p>
     * <p>API >= 22，需要添加　{@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>} 权限</p>
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    @Deprecated
    public static boolean isAppForeground(String packageName) {
        return ProcessUtils.isAppForeground(packageName);
    }

    /**
     * 获取前台应用包名（系统应用调用）
     * <p>API < 21，需要添加 {@code <uses-permission android:name="android.permission.GET_TASKS"/>} 权限</p>
     * <p>API >= 22，需要添加　{@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>} 权限</p>
     *
     * @return 前台应用包名
     */
    public String getForegroundApp() {
        return ProcessUtils.getForegroundPackage();
    }

    /**
     * 获取App信息
     * <p>AppInfo（名称，图标，包名，版本号，版本Code，是否系统应用）</p>
     *
     * @return 当前应用的AppInfo
     */
    public static AppInfo getAppInfo() {
        return getAppInfo(Utils.getApp().getPackageName());
    }

    /**
     * 获取App信息
     * <p>AppInfo（名称，图标，包名，版本号，版本Code，是否系统应用）</p>
     *
     * @return 当前应用的AppInfo
     */
    public static AppInfo getAppInfo(String packageName) {
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return getBean(pm, pi);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到AppInfo的Bean
     *
     * @param pm 包的管理
     * @param pi 包的信息
     * @return AppInfo类
     */
    private static AppInfo getBean(PackageManager pm, PackageInfo pi) {
        if (pm == null || pi == null)
            return null;
        ApplicationInfo ai = pi.applicationInfo;
        String name = ai.loadLabel(pm).toString();
        Drawable icon = ai.loadIcon(pm);
        String packageName = pi.packageName;
        String packagePath = ai.sourceDir;
        String versionName = pi.versionName;
        int versionCode = pi.versionCode;
        boolean isSystem = (ApplicationInfo.FLAG_SYSTEM & ai.flags) != 0;
        return new AppInfo(name, icon, packageName, packagePath, versionName, versionCode, isSystem);
    }

    /**
     * 获取所有已安装App信息
     * <p>{@link #getBean(PackageManager, PackageInfo)}（名称，图标，包名，包路径，版本号，版本Code，是否系统应用）</p>
     * <p>依赖上面的getBean方法</p>
     *
     * @return 所有已安装的AppInfo列表
     */
    public static List<AppInfo> getAppsInfo() {
        List<AppInfo> list = new ArrayList<>();
        PackageManager pm = Utils.getApp().getPackageManager();
        // 获取系统中安装的所有软件信息
        List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
        for (PackageInfo pi : installedPackages) {
            AppInfo ai = getBean(pm, pi);
            if (ai == null)
                continue;
            list.add(ai);
        }
        return list;
    }

    /**
     * 清除App所有数据
     *
     * @param dirPaths 目录路径
     */
    public static boolean cleanAppData(String... dirPaths) {
        File[] dirs = new File[dirPaths.length];
        int i = 0;
        for (String dirPath : dirPaths) {
            dirs[i++] = new File(dirPath);
        }
        return cleanAppData(dirs);
    }


    private static final boolean DEBUG = true;
    private static final String TAG = "AppUtils";

    /**
     * 清理后台进程与服务
     *
     * @param context 应用上下文对象context
     * @return 被清理的数量
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static int gc(Context context) {
        long i = getDeviceUsableMemory();
        int count = 0; // 清理掉的进程数
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        // 获取正在运行的service列表
        List<RunningServiceInfo> serviceList = am.getRunningServices(100);
        if (serviceList != null)
            for (RunningServiceInfo service : serviceList) {
                if (service.pid == android.os.Process.myPid())
                    continue;
                try {
                    android.os.Process.killProcess(service.pid);
                    count++;
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }

        // 获取正在运行的进程列表
        List<RunningAppProcessInfo> processList = am.getRunningAppProcesses();
        if (processList != null)
            for (RunningAppProcessInfo process : processList) {
                // 一般数值大于RunningAppProcessInfo.IMPORTANCE_SERVICE的进程都长时间没用或者空进程了
                // 一般数值大于RunningAppProcessInfo.IMPORTANCE_VISIBLE的进程都是非可见进程，也就是在后台运行着
                if (process.importance > RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                    // pkgList 得到该进程下运行的包名
                    String[] pkgList = process.pkgList;
                    for (String pkgName : pkgList) {
                        if (DEBUG) {
                            LogUtils.d(TAG, "======正在杀死包名：" + pkgName);
                        }
                        try {
                            am.killBackgroundProcesses(pkgName);
                            count++;
                        } catch (Exception e) { // 防止意外发生
                            e.getStackTrace();
                        }
                    }
                }
            }
        if (DEBUG) {
            LogUtils.d(TAG, "清理了" + (getDeviceUsableMemory() - i) + "M内存");
        }
        return count;
    }

    /**
     * 获取设备的可用内存大小
     *
     * @return 当前内存大小
     */
    public static int getDeviceUsableMemory() {
        ActivityManager am = (ActivityManager) Utils.getApp()
                .getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        // 返回当前系统的可用内存
        return (int) (mi.availMem / (1024 * 1024));
    }

    /**
     * 获取应用最高可用内存
     *
     * @return 最大内存
     */
    public static long getDeviceMaxMemory() {

        return Runtime.getRuntime().maxMemory() / 1024;
    }

    /**
     * 获取App在当前手机系统的最大内存
     *
     * @return 最大内存
     */
    public static String getAppMemoryClass_Rom() {
        StringBuilder sb = new StringBuilder();
        ActivityManager activityManager = (ActivityManager) Utils.getApp()
                .getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass = activityManager.getMemoryClass();
        int largeMemoryClass = activityManager.getLargeMemoryClass();
        sb.append("memoryClass:" + memoryClass + "\n");
        sb.append("largeMemoryClass:" + largeMemoryClass + "\n");
        return sb.toString();
    }

    /**
     * 检测服务是否运行
     *
     * @param className 类名
     * @return 是否运行的状态
     */
    public static boolean isServiceRunning(String className) {
        boolean isRunning = false;
        ActivityManager activityManager
                = (ActivityManager) Utils.getApp().getSystemService(
                Context.ACTIVITY_SERVICE);
        List<RunningServiceInfo> servicesList
                = activityManager.getRunningServices(Integer.MAX_VALUE);
        for (RunningServiceInfo si : servicesList) {
            if (className.equals(si.service.getClassName())) {
                isRunning = true;
            }
        }
        return isRunning;
    }


    /**
     * 停止运行服务
     *
     * @param className 类名
     * @return 是否执行成功
     */
    public static boolean stopRunningService(String className) {
        Intent intent_service = null;
        boolean ret = false;
        try {
            intent_service = new Intent(Utils.getApp(), Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intent_service != null) {
            ret = Utils.getApp().stopService(intent_service);
        }
        return ret;
    }

    /**
     * 是否含有当前进程
     *
     * @param processName 进程名
     * @return 是否含有当前的进程
     */
    public static boolean isCurrentProcess(String processName) {
        if (Utils.getApp() == null || TextUtils.isEmpty(processName)) {
            return false;
        }

        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) Utils.getApp().getSystemService(
                Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> processInfoList
                = manager.getRunningAppProcesses();
        if (processInfoList == null) {
            return true;
        }

        for (RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid &&
                    processName.equalsIgnoreCase(processInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否Dalvik模式
     *
     * @return 结果
     */
    public static boolean isDalvik() {
        return "Dalvik".equals(getCurrentRuntimeValue());
    }


    /**
     * 是否ART模式
     *
     * @return 结果
     */
    public static boolean isART() {
        String currentRuntime = getCurrentRuntimeValue();
        return "ART".equals(currentRuntime) ||
                "ART debug build".equals(currentRuntime);
    }

    /**
     * 获取手机当前的Runtime
     *
     * @return 正常情况下可能取值Dalvik, ART, ART debug build;
     */
    public static String getCurrentRuntimeValue() {
        try {
            Class<?> systemProperties = Class.forName(
                    "android.os.SystemProperties");
            try {
                Method get = systemProperties.getMethod("get", String.class,
                        String.class);
                if (get == null) {
                    return "WTF?!";
                }
                try {
                    final String value = (String) get.invoke(systemProperties,
                            "persist.sys.dalvik.vm.lib",
                        /* Assuming default is */"Dalvik");
                    if ("libdvm.so".equals(value)) {
                        return "Dalvik";
                    } else if ("libart.so".equals(value)) {
                        return "ART";
                    } else if ("libartd.so".equals(value)) {
                        return "ART debug build";
                    }

                    return value;
                } catch (IllegalAccessException e) {
                    return "IllegalAccessException";
                } catch (IllegalArgumentException e) {
                    return "IllegalArgumentException";
                } catch (InvocationTargetException e) {
                    return "InvocationTargetException";
                }
            } catch (NoSuchMethodException e) {
                return "SystemProperties.get(String key, String def) method is not found";
            }
        } catch (ClassNotFoundException e) {
            return "SystemProperties class is not found";
        }
    }


    /**
     * 获取唯一序列号
     *
     * @return
     */
    public static String getUUID() {
        String uuid = getDeviceId();
        String sbMed5 = EncryptUtils.encryption(uuid);
//
//        if (StringUtils.isEmpty(UUID)){
//            UUID = (String) SPUtil.get(MyApplication.getInstance(), Keys.KEY_UUID, "");
//            // 如果没有UUID则去获取
//            if (StringUtils.isEmpty(UUID)) {
//                UUID = APPUtils.getUUID(MyApplication.getInstance());
//                SPUtil.putAndApply(MyApplication.getInstance(), Keys.KEY_UUID, UUID);
//            }
//        }
//        return UUID;

        return sbMed5;
    }


    /**
     * deviceID的组成为：渠道标志+识别符来源标志+hash后的终端识别符
     * <p>
     * 渠道标志为：
     * 1，andriod（a）
     * <p>
     * 识别符来源标志：
     * 1， wifi mac地址（wifi）；
     * 2， IMEI（imei）；
     * 3， 序列号（sn）；
     * 4， id：随机码。若前面的都取不到时，则随机生成一个随机码，需要缓存。
     *
     * @return
     */
    public static String getDeviceId() {

        StringBuilder deviceId = new StringBuilder();
        // 渠道标志
        deviceId.append("pt");

        try {

            //序列号（sn）
            String sn = android.os.Build.SERIAL;
            if (sn != null && !sn.isEmpty()) {
                deviceId.append("sn");
                deviceId.append(sn);
            }

            String androidId = Settings.Secure.getString(Utils.getApp().getContentResolver(), Settings.Secure.ANDROID_ID);
            if (androidId != null && !androidId.isEmpty()) {
                deviceId.append("aid");
                deviceId.append(androidId);
            }

//            TelephonyManager TelephonyMgr = (TelephonyManager)context.getSystemService(context.TELEPHONY_SERVICE);
//            String szImei = TelephonyMgr.getDeviceId();
//            if(szImei != null && !szImei.isEmpty()){
//                deviceId.append("imei");
//                deviceId.append(szImei);
//            }

            if (deviceId.length() < 5) {
                deviceId.append("id").append(UUID.randomUUID().toString());
            }

        } catch (Exception e) {
            LogUtils.d("e : ", e.toString());
        }

        LogUtils.d("getDeviceId : ", deviceId.toString());

        return deviceId.toString();

    }

    /**
     * 判断App是否有root权限
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppRoot() {
        ShellUtils.CommandResult result = ShellUtils.execCmd("echo root", true);
        if (result.result == 0) {
            return true;
        }
        if (result.errorMsg != null) {
            Log.d("AppUtils", "isAppRoot() called" + result.errorMsg);
        }
        return false;
    }


    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug() {
        return isAppDebug(Utils.getApp().getPackageName());
    }

    /**
     * 判断App是否是Debug版本
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug(final String packageName) {
        if (isSpace(packageName)) return false;
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 清除App所有数据
     *
     * @param dirs 目录
     * @return {@code true}: 成功<br>{@code false}: 失败
     */
    public static boolean cleanAppData(final File... dirs) {
        boolean isSuccess = CleanUtils1.cleanInternalCache();
        isSuccess &= CleanUtils1.cleanInternalDbs();
        isSuccess &= CleanUtils1.cleanInternalSP();
        isSuccess &= CleanUtils1.cleanInternalFiles();
        isSuccess &= CleanUtils1.cleanExternalCache();
        for (File dir : dirs) {
            isSuccess &= CleanUtils1.cleanCustomCache(dir);
        }
        return isSuccess;
    }

}
