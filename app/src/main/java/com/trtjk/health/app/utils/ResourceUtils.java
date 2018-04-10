package com.trtjk.health.app.utils;

import android.graphics.drawable.Drawable;

import com.trtjk.health.app.TRTHealthApplication;
/**
 * Created by WangChao on 18/3/6.
 */
public class ResourceUtils {
    public static String getString(int id) {
        return TRTHealthApplication.mContext.getResources().getString(id);
    }

    public static Drawable getDrawable(int id) {
        return TRTHealthApplication.mContext.getResources().getDrawable(id);
    }

}
