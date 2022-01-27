package com.example.homewwork2android2.ui.fragment.board;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homewwork2android2.R;
import com.example.homewwork2android2.databinding.FragmentMainBoardBinding;
import com.example.homewwork2android2.model.ViewPagerModel;
import com.example.homewwork2android2.interfaces.OnViewPagerItemClickListener;

import java.util.ArrayList;


public class MainBoardFragment extends Fragment implements OnViewPagerItemClickListener {
    private FragmentMainBoardBinding binding;
    ViewPagerAdapter adapter;
    ArrayList<ViewPagerModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkOnShow();
        list.add(new ViewPagerModel("LifeTrack", "Welcome aboard", R.raw.todo_ani));
        list.add(new ViewPagerModel("LifeTrack", "Welcome aboard", R.raw.todo_ani2));
        list.add(new ViewPagerModel("LifeTrack", "Welcome aboard", R.raw.todo_ani3));
        adapter = new ViewPagerAdapter(list, this);
        binding.viewPager.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.viewPager);
    }

    private void checkOnShow() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("isShow", false);
        if (isShow) {
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        }
    }

    @Override
    public void itemClick() {
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isShow", true).apply();
    }
}
