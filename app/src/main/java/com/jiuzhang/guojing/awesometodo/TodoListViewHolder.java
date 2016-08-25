package com.jiuzhang.guojing.awesometodo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TodoListViewHolder extends RecyclerView.ViewHolder {

    TextView todoText;
    ImageView heightPlaceholder;

    public TodoListViewHolder(@NonNull View itemView) {
        super(itemView);

        todoText = (TextView) itemView.findViewById(R.id.main_list_item_text);
        heightPlaceholder = (ImageView) itemView.findViewById(R.id.main_list_height_placeholder);
    }
}
