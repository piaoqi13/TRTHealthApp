package com.trtjk.health.app.presenter;

import com.trtjk.health.app.data.ApiService;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasePresenter_MembersInjector implements MembersInjector<BasePresenter> {
  private final Provider<ApiService> apiServiceProvider;

  public BasePresenter_MembersInjector(Provider<ApiService> apiServiceProvider) {
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  public static MembersInjector<BasePresenter> create(Provider<ApiService> apiServiceProvider) {
    return new BasePresenter_MembersInjector(apiServiceProvider);
  }

  @Override
  public void injectMembers(BasePresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.apiService = apiServiceProvider.get();
  }

  public static void injectApiService(
      BasePresenter instance, Provider<ApiService> apiServiceProvider) {
    instance.apiService = apiServiceProvider.get();
  }
}
