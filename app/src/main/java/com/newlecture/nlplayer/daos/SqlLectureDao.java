package com.newlecture.nlplayer.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.newlecture.nlplayer.entities.Lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-pc on 2017-05-18.
 */

public class SqlLectureDao extends SQLiteOpenHelper implements LectureDao {

    //DML 기능을 담당하는 객체
    //private SQLiteDatabase db;
    private  Context context;

    //public SqlLectureDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    public SqlLectureDao(Context context) {
        super(context, "data.db", null,4);

        //this.context = context;
    }

    //DDL 을 담당 매소드
    @Override
    public void onCreate(SQLiteDatabase db) {
        //database = context.openOrCreateDatabase("data.db",Context.MODE_PRIVATE,null);
        String sql = "create table lecture(" +
                     "id varchar(50),"+
                     "title varchar(100)," +
                     "regdate date," +
                     "price int)";

        db.execSQL(sql);


        sql = "insert into Lecture values('1','hihihaha',date('now'),2000)";
        db.execSQL(sql);
        sql = "insert into Lecture values('2','~~~~',date('now'),3000)";
        db.execSQL(sql);

/*        ContentValues cv = new ContentValues();
        cv.put("id","1");
        cv.put("title","CV 제목");
        cv.put("regdate","date('now')");
        cv.put("price",2000);

        db.insert("Lecture",null,cv);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "drop table if exists lecture";

        db.execSQL(sql);
        onCreate(db);
    }



    @Override
    public List<Lecture> getList(int page) {

        SQLiteDatabase db = this.getReadableDatabase();
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Lecture",null);

        List<Lecture> list = new ArrayList<>();
        while(cursor.moveToNext()){
            Lecture lecture = new Lecture();
            lecture.setId(cursor.getString(0));
            lecture.setTitle(cursor.getString(1));
            lecture.setPrice(cursor.getInt(2));

            list.add(lecture);
        }

        cursor.close();
        db.close();

        return list;
    }

    @Override
    public Lecture get(String id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from Lecture where id='" +id+"'",null);

        Lecture lecture = new Lecture();

        if(cursor.moveToNext()) {

            lecture.setId(cursor.getString(0));
            lecture.setTitle(cursor.getString(1));
            lecture.setPrice(cursor.getInt(2));
        }

        cursor.close();
        db.close();

        return lecture;
    }



}
