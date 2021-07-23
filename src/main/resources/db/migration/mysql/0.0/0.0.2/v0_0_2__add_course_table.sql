create table if not exists student (
    id bigint(10) auto_increment not null primary key,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;