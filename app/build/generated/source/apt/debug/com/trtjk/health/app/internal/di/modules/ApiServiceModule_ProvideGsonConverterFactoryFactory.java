package com.trtjk.health.app.internal.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiServiceModule_ProvideGsonConverterFactoryFactory
    implements Factory<GsonConverterFactory> {
  private final ApiServiceModule module;

  public ApiServiceModule_ProvideGsonConverterFactoryFactory(ApiServiceModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return Preconditions.checkNotNull(
        module.provideGsonConverterFactory(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<GsonConverterFactory> create(ApiServiceModule module) {
    return new ApiServiceModule_ProvideGsonConverterFactoryFactory(module);
  }
}
