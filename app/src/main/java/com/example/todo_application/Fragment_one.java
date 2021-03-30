package com.example.todo_application;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.todo_application.data.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_one#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_one extends Fragment {

    public TodoListAdapter taskAdapter;
    private TodoListAdapter adapter;

    public static Fragment_one newInstance() {

        return new Fragment_one();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        FloatingActionButton btn;
        view = inflater.inflate(R.layout.fragment_one, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);

        this.adapter = new TodoListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        btn = view.findViewById(R.id.addTask);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viweTaskFrameLayout,addtask_fragment.newInstance()).commitNow();

            }
        });
        return view;



    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // deprecated, mTodoViewModel = of(this).get(TodoViewModel.class);
        //TodoViewModel mTodoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);


        // Add an observer on the LiveData returned by getTodos.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
       /* mTodoViewModel.getTodos().observe(getViewLifecycleOwner(), new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable final List<Task> todos) {
                // Update the cached copy of the todos in the adapter.
                adapter.setTodos(todos);
            }
        });*/


    }
}