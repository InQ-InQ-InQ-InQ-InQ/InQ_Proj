package com.example.inq_proj.ui.project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.inq_proj.ui.project.tab.TabFragment;
import com.example.inq_proj.ui.project.tab.TabFragment2;
import com.example.inq_proj.ui.project.tab.TabFragment3;

public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOFTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int NumOFTabs) {
        super(fm, NumOFTabs);
        this.mNumOFTabs = NumOFTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TabFragment();
            case 1: return new TabFragment2();
            case 2: return new TabFragment3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOFTabs;
    }

}
