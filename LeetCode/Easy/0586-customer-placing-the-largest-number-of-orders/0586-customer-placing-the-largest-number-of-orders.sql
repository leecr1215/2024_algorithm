SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) desc
LIMIT 1;