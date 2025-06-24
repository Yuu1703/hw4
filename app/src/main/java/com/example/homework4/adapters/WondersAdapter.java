package com.example.homework4.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework4.fragmentwonders.FranceWonderFragment;
import com.example.homework4.fragmentwonders.UKWonderFragment;
import com.example.homework4.fragmentwonders.ItalyWonderFragment;

public class WondersAdapter extends FragmentStateAdapter {
    public WondersAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FranceWonderFragment();
            case 1:
                return new UKWonderFragment();
            case 2:
                return new ItalyWonderFragment();
            default:
                return new FranceWonderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Số lượng tab: France, UK, Italy
    }
}