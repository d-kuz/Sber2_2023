package com.example.controller;

import com.example.model.Group;
import com.example.model.Album;
import com.example.model.Track;

import com.example.repository.AlbumRepository;
import com.example.repository.GroupRepository;
import com.example.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MusicController {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    TrackRepository trackRepository;

    @GetMapping("/groups")
    public String getGroup(Model model){
        model.addAttribute("groups", groupRepository.findAll());
        return "groups";
    }
    @GetMapping("/groups/add")
    public String crGroup(){
        return "groupAdd";
    }
    @PostMapping("/groups/add")
    public String createGroup(@RequestParam("name") String name, Model model){
        Group group = new Group(name);
        model.addAttribute("group", group);
        System.out.println(group.getId() + "   " + group.getName());
        groupRepository.save(group);
        return "groupAdd";
    }

    @GetMapping("/groups/{idGroup}/albums")
    public String getAlbum(@PathVariable long idGroup, Model model) {
        Optional<Group> group = groupRepository.findById(idGroup);
        System.out.println(group.get().getName());
        Optional<Album> album = albumRepository.findById(idGroup);
        System.out.println(album.get().getName());
        model.addAttribute("group", group.get().getAlbums());
        model.addAttribute("idGroup", idGroup);
        return "albums";
    }

    @GetMapping("/groups/{idGroup}/albums/add")
    public String crAlbum(@PathVariable long idGroup) {
        return "albumAdd";
    }
    @PostMapping("/groups/{idGroup}/albums/add")
    public String addAlbum(@PathVariable long idGroup, @RequestParam("name") String name,
                           @RequestParam("years") String years, Model model) {
        Optional<Group> groupOptional = groupRepository.findById(idGroup);
        System.out.println(name + " " + years);
        if (groupOptional.isPresent()){
            Group group = groupOptional.get();
            Album album = new Album(name, years);
            group.addAlbum(album);
            groupRepository.save(group);
        }
        return "albumAdd";
    }

    @GetMapping("/groups/{idGroup}/albums/{idAlbom}/tracks")
    public String getTrack(@PathVariable long idGroup, @PathVariable long idAlbom, Model model) {
        Optional<Group> group = groupRepository.findById(idGroup);
        System.out.println(group.get().getName());
        Optional<Album> album = albumRepository.findById(idGroup);
        System.out.println(album.get().getName());
        model.addAttribute("group", album.get().getTracks());
        model.addAttribute("idGroup", idGroup);
        model.addAttribute("idAlbom", idAlbom);
        return "tracks";
    }
    @GetMapping("/groups/{idGroup}/albums/{idAlbom}/tracks/add")
    public String crTrack(@PathVariable long idGroup, @PathVariable long idAlbom) {
        return "trackAdd";
    }
    @PostMapping("/groups/{idGroup}/albums/{idAlbom}/tracks/add")
    public String addTrack(@PathVariable long idGroup, @PathVariable long idAlbom,
                           @RequestParam("name") String name,
                           @RequestParam("length") String length, Model model) {
        Optional<Group> groupOptional = groupRepository.findById(idGroup);
        Optional<Album> albumOptional = albumRepository.findById(idGroup);
        System.out.println(name + " " + length);
        if (groupOptional.isPresent()){
            Group group = groupOptional.get();
            Album album = albumOptional.get();
            Track track = new Track(name, length);
            album.addTrack(track);
            group.addAlbum(album);
            albumRepository.save(album);
            groupRepository.save(group);
        }
        return "trackAdd";
    }
}