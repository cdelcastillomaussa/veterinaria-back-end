package com.softcaribbean.VeterinariaBack.service;

import com.softcaribbean.VeterinariaBack.dao.PacienteDAO;
import com.softcaribbean.VeterinariaBack.dto.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final Logger log = LoggerFactory.getLogger(PacienteServiceImpl.class);
    private final PacienteDAO pacienteDAO;

    public PacienteServiceImpl(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    @Override
    public Paciente save(Paciente paciente) {
        log.debug("Request to insert Paciente: {}", paciente);
        return pacienteDAO.insert(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        log.debug("Request to update Paciente: {}", paciente);
        return pacienteDAO.update(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        log.debug("Request to get all pacientes");
        return pacienteDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findOne(int nmid) {
        log.debug("Request to get paciente : {}", nmid);
        return pacienteDAO.getById(nmid);
    }

    @Override
    public void delete(int nmid) {
        log.debug("Request to delete paciente : {}", nmid);
        pacienteDAO.delete(nmid);

    }
}
