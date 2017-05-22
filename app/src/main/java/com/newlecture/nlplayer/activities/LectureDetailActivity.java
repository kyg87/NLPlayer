package com.newlecture.nlplayer.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.newlecture.nlplayer.R;
import com.newlecture.nlplayer.daos.FileLectureDao;
import com.newlecture.nlplayer.daos.LectureDao;
import com.newlecture.nlplayer.daos.SqlLectureDao;
import com.newlecture.nlplayer.entities.Lecture;

public class LectureDetailActivity extends Activity {

    private LectureDao lectureDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_detail);

        Intent intent = this.getIntent();

        String id = intent.getStringExtra("id");

        lectureDao = new SqlLectureDao(this);
        Lecture lectures = lectureDao.get(id);

        TextView txtView = (TextView) findViewById(R.id.tvTitle);

        txtView.setText(lectures.getTitle());

     /*   TextView txtView = (TextView) findViewById(R.id.textView);

        txtView.setText(code);*/

     //--itemListView의 데이터를 바인딩

    }
}
