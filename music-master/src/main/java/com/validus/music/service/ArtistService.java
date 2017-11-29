package com.validus.music.service;

import com.validus.music.entity.Artist;
import com.validus.music.repository.ArtistRepository;
import com.validus.music.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class ArtistService implements GenericService<Artist, Long> {

    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist read(Long id) {
        return artistRepository.findOne(id);
    }

    @Override
    public boolean update(Artist artist) {
        if (artistRepository.exists(artist.getId())) {
            artistRepository.save(artist);
        } else {
            throw new ServiceException("Can't update Artist because it doesn't exist in DB: " + artist);
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        if (artistRepository.exists(id)) {
            artistRepository.delete(id);
        } else {
            throw new ServiceException("Can't delete Artist because it doesn't exist in DB: " + id);
        }
        return true;
    }
}
