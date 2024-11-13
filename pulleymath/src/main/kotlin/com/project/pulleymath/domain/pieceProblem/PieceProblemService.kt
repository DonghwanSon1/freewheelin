package com.project.pulleymath.domain.pieceProblem


import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
import com.project.pulleymath.domain.problem.Problem
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PieceProblemService(
    private val pieceProblemRepository: PieceProblemRepository
) {

  /**
   * 학습지 문제 테이블에 저장하는 함수
   */
  @Transactional
  fun savePieceProblem(piece: Piece, problemSnList: List<Long>) {

    // 학습지에 속한 문제들을 해당 테이블에 저장할 수 있도록 엔티티 리스트를 선언한다.
    val pieceProblemEntities = ArrayList<PieceProblem>()

    // 문제들의 리스트들을 가지고 해당 테이블 엔티티를 create 한 후 저장할 변수에 담고 엔티티들을 저장한다.
    problemSnList.forEach { pieceProblemEntities.add(PieceProblem.createPieceProblem(piece, Problem.from(it))) }
    pieceProblemRepository.saveAll(pieceProblemEntities)

  }

  /**
   * 학습지 문제 조회하는 함수
   *  - DTO 대로 조회한다.
   */
  fun searchPieceProblem(piece: Piece): List<PieceProblemDto>? {
    // dto에 맞춰 조회한 후 return 한다.
    return pieceProblemRepository.searchPieceProblem(piece)
  }
}