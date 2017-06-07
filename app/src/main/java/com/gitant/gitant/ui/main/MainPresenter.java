package com.gitant.gitant.ui.main;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 17:48.
 */

public class MainPresenter implements MainContentContact.Presenter {
    private MainContentContact.View mView;


    @Override
    public void attachView(MainContentContact.View view) {
        mView = view;
        view.setPresenter(this);
    }

    @Override
    public void dettachView() {
        if (mView != null) {
            mView = null;
        }
    }

    @Override
    public void start() {
        mView.showLoading(true);
        mView.showMsg("hhhhh");
    }
}
