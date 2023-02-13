package com.softcaribbean.VeterinariaBack.mapper;

import com.softcaribbean.VeterinariaBack.dto.Veterinaria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VeterinariaMapper implements RowMapper<Veterinaria> {

    @Override
    public Veterinaria mapRow(ResultSet rs, int i) throws SQLException {
        Veterinaria entity=new Veterinaria();
        entity.setNmid(rs.getInt("nmid"));
        entity.setDs_nombre_paciente(rs.getString("ds_nombre_paciente"));
        entity.setDs_especie(rs.getString("ds_especie"));
        entity.setDs_raza(rs.getString("ds_raza"));
        entity.setDs_fecha_nac(rs.getDate("ds_fecha_nac"));
        entity.setDs_tipo_id_dueno(rs.getString("ds_tipo_id_dueno"));
        entity.setDs_id_dueno(rs.getString("ds_id_dueno"));
        entity.setDs_nombre_dueno(rs.getString("ds_nombre_dueno"));
        entity.setDs_ciudad(rs.getString("ds_ciudad"));
        entity.setDs_direccion(rs.getString("ds_direccion"));
        entity.setDs_telefono(rs.getString("ds_telefono"));
        entity.setDs_fecha_registro(rs.getTimestamp("ds_fecha_registro"));
        entity.setVeterinariaFromRs(rs);
        return entity;
    }
}
