-- 학습지 문제 테이블 (piece_problem)
CREATE TABLE piece_problem (
    sn BIGINT AUTO_INCREMENT PRIMARY KEY,                  -- 학습지 문제 SN
    piece_sn BIGINT NOT NULL,							   -- 학습지 SN (piece 테이블의 sn 참조)		
    problem_sn BIGINT NOT NULL, 						   -- 문제 SN (problem 테이블의 sn 참조)
    FOREIGN KEY (piece_sn) REFERENCES piece(sn),           -- 학습지 테이블과 외래 키 관계
    FOREIGN KEY (problem_sn) REFERENCES problem(sn)        -- 문제 테이블과 외래 키 관
);