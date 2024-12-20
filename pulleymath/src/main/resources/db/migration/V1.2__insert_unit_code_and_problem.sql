-- 제공 받은 데이터 기반으로 개발을 위한 insert (unit_code)
INSERT INTO "unit_code" ("code", "name") VALUES
('uc1572', '모수와 통계량 구별, 모집단과 표본'),
('uc1573', '도수분포표, 히스토그램, 도수분포다각형 작성 및 해석'),
('uc1574', '줄기-잎 그림 작성 및 해석'),
('uc1575', '막대그래프, 원 그래프'),
('uc1576', '중심 경향 척도 : 자료의 평균, 평균절대편차, 최빈값'),
('uc1577', '산포도 : 자료의 범위, 사분위수, IQR'),
('uc1578', '산포도 : 분산, 표준편차'),
('uc1579', '다변량 자료, 분할표, 산점도, 공분산과 상관계수'),
('uc1503', '합집합, 교집합 및 여집합'),
('uc1506', '사건의 합집합, 교집합 및 여집합의 계산'),
('uc1510', '기본 조건부 확률의 계산'),
('uc1513', '세 개 이상 집합의 교집합'),
('uc1519', '순열과 조합을 이용한 확률 계산'),
('uc1520', '이산확률분포, 이산확률변수, 확률질량함수'),
('uc1521', '연속확률분포, 연속확률변수, 확률밀도함수'),
('uc1523', '확률변수의 기대값'),
('uc1524', '확률변수의 분산, 표준편차'),
('uc1570', '확률변수의 공분산과 상관계수'),
('uc1526', '결합확률밀도함수'),
('uc1529', '확률변수의 독립과 종속 여부 판단'),
('uc1534', '이항분포 기본 계산, 이항분포의 평균 및 표준 편차'),
('uc1535', '이항 공식, 이항분포를 사용하여 정확히 m번 성공할 확률 찾기'),
('uc1536', '이항 공식, 이항분포를 사용하여 m번 이상 또는 미만 성공할 확률 찾기'),
('uc1537', '비복원추출, 초기하분포, 초기하확률'),
('uc1539', '정규분포, 정규분포의 확률밀도함수, 정규분포의 확률 계산'),
('uc1540', '표준정규분포의 확률 계산하기'),
('uc1541', '중심극한정리 : 표본 평균의 표본 분포'),
('uc1542', '중심극한정리 : 이항 분포에 대한 정규 근사'),
('uc1548', '모평균에 대한 신뢰구간'),
('uc1564', 'F분포'),
('uc1568', '카이제곱분포, 자유도, 표본분산, 카이제곱 검정'),
('uc1580', '표본추출 : 단순랜덤추출'),
('uc1581', '표본추출 : 계통추출법'),
('uc1582', '표본추출 : 표집틀(sampling frame)'),
('uc1583', '실험단위, 인자, 반응변수, 처리'),
('uc1584', '랜덤화, 블록화, 랜덤블록계획, 반복'),
('uc1571', 'SAS 명령어, 함수');

