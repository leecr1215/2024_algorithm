# 2025.02.15
SELECT user_id, name, mail
FROM Users
WHERE mail REGEXP '^[a-zA-Z]+[a-zA-Z0-9-._]*@leetcode[.]com$';