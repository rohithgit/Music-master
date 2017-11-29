package com.validus.music.controller;

import com.validus.music.entity.Artist;
import com.validus.music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artist readById(@PathVariable String id) {
        return artistService.read(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    public Boolean updateArtist(@RequestBody Artist artist) {
        return artistService.update(artist);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteArtist(@PathVariable Long id) {
        return artistService.delete(id);
    }


}
