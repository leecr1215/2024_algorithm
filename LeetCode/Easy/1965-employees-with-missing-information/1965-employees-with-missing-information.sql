# 2025.01.17
SELECT * 
FROM (SELECT e.employee_id
    FROM Employees e LEFT JOIN Salaries s
    ON e.employee_id = s.employee_id
    WHERE salary IS NULL

    UNION

    SELECT s.employee_id
    FROM Employees e RIGHT JOIN Salaries s
    ON e.employee_id = s.employee_id
    WHERE name IS NULL) AS result

ORDER BY employee_id;