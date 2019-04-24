package com.seffu.morningprojectseven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView mtandao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtandao = findViewById(R.id.web);
        WebSettings settings = mtandao.getSettings();
        settings.setJavaScriptEnabled(true);
        mtandao.loadUrl("file:///android_asset/home.html");
    }
}
