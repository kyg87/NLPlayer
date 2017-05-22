package com.newlecture.nlplayer.daos;

import com.newlecture.nlplayer.entities.Chapter;

import java.util.List;

/**
 * Created by newlec on 2017-05-19.
 */

public interface ChapterDao {

    List<Chapter> getList(String lectureId);
    List<Chapter> getList();
    List<Chapter> getList(int page, String field, String query);
    List<Chapter> getList(int page);
    Chapter get(String id);

    int add(Chapter chapter);
    int   update(Chapter chapter);
    int delete(String id);

}