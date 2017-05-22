package com.newlecture.nlplayer.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.newlecture.nlplayer.R;
import com.newlecture.nlplayer.adapters.LectureAdapter;
import com.newlecture.nlplayer.daos.FileLectureDao;
import com.newlecture.nlplayer.daos.LectureDao;
import com.newlecture.nlplayer.daos.SqlLectureDao;
import com.newlecture.nlplayer.entities.Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

/**
 * Created by pc-pc on 2017-04-18.
 */

public class MainActivity extends Activity {

    private  static  MainActivity mainActivity;

    private List<Lecture> lectures;

    private LectureDao fileLectureDao;

    private  LectureDao sqlLectureDao;
    public MainActivity(){

        mainActivity = this;



        /*lectures = new ArrayList<>();

        lectures.add(new Lecture("1","자바 프로그래밍",29000));
        lectures.add(new Lecture("2","오라클 SQL 입문",39000));
        lectures.add(new Lecture("3","Spring MVC",19000));
        lectures.add(new Lecture("4","Android Programming",29000));
        lectures.add(new Lecture("5","자바스크립트",49000));
        lectures.add(new Lecture("6","JSP 프로그래밍",89000));

        lectures.add(new Lecture("7","자바 프로그래밍",29000));
        lectures.add(new Lecture("8","오라클 SQL 입문",39000));
        lectures.add(new Lecture("9","Spring MVC",19000));
        lectures.add(new Lecture("10","Android Programming",29000));
        lectures.add(new Lecture("11","자바스크립트",49000));
        lectures.add(new Lecture("12","JSP 프로그래밍",89000));*/

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //요부분만 바꾸면 다른파일로 가능
        /*fileLectureDao = new FileLectureDao();
        lectures = fileLectureDao.getList(1);*/

        sqlLectureDao = new SqlLectureDao(this);
        lectures = sqlLectureDao.getList(1);

        /*
        int permission = ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                  new  String[]{ android.Manifest.permission.READ_EXTERNAL_STORAGE
            },1);
        }
        */

        //android.R.layout.simple_list_item_1
        //lectures

   /*     ArrayAdapter<Lecture>  adapter = new ArrayAdapter<Lecture>(this
        , android.R.layout.simple_list_item_1
        ,lectures);*/

        final LectureAdapter adapter = new LectureAdapter(this
                ,R.layout.item_lecture
                ,lectures);

        ListView lectureList = (ListView) findViewById(R.id.listview);
        lectureList.setAdapter(adapter);


        lectureList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String lectureId = lectures.get(position).getId();

                Intent intent = new Intent(MainActivity.this, LectureDetailActivity.class);
                intent.putExtra("id",lectureId);
                startActivity(intent);

                /*lectures.remove(position);
                adapter.notifyDataSetChanged();*/

            }
        });


  /*      setContentView(R.layout.activity_main);

        LinearLayout lectureList = (LinearLayout) findViewById(R.id.lectureList);

        LayoutInflater inflater = getLayoutInflater();

        View item = null;

        for (String lec : lectures) {
            item = inflater.inflate(R.layout.item_lecture, lectureList, false);

            TextView tvTitle = (TextView) item.findViewById(R.id.tvTitle);
            tvTitle.setText(lec);

            lectureList.addView(item);
        }*/

    }

    public static MainActivity getinstance() {
        return mainActivity;
    }
}
