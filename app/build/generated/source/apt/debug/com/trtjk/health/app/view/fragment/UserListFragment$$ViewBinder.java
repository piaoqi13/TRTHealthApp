// Generated code from Butter Knife. Do not modify!
package com.trtjk.health.app.view.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class UserListFragment$$ViewBinder<T extends com.trtjk.health.app.view.fragment.UserListFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165277, "field 'rv_users'");
    target.rv_users = finder.castView(view, 2131165277, "field 'rv_users'");
  }

  @Override public void unbind(T target) {
    target.rv_users = null;
  }
}
