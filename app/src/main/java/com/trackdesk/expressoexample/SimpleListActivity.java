package com.trackdesk.expressoexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.trackdesk.expressoexample.adapters.SimpleListAdapter;
import com.trackdesk.expressoexample.adapters.SimpleListItem;

import java.util.ArrayList;
import java.util.List;

public class SimpleListActivity extends AppCompatActivity {
    private List<SimpleListItem> items;
    private SimpleListAdapter adapter;
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        rvList = findViewById(R.id.rv_list);

        populate();
    }

    private void populate() {
        items = new ArrayList<>();

        for (int i=0; i<20; i++) {
            items.add(new SimpleListItem("Title #"+(i+1)));
        }

        adapter = new SimpleListAdapter(this, items);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rvList.setLayoutManager(llm);
        rvList.setAdapter(adapter);
    }
}
