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

INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0x135E9756E98047BC92AB3D216FA75B32, 'norm', 'nguyen', '$2a$10$3JVKOPY9x1wWSZ6dDsiVRO3OwvAS5tJ56/Hvd7TjLdMzePm1W7Fdq', '+84-39-295-3440', 'normdev', 'USER', null, null);
INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0x46C8DE6AA8C7405D9738E4157EB30727, 'Jane', 'Smith', '$2a$10$wJITrvW7Y.6QJqdznbXrJO2YaS.F/gbGiRn30/DoYu8/Zf1qeRQqi', '+84-98-765-4321', 'janesmith', 'ADMIN', null, null);
INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0x4ECDFBCB5D584A3ABA855C5D54936AF3, 'Ereren', 'Bieber', '$2a$10$tIjULax5qMJZSvLborVyT.HHC/llEsO9C5nKbLHWdBrp5WR.tL1TK', '+84-23-344-5566', 'emilydavis', 'ADMIN', null, null);
INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0x5A74F1719D5D471FA418F8F5EFA0AED5, 'Mike', 'Johnson', '$2a$10$bxlJY7VFU8dsEEQiI40DjOsiZcNq2V2DEWcDqU78Zw6kQhCGy.3ri', '+84-12-233-4455', 'mikejohnson', 'USER', null, null);
INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0xE2121C5B2B9049F9B85368B2A28F09A9, 'John', 'Doe', '$2a$10$6ajs2mJGbz6sCxTK0TEuWuOYugsywOfjGHgbA8KzYL6.0Y27SqEJa', '+84-12-345-6789', 'johndoe', 'USER', null, null);
INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0xE7F76A87AA724CA89C97985EF369649E, 'norm', 'nguyen', '$2a$10$YA1OlNMTTsRYBOz2ZqtsxOUyFFqHhe183mcEV/nM79S9V6QtrXM2e', '+84-39-295-5340', 'normdevstom_2024@', 'USER', null, null);
INSERT INTO commerce.user (user_id, first_name, last_name, password, phone_number, username, role, email, reset_password_token) VALUES (0xF23264A465AF4C6A8C36D2E276691187, 'Nam', 'Nguyen', '$2a$10$bFJCHKgofgxrB2gaqz9.i.6nOJgyb/f1./NiV6.JOL0XUoYNkdzaK', '+84-39-295-5340', '2024normdevarealstorm', 'USER', 'nllsover8.0@gmail.com', 'ONaBRWmeoDlRvfbrEUrRUaEnkSgsDKvHLdOyvhqfydrllHFenI');
