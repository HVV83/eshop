create sequence hibernate_sequence start 1 increment 1;

create table watches (
    id          int8          not null,
    title       varchar(255)  not null,
    price       integer       not null,
    description varchar(1024) not null,
    fountain    text,
    primary key (id)
);