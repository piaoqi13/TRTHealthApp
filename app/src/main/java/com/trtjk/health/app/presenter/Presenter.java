package com.trtjk.health.app.presenter;

/**
 * Created by WangChao on 18/3/6.
 */
public interface Presenter {
    void resume();

    void pause();

    void destroy();

    void requestData(Object... o);

}
