-- 코드를 입력하세요
SELECT member.MEMBER_NAME, review.REVIEW_TEXT, DATE_FORMAT(review.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE member INNER JOIN REST_REVIEW review
ON member.MEMBER_ID = review.MEMBER_ID
WHERE member.MEMBER_ID = (
                            SELECT MEMBER_ID
                            FROM REST_REVIEW 
                            GROUP BY MEMBER_ID
                            ORDER BY COUNT(*) DESC
                            LIMIT 1
                        )
ORDER BY REVIEW_DATE, REVIEW_TEXT;


-- 가장 많은 리뷰의 개수
# SELECT MAX(REVIEW_COUNT)
# FROM    (SELECT MEMBER_ID, COUNT(MEMBER_ID) AS REVIEW_COUNT
#         FROM REST_REVIEW
#         GROUP BY MEMBER_ID) AS REVIEWS;