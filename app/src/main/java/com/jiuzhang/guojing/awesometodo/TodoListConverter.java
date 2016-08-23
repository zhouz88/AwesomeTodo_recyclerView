package com.jiuzhang.guojing.awesometodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiuzhang.guojing.awesometodo.data.Todo;

import java.util.List;

public class TodoListConverter extends ListConverter<Todo> {

    public TodoListConverter(Context context, List<Todo> data, LinearLayout listLayout) {
        super(context, data, listLayout);
    }

    @Override
    protected View getView(int position) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.main_list_item, null);
        Todo todo = getData().get(position);

        ((TextView) view.findViewById(R.id.main_list_item_text)).setText(todo.text);
        return view;
    }
}
