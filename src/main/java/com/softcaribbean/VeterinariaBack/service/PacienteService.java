package com.softcaribbean.VeterinariaBack.service;

import com.softcaribbean.VeterinariaBack.dto.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente save(Paciente paciente);
    Paciente update(Paciente paciente);
    List<Paciente> findAll();
    Paciente findOne(int nmid);
    void delete(int nmid);


}
