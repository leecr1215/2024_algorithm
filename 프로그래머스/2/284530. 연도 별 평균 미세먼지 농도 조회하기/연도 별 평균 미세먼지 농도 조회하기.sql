-- 2025.03.20
SELECT YEAR(YM) AS YEAR, ROUND(SUM(PM_VAL1) / COUNT(*), 2) AS 'PM10', ROUND(SUM(PM_VAL2) / COUNT(*), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR(YM)
ORDER BY YEAR(YM);