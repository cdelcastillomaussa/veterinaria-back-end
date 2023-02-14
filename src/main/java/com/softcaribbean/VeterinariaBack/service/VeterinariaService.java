package com.softcaribbean.VeterinariaBack.service;

import com.softcaribbean.VeterinariaBack.dto.Veterinaria;

import java.util.List;

public interface VeterinariaService {

    Veterinaria save(Veterinaria veterinaria);
    Veterinaria update(Veterinaria veterinaria);
    List<Veterinaria> findAll();
    Veterinaria findOne(int nmid);
    void delete(int nmid);


}
