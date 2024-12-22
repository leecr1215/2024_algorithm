# 2024.12.22
SELECT a.sell_date, COUNT(DISTINCT a.product) AS 'num_sold', 
    (SELECT GROUP_CONCAT(DISTINCT product SEPARATOR  ',')
    FROM Activities
     WHERE sell_date = a.sell_date
    ) AS 'products'
FROM Activities a
GROUP BY a.sell_date
ORDER BY a.sell_date;
