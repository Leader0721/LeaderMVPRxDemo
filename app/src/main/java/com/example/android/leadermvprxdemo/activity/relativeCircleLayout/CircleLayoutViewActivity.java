package com.example.android.leadermvprxdemo.activity.relativeCircleLayout;

import android.os.Bundle;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.view.ToastUtils;

import butterknife.ButterKnife;

/**
 * @Description:Android 通用圆角布局，快速实现圆角需求。
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.relativeCircleLayout
 * @author: Leader
 * @date: 2018/1/25   16:38
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * <p>
 * 1. 基本用法
 * <p>
 * RCRelativeLayout(Round Corner RelativeLayout)，使用圆角布局包裹需要圆角的内容然后添加自定义属性即可
 * <p>
 * <com.gcssloop.widget.RCRelativeLayout
 * android:padding="20dp"
 * android:layout_width="match_parent"
 * android:layout_height="match_parent"
 * app:round_corner="40dp">
 * <p>
 * <!--任意View-->
 * <ImageView
 * android:scaleType="centerCrop"
 * android:src="@drawable/test"
 * android:layout_width="match_parent"
 * android:layout_height="match_parent"/>
 * <TextView
 * android:layout_width="match_parent"
 * android:layout_height="50dp"
 * android:background="#aaffffff"
 * android:gravity="center"
 * android:layout_alignParentBottom="true"
 * android:text="圆角测试"/>
 * <p>
 * </com.gcssloop.widget.RCRelativeLayout>
 * 2. 配置属性
 * <p>
 * 可以在布局文件中配置的属性如下：
 * <p>
 * 属性名称	摘要	是否必须设置	类型
 * round_corner	总体圆角半径	否	dp
 * round_corner_top_left	左上角圆角半径	否	dp
 * round_corner_top_right	右上角圆角半径	否	dp
 * round_corner_bottom_left	左下角圆角半径	否	dp
 * round_corner_bottom_right	右下角圆角半径	否	dp
 * round_as_circle	是否剪裁为圆形	否	boolean
 * stroke_width	描边半径	否	dp
 * stroke_color	描边颜色	否	color
 * 3. 属性简介
 * <p>
 * 3.1 圆角属性
 * <p>
 * round_as_circle 的权限最高，在默认情况下它的值为false，如果设置这个属性为 true，则会忽略圆角大小的数值，剪裁结果均为圆形。
 * <p>
 * 设置圆角大小的一共有5个属性，一个是全局的圆角大小round_corner，其余四个round_corner_xx_xx是分别对每一个角进行设置，它们之间存在替代关系。
 * <p>
 * 仅设置全局，所有的角都跟随全局。
 * 仅对某些角设置，则只有设置过的角会有圆角效果。
 * 全局和部分都有设置，则有具体设置的角跟随具体设置的数值，没有具体设置的角跟随全局设置。
 * 3.2 描边属性
 * <p>
 * 描边宽度stroke_width默认情况下数值为 0，即不存在描边效果。
 * 描边高度stroke_color默认情况下为白色，允许自定义颜色。
 * <p>
 * 4.添加方法
 * <p>
 * 4.1 添加仓库
 * <p>
 * 在项目的 build.gradle 文件中配置仓库地址。
 * <p>
 * allprojects {
 * repositories {
 * jcenter()
 * // 私有仓库地址
 * maven { url "http://lib.gcssloop.com:8081/repository/gcssloop-central/" }
 * }
 * }
 * 4.2 添加项目依赖
 * <p>
 * 在需要添加依赖的 Module 下添加以下信息，使用方式和普通的远程仓库一样。
 * <p>
 * compile 'com.gcssloop.widget:rclayout:1.4.1@aar'
 */

public class CircleLayoutViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circlelayout);
        ButterKnife.bind(this);
    }

    public void click(View view) {
        ToastUtils.showShort("Click");
    }

    public void bgclick(View view) {
        ToastUtils.showShort("BgClick");
    }
}
