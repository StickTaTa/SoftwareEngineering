package com.example.bilibili;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private Channel myFragment1 = null;
    private Message myFragment2 = null;
    private Fatest_news myFragment3 = null;
    private Mine myFragment4 = null;

    public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);
        myFragment1 = new Channel();
        myFragment2 = new Message();
        myFragment3 = new Fatest_news();
        myFragment4 = new Mine();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

}
