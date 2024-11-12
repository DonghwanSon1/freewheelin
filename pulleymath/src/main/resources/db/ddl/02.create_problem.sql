-- 문제 테이블 (problem)
CREATE TABLE IF NOT EXISTS problem (
    sn BIGINT AUTO_INCREMENT PRIMARY KEY,                                                    -- 문제 ID
    unit_code_sn BIGINT NOT NULL,                                                            -- 유형 코드 외래 키 (unitcode 테이블의 sn 참조)
    level INT NOT NULL,                                                                      -- 난이도
    type VARCHAR(50) NOT NULL,                                                               -- 문제 유형
    answer INT NOT NULL,                                                                     -- 정답
    CONSTRAINT FK_PROBLEM_UNIT_CODE_SN FOREIGN KEY (unit_code_sn) REFERENCES unit_code(sn)   -- UnitCode 테이블의 sn 컬럼을 참조
);