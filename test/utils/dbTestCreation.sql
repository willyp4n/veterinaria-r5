drop schema if exists veterinariaTest;
create schema veterinariaTest;
use veterinariaTest;

drop table if exists propietario;
create table propietario(
	propId int primary key auto_increment,
	propUsuario varchar(30) not null,
    propApellido varchar(30) not null default " ",
    propNombre varchar(30) not null,
    propTelefono char(25) null
);
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("usuario1","nombre1","apellido1","0123456789");
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("usuario2","nombre2","apellido2","1234567890");

drop table if exists mascota;
create table mascota(
	mascotaId int primary key auto_increment,
    mascotaNombre char(30) not null,
    propId int not null,
    foreign key(propId) references propietario(propId)
);

insert into mascota(mascotaNombre,propId) values ("mascota1",1);
insert into mascota(mascotaNombre,propId) values ("mascota2",2);
insert into mascota(mascotaNombre,propId) values ("mascota3",1);

drop table if exists cita;
create table cita(
	citaId int primary key auto_increment,
    citaFecha datetime not null,
    citaDescripcion varchar(180) not null,
    mascotaId int not null,
    foreign key(mascotaId) references mascota(mascotaId)
);

insert into cita(citaFecha,citaDescripcion,mascotaId) values ("2021-08-29 15:00:00","descripción cita 1",1);
insert into cita(citaFecha,citaDescripcion,mascotaId) values ("2021-08-30 18:00:00","descripción cita 2",2);
