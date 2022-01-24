package com.example.homewwork2android2.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_model")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String task;
    public String date;
    public String repeat;

    public TaskModel(String task, String date, String repeat) {
        this.task = task;
        this.date = date;
        this.repeat = repeat;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }

    public String getRepeat() {
        return repeat;
    }
}
