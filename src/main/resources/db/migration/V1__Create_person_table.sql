create table person (
    id serial not null primary key,
    name varchar(100) not null,
    version bigint not null
);