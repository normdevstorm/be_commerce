-- we don't know how to generate root <with-no-name> (class Root) :(

create table account
(
    account_id binary(16)             not null
        primary key,
    password   varchar(255)           not null,
    username   varchar(255)           not null,
    role       enum ('ADMIN', 'USER') null
);

create table address
(
    address_id   binary(16)   not null
        primary key,
    postal_code  varchar(255) null,
    country_code smallint     null,
    check (`country_code` between 0 and 222)
);

create table brand
(
    brand_id binary(16)   not null
        primary key,
    about    text         null,
    name     varchar(255) null
);

create table password_reset_token_seq
(
    next_val bigint null
);

create table product
(
    original_price double       not null,
    sale_price     double       not null,
    star_rate      tinyint      null,
    created_at     datetime(6)  null,
    stock_quantity bigint       not null,
    brand_brand_id binary(16)   null,
    product_id     binary(16)   not null
        primary key,
    desciption     varchar(255) null,
    name           varchar(255) null,
    category       tinyint      null,
    constraint FKboqft24mwam9ifa6xlj12cjpc
        foreign key (brand_brand_id) references brand (brand_id),
    check (`star_rate` between 0 and 4)
);

create table product_other_attributes
(
    product_product_id   binary(16)   not null,
    other_attributes     varchar(255) null,
    other_attributes_key varchar(255) not null,
    primary key (product_product_id, other_attributes_key),
    constraint FKr0b4eifk9nlt87oawpe4itkc0
        foreign key (product_product_id) references product (product_id)
);

create table user
(
    user_id              binary(16)             not null
        primary key,
    first_name           varchar(50)            null,
    last_name            varchar(50)            null,
    password             varchar(255)           not null,
    phone_number         varchar(255)           null,
    username             varchar(255)           not null,
    role                 enum ('ADMIN', 'USER') null,
    email                varchar(255)           null,
    reset_password_token varchar(255)           null
);

create table cart
(
    quantity           bigint     not null,
    product_product_id binary(16) not null,
    user_user_id       binary(16) not null,
    primary key (product_product_id, user_user_id),
    constraint FK45kh318jlvfel6pk3lwky6rqm
        foreign key (user_user_id) references user (user_id),
    constraint FKgt543ui1msc4owrx9x7d9eiyw
        foreign key (product_product_id) references product (product_id)
);

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

create table payment
(
    exp_date     datetime(6)  null,
    payment_id   binary(16)   not null
        primary key,
    user_user_id binary(16)   null,
    card_num     varchar(255) null,
    cvv          varchar(4)   null,
    constraint FKeyeq634dhc0yerigthfkylt3x
        foreign key (user_user_id) references user (user_id)
);

create table review
(
    created_at   datetime(6)  null,
    review_id    binary(16)   not null
        primary key,
    user_user_id binary(16)   null,
    feedback     varchar(200) null,
    constraint FK5bhefci502sd63299f0mw09t7
        foreign key (user_user_id) references user (user_id)
);

create table product_reviews
(
    product_product_id binary(16) not null,
    reviews_review_id  binary(16) not null,
    primary key (product_product_id, reviews_review_id),
    constraint UK71kr315nedgkucd6345i14co7
        unique (reviews_review_id),
    constraint FKetagsetrtlvu3ao69v7asg2ph
        foreign key (product_product_id) references product (product_id),
    constraint FKt8iliw8splv96li2ut0wd6n0j
        foreign key (reviews_review_id) references review (review_id)
);

create table transaction
(
    status         enum ('DONE', 'PENDING', 'ERROR', 'CANCELLED', 'IN_PROGRESS') default 'IN_PROGRESS' not null,
    total          double                                                                              not null,
    create_at      datetime(6)                                                                         null,
    transaction_id binary(16)                                                                          not null
        primary key,
    user_user_id   binary(16)                                                                          null,
    description    varchar(255)                                                                        null,
    constraint FKgnae5nvxpqu8jxwr75mlmc0cr
        foreign key (user_user_id) references user (user_id)
);

create table user_address
(
    address_id binary(16) not null,
    user_id    binary(16) not null,
    primary key (address_id, user_id),
    constraint FKdaaxogn1ss81gkcsdn05wi6jp
        foreign key (address_id) references address (address_id),
    constraint FKk2ox3w9jm7yd6v1m5f68xibry
        foreign key (user_id) references user (user_id)
);

