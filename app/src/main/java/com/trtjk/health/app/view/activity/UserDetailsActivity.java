package com.trtjk.health.app.view.activity;

import android.content.Intent;

import com.trtjk.health.app.R;
import com.trtjk.health.app.config.Constants;
import com.trtjk.health.app.view.base.AppActivity;
import com.trtjk.health.app.view.base.BaseFragment;
import com.trtjk.health.app.view.fragment.UserDetailFragment;
/**
 * Created by WangChao on 18/3/6.
 */
public class UserDetailsActivity extends AppActivity {
    private String userId;

    @Override
    protected BaseFragment getFirstFragment() {
        return UserDetailFragment.getInstance(userId);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handleIntent(Intent intent) {
        if (null == intent)
            return;
        userId = intent.getStringExtra(Constants.USER_ID);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_details;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.content;
    }
}
