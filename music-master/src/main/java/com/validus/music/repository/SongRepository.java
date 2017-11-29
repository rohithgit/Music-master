package com.validus.music.repository;

import com.validus.music.entity.Song;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface SongRepository extends CrudRepository<Song, Long> {
}
