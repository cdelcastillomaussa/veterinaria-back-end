package com.softcaribbean.VeterinariaBack.mapper;

import com.softcaribbean.VeterinariaBack.dto.Paciente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteMapper implements RowMapper<Paciente> {

    @Override
    public Paciente mapRow(ResultSet rs, int i) throws SQLException {
        Paciente entity=new Paciente();
        entity.setNmid(rs.getInt("nmid"));
        entity.setNmid_dueno(rs.getInt("nmid_dueno"));
        entity.setDs_nombre_paciente(rs.getString("ds_nombre_paciente"));
        entity.setDs_especie(rs.getString("ds_especie"));
        entity.setDs_raza(rs.getString("ds_raza"));
        entity.setDs_fecha_nac(rs.getDate("ds_fecha_nac"));
        entity.setPacienteFromRs(rs);
        return entity;
    }
}
