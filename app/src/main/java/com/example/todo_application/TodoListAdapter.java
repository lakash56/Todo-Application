package com.example.todo_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_application.data.Task;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        private final TextView todoItemView;

        private TodoViewHolder(View itemView) {
            super(itemView);
            todoItemView = itemView.findViewById(R.id.textView);
        }
    }


    private final LayoutInflater mInflater;
    private List<Task> mTodos;

    TodoListAdapter(Fragment_one context) {
        mInflater = LayoutInflater.from(context.getContext());
    }
    @NonNull
    @Override
    public TodoListAdapter.TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TodoViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull TodoListAdapter.TodoViewHolder holder, int position) {

        if (mTodos != null) {
            Task current = mTodos.get(position);
            holder.todoItemView.setText(current.getTitle());
        } else {
            // Covers the case of data not being ready yet.
            holder.todoItemView.setText("No Task");

        }

    }

    void setTodos(List<Task> todos){
        mTodos = todos;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        if (mTodos != null)
            return mTodos.size();
        else return 0;
    }


}
