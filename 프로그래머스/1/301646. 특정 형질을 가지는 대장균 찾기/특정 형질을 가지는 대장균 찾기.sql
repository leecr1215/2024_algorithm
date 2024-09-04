-- 2024.09.04
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA 
WHERE (SUBSTR(CONV(GENOTYPE, 10, 2), -1, 1) = '1' OR SUBSTR(CONV(GENOTYPE, 10, 2), -3, 1) = '1') AND SUBSTR(CONV(GENOTYPE, 10, 2), -2, 1) != '1';
