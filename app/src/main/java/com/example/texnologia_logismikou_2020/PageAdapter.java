package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public PageAdapter(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new proptyxiako_first();
            case 1:
                return new proptyxiako_second();
            case 2 :
                return new proptyxiako_third();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}