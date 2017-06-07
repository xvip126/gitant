package com.gitant.gitant.ui.startup;

import android.content.Context;
import android.os.SystemClock;
import android.widget.Toast;

import com.gitant.gitant.R;
import com.gitant.gitant.common.base.BaseActivity;
import com.gitant.gitant.common.eventbus.DelayMsg;
import com.gitant.gitant.ui.main.MianActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.com.ichile.bigbug.Logger;

public class SplashActivity extends BaseActivity {
    private Context mContext;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mContext = this;
        EventBus.getDefault().register(this);
    }

    @Override
    protected void processLogic() {

        new Thread() {
            @Override
            public void run() {
                Logger.i("ttttt","sleep...");
                SystemClock.sleep(3000);
                EventBus.getDefault().post(new DelayMsg(3000));
            }
        }.start();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DelayMsg delayMsg){
        Toast.makeText(mContext, "收到--" + delayMsg, Toast.LENGTH_SHORT).show();
        goActivity(mContext, MianActivity.class);
        finish();
    }


    @Override
    protected void destoryView() {
        EventBus.getDefault().unregister(this);
    }


}
