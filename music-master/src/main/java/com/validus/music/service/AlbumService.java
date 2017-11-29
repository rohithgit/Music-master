package com.validus.music.service;

import com.validus.music.entity.Album;
import com.validus.music.repository.AlbumRepository;
import com.validus.music.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class AlbumService implements GenericService<Album, Long> {

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album create(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album read(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public boolean update(Album album) {
        if (albumRepository.exists(album.getId())) {
            albumRepository.save(album);
        } else {
            throw new ServiceException("Can't update Album because it doesn't exist in DB: " + album);
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        if (albumRepository.exists(id)) {
            albumRepository.delete(id);
        } else {
            throw new ServiceException("Can't delete Album because it doesn't exist in DB: " + id);
        }
        return true;
    }
}
