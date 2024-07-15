-- table team
-- long id not null
-- string name not null

-- select турнирная таблица (название комманды - название комманды), играет каждая с каждой другой только 1ин раз,

--   1  2  3
-- 1 11 12 13
-- 2 21 22 23
-- 3 31 32 33
--
--  ответ: 12 13 23

create table team
(
    id  BIGSERIAL primary key
);

insert into team(id)
values (1),
       (2),
       (3);


SELECT t1.id, t2.id FROM team t1 cross join team t2
WHERE t1.id < t2.id;