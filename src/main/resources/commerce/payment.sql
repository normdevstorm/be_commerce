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

INSERT INTO commerce.payment (exp_date, payment_id, user_user_id, card_num, cvv) VALUES ('2024-07-28 16:04:03.000000', 0x5651D9E94CC011EFA28E98E743588A2D, 0x46C8DE6AA8C7405D9738E4157EB30727, '1234567812345678', '123');
INSERT INTO commerce.payment (exp_date, payment_id, user_user_id, card_num, cvv) VALUES ('2024-07-28 16:04:03.000000', 0x5651E1E54CC011EFA28E98E743588A2D, 0x4ECDFBCB5D584A3ABA855C5D54936AF3, '8765432187654321', '321');
