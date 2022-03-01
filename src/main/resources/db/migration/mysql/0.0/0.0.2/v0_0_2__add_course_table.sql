create table if not exists course (
    id bigint(10) auto_increment not null primary key,
    code varchar(100) not null,
    description varchar(100) not null,
    user_id bigint(10),
    FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;