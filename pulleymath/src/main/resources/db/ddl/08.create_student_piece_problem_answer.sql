-- 학생 학습지 답안 제출 테이블 (student_piece_problem_answer)
CREATE TABLE student_piece_problem_answer (
    sn BIGINT AUTO_INCREMENT PRIMARY KEY,                                                                                       -- 학생 학습지 답안 제출 SN
    student_piece_sn BIGINT NOT NULL, 						                                                                    -- 학습지 SN (piece 테이블의 sn 참조)
    problem_sn BIGINT NOT NULL,						                                                                            -- 문제 SN (problem 테이블의 sn 참조)
    student_answer INT NOT NULL,								                                                                            -- 답안
    grading TINYINT NOT NULL,									                                                                        -- 채점 (0: 틀림, 1: 정답)
    CONSTRAINT FK_STUDENT_PIECE_PROBLEM_ANSWER_STUDENT_PIECE_SN FOREIGN KEY (student_piece_sn) REFERENCES student_piece(sn),    -- 학습지 테이블과 외래 키 관계
    CONSTRAINT FK_STUDENT_PIECE_PROBLEM_ANSWER_PROBLEM_SN FOREIGN KEY (problem_sn) REFERENCES problem(sn)                       -- 문제 테이블과 외래 키 관계
);
