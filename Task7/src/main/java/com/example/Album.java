package com.example;

import java.util.ArrayList;

public class Album {

    public int id;
    public String name;
    public String year;
    public int groupId;
    public ArrayList<Track> tracks;

    public Album(int id, String name, String year,  int groupId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.groupId = groupId;
        this.tracks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getGroupId() {
        return groupId;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
