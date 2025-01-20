# 2025.01.20
SELECT machine_id, ROUND(SUM(IF(activity_type = 'start', -timestamp, timestamp)) / COUNT(DISTINCT process_id), 3) AS processing_time
FROM Activity
GROUP BY machine_id;