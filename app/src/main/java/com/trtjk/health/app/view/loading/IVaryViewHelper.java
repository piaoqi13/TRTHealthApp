package com.trtjk.health.app.view.loading;

import android.content.Context;
import android.view.View;
/**
 * Created by WangChao on 18/3/6.
 */
public interface IVaryViewHelper {

    public abstract View getCurrentLayout();

    public abstract void restoreView();

    public abstract void showLayout(View view);

    public abstract View inflate(int layoutId);

    public abstract Context getContext();

    public abstract View getView();

}