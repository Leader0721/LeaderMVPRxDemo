package com.example.pub.view.headCrop;

import com.example.pub.common.BaseActivity;

/**
 * @Description:剪切头像的界面
 * @Prject:
 * @Package: com.example.pub.view.headCrop
 * @author: Leader
 * @date: 2017/11/16   17:12
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

/**
 * 剪切头像的界面
 * author 任统帅
 * version 1.0
 * created at 2017/7/21
 */
public class ClipImageViewActivity extends BaseActivity {
//
//    @BindView(R.id.xh_xheader)
//    XHeader xhXheader;
//    @BindView(R.id.cropImageView)
//    CropImageView cropImageView;
//    private String path = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_clipimageview);
//        ButterKnife.bind(this);
//        setTitle("裁剪");
//        cropImageView.setHandleShowMode(CropImageView.ShowMode.SHOW_ALWAYS);
////        cropImageView.setGuideShowMode(CropImageView.ShowMode.SHOW_ALWAYS);   如果设置了这个属性，虚线就会一直显示
//        cropImageView.setmIsScaling(true);
//
//        cropImageView.setCropMode(CropImageView.CropMode.RATIO_1_1);
//
//        if (!getIntent().hasExtra(GetPicActivity.KEY_FILE_PATH)) { // 如果没有值
//            setResult(RESULT_CANCELED);
//            finish();
//            return;
//        }
//        path = getIntent().getStringExtra(GetPicActivity.KEY_FILE_PATH);
//
//        LogUtils.e("getPic", "接收到拍照后的文件即将被裁剪：" + path + ",能正常看到图像，说明没问题");
//
//
//        //ImageView imageView = new ImageView(this);
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
//                .cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
//                .imageScaleType(ImageScaleType.NONE)
//                //.displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
//                .build();                                   // 创建配置过得DisplayImageOption对象
//        ImageLoader.getInstance().displayImage("file:///" + path, cropImageView, options);
//
//        //Bitmap bitmap = imageView.getDrawingCache();
//        //cropImageView.setImageBitmap(bitmap);
//
//        xhXheader.setRight("完成", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bitmap bitmap = cropImageView.getCroppedBitmap();
//                saveBitmap(bitmap);
//            }
//        });
//    }
//
//    /**
//     * 储存裁剪后的图片
//     *
//     * @param bitmap
//     */
//    private void saveBitmap(final Bitmap bitmap) {
//
//        final Handler handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                setResult(RESULT_OK);
//                LogUtils.e("getPic", "返回裁剪后的图像给GetPic处理。结果：" + RESULT_OK);
//                finish();
//            }
//        };
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                FileUtil.saveFileToSdcard(bitmap, path);
//
//                LogUtils.e("getPic", "被裁剪的文件被保存在：" + path);
//
//                handler.sendEmptyMessage(0);
//            }
//        }).start();
//    }


}
