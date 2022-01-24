package com.example.homewwork2android2.app;

import android.app.Application;

import androidx.room.Room;

import com.example.homewwork2android2.room.AppDataBase;

public class App extends Application {
    AppDataBase db;
    static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "taskbase").allowMainThreadQueries().build();
    }

    public AppDataBase getDb() {
        return db;
    }

    public static App getApp() {
        return app;
    }
}
