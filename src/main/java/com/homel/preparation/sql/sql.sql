-- таблица с шаблонами имен
create table names
(
    id   BIGSERIAL primary key,
    name text
);

create table sex
(
    id  BIGSERIAL primary key,
    value text
);

insert into sex(id, value)
values (1, 'woman'),
       (2, 'unknown'),
       (3, 'man');

insert into names(id, name)
values (1, 'Ann'),
       (2, 'Bill'),
       (3, 'Cindy'),
       (4, 'Diane'),
       (5, 'Emma');

-- генерация 1_000_000 записей в country
CREATE TABLE country AS
WITH tmp AS (SELECT generate_series AS id
             FROM generate_series(1, 300))
SELECT id
FROM tmp;

ALTER TABLE country
    ADD PRIMARY KEY (id);

-- генерация 1_000_000 записей в person_data
CREATE TABLE person_data AS
WITH tmp AS (
    SELECT generate_series AS id,
           floor(random() * 300 + 1)::int AS country_id,
           (CAST(ABS(RANDOM()) AS integer) % 5) + 1 AS name_id,
           (CAST(ABS(RANDOM()) AS integer) % 80) + 1 AS age,
           (CAST(ABS(RANDOM()) AS integer) % 3) + 1 AS sex_id,
           (NOW() + (random() * (interval '1000 days')) + '30 days') as created_at
    FROM generate_series(1, 1000000)
)
SELECT id,
       (SELECT id FROM country WHERE id = country_id) AS country_id,
       (SELECT name FROM names WHERE id = name_id) AS name,
       (SELECT value FROM sex WHERE id = sex_id) AS sex,
       age,
       created_at
FROM tmp;

ALTER TABLE person_data
    ADD PRIMARY KEY (id);

alter table person_data
    add constraint fk_person_data_country
        foreign key (country_id)
            REFERENCES country (id);


------ Testing -------

-- 1.
-- count
explain analyse select count(*) from person_data;
-- better way to count
explain analyse SELECT reltuples::bigint as estimate
FROM pg_class
WHERE oid = 'person_data'::regclass;

-- 2.
-- Полезные запросы из статистики
select *
from pg_stats
where tablename = 'person_data' and attname = 'country_id';
-- Проверка индексов на таблице
select *
from pg_indexes
where tablename like 'person_data';
-- Размер таблиц
SELECT pg_size_pretty( pg_total_relation_size('person_data') );
SELECT pg_size_pretty( pg_total_relation_size('person_data_pkey') );

-- 3.
-- Added column with DEFAULT value
\timing
ALTER TABLE person_data ADD column new_column text DEFAULT 'some text';
ALTER TABLE person_data DROP COLUMN new_column;

-- 4.
-- Index for FK
explain analyse DELETE FROM person_data WHERE country_id = 5;

explain analyse SELECT * FROM person_data
                WHERE country_id = 7;

CREATE INDEX person_data_fk_country
    ON person_data(country_id);

DROP INDEX person_data_fk_country;

