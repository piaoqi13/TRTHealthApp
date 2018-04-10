package com.trtjk.health.app.view;

import java.util.List;
/**
 * Created by WangChao on 18/3/6.
 */
public interface BaseView {
    void showLoading();

    void showEmptyView(String msg);

    void refreshView();

    void showNetError();

    void hasNoMoreData();

    void loadMoreFinish(List dates);

    void showRefreshFinish(List score);

    void showToastError();
}
