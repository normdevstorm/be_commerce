create table password_reset_token
(
    id          bigint       not null
        primary key,
    expiry_date datetime(6)  null,
    token       varchar(255) null,
    user_id     binary(16)   not null,
    constraint UKf90ivichjaokvmovxpnlm5nin
        unique (user_id),
    constraint FK5lwtbncug84d4ero33v3cfxvl
        foreign key (user_id) references user (user_id)
);

