-- 학생 학습지 테이블 (student_piece)
CREATE TABLE "student_piece" (
    "sn" BIGINT AUTO_INCREMENT PRIMARY KEY,                                                       -- 학생 학습지 SN
    "piece_sn" BIGINT NOT NULL,                                                                   -- 학습지 SN (piece 테이블의 sn 참조)
    "student_sn" BIGINT NOT NULL,  						                                        -- 유저(학생) SN (users 테이블의 sn 참조)
    "correct_rate" TINYINT NOT NULL DEFAULT 0,								                    -- 학습지의 정답률
    CONSTRAINT FK_STUDENT_PIECE_PIECE_SN FOREIGN KEY ("piece_sn") REFERENCES "piece"("sn"),           -- 학습지 테이블과 외래 키 관계
    CONSTRAINT FK_STUDENT_PIECE_STUDENT_SN FOREIGN KEY ("student_sn") REFERENCES "users"("sn")        -- 유저 테이블과 외래 키 관계
);