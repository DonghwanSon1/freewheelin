package com.project.pulleymath.domain.piece


import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.piece.rqrs.PieceRq
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.studentPiece.StudentPieceService
import com.project.pulleymath.domain.users.Users
import com.project.pulleymath.domain.users.UsersService

@Service
@Transactional(readOnly = true)
class PieceService(
    private val pieceRepository: PieceRepository,
    private val pieceProblemService: PieceProblemService,
    private val studentPieceService: StudentPieceService
) {

  /**
   * 학습지 테이블 및 학습지 문제 테이블에 저장하는 함수
   */
  @Transactional
  fun savePiece(pieceRq: PieceRq, userSn: Long): String {

    // Rq를 통해 학습지 이름과, 유저정보를 가지고 학습지 엔티티를 생성한 후 저장한다.
    val piece: Piece = Piece.createPiece(pieceRq.name, Users.from(userSn))
    pieceRepository.save(piece)

    // 저장한 학습지와 문제리스트들을 보내 학습지 문제 테이블에 저장할 수 있도록 한다.
    pieceProblemService.savePieceProblem(piece, pieceRq.problemSnList)

    return "학습지 생성이 완료되었습니다."
  }

  /**
   * 자신이 만든 학습지를 학생에게 출제하는 함수
   *  - 학생 학습지 테이블에 저장을 전달
   */
  @Transactional
  fun examPiece(pieceSn: Long, studentSns: List<Long>, userSn: Long): String {

    // 학습지가 없다면, Exception 발생
    val piece: Piece = pieceRepository.findBySn(pieceSn) ?: throw CommonException(CommonExceptionCode.NOT_EXIST_PIECE)
    // 학습지가 출제하려는 선생님이 만든게 아니라면 Exception 발생
    if (piece.createdBy!!.sn != userSn) throw CommonException(CommonExceptionCode.INVALID_PIECE)

    studentPieceService.saveStudentPiece(piece, studentSns)

    return "학습지 출제가 완료되었습니다."
  }



//
//    @Transactional
//    fun saveCategory(categoryRqList: List<CategoryRq>) {
//        val entityList = ArrayList<Category>()
//        val categoryMap = HashMap<Long, CategoryRq>()
//
//        categoryRqList.forEach { rq ->
//            // 만약 카테고리 sn이 있다면,
//            if (rq.sn != null) {
//                // 수정이므로 한번에 조회 할 수 있도록 snList를 따로 빼고, Map으로 변경될 내용들을 저장한다.
//                categoryMap[rq.sn] = rq
//            }
//            else {
//                // 생성 시 이름이 없을 시 Exception 발생
//                if (rq.name.isNullOrEmpty()) throw CommonException(CommonExceptionCode.NO_CATEGORY_NAME)
//                // sn 없다면, 신규 저장이므로 생성 후 저장한다.
//                entityList.add(Category.createCategory(rq))
//            }
//        }
//
//        // Map이 비워있지 않다면, 수정할 값이 있다고 판단한다.
//        if (!categoryMap.isNullOrEmpty()) {
//            // 한번에 조회 할 수 있도록 List로 담고, 조회 후 엔티티들을 가져온다.
//            val snList: List<Long> = categoryMap.keys.toList()
//            val categoryEntities: List<Category> = categoryRepository.findBySnIn(snList)
//            // 가져온 엔티티들을 돌려 미리 Map으로 rq를 담아놓은걸을 매칭하여 해당하는 sn을 통해 update 한다.
//            categoryEntities.forEach { category ->
//                if (categoryMap.containsKey(category.sn)) {
//                    entityList.add(category.updateCategory(categoryMap[category.sn]!!))
//                }
//            }
//        }
//
//        // 생성/수정 된 엔티티들을 저장/수정 한다.
//        categoryRepository.saveAll(entityList)
//    }
//
//    @Transactional
//    fun deleteCategory(snList: List<Long>) {
//        categoryRepository.deleteBySnList(snList)
//    }
}