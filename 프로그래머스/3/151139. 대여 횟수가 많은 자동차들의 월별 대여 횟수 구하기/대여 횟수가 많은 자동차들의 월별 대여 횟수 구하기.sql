-- 2024.07.06
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE DATE_FORMAT(START_DATE, '%Y') = '2022' AND MONTH(START_DATE) BETWEEN 8 AND 10
        GROUP BY CAR_ID
        HAVING COUNT(*) >= 5
        ) AND month(start_date) between 8 and 10
GROUP BY CAR_ID, MONTH
ORDER BY MONTH, CAR_ID DESC;



# select month(start_date)as MONTH,car_id as CAR_ID,count(*) as RECORDS
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where month(start_date) between 8 and 10  and
# car_id in 
# (
# select car_id
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where month(start_date) between 8 and 10  
# group by car_id
# having count(*) >4
# )
# group by car_id,month
# order by month asc ,car_id desc