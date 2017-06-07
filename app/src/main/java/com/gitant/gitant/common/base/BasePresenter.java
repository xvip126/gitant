package com.gitant.gitant.common.base;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 10:13.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void dettachView();

    //google ??
    void start();
}
