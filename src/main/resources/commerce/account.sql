create table account
(
    account_id binary(16)             not null
        primary key,
    password   varchar(255)           not null,
    username   varchar(255)           not null,
    role       enum ('ADMIN', 'USER') null
);

INSERT INTO commerce.account (account_id, password, username, role) VALUES (0x905905CF4CBA11EFA28E98E743588A2D, 'password1', 'user1', 'USER');
INSERT INTO commerce.account (account_id, password, username, role) VALUES (0x9059107E4CBA11EFA28E98E743588A2D, 'password2', 'admin', 'ADMIN');
INSERT INTO commerce.account (account_id, password, username, role) VALUES (0x90591D684CBA11EFA28E98E743588A2D, 'password3', 'user2', 'USER');
INSERT INTO commerce.account (account_id, password, username, role) VALUES (0x90591F574CBA11EFA28E98E743588A2D, 'password4', 'admin2', 'ADMIN');
