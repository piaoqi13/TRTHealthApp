// Generated code from Butter Knife. Do not modify!
package com.trtjk.health.app.view.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class UsersAdapter$UserViewHolder$$ViewBinder<T extends com.trtjk.health.app.view.adapter.UsersAdapter.UserViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165316, "field 'textViewTitle'");
    target.textViewTitle = finder.castView(view, 2131165316, "field 'textViewTitle'");
  }

  @Override public void unbind(T target) {
    target.textViewTitle = null;
  }
}
