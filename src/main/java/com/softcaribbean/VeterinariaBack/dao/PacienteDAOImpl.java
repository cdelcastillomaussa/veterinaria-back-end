package com.softcaribbean.VeterinariaBack.dao;

import com.softcaribbean.VeterinariaBack.dto.Paciente;
import com.softcaribbean.VeterinariaBack.mapper.PacienteMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class PacienteDAOImpl implements PacienteDAO {

    private static final String INSERT = "INSERT INTO paciente (nmid, nmid_dueno, ds_nombre_paciente, ds_especie, ds_raza, ds_fecha_nac) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE paciente SET nmid_dueno=?, ds_nombre_paciente=?, ds_especie=?, ds_raza=?, ds_fecha_nac=? WHERE nmid=?";
    private static final String SELECT = "SELECT * FROM paciente";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    private static final String DELETE = "DELETE FROM paciente WHERE nmid = ?";

    JdbcTemplate jdbcTemplate;

    public PacienteDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Paciente> getAll() {
        return jdbcTemplate.query(SELECT, new PacienteMapper());
    }

    @Override
    public Paciente getById(int nmid) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new PacienteMapper(), nmid);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }

    }

    @Override
    public Paciente insert(Paciente entity) {
        jdbcTemplate.update(INSERT,
                entity.getNmid(),
                entity.getNmid_dueno(),
                entity.getDs_nombre_paciente(),
                entity.getDs_especie(),
                entity.getDs_raza(),
                entity.getDs_fecha_nac());
        return entity;
    }

    @Override
    public Paciente update(Paciente entity) {
        jdbcTemplate.update(UPDATE,
                entity.getNmid_dueno(),
                entity.getDs_nombre_paciente(),
                entity.getDs_especie(),
                entity.getDs_raza(),
                entity.getDs_fecha_nac(),
                entity.getNmid());
        return entity;
    }

    @Override
    public Boolean delete(int nmid) {
        return jdbcTemplate.update(DELETE, nmid)>0;
    }
}
