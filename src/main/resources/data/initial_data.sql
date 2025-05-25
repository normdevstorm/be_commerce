--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: brand; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.brand (brand_id, name, about) VALUES ('00aafd67-b67a-453b-a9c7-d19f04b7d964', 'ComputeTech', 'Innovative computing solutions');
INSERT INTO public.brand (brand_id, name, about) VALUES ('149a52f8-3d64-422d-97ad-8e65da796640', 'PhotoPro', 'Professional photography equipment');
INSERT INTO public.brand (brand_id, name, about) VALUES ('2807b8b1-e057-46d4-b371-87ae81cd18db', 'WearTech', 'Smart wearable devices');
INSERT INTO public.brand (brand_id, name, about) VALUES ('53f6e6e2-88a5-438a-aee0-8f4c688c5d7b', 'SoundPro', 'Premium audio equipment');
INSERT INTO public.brand (brand_id, name, about) VALUES ('62e143c4-e84c-42dd-a27c-d6034c5b76b2', 'ComputeTech', 'Innovative computing solutions');
INSERT INTO public.brand (brand_id, name, about) VALUES ('bcf6bf4b-745d-4088-85dc-3131c26147f1', 'TabWorld', 'Innovative tablet solutions');
INSERT INTO public.brand (brand_id, name, about) VALUES ('c9aef9c8-54cf-4459-b445-a40b080d7f34', 'TechBrand', 'Leading smartphone manufacturer');
INSERT INTO public.brand (brand_id, name, about) VALUES ('ef256767-5381-4dd5-a92a-76ddf2a68659', 'ComputeTech', 'Innovative computing solutions');


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '046adf6d-35e9-429f-85a6-cba76e6ba53d', 'Lightweight tablet with a stunning display', 'Elevated Test');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '1b506903-f5d2-491b-a5ba-57a1ea06b6d1', 'Lightweight tablet with a stunning display', 'Elevated Test 4');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 200, 180, 4, '2025-05-18 21:55:59.214+07', 100, '53f6e6e2-88a5-438a-aee0-8f4c688c5d7b', '1d965eba-45ca-4436-96e9-d8e507b03973', 'Noise-cancelling over-ear headphones', 'Headphones');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 200, 180, 4, '2025-05-18 21:55:59.214+07', 100, '53f6e6e2-88a5-438a-aee0-8f4c688c5d7b', '3879e1e5-2b09-4b6c-84a4-82aa828b5ee4', 'Noise-cancelling over-ear headphones', 'Airpod Pro');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 300, 250, 3, '2025-05-18 21:55:59.214+07', 70, '2807b8b1-e057-46d4-b371-87ae81cd18db', '39320f12-f86c-4206-9f35-dad6b6e947b0', 'Feature-packed smartwatch with health tracking', 'Smartwatch');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 1000, 900, 4, '2025-05-18 21:55:59.214+07', 50, 'c9aef9c8-54cf-4459-b445-a40b080d7f34', '3bd7e7c9-83d7-4264-b981-39be6407e1f7', 'Latest model smartphone with advanced features', 'Smartphone');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '3ddc27be-1bfb-43dc-8131-b59282eceb05', 'Lightweight tablet with a stunning display', 'Elevated Chair');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 1200, 1100, 4, '2025-05-18 21:55:59.214+07', 20, '149a52f8-3d64-422d-97ad-8e65da796640', '490f2f58-4fff-4cb4-88a5-0cf6bf70bd20', 'High-resolution DSLR camera', 'Camera');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '4f177d74-b417-44f8-9e21-228ca41dd25d', 'Lightweight tablet with a stunning display', 'Elevated Test 3');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '5378a9e8-0907-4c70-b707-848aadc693a8', 'Lightweight tablet with a stunning display', 'Elevated Test 2');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '8421b48e-633e-4ce6-9e48-c8caea36d9fa', 'Lightweight tablet with a stunning display', 'Laptop desk');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '94e8946a-4ff8-4df3-9e48-9171c0f3d319', 'Lightweight tablet with a stunning display', 'Tablet');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', '9c5a5033-9e0a-406a-83e1-d4507c878ee8', 'Lightweight tablet with a stunning display', 'Elevated Stand');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'a0058035-7885-4efa-83d8-5fd5119bddd9', 'Lightweight tablet with a stunning display', 'PC arms');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 1500, 1400, 3, '2025-05-18 21:55:59.214+07', 30, '00aafd67-b67a-453b-a9c7-d19f04b7d964', 'a4a96759-2c27-43c5-8f1c-bc5d40d7ac6f', 'High-performance laptop for professionals', 'Laptop');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'bd76e75d-6f43-4430-958b-d0e6faa1a286', 'Lightweight tablet with a stunning display', 'Elevated Test 5');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'c9cb0074-b3bd-40d5-b530-5cefd1d2cac2', 'Lightweight tablet with a stunning display', 'Elevated Chair');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 2, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'd4962b93-284d-4c0d-8e49-42360eb3971d', 'Lightweight tablet with a stunning', 'Elevated Test 5');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 200, 180, 4, '2025-05-18 21:55:59.214+07', 100, '53f6e6e2-88a5-438a-aee0-8f4c688c5d7b', 'dd3c99e9-2c04-411f-82ca-eee960ff2fda', 'Noise-cancelling over-ear headphones', 'Airpod Max');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'f2ba4a53-4367-4ce3-803d-68fae7dccd1d', 'Lightweight tablet with a stunning display', 'Elevated Test 5');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'fac78be3-e4f7-4487-aa15-be4c6ecaebe1', 'Lightweight tablet with a stunning display', 'Elevated Test 5');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'fd5632ca-1165-4a92-b641-0594f570d863', 'Lightweight tablet with a stunning display', 'Elevated Test 5');
INSERT INTO public.product (category, original_price, sale_price, star_rate, created_at, stock_quantity, brand_brand_id, product_id, desciption, name) VALUES (0, 600, 550, 4, '2025-05-18 21:55:59.214+07', 40, 'bcf6bf4b-745d-4088-85dc-3131c26147f1', 'fffb1dd2-26ad-4fed-9d05-0f7c77b958a3', 'Lightweight tablet with a stunning display', 'Elevated Test 5');


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (user_id, first_name, last_name, email, password, phone_number, reset_password_token, username, role) VALUES ('fa5b2674-54c0-4912-ba64-0e7ba93470b1', 'Ereren', 'Bieber', NULL, '$2a$10$GJXw4swoAi1iVo7NmjoiXOhI0jfb2.fD0CcviacrUJPZd0n1BFkNK', '+84-39-295-5340', NULL, 'emilydavis', 'ADMIN');


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: key_tokens; Type: TABLE DATA; Schema: public; Owner: postgres
--


