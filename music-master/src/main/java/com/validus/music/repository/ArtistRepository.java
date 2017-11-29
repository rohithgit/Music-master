package com.validus.music.repository;

import com.validus.music.entity.Artist;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
