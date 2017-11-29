package com.validus.music.service;

import java.io.Serializable;

public interface GenericService<T, ID extends Serializable> {

    T create(T object);

    T read(ID id);

    boolean update(T object);

    boolean delete(ID id);
}
