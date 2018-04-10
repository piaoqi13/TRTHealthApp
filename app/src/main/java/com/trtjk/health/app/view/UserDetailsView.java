package com.trtjk.health.app.view;

import com.trtjk.health.app.domain.User;
/**
 * Created by WangChao on 18/3/6.
 */
public interface UserDetailsView extends BaseView {
    void renderUser(User user);
}
