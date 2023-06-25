-- Даны таблицы:
-- Group(id)
-- Student(id, groupId)
-- Mark(id, studentId, value)
-- Найти всех студентов, у которых нет оценок
-- Найти всех студентов, у которых есть хотя бы одна оценка выше средней
-- Найти всех студентов, у которых есть хотя бы одна оценка, выше средней в его группе

-- 1. Найти всех студентов, у которых нет оценок
SELECT * FROM student s
                  LEFT JOIN mark m on s.id = m.studentid
WHERE m.studentid IS NULL;

-- 2. Найти всех студентов, у которых есть хотя бы одна оценка выше средней

SELECT DISTINCT studentId FROM Student s
JOIN Mark m ON s.Id = m.studentId
WHERE m.value > (SELECT avg(m.value) FROM mark m);

-- 3. Найти всех студентов, у которых есть хотя бы одна оценка, выше средней в его группе

WITH avg_marks AS (
    SELECT groupId, AVG(value) AS avg_value
    FROM schema_test.mark
             JOIN schema_test.student ON schema_test.mark.studentId = schema_test.student.id
    GROUP BY groupId
),
     students_above_avg AS (
         SELECT schema_test.mark.studentId, schema_test.mark.value, avg_marks.avg_value
         FROM schema_test.mark
                  JOIN schema_test.student ON schema_test.mark.studentId = schema_test.student.id
                  JOIN avg_marks ON schema_test.student.groupId = avg_marks.groupId
         WHERE schema_test.mark.value > avg_marks.avg_value
     )
SELECT *
FROM schema_test.student
WHERE id IN (SELECT studentId FROM students_above_avg);

--DDL:

CREATE TABLE schema_test.group
(
    id SERIAL PRIMARY KEY
);

CREATE TABLE schema_test.student
(
    id      SERIAL PRIMARY KEY,
    groupId INTEGER REFERENCES schema_test.group (id)
);

CREATE TABLE schema_test.mark
(
    id        SERIAL PRIMARY KEY,
    studentId INTEGER REFERENCES schema_test.student (id),
    value     FLOAT
);

INSERT INTO schema_test.group DEFAULT VALUES;
INSERT INTO schema_test.group DEFAULT VALUES;
INSERT INTO schema_test.group DEFAULT VALUES;
INSERT INTO schema_test.group DEFAULT VALUES;
INSERT INTO schema_test.group DEFAULT VALUES;
INSERT INTO schema_test.group DEFAULT VALUES;

INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (3);
INSERT INTO schema_test.student (groupId) VALUES (3);
INSERT INTO schema_test.student (groupId) VALUES (3);
INSERT INTO schema_test.student (groupId) VALUES (3);
INSERT INTO schema_test.student (groupId) VALUES (3);
INSERT INTO schema_test.student (groupId) VALUES (4);
INSERT INTO schema_test.student (groupId) VALUES (4);
INSERT INTO schema_test.student (groupId) VALUES (4);
INSERT INTO schema_test.student (groupId) VALUES (4);
INSERT INTO schema_test.student (groupId) VALUES (4);
INSERT INTO schema_test.student (groupId) VALUES (5);
INSERT INTO schema_test.student (groupId) VALUES (5);
INSERT INTO schema_test.student (groupId) VALUES (5);
INSERT INTO schema_test.student (groupId) VALUES (5);
INSERT INTO schema_test.student (groupId) VALUES (5);
INSERT INTO schema_test.student (groupId) VALUES (6);
INSERT INTO schema_test.student (groupId) VALUES (6);
INSERT INTO schema_test.student (groupId) VALUES (6);
INSERT INTO schema_test.student (groupId) VALUES (6);
INSERT INTO schema_test.student (groupId) VALUES (6);

INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (1);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (2);
INSERT INTO schema_test.student (groupId) VALUES (3);

INSERT INTO schema_test.mark (studentId, value) VALUES (1, 4.5);
INSERT INTO schema_test.mark (studentId, value) VALUES (1, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (1, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (2, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (2, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (2, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (3, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (3, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (3, 4.3);
INSERT INTO schema_test.mark (studentId, value) VALUES (4, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (4, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (4, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (5, 3.5);
INSERT INTO schema_test.mark (studentId, value) VALUES (5, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (5, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (6, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (6, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (6, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (7, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (7, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (7, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (8, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (8, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (8, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (9, 4.3);
INSERT INTO schema_test.mark (studentId, value) VALUES (9, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (9, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (10, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (10, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (10, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (11, 3.5);
INSERT INTO schema_test.mark (studentId, value) VALUES (11, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (11, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (12, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (12, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (12, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (13, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (13, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (13, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (14, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (14, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (14, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (15, 4.3);
INSERT INTO schema_test.mark (studentId, value) VALUES (15, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (15, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (16, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (16, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (16, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (17, 3.5);
INSERT INTO schema_test.mark (studentId, value) VALUES (17, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (17, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (18, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (18, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (18, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (19, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (19, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (19, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (20, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (20, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (20, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (21, 4.3);
INSERT INTO schema_test.mark (studentId, value) VALUES (21, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (21, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (22, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (22, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (22, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (23, 3.5);
INSERT INTO schema_test.mark (studentId, value) VALUES (23, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (23, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (24, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (24, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (24, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (25, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (25, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (25, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (26, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (26, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (26, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (27, 4.3);
INSERT INTO schema_test.mark (studentId, value) VALUES (27, 3.7);
INSERT INTO schema_test.mark (studentId, value) VALUES (27, 3.9);
INSERT INTO schema_test.mark (studentId, value) VALUES (28, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (28, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (28, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (29, 3.5);
INSERT INTO schema_test.mark (studentId, value) VALUES (29, 4.0);
INSERT INTO schema_test.mark (studentId, value) VALUES (29, 4.2);
INSERT INTO schema_test.mark (studentId, value) VALUES (30, 3.8);
INSERT INTO schema_test.mark (studentId, value) VALUES (30, 4.1);
INSERT INTO schema_test.mark (studentId, value) VALUES (30, 3.7);