package com.trtjk.health.app.internal.di.modules;

import android.app.Activity;

import com.trtjk.health.app.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WangChao on 18/3/6.
 */
@PerActivity
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    protected Activity provideActivity() {
        return this.activity;
    }
}
