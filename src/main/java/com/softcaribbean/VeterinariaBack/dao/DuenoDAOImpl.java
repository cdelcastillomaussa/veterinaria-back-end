package com.softcaribbean.VeterinariaBack.dao;

import com.softcaribbean.VeterinariaBack.dto.Dueno;
import com.softcaribbean.VeterinariaBack.mapper.DuenoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.List;

@Repository
public class DuenoDAOImpl implements DuenoDAO{

    private static final String INSERT = "INSERT INTO dueno (nmid, ds_tipo_id_dueno, ds_id_dueno, ds_nombre_dueno, ds_ciudad, ds_direccion, ds_telefono, ds_fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE dueno SET ds_tipo_id_dueno=?, ds_id_dueno=?, ds_nombre_dueno=?, ds_ciudad=?, ds_direccion=?, ds_telefono=?, ds_fecha_registro=NOW() WHERE nmid=?";
    private static final String SELECT = "SELECT * FROM dueno";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    private static final String DELETE = "DELETE FROM dueno WHERE nmid = ?";

    JdbcTemplate jdbcTemplate;
    public DuenoDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Dueno> getAll() {
        return jdbcTemplate.query(SELECT, new DuenoMapper());
    }

    @Override
    public Dueno getById(int nmid) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new DuenoMapper(), nmid);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Dueno insert(Dueno entity) {
        jdbcTemplate.update(INSERT,
                entity.getNmid(),
                entity.getDs_tipo_id_dueno(),
                entity.getDs_id_dueno(),
                entity.getDs_nombre_dueno(),
                entity.getDs_ciudad(),
                entity.getDs_direccion(),
                entity.getDs_telefono(),
                entity.getDs_fecha_registro());
        return entity;
    }

    @Override
    public Dueno update(Dueno entity) {
        jdbcTemplate.update(UPDATE,
                entity.getDs_tipo_id_dueno(),
                entity.getDs_id_dueno(),
                entity.getDs_nombre_dueno(),
                entity.getDs_ciudad(),
                entity.getDs_direccion(),
                entity.getDs_telefono(),
                entity.getDs_fecha_registro(),
                entity.getNmid());
        return entity;
    }

    @Override
    public Boolean delete(int nmid) {
        return jdbcTemplate.update(DELETE, nmid) > 0;
    }
}
