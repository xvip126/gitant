package com.gitant.gitant.ui.main;

import android.content.Context;
import android.widget.Toast;

import com.gitant.gitant.R;
import com.gitant.gitant.common.base.BaseMvpActivity;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 17:30.
 */

public class MianActivity extends BaseMvpActivity<MainContentContact.View, MainContentContact
        .Presenter> implements MainContentContact.View {
    private MainContentContact.Presenter mPresenter;
    private Context mContext;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContentContact.Presenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setPresenter(MainContentContact.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void initView() {
        mContext = this;
    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void processLogic() {
        mPresenter.start();
    }


    @Override
    public void showLoading(boolean show) {
        Toast.makeText(mContext, "show loading ...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void useNightMode(boolean nightMode) {

    }
}
