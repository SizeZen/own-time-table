package com.example.vadim.owntimetable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import com.example.vadim.owntimetable.models.TimePeriod;
import com.example.vadim.owntimetable.repository.Repository;


/**
 * Created by vadim on 9/2/16.
 */
public class main_layout extends AppCompatActivity {
    Repository repository = new Repository();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerAdapter mAdapter = new RecyclerAdapter(this.repository.getAll());
        mRecyclerView.setAdapter(mAdapter);

    }
}
