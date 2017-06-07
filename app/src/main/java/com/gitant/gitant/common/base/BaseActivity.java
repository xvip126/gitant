package com.gitant.gitant.common.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 9:48.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        initView();
        processLogic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destoryView();
    }


    protected abstract int setLayoutRes();

    protected abstract void initView();

    protected abstract void processLogic();

    protected abstract void destoryView();

    protected void goActivity(Context context, Class activityClass) {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }

}
