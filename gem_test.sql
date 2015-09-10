--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

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
-- Name: combos; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE combos (
    id integer NOT NULL,
    gem1_id integer,
    gem2_id integer,
    fusion_id integer
);


ALTER TABLE combos OWNER TO "Guest";

--
-- Name: combos_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE combos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE combos_id_seq OWNER TO "Guest";

--
-- Name: combos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE combos_id_seq OWNED BY combos.id;


--
-- Name: fusions; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE fusions (
    id integer NOT NULL,
    fusion_name character varying,
    description character varying
);


ALTER TABLE fusions OWNER TO "Guest";

--
-- Name: fusions_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE fusions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fusions_id_seq OWNER TO "Guest";

--
-- Name: fusions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE fusions_id_seq OWNED BY fusions.id;


--
-- Name: gems; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE gems (
    id integer NOT NULL,
    gem_name character varying
);


ALTER TABLE gems OWNER TO "Guest";

--
-- Name: gems_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE gems_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gems_id_seq OWNER TO "Guest";

--
-- Name: gems_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE gems_id_seq OWNED BY gems.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY combos ALTER COLUMN id SET DEFAULT nextval('combos_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY fusions ALTER COLUMN id SET DEFAULT nextval('fusions_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY gems ALTER COLUMN id SET DEFAULT nextval('gems_id_seq'::regclass);


--
-- Data for Name: combos; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY combos (id, gem1_id, gem2_id, fusion_id) FROM stdin;
1	1	2	2
2	1	3	5
3	2	3	1
4	2	1	2
5	3	2	1
6	3	4	4
7	3	1	5
8	4	3	4
9	5	6	5
10	6	5	5
\.


--
-- Name: combos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('combos_id_seq', 10, true);


--
-- Data for Name: fusions; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY fusions (id, fusion_name, description) FROM stdin;
1	Opal	Ultra-powerful, stone-cold Betty.
2	Sugilite	Nicki Minaj.
3	Malachite	Maniacal and a little insane.
4	Rainbow Quartz	Sassy 80s dancer and singer.
5	Sardonyx	Careful, elegant, powerful, intelligent, and accurate.
\.


--
-- Name: fusions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('fusions_id_seq', 5, true);


--
-- Data for Name: gems; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY gems (id, gem_name) FROM stdin;
1	Garnet
2	Amethyst
3	Pearl
4	Rose Quartz
5	Jasper
6	Lapis Lazuli
\.


--
-- Name: gems_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('gems_id_seq', 6, true);


--
-- Name: combos_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY combos
    ADD CONSTRAINT combos_pkey PRIMARY KEY (id);


--
-- Name: fusions_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY fusions
    ADD CONSTRAINT fusions_pkey PRIMARY KEY (id);


--
-- Name: gems_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY gems
    ADD CONSTRAINT gems_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

