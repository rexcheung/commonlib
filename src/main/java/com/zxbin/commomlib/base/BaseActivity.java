package com.zxbin.commomlib.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zxbin on 2018/2/2.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void startActivity(Class clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }
}
