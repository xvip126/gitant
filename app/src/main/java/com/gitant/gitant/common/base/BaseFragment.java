package com.gitant.gitant.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/7 - 13:42.
 */

public abstract class BaseFragment extends Fragment {
    protected FragmentActivity mFragmentActivity;
    protected View mRootView;
    private boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return setFragmentRes(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentActivity = getActivity();
        mRootView = view;
        bindView();
        processLogic();

        //for lazy load
        boolean isVisiable = isVisible() || getUserVisibleHint();
        if (isVisiable && isFirstLoad) {
            lazyLoad();
            isFirstLoad = false;
        }

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            onInVisiable();
        } else {
            onVisiable();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onVisiable();
        } else {
            onInVisiable();
        }
    }

    private void onVisiable() {
        if (isFirstLoad && isResumed()) {
            lazyLoad();
            isFirstLoad = false;
        }
    }

    private void onInVisiable() {

    }

    protected abstract void lazyLoad();


    protected abstract View setFragmentRes(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState);

    protected abstract void bindView();

    protected abstract void processLogic();
}
