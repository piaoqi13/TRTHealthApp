// Generated code from Butter Knife. Do not modify!
package com.trtjk.health.app.view.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomeActivity$$ViewBinder<T extends com.trtjk.health.app.view.activity.HomeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165244, "field 'container'");
    target.container = finder.castView(view, 2131165244, "field 'container'");
    view = finder.findRequiredView(source, 2131165310, "field 'tab'");
    target.tab = finder.castView(view, 2131165310, "field 'tab'");
  }

  @Override public void unbind(T target) {
    target.container = null;
    target.tab = null;
  }
}
