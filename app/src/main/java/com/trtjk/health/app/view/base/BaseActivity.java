package com.trtjk.health.app.view.base;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.trtjk.health.app.internal.di.modules.ActivityModule;
import com.trtjk.health.app.utils.log.KLog;
import com.trtjk.health.app.view.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by WangChao on 18/3/6.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    public Navigator navigator;
    protected String TAG = this.getClass().getSimpleName();
    protected abstract int getContentViewId();

    protected abstract int getFragmentContentId();

    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
            KLog.d(TAG, "finish");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    //配合Dagger2使用返回当前Activity中ActivityModule对象
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
