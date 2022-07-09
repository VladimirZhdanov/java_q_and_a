Даны таблицы:
Group(id)
Student(id, groupId)
Mark(id, studentId, value)
Найти всех студентов, у которых нет оценок
Найти всех студентов, у которых есть хотя бы одна оценка выше средней
Найти всех студентов, у которых есть хотя бы одна оценка, выше средней в его группе

SELECT studentId, m.id FROM Student s
LEFT JOIN Mark m ON s.Id = m.studentId
WHERE m.id is null

SELECT DISTINCT studentId FROM Student s
JOIN Mark m ON s.Id = m.studentId
WHERE m.value > (SELECT avg(m.value) FROM mark m)

SELECT studentId, groupId, avg(m.value) mv FROM Student s
JOIN Mark m ON s.Id = m.studentId
GROUP BY groupId HAVING m.value > mv
WHERE m.value > (SELECT avg(m.value) FROM mark m)