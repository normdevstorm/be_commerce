create table password_reset_token_seq
(
    next_val bigint null
);

INSERT INTO commerce.password_reset_token_seq (next_val) VALUES (1);
