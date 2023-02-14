package com.softcaribbean.VeterinariaBack.dao;

import com.softcaribbean.VeterinariaBack.dto.Paciente;

import java.util.List;

public interface PacienteDAO {

    List<Paciente> getAll();

    Paciente getById(int nmid);

    Paciente insert(Paciente entity);

    Paciente update(Paciente entity);

    Boolean delete(int nmid);


}
