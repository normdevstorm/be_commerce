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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    account_id uuid NOT NULL,
    password character varying(255),
    role character varying(255),
    username character varying(255) NOT NULL,
    CONSTRAINT account_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying])::text[])))
);


ALTER TABLE public.account OWNER TO postgres;

--
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    address_id uuid NOT NULL,
    country_code smallint,
    postal_code character varying(255),
    CONSTRAINT address_country_code_check CHECK (((country_code >= 0) AND (country_code <= 222)))
);


ALTER TABLE public.address OWNER TO postgres;

--
-- Name: brand; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.brand (
    brand_id uuid NOT NULL,
    about character varying(25000),
    name character varying(255)
);


ALTER TABLE public.brand OWNER TO postgres;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart (
    quantity bigint NOT NULL,
    user_user_id uuid NOT NULL,
    product_product_id uuid NOT NULL
);


ALTER TABLE public.cart OWNER TO postgres;

--
-- Name: key_tokens; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_tokens (
    id uuid NOT NULL,
    access_token_version integer NOT NULL,
    private_key character varying(4096) NOT NULL,
    public_key character varying(4096) NOT NULL,
    refresh_token character varying(2048) NOT NULL,
    refresh_token_version integer NOT NULL,
    user_user_id uuid
);


ALTER TABLE public.key_tokens OWNER TO postgres;

--
-- Name: password_reset_token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.password_reset_token (
    id bigint NOT NULL,
    expiry_date timestamp(6) without time zone,
    token character varying(255),
    user_id uuid NOT NULL
);


ALTER TABLE public.password_reset_token OWNER TO postgres;

--
-- Name: password_reset_token_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.password_reset_token_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.password_reset_token_seq OWNER TO postgres;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    payment_id uuid NOT NULL,
    card_num character varying(255),
    cvv character varying(4),
    exp_date timestamp(6) without time zone,
    user_user_id uuid
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    product_id uuid NOT NULL,
    category smallint,
    created_at timestamp(6) without time zone,
    desciption character varying(255),
    name character varying(255),
    original_price double precision NOT NULL,
    sale_price double precision NOT NULL,
    star_rate smallint,
    stock_quantity bigint NOT NULL,
    brand_brand_id uuid,
    CONSTRAINT product_category_check CHECK (((category >= 0) AND (category <= 19))),
    CONSTRAINT product_star_rate_check CHECK (((star_rate >= 0) AND (star_rate <= 4)))
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_other_attributes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_other_attributes (
    product_product_id uuid NOT NULL,
    other_attributes character varying(255),
    other_attributes_key character varying(255) NOT NULL
);


ALTER TABLE public.product_other_attributes OWNER TO postgres;

--
-- Name: product_reviews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_reviews (
    product_product_id uuid NOT NULL,
    reviews_review_id uuid NOT NULL
);


ALTER TABLE public.product_reviews OWNER TO postgres;

--
-- Name: review; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.review (
    review_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    feedback character varying(200),
    user_user_id uuid
);


ALTER TABLE public.review OWNER TO postgres;

--
-- Name: transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    transaction_id uuid NOT NULL,
    create_at timestamp(6) without time zone,
    description character varying(255),
    status character varying(255),
    total double precision NOT NULL,
    user_user_id uuid,
    CONSTRAINT transaction_status_check CHECK (((status)::text = ANY ((ARRAY['PENDING'::character varying, 'DONE'::character varying, 'ERROR'::character varying, 'CANCELLED'::character varying, 'IN_PROGRESS'::character varying])::text[])))
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- Name: user_address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_address (
    user_id uuid NOT NULL,
    address_id uuid NOT NULL
);


ALTER TABLE public.user_address OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id uuid NOT NULL,
    email character varying(255),
    first_name character varying(50),
    last_name character varying(50),
    password character varying(255) NOT NULL,
    phone_number character varying(255),
    reset_password_token character varying(255),
    role character varying(255),
    username character varying(255) NOT NULL,
    CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying])::text[])))
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (address_id);


--
-- Name: brand brand_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_pkey PRIMARY KEY (brand_id);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (product_product_id, user_user_id);





--
-- Name: key_tokens key_tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_tokens
    ADD CONSTRAINT key_tokens_pkey PRIMARY KEY (id);


