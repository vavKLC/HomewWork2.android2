package com.example.homewwork2android2.ui.fragment.createtask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homewwork2android2.databinding.ListHolderBinding;
import com.example.homewwork2android2.model.TaskModel;
import com.example.homewwork2android2.interfaces.OnItemClickListener;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    List<TaskModel> list ;
    OnItemClickListener onItemClickListener;


    public HomeAdapter(List<TaskModel> list , OnItemClickListener onItemClickListeners) {
        this.list = list;
        this.onItemClickListener = onItemClickListeners;
    }


    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeHolder(ListHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        private ListHolderBinding binding;
        public HomeHolder(ListHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void onBind(TaskModel model) {
            binding.titleTv.setText(model.getTask());
            binding.dateTv.setText(model.getDate());
            binding.repeatTv.setText(model.getRepeat());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickListener.onItemTouch(model);
                    return true;
                }
            });
        }
    }
}
