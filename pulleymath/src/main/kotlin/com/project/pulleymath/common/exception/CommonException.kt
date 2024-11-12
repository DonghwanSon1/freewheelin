package com.project.pulleymath.common.exception

class CommonException(val exceptionCode: CommonExceptionCode) : RuntimeException(exceptionCode.message) {

}