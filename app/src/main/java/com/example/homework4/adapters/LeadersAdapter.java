package com.example.homework4.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework4.fragmentleaders.FranceLeaderFragment;
import com.example.homework4.fragmentleaders.ItalyLeaderFragment;
import com.example.homework4.fragmentleaders.UKLeaderFragment;

public class LeadersAdapter extends FragmentStateAdapter {
    public LeadersAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FranceLeaderFragment();
            case 1:
                return new UKLeaderFragment();
            case 2:
                return new ItalyLeaderFragment();
            default:
                return new FranceLeaderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Số lượng tab: France, UK, Italy
    }
}