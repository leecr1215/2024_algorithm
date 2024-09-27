SELECT w.id
FROM Weather w
WHERE w.temperature > (SELECT temperature
                       FROM Weather
                       WHERE recordDate = DATE_SUB(w.recordDate, INTERVAL 1 DAY));
