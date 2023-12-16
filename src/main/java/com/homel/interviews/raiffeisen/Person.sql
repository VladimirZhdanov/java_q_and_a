-- Дана таблица:
-- Person(name, age)
-- Необходимо вывести не уникальные сочетания name+age

-- 1. Необходимо вывести не уникальные сочетания name+age
SELECT name, age, count(*) FROM Person GROUP BY name, age HAVING COUNT(*) > 1;;
SELECT name, age FROM Person GROUP BY name, age HAVING COUNT(*) > 1;

--DDL:
CREATE TABLE public.person
(
    id      integer not null primary key,
    name    varchar(255),
    age     integer
);

INSERT INTO public.person (id, name, age) VALUES (1, 'Vlad', 12);
INSERT INTO public.person (id, name, age) VALUES (2, 'Vlad', 12);
INSERT INTO public.person (id, name, age) VALUES (3, 'Vlad', 12);
INSERT INTO public.person (id, name, age) VALUES (4, 'Mike', 13);
INSERT INTO public.person (id, name, age) VALUES (8, 'Mike', 13);
INSERT INTO public.person (id, name, age) VALUES (5, 'Bob', 31);
INSERT INTO public.person (id, name, age) VALUES (6, 'Ile', 32);
INSERT INTO public.person (id, name, age) VALUES (7, 'Jorh', 31);
