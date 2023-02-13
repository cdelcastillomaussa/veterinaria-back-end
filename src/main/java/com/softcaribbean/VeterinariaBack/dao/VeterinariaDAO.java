package com.softcaribbean.VeterinariaBack.dao;

import com.softcaribbean.VeterinariaBack.dto.Veterinaria;

import java.util.List;

public interface VeterinariaDAO {

    List<Veterinaria> getAll();

    Veterinaria getById(int nmid);

    Veterinaria insert(Veterinaria entity);

    Veterinaria update(Veterinaria entity);

    Boolean delete(int nmid);


}
