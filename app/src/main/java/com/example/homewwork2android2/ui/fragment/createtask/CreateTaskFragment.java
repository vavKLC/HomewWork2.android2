package com.example.homewwork2android2.ui.fragment.createtask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homewwork2android2.R;
import com.example.homewwork2android2.databinding.FragmentCreateTaskBinding;


public class CreateTaskFragment extends Fragment {
    private FragmentCreateTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater() , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClicker();
    }

    private void initClicker() {
        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText();
            }
        });
    }
    private void sendText() {
        String text = binding.etTask.getText().toString();
        String number = binding.etNumber.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key", text);
        bundle.putString("A", number);
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment, bundle);
    }
}