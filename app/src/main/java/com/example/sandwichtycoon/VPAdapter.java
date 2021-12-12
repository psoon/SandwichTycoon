package com.example.sandwichtycoon;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    public VPAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        items = new ArrayList<Fragment>();
        items.add(new foodUpgrade());
        items.add(new sandwichUpgrade());
        items.add(new otherUpgrade());

        itext.add("재료 강화");
        itext.add("샌드위치 강화");
        itext.add("기타 강화");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }


    @Override
    public int getCount() {
        return items.size();
    }
}