INSERT INTO public.key_tokens (access_token_version, refresh_token_version, id, user_user_id, refresh_token, private_key, public_key) VALUES (42, 42, 'fa5b2674-54c0-4912-ba64-0e7ba93470b1', 'fa5b2674-54c0-4912-ba64-0e7ba93470b1', 'eyJhbGciOiJSUzI1NiJ9.eyJpZCI6ImZhNWIyNjc0LTU0YzAtNDkxMi1iYTY0LTBlN2JhOTM0NzBiMSIsInJvbGUiOiJBRE1JTiIsInZlcnNpb24iOjQyLCJ1c2VybmFtZSI6ImVtaWx5ZGF2aXMiLCJzdWIiOiJlbWlseWRhdmlzIiwiaWF0IjoxNzQ3OTI4ODI5LCJleHAiOjE3NDc5Mzg5MDl9.m4X6tzmc72rKJ2aLo1Pfv2kiJmZtuWuy-7dTe0wcKwSTzJBEyQrmISNp-7ca8fEU3QTp0g_Lk8fRM6QZfQJBuHKnlACmydxMxnQk3l9Ztv8yZCbV2rvN5l0BcN1l6IJHTq4CssoINCQ9HlzYyn3QPTw2OUTeucilC7w-EZWl5cfkCNfe7DXU-LzFDnWuCecHr12xBdCN2BGx67YLQ-KrIQIg0edWPFdZVDGZ39zL1nxx8OZUUqnLh8EPXG3WD1uS_6HAsqC0KKItlgkfLUGk-NDeNaCN-74CZCthVYrc4P17zfoSfYtIJDUT51leVajlL1MhPcyoxHIhCgLt-KLbKiuZaR9iR4WtxeEJgyAX8uD-f11AbWp5DjlGJqiW4hYYLU-5mURZG6bKDfwXegclBpS1frCT6ZC6UJnIRILe1aPdABcYIKod6LljJaMT1j9_-RQT2eiB3If9VRgbCp7IjILWxXHMihMT3bY6CyhsJo_ufUySQa2gl5avZr6s5S1z', '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');

