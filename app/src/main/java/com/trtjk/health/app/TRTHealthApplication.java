package com.trtjk.health.app;

import android.app.Application;
import android.content.Context;

import com.trtjk.health.app.internal.di.components.ApplicationComponent;
import com.trtjk.health.app.internal.di.components.DaggerApplicationComponent;
import com.trtjk.health.app.internal.di.modules.ApplicationModule;

/**
 * Created by WangChao on 18/3/6.
 */
public class TRTHealthApplication extends Application {
    public static Context mContext;
    private ApplicationComponent mComponent;

    public static ApplicationComponent getComponent() {
        return ((TRTHealthApplication) mContext.getApplicationContext()).mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

}
