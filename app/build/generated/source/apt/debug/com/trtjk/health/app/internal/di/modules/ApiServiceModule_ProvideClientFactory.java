package com.trtjk.health.app.internal.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiServiceModule_ProvideClientFactory implements Factory<OkHttpClient> {
  private final ApiServiceModule module;

  public ApiServiceModule_ProvideClientFactory(ApiServiceModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(ApiServiceModule module) {
    return new ApiServiceModule_ProvideClientFactory(module);
  }
}
