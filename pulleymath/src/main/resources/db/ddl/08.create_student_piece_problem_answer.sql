-- 학생 학습지 답안 제출 테이블 (student_piece_problem_answer)
CREATE TABLE student_piece_problem_answer (
    sn BIGINT AUTO_INCREMENT PRIMARY KEY,               -- 학생 학습지 답안 제출 SN
    piece_sn BIGINT NOT NULL, 						    -- 학습지 SN (piece 테이블의 sn 참조)
    problem_sn BIGINT NOT NULL,						    -- 문제 SN (problem 테이블의 sn 참조)
    student_answer INT,								    -- 답안
    grading TINYINT,									-- 채점 (0: 틀림, 1: 정답, null: 미제출)
    FOREIGN KEY (piece_sn) REFERENCES piece(sn),        -- 학습지 테이블과 외래 키 관계
    FOREIGN KEY (problem_sn) REFERENCES problem(sn)     -- 문제 테이블과 외래 키 관계
);