--
-- Data for Name: password_reset_token; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: password_reset_token_seq; Type: TABLE DATA; Schema: public; Owner: postgres
--

SELECT setval('public.password_reset_token_seq', 1, false);

--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: product_other_attributes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('1d965eba-45ca-4436-96e9-d8e507b03973', '30 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('1d965eba-45ca-4436-96e9-d8e507b03973', 'White', 'color');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('1d965eba-45ca-4436-96e9-d8e507b03973', 'Bluetooth', 'connectivity');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3879e1e5-2b09-4b6c-84a4-82aa828b5ee4', '30 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3879e1e5-2b09-4b6c-84a4-82aa828b5ee4', 'White', 'color');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3879e1e5-2b09-4b6c-84a4-82aa828b5ee4', 'Bluetooth', 'connectivity');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('39320f12-f86c-4206-9f35-dad6b6e947b0', '48 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('39320f12-f86c-4206-9f35-dad6b6e947b0', 'Silver', 'color');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('39320f12-f86c-4206-9f35-dad6b6e947b0', '50m', 'waterResistance');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3bd7e7c9-83d7-4264-b981-39be6407e1f7', '24 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3bd7e7c9-83d7-4264-b981-39be6407e1f7', 'Black', 'color');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3bd7e7c9-83d7-4264-b981-39be6407e1f7', '1 year', 'warranty');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3ddc27be-1bfb-43dc-8131-b59282eceb05', '12 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3ddc27be-1bfb-43dc-8131-b59282eceb05', '10 inches', 'screenSize');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('3ddc27be-1bfb-43dc-8131-b59282eceb05', '128GB', 'storage');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('490f2f58-4fff-4cb4-88a5-0cf6bf70bd20', '500 shots', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('490f2f58-4fff-4cb4-88a5-0cf6bf70bd20', '18-55mm', 'lens');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('490f2f58-4fff-4cb4-88a5-0cf6bf70bd20', '24MP', 'resolution');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('8421b48e-633e-4ce6-9e48-c8caea36d9fa', '12 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('8421b48e-633e-4ce6-9e48-c8caea36d9fa', '10 inches', 'screenSize');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('8421b48e-633e-4ce6-9e48-c8caea36d9fa', '128GB', 'storage');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('94e8946a-4ff8-4df3-9e48-9171c0f3d319', '12 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('94e8946a-4ff8-4df3-9e48-9171c0f3d319', '10 inches', 'screenSize');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('94e8946a-4ff8-4df3-9e48-9171c0f3d319', '128GB', 'storage');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('a0058035-7885-4efa-83d8-5fd5119bddd9', '12 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('a0058035-7885-4efa-83d8-5fd5119bddd9', '10 inches', 'screenSize');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('a0058035-7885-4efa-83d8-5fd5119bddd9', '128GB', 'storage');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('a4a96759-2c27-43c5-8f1c-bc5d40d7ac6f', 'Intel i7', 'processor');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('a4a96759-2c27-43c5-8f1c-bc5d40d7ac6f', '16GB', 'ram');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('a4a96759-2c27-43c5-8f1c-bc5d40d7ac6f', '512GB SSD', 'storage');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('c9cb0074-b3bd-40d5-b530-5cefd1d2cac2', '12 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('c9cb0074-b3bd-40d5-b530-5cefd1d2cac2', '10 inches', 'screenSize');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('c9cb0074-b3bd-40d5-b530-5cefd1d2cac2', '128GB', 'storage');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('dd3c99e9-2c04-411f-82ca-eee960ff2fda', '30 hours', 'batteryLife');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('dd3c99e9-2c04-411f-82ca-eee960ff2fda', 'White', 'color');
INSERT INTO public.product_other_attributes (product_product_id, other_attributes, other_attributes_key) VALUES ('dd3c99e9-2c04-411f-82ca-eee960ff2fda', 'Bluetooth', 'connectivity');


--
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.review (created_at, review_id, user_user_id, feedback) VALUES ('2025-05-18 21:55:59.214+07', '0f0a37e6-ee31-4c0d-8c1a-95af6f6226da', NULL, 'Excellent product!');
INSERT INTO public.review (created_at, review_id, user_user_id, feedback) VALUES ('2025-05-18 21:55:59.214+07', '19345464-7086-4bdb-ba5e-51a14eb54ffa', NULL, 'Very useful for fitness tracking.');
INSERT INTO public.review (created_at, review_id, user_user_id, feedback) VALUES ('2025-05-18 21:55:59.214+07', '2ecb75a0-3130-4699-9191-0942ef66130b', NULL, 'Amazing sound quality!');
INSERT INTO public.review (created_at, review_id, user_user_id, feedback) VALUES ('2025-05-18 21:55:59.214+07', '6b5c3727-331f-442d-9c08-a76b185c085c', NULL, 'Great for work and gaming!');
INSERT INTO public.review (created_at, review_id, user_user_id, feedback) VALUES ('2025-05-18 21:55:59.214+07', '8c422153-785c-4dd3-ace8-05a6dbc2032a', NULL, 'Excellent for photography enthusiasts.');
INSERT INTO public.review (created_at, review_id, user_user_id, feedback) VALUES ('2025-05-18 21:55:59.214+07', 'ab848871-f720-4e89-b438-13ff9734c972', NULL, 'Perfect for reading and browsing.');


--
-- Data for Name: product_reviews; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product_reviews (product_product_id, reviews_review_id) VALUES ('3bd7e7c9-83d7-4264-b981-39be6407e1f7', '0f0a37e6-ee31-4c0d-8c1a-95af6f6226da');
INSERT INTO public.product_reviews (product_product_id, reviews_review_id) VALUES ('39320f12-f86c-4206-9f35-dad6b6e947b0', '19345464-7086-4bdb-ba5e-51a14eb54ffa');
INSERT INTO public.product_reviews (product_product_id, reviews_review_id) VALUES ('1d965eba-45ca-4436-96e9-d8e507b03973', '2ecb75a0-3130-4699-9191-0942ef66130b');
INSERT INTO public.product_reviews (product_product_id, reviews_review_id) VALUES ('a4a96759-2c27-43c5-8f1c-bc5d40d7ac6f', '6b5c3727-331f-442d-9c08-a76b185c085c');
INSERT INTO public.product_reviews (product_product_id, reviews_review_id) VALUES ('490f2f58-4fff-4cb4-88a5-0cf6bf70bd20', '8c422153-785c-4dd3-ace8-05a6dbc2032a');
INSERT INTO public.product_reviews (product_product_id, reviews_review_id) VALUES ('94e8946a-4ff8-4df3-9e48-9171c0f3d319', 'ab848871-f720-4e89-b438-13ff9734c972');


--
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: user_address; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- PostgreSQL database dump complete
--