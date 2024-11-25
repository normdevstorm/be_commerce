create table brand
(
    brand_id binary(16)   not null
        primary key,
    about    text         null,
    name     varchar(255) null
);

INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x184C3EA4911949FA89925522515E7C69, 'Premium audio devices.', 'SoundMax');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x60EC002F9FAA4D7EA97A09DF5C927B79, 'Premium audio devices.', 'SoundMax');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x6D02F99A22A24FB1A28B5BE33B8A5E51, 'High-performance computing devices.', 'ComputePro');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x906331654CBA11EFA28E98E743588A2D, 'A brand about tech products', 'TechBrand');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x906336464CBA11EFA28E98E743588A2D, 'A brand about fashion', 'FashionBrand');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x9063379C4CBA11EFA28E98E743588A2D, 'A brand about sports', 'SportsBrand');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0x906337F74CBA11EFA28E98E743588A2D, 'A brand about books', 'BookBrand');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0xE240E810E45940EDBE8CB17F5EFD48AE, 'Product of a Thai mannufacturer', 'Electrolux');
INSERT INTO commerce.brand (brand_id, about, name) VALUES (0xF5386A6F37EA48B482BA73A7A2E714B1, 'Innovative technology solutions.', 'TechBrand');
