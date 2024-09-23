# Write your MySQL query statement below
# 2024.09.23
SELECT p.firstName, p.lastName, a.city, a.state
FROM Address a RIGHT JOIN Person p
ON a.personId = p.personId;