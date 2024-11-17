ALTER TABLE "student_piece_problem_answer" ADD CONSTRAINT unique_student_piece_sn_and_problem_sn UNIQUE ("student_piece_sn", "problem_sn"); -- 학생 학습지 답안 테이블에서 학생 학습지, 문제 를 유니크 키 설정
