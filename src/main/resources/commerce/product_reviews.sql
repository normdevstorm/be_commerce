create table product_reviews
(
    product_product_id binary(16) not null,
    reviews_review_id  binary(16) not null,
    primary key (product_product_id, reviews_review_id),
    constraint UK71kr315nedgkucd6345i14co7
        unique (reviews_review_id),
    constraint FKetagsetrtlvu3ao69v7asg2ph
        foreign key (product_product_id) references product (product_id),
    constraint FKt8iliw8splv96li2ut0wd6n0j
        foreign key (reviews_review_id) references review (review_id)
);

INSERT INTO commerce.product_reviews (product_product_id, reviews_review_id) VALUES (0x06CD40544CBE11EFA28E98E743588A2D, 0x4C4936484CC111EFA28E98E743588A2D);
INSERT INTO commerce.product_reviews (product_product_id, reviews_review_id) VALUES (0x06CD62914CBE11EFA28E98E743588A2D, 0x4C493FCC4CC111EFA28E98E743588A2D);
INSERT INTO commerce.product_reviews (product_product_id, reviews_review_id) VALUES (0xA747336EEDE543AEABEAD7E3B619B1C9, 0xAAA2A5CE27114E75A14B6EDF3731EAB8);
