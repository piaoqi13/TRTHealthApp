package com.trtjk.health.app.view.factory;

import android.util.SparseArray;

import com.trtjk.health.app.view.base.BaseFragment;
import com.trtjk.health.app.view.fragment.MainPageFragment;
import com.trtjk.health.app.view.fragment.MessageFragment;
import com.trtjk.health.app.view.fragment.MineFragment;

import java.lang.ref.SoftReference;

/**
 * Created by WangChao on 18/3/6.
 */
public class FragmentFactory {
    private static SparseArray<SoftReference<BaseFragment>> arr = new SparseArray<>();

    public static BaseFragment getFragment(int pos) {
        BaseFragment fragment = null;
        if (null != arr.get(pos))
            fragment = arr.get(pos).get();
        if (null == fragment) {
            switch (pos) {
                case 0:
                    fragment = new MainPageFragment();
                    break;
                case 1:
                    fragment = new MessageFragment();
                    break;
                case 2:
                    fragment = new MineFragment();
                    break;
            }
            arr.put(0, new SoftReference<>(fragment));
        }
        return fragment;
    }
}
