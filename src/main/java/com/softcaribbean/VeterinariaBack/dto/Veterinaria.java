package com.softcaribbean.VeterinariaBack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Veterinaria implements Serializable {
    private int nmid;
    private String ds_nombre_paciente;
    private String ds_especie;
    private String ds_raza;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ds_fecha_nac;
    private String ds_tipo_id_dueno;
    private String ds_id_dueno;
    private String ds_nombre_dueno;
    private String ds_ciudad;
    private String ds_direccion;
    private String ds_telefono;
    private Timestamp ds_fecha_registro;

    @JsonIgnore
    public void setVeterinariaFromRs(ResultSet rs) throws SQLException{
        nmid = rs.getInt("nmid");
        ds_nombre_paciente = rs.getString("ds_nombre_paciente");
        ds_especie = rs.getString("ds_especie");
        ds_raza = rs.getString("ds_raza");
        ds_fecha_nac = rs.getDate("ds_fecha_nac");
        ds_tipo_id_dueno = rs.getString("ds_tipo_dueno");
        ds_id_dueno = rs.getString("ds_id_dueno");
        ds_nombre_dueno = rs.getString("ds_nombre_dueno");
        ds_ciudad = rs.getString("ds_ciudad");
        ds_direccion = rs.getString("ds_direccion");
        ds_telefono = rs.getString("ds_telefono");
        ds_fecha_registro = rs.getTimestamp("ds_fecha_registro");
    }


}
