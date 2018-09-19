package com.example.mousa.semitabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutInfo extends AppCompatActivity {
   WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutinfo);
        webView=(WebView) findViewById(R.id.showinfo);
        Bundle extras = getIntent().getExtras();
        webView.loadUrl(extras.getString("info"));

    }
}
