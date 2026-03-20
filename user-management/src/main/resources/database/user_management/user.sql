create table user_management.user
(
    id         int auto_increment
        primary key,
    user_name  varchar(50) not null,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    age        int         not null
);

