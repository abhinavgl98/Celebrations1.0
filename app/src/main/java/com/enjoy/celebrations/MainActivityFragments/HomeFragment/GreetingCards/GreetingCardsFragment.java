package com.enjoy.celebrations.MainActivityFragments.HomeFragment.GreetingCards;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enjoy.celebrations.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GreetingCardsFragment extends Fragment {

    public GreetingCardsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeting_cards, container, false);
    }
}
