-- 2024.08.31
SELECT COUNT(USER_ID) AS USERS
FROM USER_INFO 
WHERE YEAR(JOINED) = '2021' AND AGE BETWEEN 20 AND 29;