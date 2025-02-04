# 2025.02.04
SELECT s.name, IFNULL(SUM(r.distance),0) AS travelled_distance
FROM Users s LEFT JOIN Rides r
ON s.id = r.user_id
GROUP BY s.id
ORDER BY travelled_distance DESC, name;
