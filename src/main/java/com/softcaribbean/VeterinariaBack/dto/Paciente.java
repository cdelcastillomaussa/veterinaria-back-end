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
public class Paciente implements Serializable {
    private int nmid;
    private int nmid_dueno;
    private String ds_nombre_paciente;
    private String ds_especie;
    private String ds_raza;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ds_fecha_nac;


    @JsonIgnore
    public void setPacienteFromRs(ResultSet rs) throws SQLException{
        nmid = rs.getInt("nmid");
        nmid_dueno = rs.getInt("nmid_dueno");
        ds_nombre_paciente = rs.getString("ds_nombre_paciente");
        ds_especie = rs.getString("ds_especie");
        ds_raza = rs.getString("ds_raza");
        ds_fecha_nac = rs.getDate("ds_fecha_nac");
    }


}
