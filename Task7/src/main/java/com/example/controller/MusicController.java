package com.example.controller;

import com.example.Group;
import com.example.Album;
import com.example.Track;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
public class MusicController {
    public List<Group> groups = new ArrayList<>();
    public int namberGroup = 0;

    //Показать все группы
    @GetMapping("/groups")
    public String getGroup(Model model){
        model.addAttribute("groups", groups);
        return "groups";
    }
    @GetMapping("/groups/add")
    public String crGroup(){
        return "groupAdd";
    }
    @PostMapping("/groups/add")
    public String createGroup(@RequestParam("name") String name, Model model){
        Group group = new Group(name, namberGroup);
        namberGroup++;
        model.addAttribute("group", group);
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
        return "groupAdd";
    }

    @GetMapping("/groups/{idGroup}/albums")
    public String getAlbum(@PathVariable int idGroup, Model model) {
        for(Group group: groups){
            if (group.getId() == idGroup){
                model.addAttribute("group", group.album);
                model.addAttribute("album", group.album.get(0));
            }
        }
        return "albums";
    }
    @GetMapping("/groups/{idGroup}/albums/add")
    public String crAlbum(@PathVariable int idGroup) {
        return "albumAdd";
    }
    @PostMapping("/groups/{idGroup}/albums/add")
    public String addAlbum(@PathVariable int idGroup, @RequestParam("name") String name,
                           @RequestParam("year") String year, Model model) {
        Album album = new Album(groups.get(idGroup).album.size(), name, year, idGroup);
        System.out.println(album.id + "   " + album.name + "   " + album.year + "   " + album.tracks);
        for (Group group:  groups) {
            if (group.getId() == idGroup){
                group.album.add(album);
                model.addAttribute("group", album);
            }
        }
        return "albumAdd";
    }


    @GetMapping("/groups/{idGroup}/albums/{idAlbom}/tracks")
    public String getTrack(@PathVariable int idGroup, @PathVariable int idAlbom, Model model) {
        for(Group group:  groups) {
            if (group.getId() == idGroup){
                for (Album album: group.album) {
                    if (album.getId() == idAlbom){
                        model.addAttribute("group", album.tracks);
                        model.addAttribute("album", album.tracks.get(0));
                    }
                }
            }
        }

        return "tracks";
    }

    @GetMapping("/groups/{idGroup}/albums/{idAlbom}/tracks/add")
    public String crTrack(@PathVariable int idGroup, @PathVariable int idAlbom) {
        return "trackAdd";
    }
    @PostMapping("/groups/{idGroup}/albums/{idAlbom}/tracks/add")
    public String addTrack(@PathVariable int idGroup, @PathVariable int idAlbom,
                           @RequestParam("name") String name,
                           @RequestParam("length") String length, Model model) {
        Track track = new Track(groups.get(idGroup).album.get(idAlbom).tracks.size(), name, length, idGroup, idAlbom);
        System.out.println(track.id + "   " + track.name + "   " + track.length);
        for (Group group: groups){
            if (group.getId() == idGroup){
                for (Album album: group.album){
                    if (album.getId() == idAlbom){
                        album.tracks.add(track);
                        model.addAttribute("group", track);
                    }
                }
            }
        }
        return "trackAdd";
    }
}