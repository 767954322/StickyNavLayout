package com.tuwan.android.stickynavlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tuwan.android.stickynavlayout.tablayout.CustomViewPagerTab;
import com.tuwan.android.stickynavlayout.tablayout.SlidingTabLayout;

public class MainActivity extends FragmentActivity {

    public String[] mTitles = new String[]{"简介", "评价", "相关"};    //页卡标题集合
    private SlidingTabLayout mIndicator;
    private CustomViewPagerTab mViewPager;
    private FragmentPagerAdapter mAdapter;
    public TabFragment[] mFragments = new TabFragment[mTitles.length];
    private MyPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();

    }

    private void initViews() {

        mIndicator = (SlidingTabLayout) findViewById(R.id.id_stickynavlayout_indicator);
        mViewPager = (CustomViewPagerTab) findViewById(R.id.id_stickynavlayout_viewpager);

    }

    private void initDatas() {

        //设置下划线的高度
        mIndicator.setIndicatorHeight(4f);
        mIndicator.setIndicatorWidth(70f);
        //设置tab的字体大小
        mIndicator.setTextsize(14f);
        //初始化Fragment
        for (int i = 0; i < mTitles.length; i++) {
            mFragments[i] = (TabFragment) TabFragment.newInstance(mTitles[i]);
        }
        //初始化FragmentPagerAdapter
        mViewPager.setScanScroll(true);
        mViewPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        mIndicator.setViewPager(mViewPager);
        //初始位置
        mViewPager.setCurrentItem(0);

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments[position];
        }

    }


}



