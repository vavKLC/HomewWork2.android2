package com.example.homewwork2android2.ui.fragment.createtask;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homewwork2android2.R;
import com.example.homewwork2android2.app.App;
import com.example.homewwork2android2.databinding.FragmentHomeBinding;
import com.example.homewwork2android2.interfaces.OnItemClickListener;
import com.example.homewwork2android2.model.TaskModel;
import com.example.homewwork2android2.ui.fragment.createtask.adapter.HomeAdapter;

public class HomeFragment extends Fragment implements OnItemClickListener {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initClickers();
    }

    private void initAdapter() {
        App.getApp().getDb().taskDao().geData().observe(getViewLifecycleOwner(), task -> {
            HomeAdapter homeAdapter = new HomeAdapter(task, this);
            binding.recyclerView.setAdapter(homeAdapter);
        });
    }

    @Override
    public void onItemTouch(TaskModel taskModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                App.getApp().getDb().taskDao().delete(taskModel);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setTitle("Delete?");
        builder.setMessage("Are you sure you want to delete?");
        builder.create().show();
    }
    private void initClickers() {
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateTaskFragment createTaskFragment = new CreateTaskFragment();
                createTaskFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });
    }
}
