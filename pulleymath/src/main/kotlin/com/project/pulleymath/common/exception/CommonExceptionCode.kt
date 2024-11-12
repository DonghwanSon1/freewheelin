package com.project.pulleymath.common.exception

import org.springframework.http.HttpStatus

enum class CommonExceptionCode(
        val status: HttpStatus,
        val message: String
) {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "입력값을 확인해주세요."),
    DUPLICATE_ID(HttpStatus.BAD_REQUEST, "중복된 아이디가 있습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    EMPTY_OR_OVER_PROBLEM(HttpStatus.BAD_REQUEST, "최소 1개 또는 최대 50개 까지 학습지 문제 생성이 가능합니다."),
    EMPTY_PIECE_NAME(HttpStatus.BAD_REQUEST, "학습지 이름은 필수입니다."),

}