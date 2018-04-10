package com.trtjk.health.app.rx;
/**
 * Created by WangChao on 18/3/6.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override
    public void onCompleted() {}

    @Override
    public void onError(Throwable e) {}

    @Override
    public void onNext(T t) {}
}