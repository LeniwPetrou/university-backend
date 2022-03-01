create table if not exists courses (
    id bigint(10) auto_increment not null primary key,
    description varchar(100) not null,
    start_date datetime,
    end_date datetime
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;