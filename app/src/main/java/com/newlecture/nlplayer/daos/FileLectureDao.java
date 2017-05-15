package com.newlecture.nlplayer.daos;

import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.newlecture.nlplayer.activities.MainActivity;
import com.newlecture.nlplayer.entities.Lecture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-pc on 2017-05-08.
 */

public class FileLectureDao implements LectureDao {

    @Override
    public List<Lecture> getList(int page) {

        String state = Environment.getExternalStorageState();

        if(state.equals(Environment.MEDIA_MOUNTED)) {


            File root = Environment.getExternalStorageDirectory();
            //-->/storage/emulated/0/

            File file = new File(root.getAbsolutePath(), "data.txt");

            if (file.exists()) {

                StringBuilder text = new StringBuilder();

                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    //byte 단위로 inputStream <-> char Reader
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String line = "";


                    while ((line = bufferedReader.readLine()) != null) {

                        Log.d("lecture json",line);
                        text.append(line);
                    }

                    List<Lecture> list = new ArrayList<>();

                    JsonArray arr = new JsonParser().parse(text.toString()).getAsJsonArray();

                    Gson gson = new Gson();

                    for(int i = 0; i < arr.size();i++) {
                        Lecture lecture = gson.fromJson(arr.get(i), Lecture.class);

                        list.add(lecture);
                    }

                    return list;

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                Toast.makeText(MainActivity.getinstance(),"File NOT Found",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(MainActivity.getinstance(),"SD Card NOT Found",Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    public Lecture get(String id) {
        return null;
    }
}
