 CREATE TABLE IF NOT EXISTS paciente (
        nmid INT NOT NULL AUTO_INCREMENT,
        ds_nombre_paciente varchar(15) NOT NULL,
        ds_especie varchar(25),
        ds_raza varchar(25),
        ds_fecha_nac date not null,
        ds_tipo_id_dueno varchar(10),
        ds_id_dueno varchar(10),
        ds_nombre_dueno varchar(50),
        ds_ciudad varchar(20),
        ds_direccion varchar(65),
        ds_telefono varchar(10),
        ds_fecha_registro timestamp not null,
        PRIMARY KEY (nmid)
  );