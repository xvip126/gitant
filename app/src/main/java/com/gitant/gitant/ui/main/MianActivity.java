package com.gitant.gitant.ui.main;

import android.content.Context;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gitant.gitant.R;
import com.gitant.gitant.common.base.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 17:30.
 */

public class MianActivity extends BaseMvpActivity<MainContentContact.View, MainContentContact
        .Presenter> implements MainContentContact.View {

    @BindView(R.id.nb_bottom)
    public BottomNavigationBar mBottomNavigationBar;

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
        ButterKnife.bind(this);
    }

    @Override
    protected void processLogic() {
        mPresenter.start();
        //
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round,"HOME"))
                .setActiveColor(R.color.colorTextPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round,"MORE"))
                .setActiveColor(R.color.colorTextPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round,"FIND"))
                .setActiveColor(R.color.colorTextPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round,"MINE"))
                .setActiveColor(R.color.colorTextPrimary)
                .setFirstSelectedPosition(0)
                .initialise();



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
