package com.project.pulleymath.common.exception

import org.springframework.http.HttpStatus

enum class CommonExceptionCode(
        val status: HttpStatus,
        val message: String
) {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "입력값을 확인해주세요."),
    DUPLICATE_ID(HttpStatus.BAD_REQUEST, "중복된 아이디가 있습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    EMPTY_OR_OVER_PROBLEM(HttpStatus.BAD_REQUEST, "최소 2개 또는 최대 50개 까지 학습지 문제 생성이 가능합니다."),
    EMPTY_PIECE_NAME(HttpStatus.BAD_REQUEST, "학습지 이름은 필수입니다."),
    EXAM_EMPTY_STUDENTS(HttpStatus.BAD_REQUEST, "최소 한명의 학생한테는 출제해야 합니다."),
    NOT_EXIST_PIECE(HttpStatus.BAD_REQUEST, "해당 학습지는 존재하지 않습니다."),
    INVALID_PIECE(HttpStatus.BAD_REQUEST, "선생님이 생성한 학습지만 출제 가능합니다."),
    INVALID_STUDENT_PIECE(HttpStatus.BAD_REQUEST, "해당 학습지는 해당 유저에게 할당되지 않았습니다."),
    DATA_LOSS(HttpStatus.INTERNAL_SERVER_ERROR, "관리자에게 문의 부탁드립니다."),
    EMPTY_OR_OVER_PROBLEM_ANSWER(HttpStatus.BAD_REQUEST, "최소 2개 또는 최대 50개 까지 학습지 답안 제출이 가능합니다."),
    DUPLICATE_DATA_ERROR(HttpStatus.CONFLICT, "중복 데이터 발생했습니다. 입력값을 확인 해주세요."),
    CONSTRAINTS_ERROR(HttpStatus.BAD_REQUEST, "데이터 처리 중 오류가 발생했습니다. 입력값을 확인한 후 다시 시도해주세요."),

}