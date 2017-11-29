package com.validus.music.entity;

import javax.persistence.Entity;

@Entity
public class Song extends BaseModel {

    private String track;
    private String name;

    public Song() {
    }

    public Song(String track, String name) {
        this.track = track;
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
