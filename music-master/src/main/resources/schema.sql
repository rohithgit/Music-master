CREATE TABLE artist (
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(100),
  created       DATE,
  last_modified DATE

);

CREATE TABLE album (
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(100),
  year_released VARCHAR(4),
  created       DATE,
  last_modified DATE

);

CREATE TABLE artist_albums (
  artist_id BIGINT,
  albums_id BIGINT
);

CREATE TABLE song (
  ID            BIGINT PRIMARY KEY AUTO_INCREMENT,
  album_id      BIGINT,
  track         BIGINT,
  name          VARCHAR(100),
  created       DATE,
  last_modified DATE

);
