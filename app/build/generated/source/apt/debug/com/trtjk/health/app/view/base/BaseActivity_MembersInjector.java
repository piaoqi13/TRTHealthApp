package com.trtjk.health.app.view.base;

import com.trtjk.health.app.view.navigation.Navigator;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
  private final Provider<Navigator> navigatorProvider;

  public BaseActivity_MembersInjector(Provider<Navigator> navigatorProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  public static MembersInjector<BaseActivity> create(Provider<Navigator> navigatorProvider) {
    return new BaseActivity_MembersInjector(navigatorProvider);
  }

  @Override
  public void injectMembers(BaseActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.navigator = navigatorProvider.get();
  }
}
