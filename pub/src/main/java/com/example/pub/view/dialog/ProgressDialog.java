package com.example.pub.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pub.R;


/**
 * description 进度框
 * author hanlei
 * version 1.0
 * created at 2016/11/18 10:32
 */
public class ProgressDialog {

    private AlertDialog mDialog;
    private TextView mTextView;

    private Runnable cancelRunnable = new Runnable() {
        public void run() {
            if (mDialog.isShowing()) {
                mDialog.cancel();
            }
        }
    };

    public ProgressDialog(Context context) {
        mDialog = new AlertDialog.Builder(context, R.style.dialog).create();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_progress, (ViewGroup) null);
        mTextView = (TextView) view.findViewById(R.id.h_progress_textview);
        setCancelable(true);
        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                mTextView.removeCallbacks(cancelRunnable);
            }
        });
        mDialog.show();
        mDialog.setContentView(view);
    }

    public void setCancelable(boolean cancelable) {
        mDialog.setCancelable(cancelable);
    }

    public void setText(String text) {
        mTextView.setText(text);
    }

    public void setText(int textID) {
        mTextView.setText(textID);
    }

    public void show() {
        mTextView.removeCallbacks(this.cancelRunnable);
        if (!mDialog.isShowing()) {
            mDialog.show();
        }

    }

    public boolean isShow(){

        if (mDialog != null){
            return mDialog.isShowing();
        }
        return false;
    }
    public void cancelImmediately() {

        if (mDialog != null && mDialog.isShowing()) {
            mDialog.cancel();
        }
    }

    public void cancel() {
        cancelImmediately();
//        if (mDialog!= null && mDialog.isShowing()){
//            mTextView.postDelayed(this.cancelRunnable, 500L);
//        }
    }
}
