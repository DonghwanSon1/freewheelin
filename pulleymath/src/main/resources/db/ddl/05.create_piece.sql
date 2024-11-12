-- 학습지 테이블 (piece)
CREATE TABLE piece (
    sn BIGINT AUTO_INCREMENT PRIMARY KEY,          	                                -- 학습지 SN
    name VARCHAR(255) NOT NULL,      			                                    -- 이름
    created_by BIGINT NOT NULL,                                                     -- 유저 SN (users 테이블의 sn 참조)
    CONSTRAINT FK_PIECE_CREATED_BY FOREIGN KEY (created_by) REFERENCES users(sn)    -- 유저 테이블과 외래 키 관계
);