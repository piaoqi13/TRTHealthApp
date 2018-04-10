package com.trtjk.health.app.internal.di.components;

import android.content.Context;

import com.trtjk.health.app.data.ApiService;
import com.trtjk.health.app.internal.di.modules.ApiServiceModule;
import com.trtjk.health.app.internal.di.modules.ApplicationModule;
import com.trtjk.health.app.presenter.BasePresenter;
import com.trtjk.health.app.view.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by WangChao on 18/3/6.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiServiceModule.class})
public interface ApplicationComponent {
    void inject(BasePresenter presenter);

    void inject(BaseActivity activity);

    Context context();

    ApiService apiService();
}
