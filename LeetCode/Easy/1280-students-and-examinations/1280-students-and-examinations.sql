# 2025.02.02
SELECT *,(
    SELECT COUNT(*)
    FROM Examinations e
    WHERE e.student_id = st.student_id AND su.subject_name = e.subject_name
) AS attended_exams
FROM Students st CROSS JOIN Subjects su
ORDER BY st.student_id, su.subject_name;
