package com.example.android.leadermvprxdemo.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pub.R;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.function.LogUtils;
import com.example.pub.utils.view.ToastUtils;
import com.example.pub.view.headCrop.ClipImageViewActivity;
import com.example.pub.view.headCrop.DemoUtils;
import com.example.pub.view.headCrop.FileAccessor;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @Description:获取图片并且进行截取
 * @Prject: 
 * @Package: com.example.android.leadermvprxdemo.activity
 * @author: Leader
 * @date: 2017/11/16   19:32
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class GetPicActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    private static final int PERMIT_CODE_CAMERA = 1;
    /**
     * 照片权限允许
     */
    private static final int PERMIT_CODE_STORAGE = 3;
    @BindView(R.id.open_camera)
    TextView openCamera;
    @BindView(R.id.open_gallery)
    TextView openGallery;
    @BindView(R.id.open_cancel)
    TextView openCancel;
    @BindView(R.id.open_layout)
    LinearLayout openLayout;
    @BindView(R.id.get_pic_layout)
    RelativeLayout getPicLayout; /** 文件读写允许 */

    /**
     * 选择图片的原始路径
     */
    private String orignFilePath;
    /**
     * 拍照压缩后的图片
     */
    private String newFilePath;

    /**
     * 拍照请求码
     */
    public static final int REQUEST_CODE_TAKE_PICTURE = 100;
    /**
     * 访问图库请求码
     */
    public static final int REQUEST_CODE_LOAD_IMAGE = 101;
    /**
     * 裁剪图片请求码
     */
    public static final int REQUEST_CODE_CLIP = 102;

    public static final String KEY_FILE_PATH = "filePath"; // 文件路径的KEY值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pic);
        ButterKnife.bind(this);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        LogUtils.e("getPic", "接收到返回：" + resultCode);

         /*回调内容*/
        if (resultCode != RESULT_OK) {
            finish();
            return;
        }

        if (requestCode == REQUEST_CODE_TAKE_PICTURE || requestCode == REQUEST_CODE_LOAD_IMAGE) {

            if (requestCode == REQUEST_CODE_LOAD_IMAGE) {
                orignFilePath = DemoUtils.resolvePhotoFromIntent(this, data, FileAccessor.IMESSAGE_IMAGE);
            }

            if (TextUtils.isEmpty(orignFilePath)) {
                ToastUtils.showShort("文件存储错误");
                finish();
                return;
            }

            File file = new File(orignFilePath);
            if (file == null || !file.exists()) {
                LogUtils.e("getPic", "orignFilePath 文件不存在");
                ToastUtils.showShort("文件存储错误");
                finish();
                return;
            }

            try {
                newFilePath = FileAccessor.getSmallPicture(file.getPath()); // 压缩文件

                LogUtils.e("getPic", "文件被压缩存放的地方：" + newFilePath + "。压缩完了要去裁剪");

            } catch (Exception e) {
                LogUtils.e("getPic", "上传图片错误：" + e.toString());
                newFilePath = orignFilePath;
            }

            Intent intent = new Intent(this, ClipImageViewActivity.class);
            intent.putExtra(KEY_FILE_PATH, newFilePath);
            startActivityForResult(intent, REQUEST_CODE_CLIP);
            return;
        }

        if (requestCode == REQUEST_CODE_CLIP) {

            Intent intent = new Intent();
            intent.putExtra(KEY_FILE_PATH, newFilePath);

            LogUtils.e("getPic", "被裁剪的文件被返回了，再返回请求的视图：" + newFilePath);

            setResult(RESULT_OK, intent);
            finish();
        }
    }

    /**
     * 打开相机
     */
    private void openCamera() {

        // 现获取拍照后，文件存放的地方
        File file = FileAccessor.getTackPicFilePath();
        if (file != null) {

            LogUtils.e("getPic", "1、拍照后将会存储到 orignFilePath：" + file.getAbsolutePath() + "，这一步OK，去确定拍照完后的情况");

            Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // 如果是4.4以后版本
                Uri imgUri = FileProvider.getUriForFile(this, "file_provider", file);
                intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
            } else {
                intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            }

            orignFilePath = file.getAbsolutePath();
            startActivityForResult(intentFromCapture, REQUEST_CODE_TAKE_PICTURE);
        } else {
            ToastUtils.showShort("没有存储空间，无法创建");
            finish();
        }

    }

    /**
     * 打开图库
     */
    private void openGallery() {

        Intent intentFromGallery = new Intent();
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_PICK);
        startActivityForResult(intentFromGallery, REQUEST_CODE_LOAD_IMAGE);
    }

    /**
     * 将系统处理的的回调交给EasyPermissions来处理
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //把申请权限的回调交由EasyPermissions处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 权限被允许时
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

        if (requestCode == PERMIT_CODE_CAMERA) {
            openCamera();
        }

        if (requestCode == PERMIT_CODE_STORAGE) {
            openGallery();
        }
    }

    /**
     * 权限被拒绝
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        ToastUtils.showShort("拒绝权限将无法获取图片，请再次尝试");
    }

    /**
     * 处理点击按键
     *
     * @param view
     */
    @OnClick({R.id.open_camera, R.id.open_gallery, R.id.open_cancel, R.id.get_pic_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.open_camera: {
                //所要申请的权限
                String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                if (EasyPermissions.hasPermissions(getApplicationContext(), perms)) {//检查是否获取该权限
                    openCamera();
                } else {
                    //第二个参数是被拒绝后再次申请该权限的解释,第三个参数是请求码,第四个参数是要申请的权限
                    EasyPermissions.requestPermissions(this, "需要拍照的权限", PERMIT_CODE_CAMERA, perms);
                }

            }
            break;
            case R.id.open_gallery: {

                //所要申请的权限
                String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                if (EasyPermissions.hasPermissions(getApplicationContext(), perms)) {//检查是否获取该权限
                    openGallery();
                } else {
                    //第二个参数是被拒绝后再次申请该权限的解释,第三个参数是请求码,第四个参数是要申请的权限
                    EasyPermissions.requestPermissions(this, "需要存储文件的权限", PERMIT_CODE_STORAGE, perms);
                }
            }
            break;

            case R.id.open_cancel:
            case R.id.get_pic_layout:
                finish();
                break;
        }
    }

}
