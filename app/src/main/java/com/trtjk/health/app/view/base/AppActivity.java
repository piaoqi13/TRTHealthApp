package com.trtjk.health.app.view.base;

import android.content.Intent;
import android.os.Bundle;

import com.trtjk.health.app.TRTHealthApplication;
/**
 * Created by WangChao on 18/3/6.
 */
public abstract class AppActivity extends BaseActivity {
    protected abstract BaseFragment getFirstFragment();

    protected void handleIntent(Intent intent) {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        TRTHealthApplication.getComponent().inject(this);
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        initView();
        initData();
        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }
    }

    protected abstract void initData();

    protected abstract void initView();

}