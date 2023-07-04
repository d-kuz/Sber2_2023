package com.example.model;
import jakarta.persistence.*;
@Entity
@Table(name = "PC_TRACK")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="length")
    private String length;
    @ManyToOne
    @JoinColumn(name = "Album_id")
    private Album album;

    public Track(String name, String length) {
        this.name = name;
        this.length = length;
    }

    public Track() {
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLength() {
        return length;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    public Album getAlbum() {
        return album;
    }
}

