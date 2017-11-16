package com.example.pub.utils.app;
/**
 * @Description: WebView 工具类
 * 1.打开/关闭自适应
 * 2.打开/关闭缩放
 * 3.开启/关闭JS
 * 4.开启/关闭JS弹窗
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:28
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewUtils {
    private WebView webView;
    private WebSettings webSettings;

    public WebViewUtils(WebView webView) {
        this.webView = webView;
        webSettings = webView.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    }

    /**
     * 开启自适应功能
     */
    public WebViewUtils enableAdaptive() {
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        return this;
    }

    /**
     * 禁用自适应功能
     */
    public WebViewUtils disableAdaptive() {
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        return this;
    }

    /**
     * 开启缩放功能
     */
    public WebViewUtils enableZoom() {
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        return this;
    }

    /**
     * 禁用缩放功能
     */
    public WebViewUtils disableZoom() {
        webSettings.setSupportZoom(false);
        webSettings.setUseWideViewPort(false);
        webSettings.setBuiltInZoomControls(false);
        return this;
    }

    /**
     * 开启JavaScript
     */
    @SuppressLint("SetJavaScriptEnabled")
    public WebViewUtils enableJavaScript() {
        webSettings.setJavaScriptEnabled(true);
        return this;
    }

    /**
     * 禁用JavaScript
     */
    public WebViewUtils disableJavaScript() {
        webSettings.setJavaScriptEnabled(false);
        return this;
    }

    /**
     * 开启JavaScript自动弹窗
     */
    public WebViewUtils enableJavaScriptOpenWindowsAutomatically() {
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        return this;
    }

    /**
     * 禁用JavaScript自动弹窗
     */
    public WebViewUtils disableJavaScriptOpenWindowsAutomatically() {
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        return this;
    }

    /**
     * 返回
     *
     * @return true：已经返回，false：到头了没法返回了
     */
    public boolean goBack() {
        if (webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            return false;
        }
    }
}
