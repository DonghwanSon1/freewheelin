package com.project.pulleymath.domain.pieceProblem


import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.pieceProblem.rqrs.PieceProblemAnalyzeRs
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
   * 간단하게 학습지 문제, 답을 조회하는 함수
   *  - DTO 대로 조회한다.
   */
  fun searchSimplePieceProblem(piece: Piece): List<PieceProblemSimpleDto>? {
    // dto에 맞춰 조회한 후 return 한다.
    return pieceProblemRepository.searchSimplePieceProblem(piece)
  }

  /**
   * 학습지의 문제들과 학생들이 맞춘 개수를 조회하는 함수
   *  - 출제한 학생이 없으면 맞춘 개수는 0
   */
  fun searchPieceProblemAnalyze(pieceSn: Long): List<PieceProblemAnalyzeRs>? {
    // Rs 형식에 맞춰 조회한다.
    return pieceProblemRepository.searchPieceProblemAnalyze(pieceSn)

  }
}