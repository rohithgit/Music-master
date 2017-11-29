package com.validus.music.controller;

import com.validus.music.entity.Song;
import com.validus.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Song readById(@PathVariable String id) {
        return songService.read(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Song createSong(@RequestBody Song song) {
        return songService.create(song);
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    public Boolean updateSong(@RequestBody Song song) {
        return songService.update(song);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteSong(@PathVariable Long id) {
        return songService.delete(id);
    }


}
