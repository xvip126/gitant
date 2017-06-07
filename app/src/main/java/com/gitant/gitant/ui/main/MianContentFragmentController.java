package com.gitant.gitant.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 16:39.
 * <p>
 * fragment controller for main content
 */

public class MianContentFragmentController {
    private static MianContentFragmentController mFragmentController;
    private static boolean mRelaod = true;
    private FragmentManager mFragmentManager;
    private int mContainerId;
    private ArrayList<Fragment> mFragments;

    MianContentFragmentController(FragmentActivity fragmentActivity, int containerId) {
        this.mFragmentManager = fragmentActivity.getSupportFragmentManager();
        this.mContainerId = containerId;
        initFragment();
    }

    public static MianContentFragmentController getInstance(FragmentActivity fragmentActivity, int
            containerId, boolean isReload) {
        if (mFragmentController == null) {
            mFragmentController = new MianContentFragmentController(fragmentActivity, containerId);
        }
        mRelaod = isReload;
        return mFragmentController;
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        if (mRelaod) {
            //add fragment to list which will be show in main content
            mFragments.add(null);
            //...
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            for (int i = 0; i < mFragments.size(); i++) {
                fragmentTransaction.add(mContainerId, mFragments.get(i), "" + i);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } else {
            //not safe . not use
            for (int i = 0; i < 5; i++) {
                mFragments.add(mFragmentManager.findFragmentByTag("" + i));
            }
        }
    }

    public void showFragment(int position) {
        hideAll();
        Fragment fragment = mFragments.get(position);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void hideAll() {
        if (mFragments != null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            for (Fragment fragment : mFragments) {
                if (fragment != null) {
                    fragmentTransaction.hide(fragment);
                }
            }
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    public Fragment getFragment(int position) {
        Fragment fragment = null;
        try {
            fragment = mFragments == null ? null : mFragments.get(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    }
}
