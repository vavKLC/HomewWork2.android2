package com.example.homewwork2android2.ui.fragment.createtask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;

import com.example.homewwork2android2.app.App;
import com.example.homewwork2android2.R;
import com.example.homewwork2android2.databinding.FragmentCreateTaskBinding;
import com.example.homewwork2android2.model.TaskModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public class CreateTaskFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    private FragmentCreateTaskBinding binding;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatabaseReference mDatabase;
    private int startYear;
    private int startMonth;
    private int startDay;
    private String date;
    private String repaet;

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
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private void initClicker() {
        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToDataBase();
                dismiss();
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



    private void writeToDataBase() {
        String text = binding.etTask.getText().toString();
        TaskModel taskModel = new  TaskModel(text , date , repaet);
        App.getApp().getDb().taskDao().insert(taskModel);
        db.collection("task").add(taskModel);
        mDatabase.child("task").child(String.valueOf(taskModel.id)).setValue(taskModel);
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

    private void showRepeatDialog() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View view = inflater.inflate(R.layout.repeat_dialog, null);
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
                String never = "Never";
                binding.tvChooseReapeat.setText(never);
                repaet = never;
                alertDialog.dismiss();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = "Every day";
                binding.tvChooseReapeat.setText(day);
                repaet = day;
                alertDialog.dismiss();
            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String week = "Every week";
                binding.tvChooseReapeat.setText(week);
                repaet = week;
                alertDialog.dismiss();
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String month = "Every month";
                binding.tvChooseReapeat.setText(month);
                repaet = month;
                alertDialog.dismiss();
            }
        });
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String year = "Every year";
                binding.tvChooseReapeat.setText(year);
                repaet = year;
                alertDialog.dismiss();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        date = "" + day + "." + month + 1 + "." + year;
        binding.tvChooseDate.setText(date);
    }
}
