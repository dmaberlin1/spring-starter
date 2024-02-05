--liquibase formatted sql

--changeset dmaberlin:1
create table if not exists revision
(
    id        serial primary key,
    timestamp bigint not null
);

--changeset dmaberlin:2
create table if not exists users_aud
(
    id bigint,
    rev int references revision(id),
    revtype smallint,
    username varchar(64) not null unique ,
    birth_date date,
    firstname varchar(64),
    lastname varchar(64),
    role varchar(32),
    company_id int
)
