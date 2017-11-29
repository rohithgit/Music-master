package com.validus.music.service;

import com.validus.music.entity.Song;
import com.validus.music.repository.SongRepository;
import com.validus.music.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class SongService implements GenericService<Song, Long> {

    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song create(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song read(Long id) {
        return songRepository.findOne(id);
    }

    @Override
    public boolean update(Song song) {
        if (songRepository.exists(song.getId())) {
            songRepository.save(song);
        } else {
            throw new ServiceException("Can't update Song because it doesn't exist in DB: " + song);
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        if (songRepository.exists(id)) {
            songRepository.delete(id);
        } else {
            throw new ServiceException("Can't delete Song because it doesn't exist in DB: " + id);
        }
        return true;
    }
}