--
-- Name: password_reset_token password_reset_token_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.password_reset_token
    ADD CONSTRAINT password_reset_token_pkey PRIMARY KEY (id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (payment_id);


--
-- Name: product_other_attributes product_other_attributes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_other_attributes
    ADD CONSTRAINT product_other_attributes_pkey PRIMARY KEY (product_product_id, other_attributes_key);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


--
-- Name: product_reviews product_reviews_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews
    ADD CONSTRAINT product_reviews_pkey PRIMARY KEY (product_product_id, reviews_review_id);


--
-- Name: review review_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT review_pkey PRIMARY KEY (review_id);


--
-- Name: transaction transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (transaction_id);


--
-- Name: product_reviews uk71kr315nedgkucd6345i14co7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews
    ADD CONSTRAINT uk71kr315nedgkucd6345i14co7 UNIQUE (reviews_review_id);


--
-- Name: password_reset_token ukf90ivichjaokvmovxpnlm5nin; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.password_reset_token
    ADD CONSTRAINT ukf90ivichjaokvmovxpnlm5nin UNIQUE (user_id);


--
-- Name: key_tokens ukhurgnsih78jxavdb06qgyn5d6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_tokens
    ADD CONSTRAINT ukhurgnsih78jxavdb06qgyn5d6 UNIQUE (user_user_id);


--
-- Name: users ukr43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- Name: user_address user_address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT user_address_pkey PRIMARY KEY (user_id, address_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: password_reset_token fk83nsrttkwkb6ym0anu051mtxn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.password_reset_token
    ADD CONSTRAINT fk83nsrttkwkb6ym0anu051mtxn FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- Name: product fkboqft24mwam9ifa6xlj12cjpc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkboqft24mwam9ifa6xlj12cjpc FOREIGN KEY (brand_brand_id) REFERENCES public.brand(brand_id);


--
-- Name: cart fkbut5u81fns8galxagpxo98om4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fkbut5u81fns8galxagpxo98om4 FOREIGN KEY (user_user_id) REFERENCES public.users(user_id);


--
-- Name: user_address fkdaaxogn1ss81gkcsdn05wi6jp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT fkdaaxogn1ss81gkcsdn05wi6jp FOREIGN KEY (address_id) REFERENCES public.address(address_id);


--
-- Name: payment fkejlextqmaiyuu6d0u2hgxpgy4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT fkejlextqmaiyuu6d0u2hgxpgy4 FOREIGN KEY (user_user_id) REFERENCES public.users(user_id);


--
-- Name: product_reviews fketagsetrtlvu3ao69v7asg2ph; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews
    ADD CONSTRAINT fketagsetrtlvu3ao69v7asg2ph FOREIGN KEY (product_product_id) REFERENCES public.product(product_id);


--
-- Name: key_tokens fkf750bnvstjveuxbxblckixjp6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_tokens
    ADD CONSTRAINT fkf750bnvstjveuxbxblckixjp6 FOREIGN KEY (user_user_id) REFERENCES public.users(user_id);


--
-- Name: transaction fkfahi57rejrndocy80o51sof0v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fkfahi57rejrndocy80o51sof0v FOREIGN KEY (user_user_id) REFERENCES public.users(user_id);


--
-- Name: cart fkgt543ui1msc4owrx9x7d9eiyw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fkgt543ui1msc4owrx9x7d9eiyw FOREIGN KEY (product_product_id) REFERENCES public.product(product_id);


--
-- Name: review fkq6prfoeqnogpi44xmtbgyuj8p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT fkq6prfoeqnogpi44xmtbgyuj8p FOREIGN KEY (user_user_id) REFERENCES public.users(user_id);


--
-- Name: product_other_attributes fkr0b4eifk9nlt87oawpe4itkc0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_other_attributes
    ADD CONSTRAINT fkr0b4eifk9nlt87oawpe4itkc0 FOREIGN KEY (product_product_id) REFERENCES public.product(product_id);


--
-- Name: user_address fkrmincuqpi8m660j1c57xj7twr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT fkrmincuqpi8m660j1c57xj7twr FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- Name: product_reviews fkt8iliw8splv96li2ut0wd6n0j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews
    ADD CONSTRAINT fkt8iliw8splv96li2ut0wd6n0j FOREIGN KEY (reviews_review_id) REFERENCES public.review(review_id);


--
-- PostgreSQL database dump complete
--

