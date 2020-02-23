package com.eso.languageprefreneces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MyApplication.localeManager.setLocale(newBase));
    }
}
