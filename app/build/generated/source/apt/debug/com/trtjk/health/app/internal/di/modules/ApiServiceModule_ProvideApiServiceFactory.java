package com.trtjk.health.app.internal.di.modules;

import com.trtjk.health.app.data.ApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiServiceModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final ApiServiceModule module;

  private final Provider<RxJavaCallAdapterFactory> rxJavaCallAdapterFactoryProvider;

  private final Provider<GsonConverterFactory> gsonConverterFactoryProvider;

  private final Provider<OkHttpClient> clientProvider;

  public ApiServiceModule_ProvideApiServiceFactory(
      ApiServiceModule module,
      Provider<RxJavaCallAdapterFactory> rxJavaCallAdapterFactoryProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider,
      Provider<OkHttpClient> clientProvider) {
    assert module != null;
    this.module = module;
    assert rxJavaCallAdapterFactoryProvider != null;
    this.rxJavaCallAdapterFactoryProvider = rxJavaCallAdapterFactoryProvider;
    assert gsonConverterFactoryProvider != null;
    this.gsonConverterFactoryProvider = gsonConverterFactoryProvider;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public ApiService get() {
    return Preconditions.checkNotNull(
        module.provideApiService(
            rxJavaCallAdapterFactoryProvider.get(),
            gsonConverterFactoryProvider.get(),
            clientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiService> create(
      ApiServiceModule module,
      Provider<RxJavaCallAdapterFactory> rxJavaCallAdapterFactoryProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider,
      Provider<OkHttpClient> clientProvider) {
    return new ApiServiceModule_ProvideApiServiceFactory(
        module, rxJavaCallAdapterFactoryProvider, gsonConverterFactoryProvider, clientProvider);
  }
}
