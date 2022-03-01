create table if not exists roles (
    id bigint(10) auto_increment not null primary key,
    description varchar(100) not null
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;