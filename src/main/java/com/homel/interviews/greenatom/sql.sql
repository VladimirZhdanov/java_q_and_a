DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE employee (id uuid PRIMARY KEY, department_id uuid, salary money);
CREATE TABLE department (id uuid PRIMARY KEY, name VARCHAR(50));

INSERT INTO "department" ("id", "name")
VALUES ('018c6439-e9b0-7754-b0eb-72ee1f5d30ba', 'Department of losers'),
       ('018c643a-271e-795e-a8d1-71a2bd9a0aa2', 'Department of winners'),
       ('018c643b-6ec8-7037-829a-3b62073a846a', 'Department of average performers'),
       ('018c6441-6655-7be5-b525-20f1ac983a04', 'Department of better than average performers');
INSERT INTO "employee" ("id", "department_id", "salary")
VALUES ('018c643a-6d6f-7e68-a898-06f9bbee82fa', '018c6439-e9b0-7754-b0eb-72ee1f5d30ba', 50),
       ('018c643a-8970-7284-8ca3-cf8998ceef83', '018c6439-e9b0-7754-b0eb-72ee1f5d30ba', 100),
       ('018c643a-a037-7940-87f6-1cbf57a52d67', '018c643a-271e-795e-a8d1-71a2bd9a0aa2', 1400),
       ('018c643a-bcab-7965-b826-de1fc07fa484', '018c643a-271e-795e-a8d1-71a2bd9a0aa2', 1600),
       ('018c643c-d2ea-7ab9-bf71-433345ed31f4', '018c643b-6ec8-7037-829a-3b62073a846a', 450),
       ('018c643c-ef04-7fe9-a538-7e3fcebc64d1', '018c643b-6ec8-7037-829a-3b62073a846a', 500),
       ('018c643d-0e19-73bd-b0cb-9707f50e2b57', '018c643b-6ec8-7037-829a-3b62073a846a', 550),
       ('018c6442-67ae-720b-a59a-8f98f78f980d', '018c6441-6655-7be5-b525-20f1ac983a04', 650),
       ('018c6442-8480-7af6-ab0f-c00fcd64a8b9', '018c6441-6655-7be5-b525-20f1ac983a04', 720),
       ('018c6442-a2d4-7ee1-a2fa-b76267d07c10', '018c6441-6655-7be5-b525-20f1ac983a04', 670);

-- Найти ТОП-3 отдела по убыванию уровня средней заработной платы, где среднее по отделу больше общего среднего.

SELECT department.name, AVG(employee.salary) AS avg_salary
FROM employee
         JOIN department ON employee.department_id = department.id
GROUP BY department.id, department.name
HAVING AVG(employee.salary) > (SELECT AVG(salary) FROM employee)
ORDER BY avg_salary DESC
LIMIT 3;