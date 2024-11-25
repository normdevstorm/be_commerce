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

INSERT INTO commerce.product (original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name, category) VALUES (100, 80, 4, '2024-07-28 15:47:31.000000', 50, 0x906331654CBA11EFA28E98E743588A2D, 0x06CD40544CBE11EFA28E98E743588A2D, 'A tech product description', 'TechProduct1', 7);
INSERT INTO commerce.product (original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name, category) VALUES (200, 150, 3, '2024-07-28 15:47:31.000000', 30, 0x906336464CBA11EFA28E98E743588A2D, 0x06CD62914CBE11EFA28E98E743588A2D, 'A fashion product description', 'FashionProduct1', 6);
INSERT INTO commerce.product (original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name, category) VALUES (699.99, 599.99, 3, '2024-08-16 11:07:17.904000', 50, 0xF5386A6F37EA48B482BA73A7A2E714B1, 0x6377E200CEEF453F8D45F6E698DF8B37, null, 'Smartphone', 0);
INSERT INTO commerce.product (original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name, category) VALUES (1199.99, 1099.99, 4, '2024-08-16 11:07:17.904000', 30, 0x6D02F99A22A24FB1A28B5BE33B8A5E51, 0x8C85CE889BCF4744847127C00A7C831F, null, 'Laptop', 0);
INSERT INTO commerce.product (original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name, category) VALUES (34, 30, 0, '2024-08-15 03:45:40.833000', 23, 0xE240E810E45940EDBE8CB17F5EFD48AE, 0xA747336EEDE543AEABEAD7E3B619B1C9, 'One station for up to 25 devices connected to at the same time', '', 0);
INSERT INTO commerce.product (original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name, category) VALUES (149.99, 129.99, 3, '2024-08-16 11:07:17.904000', 100, 0x60EC002F9FAA4D7EA97A09DF5C927B79, 0xC08F3AB55ADC4E6795D9AD733439F9F3, null, 'Wireless Earbuds', 0);
