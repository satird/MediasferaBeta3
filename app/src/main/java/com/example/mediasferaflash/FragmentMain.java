package com.example.mediasferaflash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class FragmentMain extends Fragment {
    public static FragmentMain newInstance() {
        return new FragmentMain();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        GooglePlusFragmentPageAdapter adapter = new GooglePlusFragmentPageAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private static class GooglePlusFragmentPageAdapter extends FragmentPagerAdapter {

        public GooglePlusFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
//            return FragmentChildMainTab1.newInstance(position);
            switch (position) {
                case 0:
                    return FragmentChildMainTab1.newInstance();
                case 1:
                    return FragmentChildMainTab2.newInstance();
                case 2:
                    return FragmentChildMainTab3.newInstance();
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
//            return "Item " + position;
            switch (position) {
                case 0:
                    return "Читаю";
                case 1:
                    return "Отложенные";
                case 2:
                    return "Архив";
            }
            return null;
        }
    }
}
