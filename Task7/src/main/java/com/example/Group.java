package com.example;

import java.util.ArrayList;
import java.util.List;

public class Group {

    public String name;
    public int id;
    public ArrayList<Album> album;

    public Group( String name, int id) {
        this.name = name;
        this.id = id;
        this.album = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Album> getAlbum() {
        return album;
    }
}