create table product_detail
(
    id          int auto_increment
        primary key,
    weight      int          not null,
    brand       varchar(255) not null,
    description varchar(255) not null
);

create table product_offering
(
    id     int auto_increment
        primary key,
    name   varchar(255)                not null,
    price  int                         not null,
    color  varchar(255)                null,
    status enum ('ACTIVE', 'INACTIVE') not null
);

create table product_offering_detail
(
    id                  int auto_increment
        primary key,
    product_offering_id int not null,
    product_detail_id   int not null,
    constraint product_offering_detail_ibfk_1
        foreign key (product_offering_id) references product_offering (id),
    constraint product_offering_detail_ibfk_2
        foreign key (product_detail_id) references product_detail (id)
);

create index product_detail_id
    on product_offering_detail (product_detail_id);

create index product_offering_id
    on product_offering_detail (product_offering_id);

