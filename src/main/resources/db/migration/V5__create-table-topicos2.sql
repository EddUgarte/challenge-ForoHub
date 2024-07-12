create table topicos2(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null unique,
    fecha_creacion varchar(25) not null unique,
    estado_del_topico varchar(100) not null,
    autor_id varchar(100) not null,
    curso_id varchar(100) not null,

    primary key(id)

);