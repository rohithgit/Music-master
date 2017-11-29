package com.validus.music.repository;

import com.validus.music.entity.Album;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface AlbumRepository extends CrudRepository<Album, Long> {
}
