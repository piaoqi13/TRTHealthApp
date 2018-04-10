package com.trtjk.health.app.view.activity;

import com.trtjk.health.app.R;
import com.trtjk.health.app.domain.User;
import com.trtjk.health.app.view.base.AppActivity;
import com.trtjk.health.app.view.base.BaseFragment;
import com.trtjk.health.app.view.fragment.UserListFragment;
/**
 * Created by WangChao on 18/3/6.
 */
public class UserListActivity extends AppActivity implements UserListFragment.UserListListener {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_list;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.content;
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return new UserListFragment();
    }

    @Override
    protected void initData() {
        //ToDo
    }

    @Override
    protected void initView() {
        //ToDo
    }

    @Override
    public void onUserClicked(User userModel) {
        if (null == userModel)
            return;
        navigator.toUserDetail(this, String.valueOf(userModel.getUserId()));
    }
}
