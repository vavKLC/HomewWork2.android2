package com.example.homewwork2android2.ui.fragment.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homewwork2android2.databinding.FragmentBoarkBinding;
import com.example.homewwork2android2.model.ViewPagerModel;
import com.example.homewwork2android2.interfaces.OnViewPagerItemClickListener;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
    ArrayList<ViewPagerModel> listPager = new ArrayList<>();
    OnViewPagerItemClickListener listener;

    public ViewPagerAdapter(ArrayList<ViewPagerModel> listPager, OnViewPagerItemClickListener listener) {
        this.listPager = listPager;
        this.listener = listener;
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
            binding.btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick();
                }
            });
        }
    }
}
