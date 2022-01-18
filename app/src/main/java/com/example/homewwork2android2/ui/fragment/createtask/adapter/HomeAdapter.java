package com.example.homewwork2android2.ui.fragment.createtask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homewwork2android2.databinding.ListHolderBinding;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private ListHolderBinding binding;
    ArrayList<String> list = new ArrayList<>();
    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListHolderBinding.inflate(LayoutInflater.from(parent.getContext()),parent , false);
        return new HomeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addText(String text) {
        list.add(text);
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        public HomeHolder(ListHolderBinding binding) {
            super(binding.getRoot());
        }

        public void onBind(String text) {
            binding.titleTv.setText(text);
        }
    }
}
