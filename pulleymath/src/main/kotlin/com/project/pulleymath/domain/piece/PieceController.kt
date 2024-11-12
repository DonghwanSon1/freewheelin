package com.project.pulleymath.domain.piece

import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.common.response.CustomUser
import com.project.pulleymath.domain.piece.rqrs.PieceRq
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.userRole.enums.Role
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/piece")
@Tag(name = "Piece", description = "학습지 관련 API")
class PieceController(
    private val pieceService: PieceService
) {

}