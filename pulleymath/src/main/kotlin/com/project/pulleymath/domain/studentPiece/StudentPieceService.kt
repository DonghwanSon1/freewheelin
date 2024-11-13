package com.project.pulleymath.domain.studentPiece


import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.users.Users

@Service
@Transactional(readOnly = true)
class StudentPieceService(
    private val studentPieceRepository: StudentPieceRepository
) {

  @Transactional
  fun saveStudentPiece(piece: Piece, studentSns: List<Long>) {

    val studentPieceMap: Map<Long, StudentPiece>? = studentPieceRepository.findByPiece(piece)?.associateBy { it.studentSn!!.sn ?: 0 }

    val studentPieceEntities = ArrayList<StudentPiece>()

    studentSns.forEach { studentSn ->
      if (!studentPieceMap!!.containsKey(studentSn)) {
        studentPieceEntities.add(StudentPiece.createStudentPiece(piece, Users.from(studentSn)))
      }
    }

    studentPieceRepository.saveAll(studentPieceEntities)

  }
}