create table region
(
    id   bigserial
        constraint region_pk
            primary key,
    name varchar
);

create table writer
(
    id        bigserial
        constraint writer_pk
            primary key,
    firstname varchar,
    lastname  varchar,
    id_region bigint
        constraint writer_region_id_fk
            references region
);

create unique index writer_id_uindex
    on writer (id);

create table post
(
    id        bigserial
        constraint post_pk
            primary key,
    content   varchar,
    created   timestamp,
    updated   timestamp,
    id_writer bigint
        constraint post_writer_id_fk
            references writer
);




