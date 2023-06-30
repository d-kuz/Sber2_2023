package com.example;


public class Track {

    public int id;
    public String name;
    public String length;
    public int groupId;
    public int albumId;

    public Track(int id, String name, String length, int groupId, int albumId) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.groupId = groupId;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getAlbumId() {
        return albumId;
    }
}
