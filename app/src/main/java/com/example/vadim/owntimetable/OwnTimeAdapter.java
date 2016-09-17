package com.example.vadim.owntimetable;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vadim.owntimetable.Object.TimeTable_day;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by root on 9/4/16.
 */
public class OwnTimeAdapter extends RecyclerView.Adapter<OwnTimeAdapter.DataHolder> {

    private List<TimeTable_day> cardText = new ArrayList<>();

    public static class DataHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView lessonTime;
        TextView lessonName;

        DataHolder(View itemView) {
            super(itemView);
            cardview = (CardView)itemView.findViewById(R.id.cv);
            lessonTime = (TextView)itemView.findViewById(R.id.cv_lessonTime);
            lessonName = (TextView)itemView.findViewById(R.id.cv_lessonName);
        }
    }

    public OwnTimeAdapter(List<TimeTable_day> cardText){
        this.cardText = cardText;
    }

    @Override
    public int getItemCount() {
        return cardText.size();
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        DataHolder pvh = new DataHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(DataHolder personViewHolder, int i) {
        personViewHolder.lessonTime.setText(cardText.get(i).getLesson_time());
        personViewHolder.lessonName.setText(cardText.get(i).getLesson_name());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
