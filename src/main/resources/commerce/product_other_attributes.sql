create table product_other_attributes
(
    product_product_id   binary(16)   not null,
    other_attributes     varchar(255) null,
    other_attributes_key varchar(255) not null,
    primary key (product_product_id, other_attributes_key),
    constraint FKr0b4eifk9nlt87oawpe4itkc0
        foreign key (product_product_id) references product (product_id)
);

INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x06CD40544CBE11EFA28E98E743588A2D, 'Value1', 'Key1');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x06CD40544CBE11EFA28E98E743588A2D, 'Value2', 'Key2');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x6377E200CEEF453F8D45F6E698DF8B37, '5G', 'connectivity');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x6377E200CEEF453F8D45F6E698DF8B37, 'OLED Display', 'displayType');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x6377E200CEEF453F8D45F6E698DF8B37, '128GB', 'storageCapacity');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x8C85CE889BCF4744847127C00A7C831F, 'Retina Display', 'displayQuality');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x8C85CE889BCF4744847127C00A7C831F, '16GB', 'ramSize');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0x8C85CE889BCF4744847127C00A7C831F, '512GB SSD', 'storageType');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0xA747336EEDE543AEABEAD7E3B619B1C9, 'Limelight', 'Color');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0xC08F3AB55ADC4E6795D9AD733439F9F3, '24-hour battery life', 'batteryLife');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0xC08F3AB55ADC4E6795D9AD733439F9F3, 'Bluetooth 5.0', 'connectivity');
INSERT INTO commerce.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES (0xC08F3AB55ADC4E6795D9AD733439F9F3, 'Water-resistant', 'waterResistance');
