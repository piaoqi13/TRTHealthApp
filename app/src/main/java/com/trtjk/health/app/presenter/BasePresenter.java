package com.trtjk.health.app.presenter;

import com.trtjk.health.app.TRTHealthApplication;
import com.trtjk.health.app.data.ApiService;
import com.trtjk.health.app.view.BaseView;

import javax.inject.Inject;

/**
 * Created by WangChao on 18/3/6.
 */
public class BasePresenter implements Presenter {
    protected BaseView mView;
    @Inject
    ApiService apiService;

    public BasePresenter() {
        TRTHealthApplication.getComponent().inject(this);
    }

    protected ApiService getApiService() {
        return apiService;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {}

    @Override
    public void requestData(Object... o) {}
}
