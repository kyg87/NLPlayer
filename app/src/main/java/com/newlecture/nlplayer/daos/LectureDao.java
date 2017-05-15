package com.newlecture.nlplayer.daos;

import com.newlecture.nlplayer.entities.Lecture;

import java.util.List;

/**
 * Created by pc-pc on 2017-05-08.
 */

public interface LectureDao {

    List<Lecture> getList(int page);
    Lecture get(String id);

}
