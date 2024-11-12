package com.project.pulleymath.domain.studentPiece


import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs

@Service
@Transactional(readOnly = true)
class StudentPieceService(
    private val studentPieceRepository: StudentPieceRepository
) {
}