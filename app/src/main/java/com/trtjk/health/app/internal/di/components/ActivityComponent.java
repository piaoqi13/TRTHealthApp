package com.trtjk.health.app.internal.di.components;

import android.app.Activity;

import com.trtjk.health.app.internal.di.PerActivity;
import com.trtjk.health.app.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by WangChao on 18/3/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
