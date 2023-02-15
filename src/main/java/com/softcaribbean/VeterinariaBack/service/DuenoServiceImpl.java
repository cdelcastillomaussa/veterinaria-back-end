package com.softcaribbean.VeterinariaBack.service;

import com.softcaribbean.VeterinariaBack.dao.DuenoDAO;
import com.softcaribbean.VeterinariaBack.dto.Dueno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DuenoServiceImpl implements DuenoService{

    private final Logger log = LoggerFactory.getLogger(PacienteServiceImpl.class);
    private final DuenoDAO duenoDAO;

    public DuenoServiceImpl(DuenoDAO duenoDAO) {
        this.duenoDAO = duenoDAO;
    }

    @Override
    public Dueno save(Dueno dueno) {
        log.debug("Request to insert Dueño: {}", dueno);
        return duenoDAO.insert(dueno);
    }

    @Override
    public Dueno update(Dueno dueno) {
        log.debug("Request to update Dueño: {}", dueno);
        return duenoDAO.update(dueno);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dueno> findAll() {
        log.debug("Request to get all Dueños");
        return duenoDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Dueno findOne(int nmid) {
        log.debug("Request to get dueño : {}", nmid);
        return duenoDAO.getById(nmid);
    }

    @Override
    public void delete(int nmid) {
        log.debug("Request to delete dueño : {}", nmid);
        duenoDAO.delete(nmid);
    }
}
