package com.jiuzhang.guojing.awesometodo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jiuzhang.guojing.awesometodo.data.Todo;

import java.util.List;

public class MainAdapter extends ArrayAdapter<Todo> {

    public MainAdapter(Context context, List<Todo> objects) {
        super(context, R.layout.main_list_item, 0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        final TextView tv = (TextView) view.findViewById(R.id.main_list_item_text);
        tv.setText(getItem(position).text);

        CheckBox cb = (CheckBox) view.findViewById(R.id.main_list_item_check);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    tv.setPaintFlags(tv.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), position + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), TodoDetailActivity.class);
                intent.putExtra(TodoDetailActivity.KEY_TODO, getItem(position));
                intent.putExtra(TodoDetailActivity.KEY_INDEX, position);

                ((MainActivity) getContext()).startActivityForResult(intent, MainActivity.REQ_CODE_TODO_DETAIL);
            }
        });

        return view;
    }
}
