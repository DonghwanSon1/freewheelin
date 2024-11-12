package com.project.pulleymath.domain.problem


import com.project.pulleymath.common.exception.CommonException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.category.rqrs.CategoryRq
import com.project.pulleymath.domain.category.rqrs.CategoryRs
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.UnitCode

@Service
@Transactional(readOnly = true)
class ProblemService(
    private val problemRepository: ProblemRepository
) {
    // TODO OOP로 코드스타일 변경하기
    fun search(totalCount: Long, unitCodeSnList: List<Long>, level: Level, problemType: Type): ProblemListRs {

        val problemList: MutableList<ProblemRs> = problemRepository.findByUnitCode(unitCodeSnList, problemType)

        // 만약 총 개수보다 가져온 데이터가 작다면, 가져온 데이터 개수만큼 Level 비율을 맞추기 위해 총 개수를 가져온 데이터 수로 변경한다.
        val totalCount = if (problemList.size <= totalCount) { problemList.size.toLong() } else { totalCount }

        // 필터링된 결과를 담을 리스트 선언
        val filteredProblems = mutableListOf<ProblemRs>()

        // level 별로 비율별 문제를 추출 하며, 비율별 데이터가 없을 시 남은 데이터로 총 개수를 맞춘다.
        when (level) {
            Level.LOW -> {
                // Level 1인 문제를 전체 개수의 50%만큼 가져온다.
                val lowProblems = problemList.filter { it.level == 1L }.take((totalCount * 0.5).toInt())
                // 원본 데이터에서 가져간 데이터는 삭제한다.
                problemList.removeAll(lowProblems)

                // Level 2, 3, 4인 문제를 전체 개수의 30%만큼 가져온다.
                val middleProblems = problemList.filter { it.level in listOf(2L, 3L, 4L) }.take((totalCount * 0.3).toInt())
                // 원본 데이터에서 가져간 데이터는 삭제한다.
                problemList.removeAll(middleProblems)

                // Level 5인 문제를 전체 개수의 20%만큼 가져온다.
                val highProblems = problemList.filter { it.level == 5L }.take((totalCount * 0.2).toInt())
                // 원본 데이터에서 가져간 데이터는 삭제한다.
                problemList.removeAll(highProblems)

                // 각각 필터링한 결과를 최종 리스트에 추가한다.
                filteredProblems.addAll(lowProblems)
                filteredProblems.addAll(middleProblems)
                filteredProblems.addAll(highProblems)

                // 만약 비율대로 넣었을때, 총 개수만큼 넣어지지 않았다면, ( EX) 총 개수 10 -> lowProblem 이 데이터가 부족하여 5개를 못가져왔다면)
                if (filteredProblems.size <= totalCount) {
                    // 못채운 수만큼 남은 데이터에서 총 개수 수만큼 채워 넣는다.
                    val remainCount: Int = totalCount.toInt() - filteredProblems.size
                    filteredProblems.addAll(problemList.take(remainCount))
                }
            }

            Level.MIDDLE -> {
                val lowProblems = problemList.filter { it.level == 1L }.take((totalCount * 0.25).toInt())
                val middleProblems = problemList.filter { it.level in listOf(2L, 3L, 4L) }.take((totalCount * 0.5).toInt())
                val highProblems = problemList.filter { it.level == 5L }.take((totalCount * 0.25).toInt())

                filteredProblems.addAll(lowProblems)
                filteredProblems.addAll(middleProblems)
                filteredProblems.addAll(highProblems)
            }

            Level.HIGH -> {
                val lowProblems = problemList.filter { it.level == 1L }.take((totalCount * 0.2).toInt())
                val middleProblems = problemList.filter { it.level in listOf(2L, 3L, 4L) }.take((totalCount * 0.3).toInt())
                val highProblems = problemList.filter { it.level == 5L }.take((totalCount * 0.5).toInt())

                filteredProblems.addAll(lowProblems)
                filteredProblems.addAll(middleProblems)
                filteredProblems.addAll(highProblems)
            }
        }

//        val resultCount: Int = problem.count()

        return ProblemListRs.createProblemListRs(filteredProblems)
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