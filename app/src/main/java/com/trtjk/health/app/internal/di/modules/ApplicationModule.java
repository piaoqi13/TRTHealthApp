package com.trtjk.health.app.internal.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
/**
 * Created by WangChao on 18/3/6.
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    protected Context provideApplicationContext() {
        return this.application;
    }
}
