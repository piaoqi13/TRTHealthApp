package com.trtjk.health.app.presenter;

import com.trtjk.health.app.domain.User;
import com.trtjk.health.app.rx.DefaultSubscriber;
import com.trtjk.health.app.view.UserListView;
import com.trtjk.health.app.view.base.BaseFragment;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by WangChao on 18/3/6.
 */
public class UserListPresenter extends BasePresenter {
    private UserListView mView;
    private Subscription subscription;

    public UserListPresenter(UserListView view) {
        mView = view;
    }

    @Override
    public void requestData(Object... o) {
        mView.showLoading();
        subscription = apiService.getUserList()
                .compose(((BaseFragment) mView).<List<User>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new UserListSubscriber());
    }

    public void onUserClicked(User userModel) {
        mView.viewUser(userModel);
    }

    @Override
    public void destroy() {
        super.destroy();
        if (subscription != null)
            subscription.unsubscribe();
    }

    public class UserListSubscriber extends DefaultSubscriber<List<User>> {
        @Override
        public void onNext(List<User> users) {
            if (users == null || users.size() == 0)
                mView.showEmptyView("No Data");
            else {
                mView.refreshView();
                mView.renderUserList(users);
            }
        }

        @Override
        public void onError(Throwable e) {
            mView.showNetError();
        }
    }
}
