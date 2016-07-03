package com.example.hirokazu.sampledownloadtask.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.hirokazu.sampledownloadtask.R;

/**
 * Created by Hirokazu on 2016/07/03.
 */
public class WebViewActivity extends BaseActivity {

    @Override
    public void initView() {
        super.initView();
        //WebViewの生成
        WebView webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //javascriptを有効
        webSettings.setSaveFormData(false); //フォームデータの保存の有効・無効
        webSettings.setSupportZoom(false); //ズーム機能の有効・無効

        //WebViewの通知リクエストの処理
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //外部ブラウザではなく内部ブラウザを利用
                return false;
            }

            // エラー時に呼ばれる
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                toast("connect error");
            }
        });

        setContentView(webView);
        //HTMLの読み込み
        webView.loadUrl(getString(R.string.sample_url));

    }

    private void toast(String text) {
        if(text==null){
            text = "";
        }
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
