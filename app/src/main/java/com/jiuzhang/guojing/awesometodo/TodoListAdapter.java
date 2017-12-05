package com.jiuzhang.guojing.awesometodo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiuzhang.guojing.awesometodo.models.Todo;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter {

    private List<Todo> data;

    public TodoListAdapter(@NonNull List<Todo> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.main_list_item, parent, false);
        return new TodoListViewHolder(view);
    }// create a view return corresponding vh!

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Todo todo = data.get(position);
        ((TodoListViewHolder) holder).todoText.setText(todo.text);

        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(android.R.color.white);
            ((TodoListViewHolder) holder).heightPlaceholder.setVisibility(View.GONE);
        } else {
            holder.itemView.setBackgroundResource(android.R.color.holo_purple);
            ((TodoListViewHolder) holder).heightPlaceholder.setVisibility(View.VISIBLE);
        }
    }//put the data into vh;

    @Override
    public int getItemCount() {
        return data.size();
    }
}
