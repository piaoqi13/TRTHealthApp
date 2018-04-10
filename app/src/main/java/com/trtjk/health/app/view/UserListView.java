package com.trtjk.health.app.view;

import com.trtjk.health.app.domain.User;

import java.util.Collection;
/**
 * Created by WangChao on 18/3/6.
 */
public interface UserListView extends BaseView {
    void renderUserList(Collection<User> userModelCollection);

    void viewUser(User userModel);
}
