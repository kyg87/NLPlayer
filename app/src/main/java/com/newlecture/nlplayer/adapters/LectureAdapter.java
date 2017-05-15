package com.newlecture.nlplayer.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.newlecture.nlplayer.R;
import com.newlecture.nlplayer.activities.MainActivity;
import com.newlecture.nlplayer.entities.Lecture;

import java.util.List;

/**
 * Created by lee on 2017-05-02.
 */

public class LectureAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private int item_lecturs;
    private List<Lecture> lectures;

    public LectureAdapter(MainActivity mainActivity, int item_lecture, List<Lecture> lectures ) {
        this.mainActivity = mainActivity;
        this.item_lecturs =item_lecture;
        this.lectures = lectures;

    }


    @Override
    public int getCount() {
        return lectures.size();
    }

    @Override
    public Object getItem(int position) {
        return lectures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null)
            view = mainActivity.getLayoutInflater().inflate(item_lecturs,parent,false);
        //view = mainActivity.getLayoutInflater().inflate(R.layout.item_lecture,parent,false);

        Lecture lecture = (Lecture) getItem(position);

        if(lecture != null){
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            //TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);

            tvTitle.setText(lecture.getTitle());
            //tvPrice.setText(lecture.getPrice());
        }



        return view;
    }
}