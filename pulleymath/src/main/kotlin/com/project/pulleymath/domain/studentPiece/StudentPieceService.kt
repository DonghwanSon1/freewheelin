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

  /**
   * 학생 학습지 테이블에 저장 하는 함수
   *  - 이미 학습지를 가지고 있다면, 무시하고 없는 학생만 학습지 저장한다.
   */
  @Transactional
  fun saveStudentPiece(piece: Piece, studentSns: List<Long>) {

    // Piece를 가지고 가지고 있는 학생들을 추린 후 이미 가지고 있는 학생들을 필터 하기 위해 Map 으로 변경한다.
    val studentPieceMap: Map<Long, StudentPiece>? = studentPieceRepository.findByPiece(piece)?.associateBy { it.studentSn!!.sn ?: 0 }

    // 저장할 엔티티 리스트 변수를 선언한다.
    val studentPieceEntities = ArrayList<StudentPiece>()

    // 요청받은 학생Sn들을 for문 돌려 이미 저장되어 있는 학생들은 무시하고, 저장되지 않은 학생들은 엔티티 리스트 변수에 담고 저장한다.
    studentSns.forEach { studentSn ->
      if (!studentPieceMap!!.containsKey(studentSn)) {
        studentPieceEntities.add(StudentPiece.createStudentPiece(piece, Users.from(studentSn)))
      }
    }
    studentPieceRepository.saveAll(studentPieceEntities)

  }
}