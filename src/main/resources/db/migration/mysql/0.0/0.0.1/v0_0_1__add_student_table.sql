--create table if not exists roles (
--    id bigint(10) auto_increment not null primary key,
--    description varchar(100) not null
--) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table if not exists users (
    id bigint(10) auto_increment not null primary key,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null,
    username varchar(100) not null,
    password varchar(100) not null,
    role_id bigint(10) not null
--    FOREIGN KEY (role_id) REFERENCES roles(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;