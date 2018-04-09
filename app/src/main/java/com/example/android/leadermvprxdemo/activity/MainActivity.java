package com.example.android.leadermvprxdemo.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.graphics.Palette;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.PicsLayoutView.style_one.PicsLayoutView1Activity;
import com.example.android.leadermvprxdemo.activity.PicsLayoutView.style_two.PicsLayoutView2Activity;
import com.example.android.leadermvprxdemo.activity.addDeleteView.AddDeleteViewActivity;
import com.example.android.leadermvprxdemo.activity.androidExcelPanelView.ExcelPanelActivity;
import com.example.android.leadermvprxdemo.activity.androidExcelView.ExcelViewActivity;
import com.example.android.leadermvprxdemo.activity.baiduWaveView.BaiduWaveLoadingActivity;
import com.example.android.leadermvprxdemo.activity.bezierIndicator.BezierIndicatorActivity;
import com.example.android.leadermvprxdemo.activity.bezierView.BezierViewActivity;
import com.example.android.leadermvprxdemo.activity.blueTooth.BlueToothActivity;
import com.example.android.leadermvprxdemo.activity.bottomBarLayoutView.BottomBarLayoutActivity;
import com.example.android.leadermvprxdemo.activity.cardView.CardViewActivity;
import com.example.android.leadermvprxdemo.activity.circleCounter.CircularCounterActivity;
import com.example.android.leadermvprxdemo.activity.cloudEditText.CloudEditTextActivity;
import com.example.android.leadermvprxdemo.activity.countDownView.CountDownViewActivity;
import com.example.android.leadermvprxdemo.activity.dashBoardView.DashBoardViewActivity;
import com.example.android.leadermvprxdemo.activity.delicateView.DelicateViewActivity;
import com.example.android.leadermvprxdemo.activity.diyKeyBorad.DiyKeyBoardActivity;
import com.example.android.leadermvprxdemo.activity.flowLayout.FlowLayoutActivity;
import com.example.android.leadermvprxdemo.activity.horizontalExpandMenu.HorizontalExpandMenuActivity;
import com.example.android.leadermvprxdemo.activity.jdStepView.JdStepViewActivity;
import com.example.android.leadermvprxdemo.activity.launchView.LauncherViewActivity;
import com.example.android.leadermvprxdemo.activity.leiDa.LeiDaActivity;
import com.example.android.leadermvprxdemo.activity.likeView.LikeViewActivity;
import com.example.android.leadermvprxdemo.activity.lockView.LockViewActivity;
import com.example.android.leadermvprxdemo.activity.luban.LubanActivity;
import com.example.android.leadermvprxdemo.activity.marqueenView.MarqueeActivity;
import com.example.android.leadermvprxdemo.activity.miClickView.MiClockViewActivity;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.MultiLevelActivity;
import com.example.android.leadermvprxdemo.activity.musicWaveView.MusicWaveActivity;
import com.example.android.leadermvprxdemo.activity.note_text.NormalActivity;
import com.example.android.leadermvprxdemo.activity.note_text.RichActivity;
import com.example.android.leadermvprxdemo.activity.numberAnimView.NumberAnimTextViewActivity;
import com.example.android.leadermvprxdemo.activity.panelView.PanelViewActivity;
import com.example.android.leadermvprxdemo.activity.postmanViewLoading.PostManLoadingActivity;
import com.example.android.leadermvprxdemo.activity.progressRunView.ProgressRunViewActivity;
import com.example.android.leadermvprxdemo.activity.qianDao.QianDaoActivity;
import com.example.android.leadermvprxdemo.activity.radarCycleView.RadarCycleViewActivity;
import com.example.android.leadermvprxdemo.activity.rangeSeekBar.SeekBarViewActivity;
import com.example.android.leadermvprxdemo.activity.record_mp3.RecordMp3Activity;
import com.example.android.leadermvprxdemo.activity.redarView.RadarViewActivity;
import com.example.android.leadermvprxdemo.activity.relativeCircleLayout.CircleLayoutViewActivity;
import com.example.android.leadermvprxdemo.activity.roundProgress.RoundProgressActivity;
import com.example.android.leadermvprxdemo.activity.screenRecorder.ScreenRecorderActivity;
import com.example.android.leadermvprxdemo.activity.shineTextView.ShimmerActivity;
import com.example.android.leadermvprxdemo.activity.slideRulerView.SlideRulerViewActivity;
import com.example.android.leadermvprxdemo.activity.spanStringView.SpanStringViewActivity;
import com.example.android.leadermvprxdemo.activity.stateButtonView.StateButtonViewActivity;
import com.example.android.leadermvprxdemo.activity.swipCardTanTan.SwipCardViewActivity;
import com.example.android.leadermvprxdemo.activity.swipMenuListView.ui.SwipMenuListViewActivity;
import com.example.android.leadermvprxdemo.activity.switchButtonView.SwitchButtonViewActivity;
import com.example.android.leadermvprxdemo.activity.textSelectedableHelper.TextSelectedHelperActivity;
import com.example.android.leadermvprxdemo.activity.tickView.TickViewActivity;
import com.example.android.leadermvprxdemo.activity.toggleButton.ToggleButtonActivity;
import com.example.android.leadermvprxdemo.activity.topSearchView.demo.TopSearchViewActivity;
import com.example.android.leadermvprxdemo.activity.viewPagerCard.ViewPagerCardActivity;
import com.example.android.leadermvprxdemo.activity.voiceLine.VoiceLineActivity;
import com.example.android.leadermvprxdemo.activity.waveLoadingView.WaveLoadingViewActivity;
import com.example.android.leadermvprxdemo.activity.wavePercentView.WavePercentActivity;
import com.example.android.leadermvprxdemo.activity.wave_titanic.TitanicViewActivity;
import com.example.android.leadermvprxdemo.activity.weatherView.WeatherViewActivity;
import com.example.android.leadermvprxdemo.activity.wheelView_3d.WheelView3DActivity;
import com.example.android.leadermvprxdemo.activity.xiaoMiStepView.XiaoMiStepViewActivity;
import com.example.android.leadermvprxdemo.adapter.MainAdapter;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.app.Utils;
import com.example.pub.utils.function.LogUtils;
import com.example.pub.utils.view.AppSystemBarMgr;
import com.example.pub.utils.view.BitmapUtils;
import com.example.pub.utils.view.SecurityCodeUtils;
import com.example.pub.utils.view.SnackbarUtils;
import com.example.pub.utils.view.ToastUtils;
import com.example.pub.utils.view.ViewAnimationUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.lv_content)
    ListView lvContent;
    @BindView(R.id.ll_total)
    LinearLayout llTotal;
    @BindView(R.id.iv_content)
    ImageView ivContent;
    private MainAdapter mainAdapter;
    private List<String> listString = new ArrayList<>();
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        listString.add((index++) + "属性最多的带有图片的吐司验证");
        listString.add((index++) + "带有图片的长吐司验证");
        listString.add((index++) + "带有图片的短吐司验证");
        listString.add((index++) + "SnackBar");
        listString.add((index++) + "验证码图片验证");
        listString.add((index++) + "视图动画验证");
        listString.add((index++) + "视图动画验证");
        listString.add((index++) + "视图动画验证，图片渐渐消失");
        listString.add((index++) + "视图动画验证，从新进行显示");
        listString.add((index++) + "懷舊  对图片进行的一些特效处理");
        listString.add((index++) + "浮雕    对图片进行的一些特效处理");
        listString.add((index++) + "黑白   对图片进行的一些特效处理");
        listString.add((index++) + "异步加载获取图片的主色调    对图片进行的一些特效处理");
        listString.add((index++) + "DownMenu效果");
        listString.add((index++) + "拖拽填空");
        listString.add((index++) + "流式布局");
        listString.add((index++) + "步骤完成StepView");
        listString.add((index++) + "图片压缩框架LuBan");
        listString.add((index++) + "波纹效果的文字下载效果");
        listString.add((index++) + "多层列表");
        listString.add((index++) + "一闪而过的字体样式");
        listString.add((index++) + "正常样式____可绘制下划线，笔记标志和点击弹框的TextView");
        listString.add((index++) + "复杂样式____可绘制下划线，笔记标志和点击弹框的TextView");
        listString.add((index++) + "贝塞尔曲线水滴效果导航栏");
        listString.add((index++) + "雷达相关的视图");
        listString.add((index++) + "根据声音大小进行波段图的绘制");
        listString.add((index++) + "签到的自定义视图");
        listString.add((index++) + "贝塞尔曲线的几个小自定义view");
        listString.add((index++) + "原型进度条roundProgress");
        listString.add((index++) + "打对号的动画效果");
        listString.add((index++) + "锁屏的一个视图");
        listString.add((index++) + "带有百分比的波浪视图");
        listString.add((index++) + "跑马灯的效果");
        listString.add((index++) + "音乐跳动动效自定义视图");
        listString.add((index++) + "SeekBar进度相关的视图");
        listString.add((index++) + "自定义键盘自定义视图，可以用一个popupWindow来实现，可以封装一下");
        listString.add((index++) + "仿京东物流配送流程图");
        listString.add((index++) + "纵向的可以收缩扩展的Menu");
        listString.add((index++) + "各式各样的雷达图");
        listString.add((index++) + "样式齐全的倒计时的图");
        listString.add((index++) + "模仿探探的一款滑动移除图片的自定义view");
        listString.add((index++) + "模仿postman的一个加载动画");
        listString.add((index++) + "模仿小米闹钟的一个自定义view");
        listString.add((index++) + "模仿小米天气的一个自定义view");
        listString.add((index++) + "数字动画跳动变化");
        listString.add((index++) + "高仿京东金融的数值滚动尺");
        listString.add((index++) + "3d效果的一个滑动轮");
        listString.add((index++) + "Android 通用圆角布局，快速实现圆角需求");
        listString.add((index++) + "仿QQ向左滑动弹出菜单的布局");
        listString.add((index++) + "波浪纹的下载自定义视图");
        listString.add((index++) + "模仿小米手环App首页的展示计步数据的自定义View");
        listString.add((index++) + "一种堆叠头像的点赞效果第一种");
        listString.add((index++) + "一种堆叠头像的点赞效果第二种");
        listString.add((index++) + "原生的仿Excel表格形式的自定义视图1");
        listString.add((index++) + "弧形流量条控件");
        listString.add((index++) + "原生的仿Excel表格形式的自定义视图2");
        listString.add((index++) + "购物车添加减去自定义view");
        listString.add((index++) + "利用StringSpan实现多种字体效果");
        listString.add((index++) + "switchButton自定义视图");
        listString.add((index++) + "各种精致的小动画");
        listString.add((index++) + "雷达扫描的一个自定义view");
        listString.add((index++) + "录音机录成mp3格式的文件");
        listString.add((index++) + "Android 5.0 引入 MediaProject 可以不用 root 就可以录屏");
        listString.add((index++) + "textView选择之后的操作");
        listString.add((index++) + "一个卡片滑动的效果");
        listString.add((index++) + "汽车刻度盘的一个自定义视图");
        listString.add((index++) + "各种状态的按钮，各种属性定制");
        listString.add((index++) + "底部的菜单栏，多种功能");
        listString.add((index++) + "点赞的视图");
        listString.add((index++) + "启动页的动画效果");
        listString.add((index++) + "蓝牙模块");
        listString.add((index++) + "可编辑的EditText");
        listString.add((index++) + "按钮开关");
        listString.add((index++) + "一个美观的cardView");
        listString.add((index++) + "顶部搜索框");
        listString.add((index++) + "侧边栏的自定义view");
        listString.add((index++) + "多层圆计数自定义视图");
        listString.add((index++) + "百度动画的加载效果");


        initView();
    }


    private void initView() {
        mainAdapter = new MainAdapter(this, listString);
        lvContent.setAdapter(mainAdapter);
        lvContent.setOnItemClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                ToastUtils.showWithPic("这个是带有图片的", R.mipmap.ic_launcher, R.color.white, 3000, Gravity.BOTTOM, 0, 0, R.drawable.bg_btn_ok_nomal);
                break;
            case 1:
                ToastUtils.showWithPicLong("长吐司验证，带有图片的", R.mipmap.ic_launcher);
                break;
            case 2:
                ToastUtils.showWithPicShort("短吐司验证，带有图片的", R.mipmap.ic_launcher);
                break;
            case 3:
                SnackbarUtils.showLong(view, "dddddddddd", Utils.getApp().getColor(R.color.red), Utils.getApp().getColor(R.color.black));
                break;
            case 4:
                Bitmap bitmap = SecurityCodeUtils.getInstance().createBitmap();
                ivContent.setImageBitmap(bitmap);
                ToastUtils.showShort(SecurityCodeUtils.getInstance().getCode());
                break;
            case 5:
                ViewAnimationUtils.shake(ivContent);
                break;
            case 6://在执行动画的过程中是否禁止点击
                ViewAnimationUtils.shake(ivContent, false);
                break;
            case 7:
                ViewAnimationUtils.goneViewByAlpha(ivContent);
                break;
            case 8:
                ViewAnimationUtils.visibleViewByAlpha(ivContent);
                break;
            case 9:
                ivContent.setImageBitmap(BitmapUtils.nostalgic(BitmapUtils.getBitmap(ivContent)));
                break;
            case 10:
                ivContent.setImageBitmap(BitmapUtils.emboss(BitmapUtils.getBitmap(ivContent)));
                break;
            case 11:
                ivContent.setImageBitmap(BitmapUtils.convertToBlackWhite(BitmapUtils.getBitmap(ivContent)));
                break;
            case 12:
                LogUtils.sLogSwitch = false;
                LogUtils.d("rentong", "dddddddddddddddasdflasdfklasdjfasldfj" + LogUtils.sLogSwitch);
                LogUtils.i("rentong", "大速度发是打发三大速度发阿呆as" + LogUtils.sLogSwitch);
                LogUtils.sLogSwitch = true;
                LogUtils.d("rentong", "dddddddddddddddasdflasdfklasdjfasldfj" + LogUtils.sLogSwitch);
                LogUtils.i("rentong", "大速度发是打发三大速度发阿呆as" + LogUtils.sLogSwitch);
                Palette.from(BitmapUtils.getBitmap(ivContent)).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch swatch = palette.getMutedSwatch();
                        //Palette.Swatch swatch = palette.getVibrantSwatch();
                        //Palette.Swatch swatch = palette.getDarkMutedSwatch();
                        //Palette.Swatch swatch = palette.getDarkVibrantSwatch();
                        //Palette.Swatch swatch = palette.getLightMutedSwatch();
                        //Palette.Swatch swatch = palette.getLightVibrantSwatch();
                        if (swatch != null) {
                            ToastUtils.showShort(swatch.getRgb() + "");
                            AppSystemBarMgr.setColor(MainActivity.this, swatch.getRgb());
                            llTotal.setBackgroundColor(swatch.getRgb());
                        } else {
                            LogUtils.e("smallsoho", "swatch为空");
                        }
                    }
                });
                break;
            case 13:
                openActivity(DownTabActivity.class, null);
                break;
            case 14:
                openActivity(DragBlankActivity.class, null);
                break;
            case 15:
                openActivity(FlowLayoutActivity.class, null);
                break;
            case 16:
                openActivity(StepViewActivity.class, null);
                break;
            case 17:
                openActivity(LubanActivity.class, null);
                break;
            case 18:
                openActivity(TitanicViewActivity.class, null);
                break;
            case 19:
                openActivity(MultiLevelActivity.class, null);
                break;
            case 20:
                openActivity(ShimmerActivity.class, null);
                break;
            case 21:
                openActivity(NormalActivity.class, null);
                break;
            case 22:
                openActivity(RichActivity.class, null);
                break;
            case 23:
                openActivity(BezierIndicatorActivity.class, null);
                break;
            case 24:
                openActivity(LeiDaActivity.class, null);
                break;
            case 25:
                openActivity(VoiceLineActivity.class, null);
                break;
            case 26:
                openActivity(QianDaoActivity.class, null);
                break;
            case 27:
                openActivity(BezierViewActivity.class, null);
                break;
            case 28:
                openActivity(RoundProgressActivity.class, null);
                break;
            case 29:
                openActivity(TickViewActivity.class, null);
                break;
            case 30:
                openActivity(LockViewActivity.class, null);
                break;
            case 31:
                openActivity(WavePercentActivity.class, null);
                break;
            case 32:
                openActivity(MarqueeActivity.class, null);
                break;
            case 33:
                openActivity(MusicWaveActivity.class, null);
                break;
            case 34:
                openActivity(SeekBarViewActivity.class, null);
                break;
            case 35:
                openActivity(DiyKeyBoardActivity.class, null);
                break;
            case 36:
                openActivity(JdStepViewActivity.class, null);
                break;
            case 37:
                openActivity(HorizontalExpandMenuActivity.class, null);
                break;
            case 38:
                openActivity(RadarViewActivity.class, null);
                break;
            case 39:
                openActivity(CountDownViewActivity.class, null);
                break;
            case 40:
                openActivity(SwipCardViewActivity.class, null);
                break;
            case 41:
                openActivity(PostManLoadingActivity.class, null);
                break;
            case 42:
                openActivity(MiClockViewActivity.class, null);
                break;
            case 43:
                openActivity(WeatherViewActivity.class, null);
                break;
            case 44:
                openActivity(NumberAnimTextViewActivity.class, null);
                break;
            case 45:
                openActivity(SlideRulerViewActivity.class, null);
                break;
            case 46:
                openActivity(WheelView3DActivity.class, null);
                break;
            case 47:
                openActivity(CircleLayoutViewActivity.class, null);
                break;
            case 48:
                openActivity(SwipMenuListViewActivity.class, null);
                break;
            case 49:
                openActivity(WaveLoadingViewActivity.class, null);
                break;
            case 50:
                openActivity(XiaoMiStepViewActivity.class, null);
                break;
            case 51:
                openActivity(PicsLayoutView1Activity.class, null);
                break;
            case 52:
                openActivity(PicsLayoutView2Activity.class, null);
                break;
            case 53:
                openActivity(ExcelViewActivity.class, null);
                break;
            case 54:
                openActivity(ProgressRunViewActivity.class, null);
                break;
            case 55:
                openActivity(ExcelPanelActivity.class, null);
                break;
            case 56:
                openActivity(AddDeleteViewActivity.class, null);
                break;
            case 57:
                openActivity(SpanStringViewActivity.class, null);
                break;
            case 58:
                openActivity(SwitchButtonViewActivity.class, null);
                break;
            case 59:
                openActivity(DelicateViewActivity.class, null);
                break;
            case 60:
                openActivity(RadarCycleViewActivity.class, null);
                break;
            case 61:
                openActivity(RecordMp3Activity.class, null);
                break;
            case 62:
                openActivity(ScreenRecorderActivity.class, null);
                break;
            case 63:
                openActivity(TextSelectedHelperActivity.class, null);
                break;
            case 64:
                openActivity(ViewPagerCardActivity.class, null);
                break;
            case 65:
                openActivity(DashBoardViewActivity.class, null);
                break;
            case 66:
                openActivity(StateButtonViewActivity.class, null);
                break;
            case 67:
                openActivity(BottomBarLayoutActivity.class, null);
                break;
            case 68:
                openActivity(LikeViewActivity.class, null);
                break;
            case 69:
                openActivity(LauncherViewActivity.class, null);
                break;
            case 70:
                openActivity(BlueToothActivity.class, null);
                break;
            case 71:
                openActivity(CloudEditTextActivity.class, null);
                break;
            case 72:
                openActivity(ToggleButtonActivity.class, null);
                break;
            case 73:
                openActivity(CardViewActivity.class, null);
                break;
            case 74:
                openActivity(TopSearchViewActivity.class, null);
                break;
            case 75:
                openActivity(PanelViewActivity.class, null);
                break;
            case 76:
                openActivity(CircularCounterActivity.class, null);
                break;
            case 77:
                openActivity(BaiduWaveLoadingActivity.class, null);
                break;
        }
    }
}
