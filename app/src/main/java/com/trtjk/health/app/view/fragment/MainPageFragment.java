package com.trtjk.health.app.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.trtjk.health.app.R;
import com.trtjk.health.app.presenter.Presenter;
import com.trtjk.health.app.view.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by WangChao on 18/3/6.
 */
public class MainPageFragment extends BaseFragment {
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        initAdapter();
        setListener();
    }

    private void initAdapter() {
        //ToDo
    }

    private void setListener() {
        //ToDo
    }

    @Override
    protected void initData() {
        //ToDo
    }

    @Override
    public void loadData() {
        //ToDo
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_page;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    protected Presenter getChildPresenter() {
        return null;
    }

    @Override
    protected View getLoaingTargetView() {
        return null;
    }
}
