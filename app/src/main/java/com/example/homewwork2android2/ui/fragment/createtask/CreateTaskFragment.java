package com.example.homewwork2android2.ui.fragment.createtask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;

import com.example.homewwork2android2.R;
import com.example.homewwork2android2.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;


public class CreateTaskFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    private FragmentCreateTaskBinding binding;
    private int startYear;
    private int startMonth;
    private int startDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater(), container, false);
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
        binding.tvChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        binding.tvChooseReapeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRepeatDialog();
            }
        });
    }


    private void sendText() {
        String text = binding.etTask.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key", text);
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment, bundle);
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        startMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(), this::onDateSet, startYear, startMonth, startDay);
        datePickerDialog.show();

    }

    private void showRepeatDialog(){
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View view = inflater.inflate(R.layout.repeat_dialog , null);
        Dialog alertDialog = new Dialog(requireContext());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.show();
        RadioButton never = alertDialog.findViewById(R.id.never_radioBtn);
        RadioButton day = alertDialog.findViewById(R.id.day_radioBtn);
        RadioButton week = alertDialog.findViewById(R.id.week_radioBtn);
        RadioButton month = alertDialog.findViewById(R.id.month_radioBtn);
        RadioButton year = alertDialog.findViewById(R.id.year_radioBtn);
        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvChooseReapeat.setText("Never");
                alertDialog.dismiss();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvChooseReapeat.setText("Every day");
                alertDialog.dismiss();
            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvChooseReapeat.setText("Every week");
                alertDialog.dismiss();
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvChooseReapeat.setText("Every month");
                alertDialog.dismiss();
            }
        });
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvChooseReapeat.setText("Every year");
                alertDialog.dismiss();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        binding.tvChooseDate.setText("" + day + "." + month + 1  + "." + year);
    }
}