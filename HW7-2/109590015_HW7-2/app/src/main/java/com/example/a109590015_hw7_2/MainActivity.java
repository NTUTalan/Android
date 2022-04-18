package com.example.a109590015_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

import recyclerview.RecipeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<String> title = new LinkedList<>();
        LinkedList<String> subtitle = new LinkedList<>();

        title.add("卡邦尼雞肉燉飯");
        title.add("漸層奶酪");

        subtitle.add("雞肉 + 飯");
        subtitle.add("漸層的奶酪");

        mRecyclerView = findViewById(R.id.recycleview);
        mAdapter = new RecipeAdapter(this, title, subtitle);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}