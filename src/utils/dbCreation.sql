drop schema if exists veterinaria;
create schema veterinaria;
use veterinaria;

drop table if exists propietario;
create table propietario(
	propId int primary key auto_increment,
	propUsuario varchar(30) not null,
    propApellido varchar(30) not null default " ",
    propNombre varchar(30) not null,
    propTelefono char(25) null
);
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("vincent","Vanghogh","Vicente","3221234564");
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("dantonito","Antony","Diego","3133151232");
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("haylee","Lee","Hayo","3192212121");
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("cristop","Rojas","Christopher","2927272 ext 333");
insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values ("JReina","Reina","Johan","+549 4984445413");

drop table if exists mascota;
create table mascota(
	mascotaId int primary key auto_increment,
    mascotaNombre char(30) not null,
    propId int not null,
    foreign key(propId) references propietario(propId)
);

insert into mascota(mascotaNombre,propId) values ("Sam",5);
insert into mascota(mascotaNombre,propId) values ("Merlín",4);
insert into mascota(mascotaNombre,propId) values ("Toby",5);
insert into mascota(mascotaNombre,propId) values ("Kira",2);
insert into mascota(mascotaNombre,propId) values ("Sasha",1);
insert into mascota(mascotaNombre,propId) values ("Tribilín",2);

drop table if exists cita;
create table cita(
	citaId int primary key auto_increment,
    citaFecha datetime not null,
    citaDescripcion varchar(180) not null,
    mascotaId int not null,
    foreign key(mascotaId) references mascota(mascotaId)
);

insert into cita(citaFecha,citaDescripcion,mascotaId) values ("2021-08-01 15:30:00","El gato se encuentra con un peso normal y en su cita de control de ojos al parecer la catarata se detuvo",1);
insert into cita(citaFecha,citaDescripcion,mascotaId) values ("2021-08-02 18:30:00","Merlín presenta halitosis reflejo de un problema localizado en la boca o incluso de algún problema del aparato digestivo.",2);
insert into cita(citaFecha,citaDescripcion,mascotaId) values ("2021-06-30 04:30:20","El pronóstico es reservado. Presenta molestias bucales (gingivitis), vómitos, fiebre. Se deja en hospitalización.",4);
insert into cita(citaFecha,citaDescripcion,mascotaId) values ("2021-08-13 04:30:20","Viene para el programa de perritos de la tercera edad",5);