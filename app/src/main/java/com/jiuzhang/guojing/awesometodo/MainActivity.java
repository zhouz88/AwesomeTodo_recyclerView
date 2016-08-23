package com.jiuzhang.guojing.awesometodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jiuzhang.guojing.awesometodo.data.Todo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_NEW_TODO = 100;
    public static final int REQ_CODE_TODO_DETAIL = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewTodoActivity.class);
                startActivityForResult(intent, REQ_CODE_NEW_TODO);
            }
        });

        ListView listView = (ListView) findViewById(R.id.main_list_view);
        listView.setAdapter(new TodoListAdapter(this, mockData()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (Activity.RESULT_OK == resultCode) {
//            if (REQ_CODE_NEW_TODO == requestCode) {
//                Todo newTodo = data.getParcelableExtra(NewTodoActivity.KEY_TODO);
//                adapter.add(newTodo);
//            } else if (REQ_CODE_TODO_DETAIL == requestCode) {
//                Todo newTodo = data.getParcelableExtra(TodoDetailActivity.KEY_TODO);
//                int index = data.getIntExtra(TodoDetailActivity.KEY_INDEX, 0);
//                adapter.remove(adapter.getItem(index));
//                adapter.insert(newTodo, index);
//            }
//        }
//    }

//    private void setupUI(@NonNull List<Todo> data) {
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.todo_list);
//        linearLayout.removeAllViews();
//
//        for (Todo todo : data) {
//            View view = LayoutInflater.from(this).inflate(R.layout.main_list_item, null);
//            setupListItem(view, todo);
//            linearLayout.addView(view);
//        }
//    }
//
//    private void setupListItem(@NonNull View listItemView, @NonNull Todo data) {
//        ((TextView) listItemView.findViewById(R.id.main_list_item_text)).setText(data.text);
//    }

    @NonNull
    private List<Todo> mockData() {
        List<Todo> list = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH:mm", Locale.getDefault());
        try {
            list.add(new Todo("lala", dateFormat.parse("2011 1 1 0:00")));
            list.add(new Todo("yiyi", dateFormat.parse("2013 3 8 0:00")));
            list.add(new Todo("shit", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 1", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 2", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 3", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 4", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 5", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 6", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 7", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 8", dateFormat.parse("2015 7 29 0:00")));
            list.add(new Todo("todo 9", dateFormat.parse("2015 7 29 0:00")));

            for (int i = 0; i < 1000; ++i) {
                list.add(new Todo("todo 9", dateFormat.parse("2015 7 29 0:00")));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }
}
