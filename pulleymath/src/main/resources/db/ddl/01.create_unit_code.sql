-- 유니코드 테이블 (unit_code)
CREATE TABLE IF NOT EXISTS unit_code (
    sn BIGINT AUTO_INCREMENT PRIMARY KEY,    -- 고유 ID
    code VARCHAR(30) NOT NULL,               -- 유형 코드 (고유 값)
    name VARCHAR(255) NOT NULL,              -- 유형 이름
    UNIQUE KEY unique_code (code)            -- 유형 코드 UNIQUE KEY
);