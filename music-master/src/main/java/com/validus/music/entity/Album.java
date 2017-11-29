package com.validus.music.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album extends BaseModel {

    private String name;

    @Column(name = "year_released")
    private int yearReleased;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "album_id")
    private List<Song> songs;

    public Album() {
    }

    public Album(String name, int yearReleased, ArrayList<Song> songs) {
        this.name = name;
        this.yearReleased = yearReleased;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
