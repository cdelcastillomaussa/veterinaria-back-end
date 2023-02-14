package com.softcaribbean.VeterinariaBack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
public class Dueno implements Serializable {
    private int nmid;
    private String ds_tipo_id_dueno;
    private String ds_id_dueno;
    private String ds_nombre_dueno;
    private String ds_ciudad;
    private String ds_direccion;
    private String ds_telefono;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ds_fecha_registro;

    public void setDuenoFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        ds_tipo_id_dueno = rs.getString("ds_tipo_id_dueno");
        ds_id_dueno = rs.getString("ds_id_dueno");
        ds_nombre_dueno = rs.getString("ds_nombre_dueno");
        ds_ciudad = rs.getString("ds_ciudad");
        ds_direccion = rs.getString("ds_direccion");
        ds_telefono = rs.getString("ds_telefono");
        ds_fecha_registro = rs.getTimestamp("ds_fecha_registro");
    }
}
