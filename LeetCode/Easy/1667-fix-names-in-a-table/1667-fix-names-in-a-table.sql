# 2025.01.30
SELECT user_id, CONCAT(UPPER(SUBSTR(name,1,1)), LOWER(SUBSTR(name,2,LENGTH(name)-1))) name
FROM Users
ORDER BY user_id;
