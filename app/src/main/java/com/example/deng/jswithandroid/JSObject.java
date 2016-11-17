package com.example.deng.jswithandroid;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.List;

/**
 * Created by deng on 16-11-17.
 */

public class JSObject {
    private final Context context;

    public JSObject(MainActivity mainActivity) {
        this.context=mainActivity;
    }
    @JavascriptInterface
    public String JsCallAndroid(){
        Toast.makeText(context,"Js调用Android",Toast.LENGTH_SHORT).show();
        return "Js调用Android";
    }
    @JavascriptInterface
    public String JsCallAndroid(String s){
        Toast.makeText(context,"Js调用Android"+s,Toast.LENGTH_SHORT).show();
        return "Js调用Android";
    }
    @JavascriptInterface
    public void JsCallAndroidStartNew(){
        Intent intent = new Intent();
        intent.setClass(context,Main2Activity.class);
        context.startActivity(intent);
    }
}
