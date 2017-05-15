package com.newlecture.nlplayer.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.newlecture.nlplayer.R;

public class LectureDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_detail);

        Intent intent = this.getIntent();

        String code = intent.getStringExtra("id");

        TextView txtView = (TextView) findViewById(R.id.textView);

        txtView.setText(code);

    }
}
