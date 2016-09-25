package com.example.vadim.owntimetable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vadim.owntimetable.fragments.DateRangePickerFragment;
import com.example.vadim.owntimetable.models.TimePeriod;
import com.example.vadim.owntimetable.models.TimeTableDayModel;
import com.example.vadim.owntimetable.repository.Repository;

import java.util.Calendar;
import java.util.List;


/**
 * Created by vadim on 9/2/16.
 */
public class main_layout extends AppCompatActivity implements DateRangePickerFragment.OnDateRangeSelectedListener{
    Repository repository = new Repository();
    Calendar c = Calendar.getInstance();

    RecyclerView mRecyclerView;
    GridLayoutManager mLayoutManager;
    RecyclerAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new GridLayoutManager(this, 2);

        String startPeriod = c.get(Calendar.DAY_OF_MONTH) +"."+ c.get(Calendar.MONTH) +"."+ c.get(Calendar.YEAR);
        String endPeriod = c.get(Calendar.DAY_OF_MONTH) +"."+ (c.get(Calendar.MONTH) +1) +"."+ c.get(Calendar.YEAR);

        createRecyclerView(new TimePeriod(startPeriod, endPeriod));
    }

    private void createRecyclerView(TimePeriod period) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(repository.getListTimeTableDay(period));
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.gefasim:
                Toast.makeText(getApplicationContext(), "Alex", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.vlmcr:
                Toast.makeText(getApplicationContext(), "Vadim", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.new_game:
                DateRangePickerFragment dateRangePickerFragment= DateRangePickerFragment.newInstance(main_layout.this, false);
                dateRangePickerFragment.show(getSupportFragmentManager(),"datePicker");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateRangeSelected(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
        createRecyclerView(new TimePeriod(
                startDay+"."+(startMonth+1)+"."+startYear,
                endDay+"."+(endMonth+1)+"."+endYear
        ));
    }

}
