package com.trtjk.health.app.presenter;

import android.text.TextUtils;

import com.trtjk.health.app.domain.User;
import com.trtjk.health.app.rx.DefaultSubscriber;
import com.trtjk.health.app.view.UserDetailsView;
import com.trtjk.health.app.view.base.BaseFragment;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by WangChao on 18/3/6.
 */
public class UserDetailPresenter extends BasePresenter {

    private Subscription subscription;

    public UserDetailPresenter(UserDetailsView view) {
        mView = view;
    }

    @Override
    public void requestData(Object... o) {
        if (o == null)
            return;
        String userId = (String) o[0];
        if (TextUtils.isEmpty(userId))
            return;
        mView.showLoading();
        subscription = apiService.getUser(userId).compose(((BaseFragment) mView).<User>bindToLifecycle()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new UserDetailSubscriber());
    }

    @Override
    public void destroy() {
        super.destroy();
        subscription.unsubscribe();
    }

    public class UserDetailSubscriber extends DefaultSubscriber<User> {
        @Override
        public void onNext(User user) {
            if (user == null)
                mView.showEmptyView("No Data");
            else {
                mView.refreshView();
                ((UserDetailsView) mView).renderUser(user);
            }
        }

        @Override
        public void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onError(Throwable e) {
            mView.showNetError();
        }
    }
}
