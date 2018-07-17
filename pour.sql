--
-- PostgreSQL database dump
--

-- Dumped from database version 10.2
-- Dumped by pg_dump version 10.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: bars; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE bars (
    id integer NOT NULL,
    name character varying,
    address character varying,
    phone character varying,
    deal character varying,
    happyhour character varying
);


ALTER TABLE bars OWNER TO "Guest";

--
-- Name: bars_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE bars_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bars_id_seq OWNER TO "Guest";

--
-- Name: bars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE bars_id_seq OWNED BY bars.id;


--
-- Name: bars id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY bars ALTER COLUMN id SET DEFAULT nextval('bars_id_seq'::regclass);


--
-- Data for Name: bars; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY bars (id, name, address, phone, deal, happyhour) FROM stdin;
\.


--
-- Name: bars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('bars_id_seq', 1, false);


--
-- Name: bars bars_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY bars
    ADD CONSTRAINT bars_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

