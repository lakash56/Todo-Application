package com.example.todo_application;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo_application.data.Repository;
import com.example.todo_application.data.Task;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private Repository mRepository;

    // Using LiveData and caching what getTodos returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel
    private LiveData<List<Task>> mTodos;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
        mTodos = (LiveData<List<Task>>) mRepository.getALlTasks();
    }

    LiveData<List<Task>> getTodos() {
        return mTodos;
    }

    public void insert(Task task) {
        mRepository.addTask(task);
    }


}
