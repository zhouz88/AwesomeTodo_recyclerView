package com.jiuzhang.guojing.awesometodo;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

public abstract class ListConverter<T> {

    private Context context;
    private List<T> data;
    private LinearLayout listLayout;

    public ListConverter(Context context, List<T> data, LinearLayout listLayout) {
        this.context = context;
        this.data = data;
        this.listLayout = listLayout;
    }

    public void convert() {
        listLayout.removeAllViews();
        for (int i = 0; i < data.size(); ++i) {
            listLayout.addView(getView(i));
        }
    }

    protected Context getContext() {
        return context;
    }

    protected List<T> getData() {
        return data;
    }

    protected abstract View getView(int position);
}
