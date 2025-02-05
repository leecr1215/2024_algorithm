# 2025.02.05
SELECT s.user_id, ROUND(IFNULL(AVG(action='confirmed'), 0),2)  AS confirmation_rate
FROM SignUps s LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;
