package com.softcaribbean.VeterinariaBack.dao;

import com.softcaribbean.VeterinariaBack.dto.Veterinaria;
import com.softcaribbean.VeterinariaBack.mapper.VeterinariaMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class VeterinariaDAOImpl implements VeterinariaDAO {

    private static final String INSERT = "INSERT INTO paciente (nmid, ds_nombre_paciente, ds_especie, ds_raza, ds_fecha_nac, ds_tipo_id_dueno, ds_id_dueno, ds_nombre_dueno, ds_ciudad, ds_direccion, ds_telefono, ds_fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE paciente SET ds_nombre_paciente=?, ds_especie=?, ds_raza=?, ds_fecha_nac=?, ds_tipo_id_dueno=?, ds_id_dueno=?, ds_nombre_dueno=?, ds_ciudad=?, ds_direccion=?, ds_telefono=?, ds_fecha_registro=? WHERE nmid=?";
    private static final String SELECT = "SELECT * FROM paciente";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    private static final String DELETE = "DELETE FROM paciente WHERE nmid = ?";

    JdbcTemplate jdbcTemplate;

    public VeterinariaDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Veterinaria> getAll() {
        return jdbcTemplate.query(SELECT, new VeterinariaMapper());
    }

    @Override
    public Veterinaria getById(int nmid) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new VeterinariaMapper(), nmid);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }

    }

    @Override
    public Veterinaria insert(Veterinaria entity) {
        jdbcTemplate.update(INSERT,
                entity.getNmid(),
                entity.getDs_nombre_paciente(),
                entity.getDs_especie(),
                entity.getDs_raza(),
                entity.getDs_fecha_nac(),
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
    public Veterinaria update(Veterinaria entity) {
        jdbcTemplate.update(UPDATE,
                entity.getDs_nombre_paciente(),
                entity.getDs_especie(),
                entity.getDs_raza(),
                entity.getDs_fecha_nac(),
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
        return jdbcTemplate.update(DELETE, nmid)>0;
    }
}
