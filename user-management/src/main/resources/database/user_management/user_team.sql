create table user_management.user_team
(
    id      int auto_increment
        primary key,
    user_id int not null,
    team_id int not null,
    constraint user_team_ibfk_1
        foreign key (user_id) references user_management.user (id),
    constraint user_team_ibfk_2
        foreign key (team_id) references user_management.team (id)
);

create index team_id
    on user_management.user_team (team_id);

create index user_id
    on user_management.user_team (user_id);

