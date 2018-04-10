package com.trtjk.health.app.view.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trtjk.health.app.view.base.BaseFragment;
import com.trtjk.health.app.view.factory.FragmentFactory;

/**
 * Created by WangChao on 18/3/6.
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {
    private int count;

    public HomeFragmentAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public BaseFragment getItem(int position) {
        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
