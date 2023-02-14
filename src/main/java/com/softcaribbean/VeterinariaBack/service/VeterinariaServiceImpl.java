package com.softcaribbean.VeterinariaBack.service;

import com.softcaribbean.VeterinariaBack.dao.VeterinariaDAO;
import com.softcaribbean.VeterinariaBack.dto.Veterinaria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VeterinariaServiceImpl implements VeterinariaService{

    private final Logger log = LoggerFactory.getLogger(VeterinariaServiceImpl.class);
    private final VeterinariaDAO veterinariaDAO;

    public VeterinariaServiceImpl(VeterinariaDAO veterinariaDAO) {
        this.veterinariaDAO = veterinariaDAO;
    }

    @Override
    public Veterinaria save(Veterinaria veterinaria) {
        log.debug("Request to insert veterinaria: {}", veterinaria);
        return veterinariaDAO.insert(veterinaria);
    }

    @Override
    public Veterinaria update(Veterinaria veterinaria) {
        log.debug("Request to update veterinaria: {}", veterinaria);
        return veterinariaDAO.update(veterinaria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Veterinaria> findAll() {
        log.debug("Request to get all veterinaria");
        return veterinariaDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinaria findOne(int nmid) {
        log.debug("Request to get veterianaria : {}", nmid);
        return veterinariaDAO.getById(nmid);
    }

    @Override
    public void delete(int nmid) {
        log.debug("Request to delete veterinaria : {}", nmid);
        veterinariaDAO.delete(nmid);

    }
}
