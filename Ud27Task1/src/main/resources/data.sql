drop table if exists suministra;
drop table if exists piezas;
drop table if exists proveedores;

create table piezas(
	codigo int auto_increment,
    nombre varchar(100),
    primary key (codigo)
);

create table proveedores(
	id char(4),
    nombre varchar(100),
    primary key (id)
);

create table suministra(
	id int auto_increment,
	codigopieza int,
    proveedorid char(4),
    precio int,
    primary key (id, codigopieza, proveedorid),
    foreign key (codigopieza) references piezas(codigo),
    foreign key (proveedorid) references proveedores(id)
);

insert into piezas(nombre) values('A-14');
insert into piezas(nombre) values('A-15');

insert into proveedores values('1','Marc');
insert into proveedores values('2','Manolo');

insert into suministra(codigopieza, proveedorid, precio) values(1,'1', 10);
insert into suministra(codigopieza, proveedorid, precio) values(2,'2', 15);