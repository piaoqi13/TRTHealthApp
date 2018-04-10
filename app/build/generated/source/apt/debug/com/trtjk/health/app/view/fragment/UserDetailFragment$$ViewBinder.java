// Generated code from Butter Knife. Do not modify!
package com.trtjk.health.app.view.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class UserDetailFragment$$ViewBinder<T extends com.trtjk.health.app.view.fragment.UserDetailFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165250, "field 'iv_cover'");
    target.iv_cover = finder.castView(view, 2131165250, "field 'iv_cover'");
    view = finder.findRequiredView(source, 2131165324, "field 'tv_fullname'");
    target.tv_fullname = finder.castView(view, 2131165324, "field 'tv_fullname'");
    view = finder.findRequiredView(source, 2131165322, "field 'tv_email'");
    target.tv_email = finder.castView(view, 2131165322, "field 'tv_email'");
    view = finder.findRequiredView(source, 2131165323, "field 'tv_followers'");
    target.tv_followers = finder.castView(view, 2131165323, "field 'tv_followers'");
    view = finder.findRequiredView(source, 2131165321, "field 'tv_description'");
    target.tv_description = finder.castView(view, 2131165321, "field 'tv_description'");
  }

  @Override public void unbind(T target) {
    target.iv_cover = null;
    target.tv_fullname = null;
    target.tv_email = null;
    target.tv_followers = null;
    target.tv_description = null;
  }
}
