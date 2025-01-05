# 2025.01.05
SELECT event_day AS day, emp_id, SUM(out_time - in_time) total_time
FROM Employees
GROUP BY event_day, emp_id