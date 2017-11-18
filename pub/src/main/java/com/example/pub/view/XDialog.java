package com.example.pub.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.example.pub.view.dialog.CustomDialog;


/**
 * 自定义对话框管理类
 * <p>
 * 用法分为两种，一种普通用法，一种自定义用法，普通用法如下，自定义用法就是在Message部分传入自定义布局的Layout
 * <p>
 * XDialog dialog = new XDialog(this, "你好","标题","OK","cancel");
 * dialog.setOnDiaLogListener(new XDialog.OnDialogListener(){
 *
 * @Override public void dialogPositiveListener(View customView, DialogInterface dialogInterface, int which) {
 * Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
 * }
 * @Override public void dialogNegativeListener(View customView, DialogInterface dialogInterface, int which) {
 * Toast.makeText(MainActivity.this, "确定111", Toast.LENGTH_SHORT).show();
 * }
 * });
 * dialog.showDialog();//默认可以取消。默认确定按键可用。
 * dialog.showDialog(boolean isCanCancel);//第一个参数是是否可以取消。默认确定按键可用。
 * dialog.showDialog(boolean isCanCancel, boolean isPositiveEnable); //第一个参数是是否可以取消，默认可以取消。第二确定键是否可用，默认可用。
 * <p>
 * dialog.setPositiveButtonEnable(boolean isEnable); // 设置确认键是否可用
 */
public class XDialog {

    private Context context;
    private int customeLayoutId;
    private String dialogTitle;
    private String dialogMessage;
    private String positiveText;
    private String negativeText;

    private View dialogView;
    private OnDialogListener listener;
    CustomDialog.Builder dialog;

    private boolean isPositiveButtonEnable = true;

    /**
     * 带有自定义view的构造器
     *
     * @param context
     * @param customeLayoutId
     * @param dialogTitle
     * @param positiveText
     * @param negativeText
     */
    public XDialog(Context context, int customeLayoutId, String dialogTitle, String positiveText, String negativeText) {
        this.context = context;
        this.customeLayoutId = customeLayoutId;
        this.dialogTitle = dialogTitle;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.dialogView = View.inflate(context, customeLayoutId, null);
    }

    /**
     * 不带自定义view的构造器
     *
     * @param context
     * @param dialogMessage
     * @param dialogTitle
     * @param positiveText
     * @param negativeText
     */
    public XDialog(Context context, String dialogMessage, String dialogTitle, String positiveText, String negativeText) {
        this.context = context;
        this.dialogTitle = dialogTitle;
        this.dialogMessage = dialogMessage;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
    }

    /**
     * 获取自定义的view用于进一步操作
     *
     * @return
     */
    public View getDialogView() {
        return dialogView;
    }

    /**
     * 设置自定义View
     *
     * @param dialogView
     */
    public void setDialogView(View dialogView) {
        this.dialogView = dialogView;
    }

    /**
     * 显示对话框
     * 默认样式，不可以取消，确定按键初始可用
     */
    public void showDialog() {
        showDialog(true);
    }

    /**
     * 显示对话框
     */
    public void showDialog(int leftButtonBack, int rightButtonBack) {

        CustomDialog.Builder dialog = new CustomDialog.Builder(context);
        dialog.setTitle(dialogTitle);//设置标题

        //注意:dialogMessage和dialogView是互斥关系也就是dialogMessage存在dialogView就不存在,dialogView不存在dialogMessage就存在
        if (dialogMessage != null) {
            dialog.setMessage(dialogMessage);//设置对话框内容
        } else {
            dialog.setContentView(dialogView);//设置对话框的自定义view对象
        }


        dialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener != null) {
                    listener.dialogPositiveListener(dialogView, dialogInterface, which);
                }
            }
        }).setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener != null) {
                    listener.dialogNegativeListener(dialogView, dialogInterface, which);
                }
            }
        }).create(true, leftButtonBack, rightButtonBack).show();
    }

    /**
     * 显示对话框
     * 样式，确定按键初始可用
     *
     * @param isCanCancel
     */
    public void showDialog(boolean isCanCancel) {
        showDialog(isCanCancel, true);
    }

    /**
     * 显示对话框
     *
     * @param isCanCancel      是否可以取消
     * @param isPositiveEnable 确定按钮是否可用
     */
    public void showDialog(boolean isCanCancel, boolean isPositiveEnable) {

        dialog = new CustomDialog.Builder(context);
        dialog.setTitle(dialogTitle);//设置标题
        //注意:dialogMessage和dialogView是互斥关系也就是dialogMessage存在dialogView就不存在,dialogView不存在dialogMessage就存在
        if (dialogMessage != null) {
            dialog.setMessage(dialogMessage);//设置对话框内容
        } else {
            dialog.setContentView(dialogView);//设置对话框的自定义view对象
        }

        dialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                if (!isPositiveButtonEnable) {
                    return;
                }

                dialogInterface.dismiss();
                if (listener != null) {
                    listener.dialogPositiveListener(dialogView, dialogInterface, which);
                }
            }
        }).setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener != null) {
                    listener.dialogNegativeListener(dialogView, dialogInterface, which);
                }
            }
        }).create(isCanCancel, isPositiveEnable).show();
    }

    /**
     * 设置确定按钮是否可用
     *
     * @param isEnable
     */
    public void setPositiveButtonEnable(boolean isEnable) {
        isPositiveButtonEnable = isEnable;
        dialog.setPositiveButtonEnable(isEnable);
    }

    /**
     * 注册监听器方法
     *
     * @param listener
     * @return
     */
    public XDialog setOnDiaLogListener(OnDialogListener listener) {
        this.listener = listener;
        return this;//把当前对象返回,用于链式编程
    }

    //定义一个监听器接口
    public interface OnDialogListener {
        //customView　这个参数需要注意就是如果没有自定义view,那么它则为null
        public void dialogPositiveListener(View customView, DialogInterface dialogInterface, int which);

        public void dialogNegativeListener(View customView, DialogInterface dialogInterface, int which);
    }


}