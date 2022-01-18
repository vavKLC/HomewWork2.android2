package com.example.homewwork2android2.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homewwork2android2.databinding.FragmentBoarkBinding;
import com.example.homewwork2android2.databinding.FragmentMainBoardBinding;
import com.example.homewwork2android2.model.ViewPagerModel;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
    ArrayList<ViewPagerModel> listPager = new ArrayList<>();

    public ViewPagerAdapter(ArrayList<ViewPagerModel> listPager) {
        this.listPager = listPager;
    }

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(FragmentBoarkBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.onBind(listPager.get(position));
    }

    @Override
    public int getItemCount() {
        return listPager.size();
    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {
        private FragmentBoarkBinding binding;

        public ViewPagerHolder(FragmentBoarkBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(ViewPagerModel model){
            binding.tvTittle.setText(model.getTitle());
            binding.descriptionTv.setText(model.getDescription());
            binding.imageView.setImageResource(model.getImage());
        }
    }
}
