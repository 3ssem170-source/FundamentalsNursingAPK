package com.fundamentalsofnursing.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String APP_URL = "https://3ssem170-source.github.io/-/nursing.html";
    private WebView webView;
    private TextView offlineMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(15, 28, 30));
        getWindow().setNavigationBarColor(Color.rgb(15, 28, 30));

        FrameLayout root = new FrameLayout(this);
        webView = new WebView(this);
        offlineMessage = new TextView(this);
        offlineMessage.setText("تعذر الاتصال بالإنترنت. تحقق من الاتصال ثم أعد فتح التطبيق.");
        offlineMessage.setTextColor(Color.WHITE);
        offlineMessage.setTextSize(18);
        offlineMessage.setGravity(android.view.Gravity.CENTER);
        offlineMessage.setPadding(32, 32, 32, 32);
        offlineMessage.setBackgroundColor(Color.rgb(15, 28, 30));
        offlineMessage.setVisibility(View.GONE);
        root.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        root.addView(offlineMessage, new FrameLayout.LayoutParams(-1, -1));
        setContentView(root);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true); // needed by nursing_v1 localStorage progress
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                offlineMessage.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                if (request.isForMainFrame()) {
                    offlineMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        if (savedInstanceState == null) {
            webView.loadUrl(APP_URL);
        } else {
            webView.restoreState(savedInstanceState);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (webView != null) webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.stopLoading();
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
