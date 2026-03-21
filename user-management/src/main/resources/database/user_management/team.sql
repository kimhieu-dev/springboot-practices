create table user_management.team
(
    id          int auto_increment
        primary key,
    name        varchar(50) not null,
    description varchar(50) not null,
    constraint name
        unique (name)
);

