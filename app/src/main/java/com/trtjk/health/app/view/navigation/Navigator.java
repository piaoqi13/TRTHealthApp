package com.trtjk.health.app.view.navigation;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.trtjk.health.app.config.Constants;
import com.trtjk.health.app.view.activity.UserDetailsActivity;
import com.trtjk.health.app.view.activity.UserListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by WangChao on 18/3/6.
 */
@Singleton
public class Navigator {
    @Inject
    public Navigator() {}

    public void toUserDetail(Context context, String userId) {
        if (null == context || TextUtils.isEmpty(userId))
            return;
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(Constants.USER_ID, userId);
        context.startActivity(intent);
    }

    public void toUserList(Context context) {
        Intent intent = new Intent(context, UserListActivity.class);
        context.startActivity(intent);
    }
}
