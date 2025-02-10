# 2025.02.10
SELECT user_id, email
FROM Users
WHERE email REGEXP '^[a-zA-Z0-9_]+@[a-zA-z0-9]+.com$'
ORDER BY user_id;