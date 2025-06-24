package com.example.homework4.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework4.fragmentcountries.FranceFragment;
import com.example.homework4.fragmentcountries.ItalyFragment;
import com.example.homework4.fragmentcountries.UKFragment;

public class CountriesAdapter extends FragmentStateAdapter {
    public CountriesAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new UKFragment();
            case 1:
                return new ItalyFragment();
            case 2:
                return new FranceFragment();
            default:
                return new UKFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Số lượng tab: UK, Italy, France
    }
}