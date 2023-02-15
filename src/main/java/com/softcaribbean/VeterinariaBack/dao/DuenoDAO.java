package com.softcaribbean.VeterinariaBack.dao;

import com.softcaribbean.VeterinariaBack.dto.Dueno;

import java.util.List;

public interface DuenoDAO {

    List<Dueno> getAll();

    Dueno getById(int nmid);

    Dueno insert(Dueno entity);

    Dueno update(Dueno entity);

    Boolean delete(int nmid);
}
