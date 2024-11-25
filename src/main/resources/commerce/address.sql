create table address
(
    address_id   binary(16)   not null
        primary key,
    postal_code  varchar(255) null,
    country_code smallint     null,
    check (`country_code` between 0 and 222)
);

INSERT INTO commerce.address (address_id, postal_code, country_code) VALUES (0x905F368F4CBA11EFA28E98E743588A2D, '12345', null);
INSERT INTO commerce.address (address_id, postal_code, country_code) VALUES (0x905F3AA44CBA11EFA28E98E743588A2D, '67890', null);
INSERT INTO commerce.address (address_id, postal_code, country_code) VALUES (0x905F3B844CBA11EFA28E98E743588A2D, '54321', null);
INSERT INTO commerce.address (address_id, postal_code, country_code) VALUES (0x905F3BE34CBA11EFA28E98E743588A2D, '09876', null);
