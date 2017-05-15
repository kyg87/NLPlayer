package com.newlecture.nlplayer.entities;

/**
 * Created by pc-pc on 2017-05-02.
 */

public class Lecture {
    private String id;
    private String title;
    private int price;

    public Lecture(String id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
