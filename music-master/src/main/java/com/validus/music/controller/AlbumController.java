package com.validus.music.controller;

import com.validus.music.entity.Album;
import com.validus.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album readById(@PathVariable String id) {
        return albumService.read(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album) {
        return albumService.create(album);
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    public Boolean updateAlbum(@RequestBody Album album) {
        return albumService.update(album);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteAlbum(@PathVariable Long id) {
        return albumService.delete(id);
    }
}
