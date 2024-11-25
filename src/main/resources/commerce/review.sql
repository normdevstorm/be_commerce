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

INSERT INTO commerce.review (created_at, review_id, user_user_id, feedback) VALUES ('2024-08-15 03:45:40.833000', 0x3F8D9D119D964D4486F85FD05ED7F9B6, null, 'Way too good');
INSERT INTO commerce.review (created_at, review_id, user_user_id, feedback) VALUES ('2024-07-28 16:10:56.000000', 0x4C4936484CC111EFA28E98E743588A2D, 0x46C8DE6AA8C7405D9738E4157EB30727, 'Great product!');
INSERT INTO commerce.review (created_at, review_id, user_user_id, feedback) VALUES ('2024-07-28 16:10:56.000000', 0x4C493FCC4CC111EFA28E98E743588A2D, 0x4ECDFBCB5D584A3ABA855C5D54936AF3, 'Not bad.');
INSERT INTO commerce.review (created_at, review_id, user_user_id, feedback) VALUES ('2024-08-15 03:45:40.833000', 0x949E5A5AE93B49C1A018ACC872007C67, null, 'Not bad');
INSERT INTO commerce.review (created_at, review_id, user_user_id, feedback) VALUES ('2024-08-15 03:45:40.833000', 0xAAA2A5CE27114E75A14B6EDF3731EAB8, null, 'Not bad');
