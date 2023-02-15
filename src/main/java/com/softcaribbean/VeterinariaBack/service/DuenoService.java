package com.softcaribbean.VeterinariaBack.service;

import com.softcaribbean.VeterinariaBack.dto.Dueno;
import com.softcaribbean.VeterinariaBack.dto.Paciente;

import java.util.List;

public interface DuenoService {

    Dueno save(Dueno dueno);
    Dueno update(Dueno dueno);
    List<Dueno> findAll();
    Dueno findOne(int nmid);
    void delete(int nmid);
}
