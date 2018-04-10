package com.trtjk.health.app.view.activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.trtjk.health.app.R;
import com.trtjk.health.app.utils.ResourceUtils;
import com.trtjk.health.app.view.adapter.HomeFragmentAdapter;
import com.trtjk.health.app.view.base.AppActivity;
import com.trtjk.health.app.view.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by WangChao on 18/3/6.
 */

public class HomeActivity extends AppActivity {
    @Bind(R.id.home_content)
    ViewPager container;
    @Bind(R.id.tab)
    TabLayout tab;
    private HomeFragmentAdapter adapter;

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void initData() {
        //Todo
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tab.setTabMode(TabLayout.MODE_FIXED);
        initTab();
        setListener();
        setAdapterAndNotify();
        container.setOffscreenPageLimit(3);
    }

    private void setAdapterAndNotify() {
        if (null == adapter) {
            adapter = new HomeFragmentAdapter(getSupportFragmentManager(), 3);
            container.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                container.setCurrentItem(position, false);
                tab.getCustomView().setEnabled(true);
                adapter.getItem(position).loadData();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setEnabled(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initTab() {
        LayoutInflater inflater = getLayoutInflater();
        TextView view;
        for (int i = 0; i < 3; i++) {
            view = (TextView) inflater.inflate(R.layout.tab_home_item, null);
            String text = null;
            Drawable drawable = null;
            switch (i) {
                case 0:
                    text = ResourceUtils.getString(R.string.tab_main);
                    view.setEnabled(true);
                    drawable = ResourceUtils.getDrawable(R.drawable.tab_main);
                    break;
                case 1:
                    text = ResourceUtils.getString(R.string.tab_message);
                    drawable = ResourceUtils.getDrawable(R.drawable.tab_message);
                    break;
                case 2:
                    text = ResourceUtils.getString(R.string.tab_mine);
                    drawable = ResourceUtils.getDrawable(R.drawable.tab_mine);
                    break;
            }
            view.setText(text);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            view.setCompoundDrawables(null, drawable, null, null);
            TabLayout.Tab tab = this.tab.newTab().setCustomView(view);
            this.tab.addTab(tab, i == 0 ? true : false);
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
