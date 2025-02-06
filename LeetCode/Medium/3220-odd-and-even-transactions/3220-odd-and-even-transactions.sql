# 2025.02.06
SELECT transaction_date, SUM(IF(amount % 2 != 0, amount, 0)) odd_sum, SUM(IF(amount % 2 = 0, amount, 0)) even_sum
FROM transactions
GROUP BY transaction_date
ORDER BY transaction_date;
