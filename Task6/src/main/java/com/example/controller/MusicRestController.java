package com.example.controller;

import com.example.Group;
import com.example.Album;
import com.example.Track;

import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class MusicRestController {
    public List<Group> groups = new ArrayList<>();
    public HashMap<Album, Group> albumGroupHashMap = new HashMap<>();
    public HashMap<Track, Album> trackAlbumHashMap = new HashMap<>();
    public ArrayList<Integer> albomsNanberGroups = new ArrayList<>();

    public ArrayList<Integer> tracksNamberAmdoms = new ArrayList<>();
    public int namberGroup = 0;

    //Показать все группы
    @GetMapping("/groups")
    public List<Group> getGroup() {
        return groups;
    }
    @PostMapping("/groups")
    public void addGroup(@RequestBody Group group) {
        group.id = namberGroup;
        namberGroup++;
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
    }
    //Показать все альбомы группы idGroup
    @GetMapping("/groups/{idGroup}/albums")
    public List<Album> getAlbum(@PathVariable int idGroup) {
        Group group1 = null;
        for(Group group: groups) {
            if (group.getId() == idGroup) {
                group1 = group;
            }
        }
        return group1.album;
    }
    @PostMapping("/groups/{idGroup}/albums")
    public void addAlbum(@PathVariable int idGroup, @RequestBody Album album) {
        album.id = groups.get(idGroup).album.size();
        System.out.println(album.id + "   " + album.name + "   " + album.year + "   " + album.tracks);
        for (Group group:  groups) {
            if (group.getId() == idGroup){
                group.album.add(album);
            }
        }
    }

    @GetMapping("/groups/{idGroup}/albums/{idAlbom}/tracks")
    public List<Track> getTrack(@PathVariable int idGroup, @PathVariable int idAlbom) {
        Album album1 = null;
        for(Group group:  groups) {
            if (group.getId() == idGroup){
                for (Album album: group.album) {
                    if (album.getId() == idAlbom){
                        album1 = album;
                    }
                }
            }
        }
        return album1.tracks;
    }
    @PutMapping("/groups/{idGroup}/albums/{idAlbom}/tracks")
    public void addTrack(@PathVariable int idGroup,  @PathVariable int idAlbom, @RequestBody Track track) {
        for (Group group: groups){
            if (group.getId() == idGroup){
                for (Album album: group.album){
                    if (album.getId() == idAlbom){
                        album.tracks.add(track);
                    }
                }
            }
        }

    }

}