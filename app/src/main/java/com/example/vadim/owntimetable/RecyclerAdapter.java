package com.example.vadim.owntimetable;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vadim.owntimetable.models.TimeTableDayModel;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<TimeTableDayModel> mDataset;
    int idLayout;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mTextView2;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
            mTextView2 = (TextView) v.findViewById(R.id.tv_recycler_item2);
        }
    }

    public RecyclerAdapter(List<TimeTableDayModel> dataset, int idLayout) {
        mDataset = dataset;
        this.idLayout = idLayout;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(idLayout, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mDataset.get(position).getLesson_time());
        holder.mTextView2.setText(mDataset.get(position).getLesson_name());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}