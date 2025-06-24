package com.example.homework4.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework4.fragmentmuseums.FranceMuseumFragment;
import com.example.homework4.fragmentmuseums.UKMuseumFragment;
import com.example.homework4.fragmentmuseums.ItalyMuseumFragment;

public class MuseumsAdapter extends FragmentStateAdapter {
    public MuseumsAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FranceMuseumFragment();
            case 1:
                return new UKMuseumFragment();
            case 2:
                return new ItalyMuseumFragment();
            default:
                return new FranceMuseumFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Số lượng tab: France, UK, Italy
    }
}