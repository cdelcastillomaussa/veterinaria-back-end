package com.softcaribbean.VeterinariaBack.mapper;

import com.softcaribbean.VeterinariaBack.dto.Dueno;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DuenoMapper implements RowMapper<Dueno> {
    @Override
    public Dueno mapRow(ResultSet rs, int i) throws SQLException {
        Dueno entity=new Dueno();
        entity.setNmid(rs.getInt("nmid"));
        entity.setDs_tipo_id_dueno(rs.getString("ds_tipo_id_dueno"));
        entity.setDs_id_dueno(rs.getString("ds_id_dueno"));
        entity.setDs_nombre_dueno(rs.getString("ds_nombre_dueno"));
        entity.setDs_ciudad(rs.getString("ds_ciudad"));
        entity.setDs_direccion(rs.getString("ds_direccion"));
        entity.setDs_telefono(rs.getString("ds_telefono"));
        entity.setDs_fecha_registro(rs.getTimestamp("ds_fecha_registro"));
        entity.setDuenoFromRs(rs);
        return entity;
    }
}
