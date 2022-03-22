package com.example.inq_proj.ui.project;

import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.inq_proj.R;
import com.google.android.material.tabs.TabLayout;

public class ProjectFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_project, container, false);

        TabLayout tabLayout = v.findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("REC"));
        tabLayout.addTab(tabLayout.newTab().setText("ING"));
        tabLayout.addTab(tabLayout.newTab().setText("END"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = v.findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        return v;
    }
}