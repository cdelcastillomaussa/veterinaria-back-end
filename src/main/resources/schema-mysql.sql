
  CREATE TABLE IF NOT EXISTS dueno (
        nmid INT not null AUTO_INCREMENT,
        ds_tipo_id_dueno varchar(10),
        ds_id_dueno varchar(10),
        ds_nombre_dueno varchar(50),
        ds_ciudad varchar(20),
        ds_direccion varchar(65),
        ds_telefono varchar(10),
        ds_fecha_registro timestamp,
        PRIMARY KEY (nmid)
  );

 CREATE TABLE IF NOT EXISTS paciente (
        nmid INT NOT NULL AUTO_INCREMENT,
        nmid_dueno INT NOT NULL,
        ds_nombre_paciente varchar(15) NOT NULL,
        ds_especie varchar(25),
        ds_raza varchar(25),
        ds_fecha_nac date not null,
        PRIMARY KEY (nmid)
  );

ALTER TABLE paciente ADD CONSTRAINT FK_nmid_dueno FOREIGN KEY (nmid_dueno) REFERENCES dueno (nmid);