-- 코드를 작성해주세요
# SELECT FISH_TYPE, (
#                      SELECT FISH_NAME
#                      FROM FISH_NAME_INFO 
#                      WHERE info.FISH_TYPE = FISH_TYPE
#                     ) AS FISH_NAME, MAX(LENGTH)
# FROM FISH_INFO info
# GROUP BY FISH_TYPE
# HAVING MAX(FISH_TYPE) = FISH_TYPE;

SELECT info.ID, name.FISH_NAME, info.LENGTH
FROM FISH_INFO info INNER JOIN FISH_NAME_INFO name
ON info.FISH_TYPE = name.FISH_TYPE
WHERE info.LENGTH = ( 
                        SELECT MAX(LENGTH)
                        FROM FISH_INFO
                        GROUP BY FISH_TYPE
                        HAVING info.FISH_TYPE = FISH_TYPE
                    );