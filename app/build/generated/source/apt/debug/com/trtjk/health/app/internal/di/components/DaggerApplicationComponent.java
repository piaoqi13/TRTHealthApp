package com.trtjk.health.app.internal.di.components;

import android.content.Context;
import com.trtjk.health.app.data.ApiService;
import com.trtjk.health.app.internal.di.modules.ApiServiceModule;
import com.trtjk.health.app.internal.di.modules.ApiServiceModule_ProvideApiServiceFactory;
import com.trtjk.health.app.internal.di.modules.ApiServiceModule_ProvideClientFactory;
import com.trtjk.health.app.internal.di.modules.ApiServiceModule_ProvideGsonConverterFactoryFactory;
import com.trtjk.health.app.internal.di.modules.ApiServiceModule_ProvideRxJavaCallAdapterFactoryFactory;
import com.trtjk.health.app.internal.di.modules.ApplicationModule;
import com.trtjk.health.app.internal.di.modules.ApplicationModule_ProvideApplicationContextFactory;
import com.trtjk.health.app.presenter.BasePresenter;
import com.trtjk.health.app.presenter.BasePresenter_MembersInjector;
import com.trtjk.health.app.view.base.BaseActivity;
import com.trtjk.health.app.view.base.BaseActivity_MembersInjector;
import com.trtjk.health.app.view.navigation.Navigator;
import com.trtjk.health.app.view.navigation.Navigator_Factory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
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
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<RxJavaCallAdapterFactory> provideRxJavaCallAdapterFactoryProvider;

  private Provider<GsonConverterFactory> provideGsonConverterFactoryProvider;

  private Provider<OkHttpClient> provideClientProvider;

  private Provider<ApiService> provideApiServiceProvider;

  private MembersInjector<BasePresenter> basePresenterMembersInjector;

  private Provider<Navigator> navigatorProvider;

  private MembersInjector<BaseActivity> baseActivityMembersInjector;

  private Provider<Context> provideApplicationContextProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideRxJavaCallAdapterFactoryProvider =
        DoubleCheck.provider(
            ApiServiceModule_ProvideRxJavaCallAdapterFactoryFactory.create(
                builder.apiServiceModule));

    this.provideGsonConverterFactoryProvider =
        DoubleCheck.provider(
            ApiServiceModule_ProvideGsonConverterFactoryFactory.create(builder.apiServiceModule));

    this.provideClientProvider =
        DoubleCheck.provider(
            ApiServiceModule_ProvideClientFactory.create(builder.apiServiceModule));

    this.provideApiServiceProvider =
        DoubleCheck.provider(
            ApiServiceModule_ProvideApiServiceFactory.create(
                builder.apiServiceModule,
                provideRxJavaCallAdapterFactoryProvider,
                provideGsonConverterFactoryProvider,
                provideClientProvider));

    this.basePresenterMembersInjector =
        BasePresenter_MembersInjector.create(provideApiServiceProvider);

    this.navigatorProvider = DoubleCheck.provider(Navigator_Factory.create());

    this.baseActivityMembersInjector = BaseActivity_MembersInjector.create(navigatorProvider);

    this.provideApplicationContextProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApplicationContextFactory.create(builder.applicationModule));
  }

  @Override
  public void inject(BasePresenter presenter) {
    basePresenterMembersInjector.injectMembers(presenter);
  }

  @Override
  public void inject(BaseActivity activity) {
    baseActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public Context context() {
    return provideApplicationContextProvider.get();
  }

  @Override
  public ApiService apiService() {
    return provideApiServiceProvider.get();
  }

  public static final class Builder {
    private ApiServiceModule apiServiceModule;

    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (apiServiceModule == null) {
        this.apiServiceModule = new ApiServiceModule();
      }
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder apiServiceModule(ApiServiceModule apiServiceModule) {
      this.apiServiceModule = Preconditions.checkNotNull(apiServiceModule);
      return this;
    }
  }
}
