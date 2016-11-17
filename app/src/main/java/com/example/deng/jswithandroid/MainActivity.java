package com.example.deng.jswithandroid;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mWebWebView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebWebView = (WebView) findViewById(R.id.web);
        mWebWebView.loadUrl("file:///android_asset/www/index.html");
        mWebWebView.getSettings().setJavaScriptEnabled(true);
        JSObject jsObject = new JSObject(MainActivity.this);
        mWebWebView.addJavascriptInterface(jsObject, "android");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.method1:
                mWebWebView.loadUrl("javascript:jsFunction()");
                break;
            case R.id.method2:
                mWebWebView.loadUrl("javascript:jsFunctionArg('[Android传递过来的数据]')");
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
