package com.example.todo_application.data;

import android.app.Application;

import java.util.List;

public class Repository {

    static Repository INSTANCE;
    AppDatabase db;
    TodoDao dao;

    public Repository(Application application) {
        db = AppDatabase.getDatabase(application);
        dao = db.todoDao();
    }

    public static Repository getRepository(Application application){
        if(INSTANCE == null){
            INSTANCE = new Repository(application);
        }
        return INSTANCE;
    }

    public List<Task> getALlTasks(){
        return dao.getAllTasks();
    }

    public void  deleteAll(){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteAll();
            }
        });

    }

    public void  update(final Task task){

        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });

    }

    public void  addTask(final Task task){

        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(task);
            }
        });

    }


}