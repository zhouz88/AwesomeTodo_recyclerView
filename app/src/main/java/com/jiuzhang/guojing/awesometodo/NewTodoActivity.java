package com.jiuzhang.guojing.awesometodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jiuzhang.guojing.awesometodo.data.Todo;

import java.util.Calendar;
import java.util.Date;

public class NewTodoActivity extends AppCompatActivity {

    public static final String KEY_TODO = "todo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_new_todo);

        View root = findViewById(R.id.new_todo_root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTodoActivity.this.finish();
            }
        });

        final EditText edit = (EditText) findViewById(R.id.new_todo_edit);
        Button btn = (Button) findViewById(R.id.new_todo_add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText = edit.getText().toString();
                if (!todoText.isEmpty()) {
                    Date remindDate = Calendar.getInstance().getTime();
                    Todo newTodo = new Todo(todoText, remindDate);

                    Intent intent = new Intent();
                    intent.putExtra(KEY_TODO, newTodo);
                    setResult(Activity.RESULT_OK, intent);
                    NewTodoActivity.this.finish();
                }
            }
        });

    }
}
