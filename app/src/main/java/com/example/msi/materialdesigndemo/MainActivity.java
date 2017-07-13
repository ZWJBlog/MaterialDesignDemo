package com.example.msi.materialdesigndemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    public ArrayList<String> list_str = new ArrayList<>();
    RadioGroup RG;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RG = (RadioGroup) findViewById(R.id.RG);
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb1:
                        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                        recycler.setLayoutManager(linearLayoutManager);
                        recyclerAdapter.notifyDataSetChanged();
                        break;
                    case R.id.rb2:
                        final GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
                        recycler.setLayoutManager(gridLayoutManager);
                        recyclerAdapter.notifyDataSetChanged();
                        break;
                    case R.id.rb3:
                        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
                        recycler.setLayoutManager(staggeredGridLayoutManager);
                        recyclerAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            list_str.add("" + i);
        }
        recycler = (RecyclerView) findViewById(R.id.id_recyclerview);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recycler.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(this, list_str);
        recycler.setAdapter(recyclerAdapter);
        recycler.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, list_str.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
