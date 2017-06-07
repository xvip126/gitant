package com.gitant.gitant.common.base;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 10:04.
 */

public interface BaseView<P> {
    void setPresenter(P presenter);

    void showLoading(boolean show);

    void showMsg(String msg);

    void useNightMode(boolean nightMode);
}
