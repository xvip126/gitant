package com.gitant.gitant.ui.test;

import android.view.View;
import android.widget.Toast;

import com.gitant.gitant.R;
import com.gitant.gitant.common.base.BaseActivity;
import com.gitant.gitant.ui.widget.RightButton;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/8 - 18:25.
 */

public class TestActivity extends BaseActivity {
    @Override
    protected int setLayoutRes() {
        return R.layout.frag_mine;
    }

    @Override
    protected void initView() {
        RightButton viewById = (RightButton) findViewById(R.id.right_btn_like);
        viewById.setRightBtnOnclickLis(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void destoryView() {

    }
}
