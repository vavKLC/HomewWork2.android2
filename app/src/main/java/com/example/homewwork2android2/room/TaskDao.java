package com.example.homewwork2android2.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.homewwork2android2.model.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(TaskModel taskModel);

    @Query("SELECT * FROM task_model")
    LiveData<List<TaskModel>> geData();

    @Delete
    void delete(TaskModel taskModel);

    @Query("DELETE FROM task_model")
    void deleteAll();

    @Update
    void updateTask(TaskModel taskModel);

}
