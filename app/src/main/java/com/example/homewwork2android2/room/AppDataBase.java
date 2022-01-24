package com.example.homewwork2android2.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.homewwork2android2.model.TaskModel;


@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
