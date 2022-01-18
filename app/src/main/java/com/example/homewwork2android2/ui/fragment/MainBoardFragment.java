package com.example.homewwork2android2.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homewwork2android2.R;
import com.example.homewwork2android2.databinding.FragmentMainBoardBinding;
import com.example.homewwork2android2.model.ViewPagerModel;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;


public class MainBoardFragment extends Fragment {
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
        list.add(new ViewPagerModel("Куджо Джотаро" , "Джотаро — правонарушитель, который живет обычной жизнью." , R.drawable.jotaro));
        list.add(new ViewPagerModel("Антон" , "Самый обычный человек,не называйте его черным" , R.drawable.negr));
        list.add(new ViewPagerModel("Меня зовут Кира Йошикаге" , " Мне 33 года." , R.drawable.kira));
        adapter = new ViewPagerAdapter(list);
        binding.viewPager.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.viewPager);
    }
}
