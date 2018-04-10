package com.trtjk.health.app.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trtjk.health.app.presenter.Presenter;
import com.trtjk.health.app.view.BaseView;
import com.trtjk.health.app.view.loading.VaryViewHelperController;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by WangChao on 18/3/6.
 */

public abstract class BaseFragment<T extends Presenter> extends RxFragment implements BaseView {
    protected BaseActivity mActivity;
    protected T mPresenter;
    private View contentView;
    private VaryViewHelperController mVaryViewHelperController;

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initData();

    public abstract void loadData();

    protected abstract int getLayoutId();

    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getChildFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    protected void removeFragment() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            getChildFragmentManager().popBackStack();
        }
    }

    protected abstract int getFragmentContentId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = inflater.inflate(getLayoutId(), container, false);
            initView(contentView, savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) contentView.getParent();
            if (parent != null) {
                parent.removeView(contentView);
            }
        }
        if (null == mVaryViewHelperController)
            mVaryViewHelperController = new VaryViewHelperController(getLoaingTargetView());
        if (null == mPresenter)
            mPresenter = getChildPresenter();
        return contentView;
    }

    protected abstract T getChildPresenter();

    protected abstract View getLoaingTargetView();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (null != this.getView()) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.INVISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mPresenter)
            mPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != mPresenter)
            mPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (null != mPresenter)
            mPresenter.destroy();
    }

    @Override
    public BaseActivity getContext() {
        return mActivity;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //Google bug
        outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showLoading() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showLoading();
    }

    @Override
    public void refreshView() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.restore();
    }

    @Override
    public void showNetError() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showNetworkError(v -> {
            showLoading();
            mPresenter.requestData(getRequestParams());
        });
    }

    @Override
    public void hasNoMoreData() {

    }

    @Override
    public void loadMoreFinish(List dates) {

    }

    @Override
    public void showRefreshFinish(List score) {

    }

    @Override
    public void showToastError() {

    }

    protected String getRequestParams() {
        return null;
    }

    @Override
    public void showEmptyView(String msg) {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showEmpty(msg);
    }
}