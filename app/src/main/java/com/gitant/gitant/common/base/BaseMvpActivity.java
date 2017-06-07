package com.gitant.gitant.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 11:13.
 */

public abstract class BaseMvpActivity<V extends BaseView, T extends BasePresenter<V>> extends
        AppCompatActivity {
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        this.presenter = initPresenter();
        presenter.attachView((V) this);
        initView();
        bindView();
        processLogic();

    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    protected abstract void initView();

    protected abstract void bindView();

    protected abstract void processLogic();

    //init presenter
    protected abstract T initPresenter();

    protected abstract int setLayoutRes();
}
