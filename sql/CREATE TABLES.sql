--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)


SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 2260
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 7 (class 2615 OID 18152)
-- Name: cafeto_challenge_janez; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cafeto_challenge_janez;


ALTER SCHEMA cafeto_challenge_janez OWNER TO postgres;

--
-- TOC entry 1 (class 3079 OID 12469)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 18235)
-- Name: city; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.city (
    id bigint NOT NULL,
    description character varying(255),
    zone_id bigint
);


ALTER TABLE cafeto_challenge_janez.city OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 18240)
-- Name: clinic; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.clinic (
    id bigint NOT NULL,
    administrator character varying(255),
    capacity bigint,
    director character varying(255),
    email character varying(255),
    name character varying(255),
    city_id bigint,
    clinic_type_id bigint
);


ALTER TABLE cafeto_challenge_janez.clinic OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 18248)
-- Name: clinic_type; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.clinic_type (
    id bigint NOT NULL,
    description character varying(255)
);


ALTER TABLE cafeto_challenge_janez.clinic_type OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 18165)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE SEQUENCE cafeto_challenge_janez.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cafeto_challenge_janez.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 18253)
-- Name: nephrologist; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.nephrologist (
    id bigint NOT NULL,
    active boolean,
    email character varying(255),
    name character varying(255),
    nephrologist_type_id bigint
);


ALTER TABLE cafeto_challenge_janez.nephrologist OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 18261)
-- Name: nephrologist_base_clinic; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.nephrologist_base_clinic (
    id bigint NOT NULL,
    dedication_hours double precision,
    salary numeric(19,2),
    clinic_id bigint,
    nephrologist_id bigint
);


ALTER TABLE cafeto_challenge_janez.nephrologist_base_clinic OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 18266)
-- Name: nephrologist_type; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.nephrologist_type (
    id bigint NOT NULL,
    description character varying(255)
);


ALTER TABLE cafeto_challenge_janez.nephrologist_type OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 18271)
-- Name: user; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez."user" (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    login character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE cafeto_challenge_janez."user" OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 18279)
-- Name: zone; Type: TABLE; Schema: cafeto_challenge_janez; Owner: postgres
--

CREATE TABLE cafeto_challenge_janez.zone (
    id bigint NOT NULL,
    description character varying(255)
);


ALTER TABLE cafeto_challenge_janez.zone OWNER TO postgres;

--
-- TOC entry 2113 (class 2606 OID 18239)
-- Name: city city_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);


--
-- TOC entry 2115 (class 2606 OID 18247)
-- Name: clinic clinic_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.clinic
    ADD CONSTRAINT clinic_pkey PRIMARY KEY (id);


--
-- TOC entry 2117 (class 2606 OID 18252)
-- Name: clinic_type clinic_type_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.clinic_type
    ADD CONSTRAINT clinic_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2121 (class 2606 OID 18265)
-- Name: nephrologist_base_clinic nephrologist_base_clinic_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.nephrologist_base_clinic
    ADD CONSTRAINT nephrologist_base_clinic_pkey PRIMARY KEY (id);


--
-- TOC entry 2119 (class 2606 OID 18260)
-- Name: nephrologist nephrologist_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.nephrologist
    ADD CONSTRAINT nephrologist_pkey PRIMARY KEY (id);


--
-- TOC entry 2123 (class 2606 OID 18270)
-- Name: nephrologist_type nephrologist_type_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.nephrologist_type
    ADD CONSTRAINT nephrologist_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2125 (class 2606 OID 18287)
-- Name: user uk_ew1hvam8uwaknuaellwhqchhb; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez."user"
    ADD CONSTRAINT uk_ew1hvam8uwaknuaellwhqchhb UNIQUE (login);


--
-- TOC entry 2127 (class 2606 OID 18285)
-- Name: user uk_ob8kqyqqgmefl0aco34akdtpe; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez."user"
    ADD CONSTRAINT uk_ob8kqyqqgmefl0aco34akdtpe UNIQUE (email);


--
-- TOC entry 2129 (class 2606 OID 18278)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2131 (class 2606 OID 18283)
-- Name: zone zone_pkey; Type: CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.zone
    ADD CONSTRAINT zone_pkey PRIMARY KEY (id);


--
-- TOC entry 2133 (class 2606 OID 18293)
-- Name: clinic fk186cjle6ib5jdp4l4dywg9rvo; Type: FK CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.clinic
    ADD CONSTRAINT fk186cjle6ib5jdp4l4dywg9rvo FOREIGN KEY (city_id) REFERENCES cafeto_challenge_janez.city(id);


--
-- TOC entry 2136 (class 2606 OID 18308)
-- Name: nephrologist_base_clinic fk2vooykjps8ojwkh7aknrqjqky; Type: FK CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.nephrologist_base_clinic
    ADD CONSTRAINT fk2vooykjps8ojwkh7aknrqjqky FOREIGN KEY (clinic_id) REFERENCES cafeto_challenge_janez.clinic(id);


--
-- TOC entry 2134 (class 2606 OID 18298)
-- Name: clinic fk6ecm7vhe8ywy3u1ei9hrqk1ho; Type: FK CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.clinic
    ADD CONSTRAINT fk6ecm7vhe8ywy3u1ei9hrqk1ho FOREIGN KEY (clinic_type_id) REFERENCES cafeto_challenge_janez.clinic_type(id);


--
-- TOC entry 2132 (class 2606 OID 18288)
-- Name: city fkc4l75pj6bqkvthg49bmxsc3mg; Type: FK CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.city
    ADD CONSTRAINT fkc4l75pj6bqkvthg49bmxsc3mg FOREIGN KEY (zone_id) REFERENCES cafeto_challenge_janez.zone(id);


--
-- TOC entry 2135 (class 2606 OID 18303)
-- Name: nephrologist fkfcugktx6hasq928rf9y6bchus; Type: FK CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.nephrologist
    ADD CONSTRAINT fkfcugktx6hasq928rf9y6bchus FOREIGN KEY (nephrologist_type_id) REFERENCES cafeto_challenge_janez.nephrologist_type(id);


--
-- TOC entry 2137 (class 2606 OID 18313)
-- Name: nephrologist_base_clinic fkhy64ek4mhfe5kwxy1n8scoixr; Type: FK CONSTRAINT; Schema: cafeto_challenge_janez; Owner: postgres
--

ALTER TABLE ONLY cafeto_challenge_janez.nephrologist_base_clinic
    ADD CONSTRAINT fkhy64ek4mhfe5kwxy1n8scoixr FOREIGN KEY (nephrologist_id) REFERENCES cafeto_challenge_janez.nephrologist(id);


--
-- PostgreSQL database dump complete
--

