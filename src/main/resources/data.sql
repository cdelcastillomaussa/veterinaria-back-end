
insert into dueno (nmid, ds_tipo_id_dueno, ds_id_dueno, ds_nombre_dueno, ds_ciudad, ds_direccion, ds_telefono, ds_fecha_registro)
values(1, 'CC','1003045448','Carlos del castillo','Monteria','Diag 16 trasv 1a-sur Barrio Stander','3044672390', NOW());

insert into paciente (nmid, nmid_dueno, ds_nombre_paciente, ds_especie, ds_raza, ds_fecha_nac)
values(1, 1,'Oriona','Conejo','Conejo californiano','2022-12-24');