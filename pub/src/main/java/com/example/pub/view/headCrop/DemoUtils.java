package com.example.pub.view.headCrop;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;

import com.example.pub.common.MyApplication;
import com.example.pub.utils.function.LogUtils;

import junit.framework.Assert;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by Leader on 2017/5/22.
 *
 */
public class DemoUtils {
    public static final String TAG = "ECDemo.DemoUtils";
    private static final int MAX_DECODE_PICTURE_SIZE = 1920 * 1440;
    public static boolean inNativeAllocAccessError = false;
    /**当前SDK版本号*/
    private static int mSdkint = -1;

    private static MessageDigest md = null;
    public static String md5(final String c) {
        if (md == null) {
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        if (md != null) {
            md.update(c.getBytes());
            return byte2hex(md.digest());
        }
        return "";
    }

    public static String byte2hex(byte b[]) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = (new StringBuffer(String.valueOf(hs))).toString();
        }

        return hs.toUpperCase();
    }

    /**
     * @param context
     * @param intent
     * @param appPath
     * @return
     */
    public static String resolvePhotoFromIntent(Context context , Intent intent , String appPath) {

        if(context == null || intent == null || appPath == null) {
            LogUtils.e("", "resolvePhotoFromIntent fail, invalid argument");
            return null;
        }

        //Uri uri = Uri.parse(intent.toURI());
        Uri uri = intent.getData();

        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        try {

            String pathFromUri = null;
            if(cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(MediaStore.MediaColumns.DATA);
                // if it is a picasa image on newer devices with OS 3.0 and up
                if(uri.toString().startsWith("content://com.google.android.gallery3d")) {
                    // Do this in a background thread, since we are fetching a large image from the web
                    pathFromUri =  saveBitmapToLocal(appPath, createChattingImageByUri(intent.getData()));
                } else {
                    // it is a regular local image file
                    pathFromUri =  cursor.getString(columnIndex);
                }
                cursor.close();
                LogUtils.d(TAG, "photo from resolver, path: " + pathFromUri);
                return pathFromUri;
            } else {

                if(intent.getData() != null) {
                    pathFromUri = intent.getData().getPath();
                    if(new File(pathFromUri).exists()) {
                        LogUtils.d(TAG, "photo from resolver, path: " + pathFromUri);
                        return pathFromUri;
                    }
                }

                // some devices (OS versions return an URI of com.android instead of com.google.android
                if((intent.getAction() != null) && (!(intent.getAction().equals("inline-data")))){
                    // use the com.google provider, not the com.android provider.
                    // Uri.parse(intent.getData().toString().replace("com.android.gallery3d","com.google.android.gallery3d"));
                    pathFromUri =  saveBitmapToLocal(appPath, (Bitmap)intent.getExtras().get("data"));
                    LogUtils.d(TAG, "photo from resolver, path: " + pathFromUri);
                    return pathFromUri;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null) {
                cursor.close();
            }
        }

        LogUtils.e(TAG, "resolve photo from intent failed ");
        return null;
    }


    /**
     *
     * @param uri
     * @return
     */
    public static Bitmap createChattingImageByUri(Uri uri) {
        return createChattingImage(0, null, null, uri, 0.0F, 400, 800);
    }

    /**
     *
     * @param resource
     * @param path
     * @param b
     * @param uri
     * @param dip
     * @param width
     * @param height
     * @return
     */
    public static Bitmap createChattingImage(int resource , String path , byte[] b , Uri uri , float dip , int width , int height ) {
        if(width <= 0 || height <= 0) {
            return null;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        int outWidth = 0;
        int outHeight = 0;
        int sampleSize = 0;
        try {

            do {
                if(dip != 0.0F) {
                    options.inDensity = (int)(160.0F * dip);
                }
                options.inJustDecodeBounds = true;
                decodeMuilt(options, b, path, uri, resource);
                //
                outWidth = options.outWidth;
                outHeight = options.outHeight;

                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                if(outWidth <= width || outHeight <= height){
                    sampleSize = 0;
                    setInNativeAlloc(options);
                    Bitmap decodeMuiltBitmap = decodeMuilt(options, b, path, uri, resource);
                    return decodeMuiltBitmap;
                } else {
                    options.inSampleSize = (int) Math.max(outWidth / width, outHeight / height);
                    sampleSize = options.inSampleSize;
                }
            } while (sampleSize != 0);

        } catch (IncompatibleClassChangeError e) {
            e.printStackTrace();
            throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            BitmapFactory.Options catchOptions = new BitmapFactory.Options();
            if (dip != 0.0F) {
                catchOptions.inDensity = (int) (160.0F * dip);
            }
            catchOptions.inPreferredConfig = Bitmap.Config.RGB_565;
            if(sampleSize != 0) {
                catchOptions.inSampleSize = sampleSize;
            }
            setInNativeAlloc(catchOptions);
            try {
                return decodeMuilt(options, b, path, uri, resource);
            } catch (IncompatibleClassChangeError twoE) {
                twoE.printStackTrace();
                throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(twoE));
            } catch (Throwable twoThrowable) {
                twoThrowable.printStackTrace();
            }
        }

        return null;
    }

    /**
     *
     * @param options
     * @param data
     * @param path
     * @param uri
     * @param resource
     * @return
     */
    public static Bitmap decodeMuilt(BitmapFactory.Options options , byte[] data , String path , Uri uri , int resource) {
        try {

            if(!checkByteArray(data) && TextUtils.isEmpty(path) && uri == null && resource <= 0) {
                return null;
            }

            if(checkByteArray(data)) {
                return BitmapFactory.decodeByteArray(data, 0, data.length, options);
            }

            if (uri != null){
                InputStream inputStream = MyApplication.getInstance().getContentResolver().openInputStream(uri);
                Bitmap localBitmap = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.close();
                return localBitmap;
            }

            if(resource > 0) {
                return BitmapFactory.decodeResource(MyApplication.getInstance().getResources(), resource, options);
            }
            return BitmapFactory.decodeFile(path, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * save image from uri
     * @param outPath
     * @param bitmap
     * @return
     */
    public static String saveBitmapToLocal(String outPath , Bitmap bitmap) {
        try {
            String imagePath = outPath + DemoUtils.md5(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString()) + ".jpg";
            File file = new File(imagePath);
            if(!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            LogUtils.d(TAG, "photo image from data, path:" + imagePath);
            return imagePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String saveBitmapToLocal(File file , Bitmap bitmap) {
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            LogUtils.d(TAG, "photo image from data, path:" + file.getAbsolutePath());
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setInNativeAlloc(BitmapFactory.Options options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH && !inNativeAllocAccessError) {
            try {
                BitmapFactory.Options.class.getField("inNativeAlloc").setBoolean(options, true);
                return ;
            } catch (Exception e) {
                inNativeAllocAccessError = true;
            }
        }
    }

    public static boolean checkByteArray(byte[] b) {
        return b != null && b.length > 0;
    }

    /**
     * 将要保存图片的路径
     * @param path
     * @param bitmap
     */
    public static void saveBitmapFile(String path, Bitmap bitmap){
        File file=new File(path);//将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取图片属性：旋转的角度
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("degreedegree:"+degree);
        return degree;
    }

    /**
     *
     * @param src
     * @param degree
     * @return
     */
    public static Bitmap degreeBitmap(Bitmap src , float degree) {
        if(degree == 0.0F) {
            return src;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree, src.getWidth() / 2, src.getHeight() / 2);
        Bitmap resultBitmap = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        boolean filter = true;
        if(resultBitmap == null) {
            LogUtils.e(TAG, "resultBmp is null: ");
            filter = true;
        } else {
            filter = false;
        }

        if(resultBitmap != src) {
            src.recycle();
        }
        LogUtils.d(TAG, "filter: " + filter + "  degree:" + degree);
        return resultBitmap;
    }

    /**
     * 得到指定路径图片的options
     * @param srcPath
     * @return Options {@link BitmapFactory.Options}
     */
    public final static BitmapFactory.Options getBitmapOptions(String srcPath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, options);
        return options;
    }

    /**
     * 压缩发送到服务器的图片
     * @param origPath 原始图片路径
     * @param widthLimit 图片宽度限制
     * @param heightLimit 图片高度限制
     * @param format 图片格式
     * @param quality 图片压缩率
     * @param authorityDir 图片目录
     * @param outPath 图片详细目录
     * @return
     */
    public static boolean createThumbnailFromOrig(String origPath,
                                                  int widthLimit, int heightLimit, Bitmap.CompressFormat format,
                                                  int quality, String authorityDir, String outPath) {
        Bitmap bitmapThumbNail = extractThumbNail(origPath, widthLimit, heightLimit, false);
        if(bitmapThumbNail == null) {
            return false;
        }

        try {
            saveImageFile(bitmapThumbNail, quality, format, authorityDir, outPath);
            return true;
        } catch (IOException e) {
            LogUtils.e(TAG,  "create thumbnail from orig failed: " + outPath);
        }
        return false;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Bitmap extractThumbNail(final String path, final int width, final int height, final boolean crop) {
        Assert.assertTrue(path != null && !path.equals("") && height > 0 && width > 0);

        BitmapFactory.Options options = new BitmapFactory.Options();

        try {
            options.inJustDecodeBounds = true;
            Bitmap tmp = BitmapFactory.decodeFile(path, options);
            if (tmp != null) {
                tmp.recycle();
                tmp = null;
            }

            LogUtils.d(TAG, "extractThumbNail: round=" + width + "x" + height + ", crop=" + crop);
            final double beY = options.outHeight * 1.0 / height;
            final double beX = options.outWidth * 1.0 / width;
            LogUtils.d(TAG, "extractThumbNail: extract beX = " + beX + ", beY = " + beY);
            options.inSampleSize = (int) (crop ? (beY > beX ? beX : beY) : (beY < beX ? beX : beY));
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }

            // NOTE: out of memory error
            while (options.outHeight * options.outWidth / options.inSampleSize > MAX_DECODE_PICTURE_SIZE) {
                options.inSampleSize++;
            }

            int newHeight = height;
            int newWidth = width;
            if (crop) {
                if (beY > beX) {
                    newHeight = (int) (newWidth * 1.0 * options.outHeight / options.outWidth);
                } else {
                    newWidth = (int) (newHeight * 1.0 * options.outWidth / options.outHeight);
                }
            } else {
                if (beY < beX) {
                    newHeight = (int) (newWidth * 1.0 * options.outHeight / options.outWidth);
                } else {
                    newWidth = (int) (newHeight * 1.0 * options.outWidth / options.outHeight);
                }
            }

            options.inJustDecodeBounds = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                options.inMutable = true;
            }
            LogUtils.i(TAG, "bitmap required size=" + newWidth + "x" + newHeight + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize);
            Bitmap bm = BitmapFactory.decodeFile(path, options);
            setInNativeAlloc(options);
            if (bm == null) {
                Log.e(TAG, "bitmap decode failed");
                return null;
            }

            LogUtils.i(TAG, "bitmap decoded size=" + bm.getWidth() + "x" + bm.getHeight());
            final Bitmap scale = Bitmap.createScaledBitmap(bm, newWidth, newHeight, true);
            if (scale != null) {
                bm.recycle();
                bm = scale;
            }

            if (crop) {
                final Bitmap cropped = Bitmap.createBitmap(bm, (bm.getWidth() - width) >> 1, (bm.getHeight() - height) >> 1, width, height);
                if (cropped == null) {
                    return bm;
                }

                bm.recycle();
                bm = cropped;
                LogUtils.i(TAG, "bitmap croped size=" + bm.getWidth() + "x" + bm.getHeight());
            }
            return bm;

        } catch (final OutOfMemoryError e) {
            LogUtils.e(TAG, "decode bitmap failed: " + e.getMessage());
            options = null;
        }

        return null;
    }

    public static void saveImageFile(Bitmap bitmap , int quality , Bitmap.CompressFormat format , String authorityDir, String outPath) throws IOException {
        if(!TextUtils.isEmpty(authorityDir) && !TextUtils.isEmpty(outPath)) {
            LogUtils.d(TAG, "saving to " + authorityDir + outPath);
            File file = new File(authorityDir);
            if(!file.exists()) {
                file.mkdirs();
            }
            File outfile = new File(file, outPath);
            outfile.createNewFile();

            try {
                FileOutputStream outputStream = new FileOutputStream(outfile);
                bitmap.compress(format, quality, outputStream);
                outputStream.flush();
            } catch (Exception e) {
                LogUtils.e(TAG, "saveImageFile fil=" + e.getMessage());
            }
        }
    }

    /**
     *
     * @Title: getResource
     * @Description: TODO
     * @param context
     * @return Resources
     */
    public static Resources getResources(Context context) {
        return context.getResources();
    }

}
