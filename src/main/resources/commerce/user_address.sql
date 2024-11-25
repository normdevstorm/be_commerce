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

INSERT INTO commerce.user_address (address_id, user_id) VALUES (0x905F3BE34CBA11EFA28E98E743588A2D, 0x46C8DE6AA8C7405D9738E4157EB30727);
INSERT INTO commerce.user_address (address_id, user_id) VALUES (0x905F3B844CBA11EFA28E98E743588A2D, 0x4ECDFBCB5D584A3ABA855C5D54936AF3);
