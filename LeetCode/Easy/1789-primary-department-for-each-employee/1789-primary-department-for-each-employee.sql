# 2025.01.19
SELECT e1.employee_id, IF(COUNT(e1.department_id) = 1, e1.department_id, (SELECT e.department_id FROM Employee e WHERE e.employee_id = e1.employee_id AND e.primary_flag = 'Y')) department_id
FROM Employee e1
GROUP BY e1.employee_id;
