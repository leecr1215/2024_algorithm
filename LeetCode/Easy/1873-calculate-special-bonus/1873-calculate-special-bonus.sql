# 2025.02.07
SELECT employee_id, IF(employee_id % 2 != 0 AND name NOT LIKE 'M%' , salary, 0) bonus
FROM Employees
ORDER BY employee_id;
