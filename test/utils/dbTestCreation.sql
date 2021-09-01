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