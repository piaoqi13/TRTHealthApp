package com.trtjk.health.app.internal.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiServiceModule_ProvideRxJavaCallAdapterFactoryFactory
    implements Factory<RxJavaCallAdapterFactory> {
  private final ApiServiceModule module;

  public ApiServiceModule_ProvideRxJavaCallAdapterFactoryFactory(ApiServiceModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public RxJavaCallAdapterFactory get() {
    return Preconditions.checkNotNull(
        module.provideRxJavaCallAdapterFactory(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RxJavaCallAdapterFactory> create(ApiServiceModule module) {
    return new ApiServiceModule_ProvideRxJavaCallAdapterFactoryFactory(module);
  }
}
