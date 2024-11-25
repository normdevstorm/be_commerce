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

INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0x005D03CCC7E6493BBFF70F9BC5C7C549, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_005');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 78, '2024-08-21 16:39:03.808000', 0x2F786F4F707C40F1BABF372A2C5CAFF9, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_01');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 78, '2024-08-21 16:39:03.808000', 0x360FC1C3B9E8476595873DE418EB6CC5, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'dfhgfd');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0x3B8D3CA28846415293B82651985BBD05, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_006');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 90, '2024-08-21 16:52:49.813000', 0x3E3D0150F7354F7084564CEDF42CA3DB, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_004');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 96, '2024-08-21 16:39:03.808000', 0x4146E8B4731D4A63943C9846B7EDCC00, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_02');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0x560CECB5630B43398B21BC7EC1285989, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_007');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 90, '2024-08-21 16:52:49.813000', 0x7023FAEBB2B04285A9C7011388EE9519, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_004');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 98, '2024-08-21 16:52:49.813000', 0x8344663C132E44F0877F31268BD50531, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_008');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 78, '2024-08-21 16:39:03.808000', 0x8A0DB5D41AE248C19084E6B4AF318195, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'oke');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 92, '2024-08-21 16:52:49.813000', 0x8A5522A408244E7F892825BE2899868B, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_006');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0x920340DFAD154A93AC47E6624B5A32C3, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_007');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('DONE', 270, '2024-08-21 11:26:18.732000', 0x97066E41A19C41A4B39BAE06024140CF, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'bill_03');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0x99384D4DE3EF4A31867DB6D438C5648E, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_004');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('DONE', 250, '2024-08-21 11:26:18.732000', 0xA0D0E3EB30834E07BF2166231E84CBC0, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'bill_02');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 90, '2024-08-21 16:52:49.813000', 0xA4352B4722A448D3886798956BC0F27C, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_005');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('DONE', 100, '2024-07-28 16:06:22.000000', 0xA8CC623F4CC011EFA28E98E743588A2D, 0x46C8DE6AA8C7405D9738E4157EB30727, null);
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('DONE', 200, '2024-07-28 16:06:22.000000', 0xA8CC6A6F4CC011EFA28E98E743588A2D, 0x4ECDFBCB5D584A3ABA855C5D54936AF3, null);
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0xC653096ADFEC4D9A90533D8D3BD7A177, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_003');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 98, '2024-08-21 16:52:49.813000', 0xCB21FCC72D4E432A984FB36FE025B85E, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_008');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 67, '2024-08-21 16:16:44.985000', 0xE1968AF76B0444EE902AA82CA715BF16, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Bill_007');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 92, '2024-08-21 16:52:49.813000', 0xEE04631E9BF746B9940D88301DCAB28B, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'test_006');
INSERT INTO commerce.transaction (status, total, create_at, transaction_id, user_user_id, description) VALUES ('PENDING', 220, '2024-08-21 11:26:18.732000', 0xF4C14F2C6FF24400B4D15B030C998085, 0x5A74F1719D5D471FA418F8F5EFA0AED5, 'bill_01');