-- 제공 받은 데이터 기반으로 개발을 위한 insert (problem)
INSERT INTO "problem" ("unit_code_sn", "level", "type", "answer") VALUES
(32, 1, 'SELECTION', 1),
(32, 1, 'SELECTION', 1),
(32, 1, 'SELECTION', 1),
(32, 1, 'SELECTION', 2),
(32, 1, 'SELECTION', 2),
(33, 1, 'SELECTION', 3),
(33, 2, 'SELECTION', 2),
(33, 2, 'SELECTION', 3),
(33, 2, 'SELECTION', 1),
(34, 2, 'SELECTION', 3),
(34, 2, 'SELECTION', 3),
(35, 3, 'SELECTION', 1),
(35, 3, 'SELECTION', 1),
(35, 3, 'SELECTION', 1),
(35, 3, 'SELECTION', 3),
(35, 3, 'SELECTION', 2),
(35, 3, 'SELECTION', 3),
(35, 3, 'SELECTION', 1),
(36, 3, 'SELECTION', 3),
(36, 3, 'SELECTION', 4),
(36, 3, 'SELECTION', 3),
(36, 3, 'SELECTION', 2),
(35, 2, 'SELECTION', 4),
(35, 2, 'SELECTION', 1),
(35, 2, 'SELECTION', 4),
(36, 2, 'SELECTION', 2),
(36, 2, 'SELECTION', 1),
(36, 2, 'SELECTION', 1),
(5, 2, 'SELECTION', 1),
(5, 2, 'SELECTION', 2),
(5, 2, 'SELECTION', 1),
(16, 2, 'SELECTION', 1),
(16, 2, 'SELECTION', 1),
(16, 2, 'SELECTION', 4),
(7, 2, 'SELECTION', 4),
(7, 2, 'SELECTION', 2),
(7, 2, 'SELECTION', 1),
(8, 2, 'SELECTION', 1),
(8, 2, 'SELECTION', 2),
(8, 2, 'SELECTION', 2),
(4, 2, 'SELECTION', 1),
(4, 2, 'SELECTION', 1),
(4, 2, 'SELECTION', 1),
(4, 2, 'SELECTION', 2),
(2, 2, 'SELECTION', 2),
(2, 2, 'SELECTION', 1),
(2, 2, 'SELECTION', 3),
(8, 2, 'SELECTION', 4),
(8, 2, 'SELECTION', 4),
(8, 2, 'SELECTION', 3),
(5, 2, 'SELECTION', 2),
(5, 2, 'SELECTION', 2),
(5, 2, 'SELECTION', 3),
(6, 2, 'SELECTION', 1),
(6, 2, 'SELECTION', 2),
(6, 2, 'SELECTION', 2),
(8, 2, 'SELECTION', 1),
(8, 2, 'SELECTION', 4),
(8, 2, 'SELECTION', 2),
(1, 2, 'SELECTION', 1),
(1, 2, 'SELECTION', 1),
(1, 2, 'SELECTION', 1),
(1, 2, 'SELECTION', 3),
(1, 2, 'SELECTION', 3),
(1, 2, 'SELECTION', 3),
(5, 2, 'SELECTION', 1),
(5, 2, 'SELECTION', 2),
(5, 2, 'SELECTION', 3),
(2, 2, 'SELECTION', 4),
(2, 2, 'SELECTION', 4),
(2, 2, 'SELECTION', 4),
(5, 2, 'SELECTION', 3),
(5, 2, 'SELECTION', 4),
(5, 2, 'SELECTION', 1),
(3, 2, 'SELECTION', 2),
(3, 2, 'SELECTION', 1),
(3, 2, 'SELECTION', 2),
(5, 2, 'SELECTION', 3),
(5, 2, 'SELECTION', 1),
(5, 2, 'SELECTION', 4),
(4, 2, 'SELECTION', 2),
(4, 2, 'SELECTION', 1),
(4, 2, 'SUBJECTIVE', 4),
(2, 2, 'SUBJECTIVE', 2),
(2, 2, 'SUBJECTIVE', 2),
(2, 2, 'SUBJECTIVE', 2),
(2, 2, 'SUBJECTIVE', 3),
(2, 2, 'SUBJECTIVE', 4),
(2, 2, 'SUBJECTIVE', 3),
(8, 3, 'SUBJECTIVE', 1),
(8, 3, 'SUBJECTIVE', 4),
(8, 3, 'SUBJECTIVE', 4),
(8, 3, 'SUBJECTIVE', 1),
(8, 3, 'SUBJECTIVE', 1),
(8, 3, 'SUBJECTIVE', 1),
(6, 3, 'SUBJECTIVE', 2),
(6, 3, 'SUBJECTIVE', 2),
(6, 3, 'SUBJECTIVE', 4),
(5, 3, 'SUBJECTIVE', 3),
(5, 3, 'SUBJECTIVE', 3),
(5, 3, 'SUBJECTIVE', 3),
(24, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 4),
(24, 3, 'SUBJECTIVE', 4),
(14, 3, 'SUBJECTIVE', 1),
(14, 3, 'SUBJECTIVE', 4),
(14, 3, 'SUBJECTIVE', 1),
(11, 3, 'SUBJECTIVE', 2),
(11, 3, 'SUBJECTIVE', 3),
(11, 3, 'SUBJECTIVE', 3),
(11, 2, 'SUBJECTIVE', 2),
(11, 2, 'SUBJECTIVE', 2),
(11, 2, 'SUBJECTIVE', 3),
(12, 3, 'SUBJECTIVE', 2),
(12, 3, 'SUBJECTIVE', 1),
(12, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 2),
(20, 3, 'SUBJECTIVE', 3),
(24, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 3),
(15, 4, 'SUBJECTIVE', 2),
(15, 4, 'SUBJECTIVE', 1),
(15, 4, 'SUBJECTIVE', 1),
(16, 2, 'SUBJECTIVE', 1),
(16, 2, 'SUBJECTIVE', 1),
(16, 2, 'SUBJECTIVE', 3),
(16, 3, 'SUBJECTIVE', 4),
(16, 3, 'SUBJECTIVE', 2),
(16, 3, 'SUBJECTIVE', 3),
(16, 4, 'SUBJECTIVE', 2),
(16, 4, 'SUBJECTIVE', 2),
(16, 4, 'SUBJECTIVE', 2),
(16, 3, 'SUBJECTIVE', 1),
(17, 3, 'SUBJECTIVE', 2),
(16, 3, 'SUBJECTIVE', 2),
(16, 3, 'SUBJECTIVE', 2),
(16, 3, 'SUBJECTIVE', 3),
(16, 3, 'SUBJECTIVE', 2),
(19, 3, 'SUBJECTIVE', 1),
(19, 3, 'SUBJECTIVE', 2),
(19, 3, 'SUBJECTIVE', 2),
(19, 3, 'SUBJECTIVE', 3),
(19, 3, 'SUBJECTIVE', 3),
(19, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 2),
(20, 3, 'SUBJECTIVE', 2),
(18, 2, 'SUBJECTIVE', 2),
(18, 2, 'SUBJECTIVE', 4),
(18, 2, 'SUBJECTIVE', 1),
(11, 2, 'SUBJECTIVE', 2),
(11, 2, 'SUBJECTIVE', 3),
(11, 2, 'SUBJECTIVE', 2),
(22, 3, 'SUBJECTIVE', 2),
(22, 3, 'SUBJECTIVE', 1),
(22, 3, 'SUBJECTIVE', 1),
(11, 3, 'SUBJECTIVE', 2),
(11, 3, 'SUBJECTIVE', 2),
(11, 3, 'SUBJECTIVE', 4),
(11, 4, 'SUBJECTIVE', 4),
(11, 4, 'SUBJECTIVE', 2),
(11, 4, 'SUBJECTIVE', 4),
(10, 3, 'SUBJECTIVE', 2),
(10, 3, 'SUBJECTIVE', 4),
(10, 3, 'SUBJECTIVE', 2),
(9, 3, 'SUBJECTIVE', 1),
(9, 3, 'SUBJECTIVE', 4),
(9, 3, 'SUBJECTIVE', 2),
(20, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 1),
(16, 3, 'SUBJECTIVE', 1),
(16, 3, 'SUBJECTIVE', 2),
(16, 3, 'SUBJECTIVE', 2),
(21, 3, 'SUBJECTIVE', 2),
(21, 3, 'SUBJECTIVE', 3),
(21, 3, 'SUBJECTIVE', 1),
(15, 4, 'SUBJECTIVE', 2),
(15, 4, 'SUBJECTIVE', 1),
(15, 4, 'SUBJECTIVE', 1),
(15, 4, 'SUBJECTIVE', 2),
(15, 4, 'SUBJECTIVE', 4),
(15, 4, 'SUBJECTIVE', 2),
(16, 2, 'SUBJECTIVE', 1),
(16, 2, 'SUBJECTIVE', 3),
(16, 2, 'SUBJECTIVE', 3),
(19, 3, 'SUBJECTIVE', 3),
(19, 3, 'SUBJECTIVE', 3),
(19, 3, 'SUBJECTIVE', 3),
(19, 3, 'SUBJECTIVE', 2),
(19, 3, 'SUBJECTIVE', 2),
(19, 3, 'SUBJECTIVE', 3),
(20, 3, 'SUBJECTIVE', 1),
(20, 3, 'SUBJECTIVE', 2),
(20, 3, 'SUBJECTIVE', 1),
(37, 3, 'SUBJECTIVE', 1),
(37, 3, 'SUBJECTIVE', 1),
(21, 2, 'SUBJECTIVE', 1),
(21, 2, 'SUBJECTIVE', 2),
(21, 2, 'SUBJECTIVE', 2),
(26, 2, 'SUBJECTIVE', 1),
(26, 2, 'SUBJECTIVE', 2),
(26, 2, 'SUBJECTIVE', 3),
(26, 2, 'SUBJECTIVE', 3),
(26, 2, 'SUBJECTIVE', 1),
(26, 2, 'SUBJECTIVE', 2),
(25, 3, 'SUBJECTIVE', 2),
(25, 3, 'SUBJECTIVE', 2),
(25, 3, 'SUBJECTIVE', 3),
(25, 3, 'SUBJECTIVE', 2),
(25, 3, 'SUBJECTIVE', 2),
(25, 3, 'SUBJECTIVE', 2),
(14, 3, 'SUBJECTIVE', 2),
(14, 3, 'SUBJECTIVE', 2),
(14, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 3),
(24, 3, 'SUBJECTIVE', 3),
(22, 3, 'SUBJECTIVE', 1),
(22, 3, 'SUBJECTIVE', 2),
(22, 3, 'SUBJECTIVE', 2),
(23, 3, 'SUBJECTIVE', 2),
(23, 3, 'SUBJECTIVE', 2),
(23, 3, 'SUBJECTIVE', 3),
(27, 3, 'SUBJECTIVE', 1),
(27, 3, 'SUBJECTIVE', 3),
(27, 3, 'SUBJECTIVE', 1),
(28, 3, 'SUBJECTIVE', 3),
(28, 3, 'SUBJECTIVE', 3),
(28, 3, 'SUBJECTIVE', 3),
(13, 2, 'SUBJECTIVE', 3),
(13, 2, 'SUBJECTIVE', 4),
(13, 2, 'SUBJECTIVE', 3),
(26, 3, 'SUBJECTIVE', 3),
(26, 3, 'SUBJECTIVE', 1),
(26, 3, 'SUBJECTIVE', 3),
(26, 3, 'SUBJECTIVE', 2),
(26, 3, 'SUBJECTIVE', 2),
(26, 3, 'SUBJECTIVE', 3),
(25, 3, 'SUBJECTIVE', 3),
(25, 3, 'SUBJECTIVE', 3),
(25, 3, 'SUBJECTIVE', 3),
(25, 3, 'SUBJECTIVE', 2),
(25, 3, 'SUBJECTIVE', 3),
(25, 3, 'SUBJECTIVE', 2),
(27, 3, 'SUBJECTIVE', 4),
(27, 3, 'SUBJECTIVE', 1),
(27, 3, 'SUBJECTIVE', 3),
(25, 4, 'SUBJECTIVE', 2),
(25, 4, 'SUBJECTIVE', 4),
(25, 4, 'SUBJECTIVE', 1),
(14, 3, 'SUBJECTIVE', 1),
(14, 3, 'SUBJECTIVE', 2),
(14, 3, 'SUBJECTIVE', 1),
(24, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 3),
(24, 3, 'SUBJECTIVE', 1),
(24, 3, 'SUBJECTIVE', 2),
(24, 3, 'SUBJECTIVE', 1),
(24, 3, 'SUBJECTIVE', 2),
(23, 3, 'SUBJECTIVE', 3),
(23, 3, 'SUBJECTIVE', 3),
(23, 3, 'SUBJECTIVE', 3),
(23, 3, 'SUBJECTIVE', 4),
(23, 3, 'SUBJECTIVE', 3),
(23, 3, 'SUBJECTIVE', 2),
(21, 3, 'SUBJECTIVE', 1),
(21, 3, 'SUBJECTIVE', 1),
(21, 3, 'SUBJECTIVE', 2),
(23, 5, 'SUBJECTIVE', 3),
(23, 5, 'SUBJECTIVE', 4),
(23, 5, 'SUBJECTIVE', 2),
(28, 3, 'SUBJECTIVE', 4),
(28, 3, 'SUBJECTIVE', 2),
(28, 3, 'SUBJECTIVE', 1),
(28, 3, 'SUBJECTIVE', 4),
(28, 3, 'SUBJECTIVE', 1),
(28, 3, 'SUBJECTIVE', 3),
(27, 4, 'SUBJECTIVE', 1),
(27, 4, 'SUBJECTIVE', 2),
(27, 4, 'SUBJECTIVE', 3),
(31, 4, 'SUBJECTIVE', 4),
(31, 4, 'SUBJECTIVE', 3),
(31, 4, 'SUBJECTIVE', 4),
(30, 4, 'SUBJECTIVE', 3),
(30, 4, 'SUBJECTIVE', 4),
(30, 4, 'SUBJECTIVE', 2),
(30, 3, 'SUBJECTIVE', 3),
(30, 3, 'SUBJECTIVE', 3),
(30, 3, 'SUBJECTIVE', 1),
(37, 5, 'SUBJECTIVE', 2),
(37, 5, 'SUBJECTIVE', 2),
(37, 5, 'SUBJECTIVE', 2),
(37, 5, 'SUBJECTIVE', 3),
(37, 5, 'SUBJECTIVE', 3),
(37, 5, 'SUBJECTIVE', 4),
(37, 5, 'SUBJECTIVE', 1),
(29, 5, 'SELECTION', 2);