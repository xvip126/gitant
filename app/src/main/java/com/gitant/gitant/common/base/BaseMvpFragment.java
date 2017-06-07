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
 * Created by WangZQ on 2017/6/7 - 16:12.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends Fragment {
    protected T mPresenter;
    protected FragmentActivity mFragmentActivity;
    private View mRootView;
    private boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return setFragmentRes(inflater, container, savedInstanceState);
    }

    protected abstract View setFragmentRes(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter == null) mPresenter = initPresenter();
        mFragmentActivity = getActivity();
        mRootView = view;
        bindView();
        processLogic();

        //lazy load
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
            onInVishable();
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
            onInVishable();
        }
    }

    private void onInVishable() {

    }

    private void onVisiable() {
        if (isFirstLoad) {
            lazyLoad();
            isFirstLoad = false;
        }
    }

    protected abstract void lazyLoad();

    protected abstract void processLogic();

    protected abstract void bindView();

    protected abstract T initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.dettachView();
            mPresenter = null;
        }
    }

}
