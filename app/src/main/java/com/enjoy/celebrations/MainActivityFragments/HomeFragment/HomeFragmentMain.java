package com.enjoy.celebrations.MainActivityFragments.HomeFragment;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.enjoy.celebrations.R;
import com.google.android.material.tabs.TabLayout;
import com.ramotion.foldingcell.FoldingCell;


public class HomeFragmentMain extends Fragment {

    ViewPager cardsViewPager;
    TabLayout cardsTabLayout;


    public HomeFragmentMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardsViewPager = view.findViewById(R.id.viewPagerCards);
        cardsTabLayout=view.findViewById(R.id.tabLayoutCards);
        CardsViewPagerAdapter cardsViewPagerAdapter=new CardsViewPagerAdapter(getFragmentManager());
        cardsViewPager.setAdapter(cardsViewPagerAdapter);
        cardsTabLayout.setupWithViewPager(cardsViewPager);
    }


}
