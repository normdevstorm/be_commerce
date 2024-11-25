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

INSERT INTO commerce.cart (quantity, product_product_id, user_user_id) VALUES (1, 0x06CD40544CBE11EFA28E98E743588A2D, 0x46C8DE6AA8C7405D9738E4157EB30727);
INSERT INTO commerce.cart (quantity, product_product_id, user_user_id) VALUES (7, 0x06CD62914CBE11EFA28E98E743588A2D, 0x5A74F1719D5D471FA418F8F5EFA0AED5);
