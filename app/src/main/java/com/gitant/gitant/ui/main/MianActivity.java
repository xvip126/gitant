package com.gitant.gitant.ui.main;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gitant.gitant.R;
import com.gitant.gitant.common.base.BaseMvpActivity;
import com.gitant.gitant.ui.test.TestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.ichile.bigbug.ActivityUtils;
import cn.com.ichile.bigbug.AppUtils;
import cn.com.ichile.bigbug.UIUtils;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 17:30.
 */

public class MianActivity extends BaseMvpActivity<MainContentContact.View, MainContentContact
        .Presenter> implements MainContentContact.View {

    @BindView(R.id.nb_bottom)
    public BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.rl_main_content)
    public RelativeLayout mMainContent;

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
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                            .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                            .setActiveColor(R.color.iconBlue)
                            .addItem(new BottomNavigationItem(R.drawable.selector_btn_git,"开源"))
                            .addItem(new BottomNavigationItem(R.drawable.selector_btn_repo,"仓库"))
                            .addItem(new BottomNavigationItem(R.drawable.selector_btn_find,"发现"))
                            .addItem(new BottomNavigationItem(R.drawable.selector_btn_mine,"我的"))
                            .setFirstSelectedPosition(0)
                            .initialise();
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {

            @Override
            public void onTabSelected(int position) {
                if (position == 2) {
                    ActivityUtils.startActivity(MianActivity.this, TestActivity.class);
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


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
