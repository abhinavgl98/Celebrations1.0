package com.enjoy.celebrations.MainActivityFragments.HomeFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.enjoy.celebrations.MainActivityFragments.HomeFragment.ECardsFragment.ECardsFragment;
import com.enjoy.celebrations.MainActivityFragments.HomeFragment.GreetingCards.GreetingCardsFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CardsViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList=new ArrayList<>(Arrays.asList( new ECardsFragment(),new GreetingCardsFragment()));
    private final ArrayList<String> titleArrayList=new ArrayList<>(Arrays.asList("E-Cards","Greetinng Cards"));
    public CardsViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleArrayList.get(position);
    }
}
